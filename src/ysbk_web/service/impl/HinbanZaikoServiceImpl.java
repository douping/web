/*
 * クラス名: HinbanZaikoServiceImpl
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/24
 *
 * Copyright:
 */

package ysbk_web.service.impl;

import java.text.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import ysbk_web.condition.HinbanZaikoCondition;
import ysbk_web.dao.HinbanZaikoDao;
import ysbk_web.view.UserView;
import ysbk_web.model.hinbanZaiko.HinbanZaikoDetailEntity;
import ysbk_web.model.hinbanZaiko.HinbanZaikoEntity;
import ysbk_web.service.HinbanZaikoService;
import ysbk_web.utility.CommandException;
import ysbk_web.utility.CommonTool;
import ysbk_web.utility.Constants;
import ysbk_web.utility.Utility;

public class HinbanZaikoServiceImpl implements HinbanZaikoService {

    private static HinbanZaikoDao dao;

    public void setDao(HinbanZaikoDao dao) {
        this.dao = dao;
    }

    /**
     * 品番別在庫情報初期化表示用データ取得
     */
    @Override
    public List<HinbanZaikoEntity> getAllHinbanZaiko(UserView userView)
            throws CommandException {
        List<HinbanZaikoEntity> list = Collections.EMPTY_LIST;
        try {
            // システム管理情報 NAIYO内容取得
            String naiyo = dao.getNaiyo();
            // 稼働日を取得する
            String sKadoDate = Utility.getKadoDate(naiyo).substring(0, 8);
            HinbanZaikoCondition hinbanZaikoCondition = new HinbanZaikoCondition();
            // 稼働日
            hinbanZaikoCondition.setsKadoDate(sKadoDate);
            // ユーザ情報
            hinbanZaikoCondition.setUserView(userView);
            // 品番別在庫情報取得
            list = dao.searchHinbanZaikoByCondtion(hinbanZaikoCondition);

        } catch (CommandException e) {
            throw e;
        } catch (Exception e) {
            throw new CommandException(e.getMessage(),
                    "error.HibanZaikoServiceImpl.getAllHinbanZaiko.Exception",
                    Constants.EXCEPTION);
        }
        return formatHinbanData(list);
    }

    /**
     * 品番別在庫情報照会結果表示用データ取得
     */
    @Override
    public List<HinbanZaikoEntity> getAllHinbanZaiko(UserView userView,
            String tk_hin, String tk_uke, String seban) throws CommandException {
        List<HinbanZaikoEntity> list = Collections.EMPTY_LIST;
        try {
            // システム管理情報 NAIYO内容取得
            String naiyo = dao.getNaiyo();
            // 稼働日を取得する
            String sKadoDate = Utility.getKadoDate(naiyo).substring(0, 8);
            HinbanZaikoCondition hinbanZaikoCondition = new HinbanZaikoCondition();
            hinbanZaikoCondition.setsKadoDate(sKadoDate);
            // 受入
            hinbanZaikoCondition.setTk_uke(tk_uke);
            // 仕入先背番
            hinbanZaikoCondition.setSeban(seban);
            // メーカー品番
            hinbanZaikoCondition.setTk_hin(tk_hin);
            // ユーザ情報
            hinbanZaikoCondition.setUserView(userView);
            list = dao.searchHinbanZaikoByCondtion(hinbanZaikoCondition);
        } catch (CommandException e) {
            throw e;
        } catch (Exception e) {
            throw new CommandException(
                    e.getMessage(),
                    "error.HinbanZaikoServiceImpl.getAllHinbanZaiko_mutiliCoditions.Exception",
                    Constants.EXCEPTION);
        }
        return formatHinbanData(list);
    }

    /**
     * 品番別在庫管理詳細画面表示用データ取得
     */
    @Override
    public List<HinbanZaikoDetailEntity> getAllHinbanZaikoDetail(
            UserView userView, String tk_hin, String syuyo_su)
            throws CommandException {
    	List<HinbanZaikoDetailEntity> list = new ArrayList<HinbanZaikoDetailEntity>();
        try{
        	HinbanZaikoCondition hinbanZaikoCondition = new HinbanZaikoCondition();
            // メーカー品番
            hinbanZaikoCondition.setTk_hin(tk_hin.replaceAll("-", ""));
            // 収容数
            hinbanZaikoCondition.setSyuyo_su(Integer.parseInt(syuyo_su.replaceAll(
                    ",", "")));
            // ユーザ情報
            hinbanZaikoCondition.setUserView(userView);
            
            dao.deleteItemBywkiban(userView.getWkiban());
            if (userView.getRg() == null) {
                // 引数(得意先品番・収容数・Web機番・物流拠点・仕入先)
                dao.updateNumRet(hinbanZaikoCondition);
            } else {
                // 引数(得意先品番・収容数・Web機番・物流拠点・仕入先・RG)
                for (int i = 0; i < userView.getRg().length; i++) {
                    hinbanZaikoCondition.setRg(userView.getRg()[i]);
                    dao.updateNumRet(hinbanZaikoCondition);
                }
            }
            List<HinbanZaikoDetailEntity> hinbanZaikoDetails = dao
                    .findHinbanZaikoDetail(hinbanZaikoCondition);
            list = formatHinbanDetail(hinbanZaikoDetails);
        } catch (CommandException e) {
            throw e;
        } catch (Exception e) {
            throw new CommandException(
                    e.getMessage(),
                    "error.HinbanZaikoServiceImpl.getAllHinbanZaikoDetail.Exception",
                    Constants.EXCEPTION);
        }
        return list;
    }

    /**
     * DBから取得したデータを品番別在庫管理画面レイアウトに転換
     */
    @Override
    public List<HinbanZaikoEntity> formatHinbanData(
            List<HinbanZaikoEntity> hinbanZaikos) {
        if (hinbanZaikos.isEmpty()) {
            return hinbanZaikos;
        }
        List<HinbanZaikoEntity> list = new ArrayList<HinbanZaikoEntity>();
        DecimalFormat df;
        String wk;
        for (HinbanZaikoEntity hinbanZaiko : hinbanZaikos) {
            /* メーカー品番 */
            wk = hinbanZaiko.getTk_hin();
            wk = new String(CommonTool.checkEmpty(hinbanZaiko.getTk_hin()));
            hinbanZaiko.setTk_hin(wk.substring(0, 5) + "-"
                    + wk.substring(5, 10) + "-" + wk.substring(10));

            /* 収容数 */
            df = new DecimalFormat("##,##0");
            hinbanZaiko.setSyuyo_su(df.format(Integer.parseInt(hinbanZaiko
                    .getSyuyo_su())));

            /* 在庫数 */
            df = new DecimalFormat("###,###,##0");
            hinbanZaiko.setZaiko_su(df.format(Integer.parseInt(hinbanZaiko
                    .getZaiko_su())));

            /* ロケ在庫数 */
            df = new DecimalFormat("###,###,##0");
            hinbanZaiko.setLoc_zaiko_su(df.format(Integer.parseInt(hinbanZaiko
                    .getLoc_zaiko_su())));

            /* 引当可能在庫数 */
            df = new DecimalFormat("###,###,##0");
            hinbanZaiko.setHiki_zaiko_su(df.format(Integer.parseInt(hinbanZaiko
                    .getHiki_zaiko_su())));

            /* 不足総数 */
            df = new DecimalFormat("###,###,##0");
            hinbanZaiko.setFusoku_su(df.format(Integer.parseInt(hinbanZaiko
                    .getFusoku_su())));

            /* 当日搬入数 */
            df = new DecimalFormat("###,##0");
            hinbanZaiko.setHan_su(df.format(Integer.parseInt(hinbanZaiko
                    .getHan_su())));

            /* 最終納入日 */
            wk = CommonTool.checkEmpty(hinbanZaiko.getLst_nou_ymd());
            hinbanZaiko.setLst_nou_ymd(wk.substring(0, 4) + "/"
                    + wk.substring(4, 6) + "/" + wk.substring(6));

            /* 最終搬入日 */
            wk = CommonTool.checkEmpty(hinbanZaiko.getLst_han_ymd());
            hinbanZaiko.setLst_han_ymd(wk.substring(0, 4) + "/"
                    + wk.substring(4, 6) + "/" + wk.substring(6));

            list.add(hinbanZaiko);
        }
        return list;
    }

    /**
     * DBから取得したデータを品番別在庫管理詳細画面レイアウトに転換
     */
    @Override
    public List<HinbanZaikoDetailEntity> formatHinbanDetail(
            List<HinbanZaikoDetailEntity> hinbanZaikoDetails) {
        List<HinbanZaikoDetailEntity> list = new ArrayList<HinbanZaikoDetailEntity>();
        DecimalFormat df = new DecimalFormat("###,###,##0");
        String sWk;
        double dWork = 0;
        HinbanZaikoDetailEntity entity;
        for (HinbanZaikoDetailEntity hinbanZaiko : hinbanZaikoDetails) {
            entity = new HinbanZaikoDetailEntity();

            /* 予定日 */
            sWk = CommonTool.checkEmpty(hinbanZaiko.getYotei_ymd());
            if (!"".equals(sWk.trim())) {
                entity.setYotei_ymd(sWk.substring(0, 4) + "/"
                        + sWk.substring(4, 6) + "/" + sWk.substring(6));
            } else {
                entity.setYotei_ymd("");
            }

            /* 予定時刻 */
            sWk = CommonTool.checkEmpty(hinbanZaiko.getYotei_hms());
            if (!"".equals(sWk.trim())) {
                entity.setYotei_hms(sWk.substring(0, 2) + ":"
                        + sWk.substring(2, 4));
            } else {
                entity.setYotei_hms("");
            }

            /* 相手先 */
            entity.setA_jigyo_cd(CommonTool.checkEmpty(hinbanZaiko
                    .getA_jigyo_cd()));

            /* 受入 */
            entity.setTk_uke(CommonTool.checkEmpty(hinbanZaiko.getTk_uke()));

            /* 便 */
            entity.setBin_no(CommonTool.checkEmpty(hinbanZaiko.getBin_no()));

            /* 納入番号 */
            entity.setTp_noban(CommonTool.checkEmpty(hinbanZaiko.getTp_noban()));

            /* 入出庫 */
            entity.setNyusyu_kb(CommonTool.checkEmpty(hinbanZaiko
                    .getNyusyu_kb()));

            /* 搬入数 */
            sWk = CommonTool.checkEmpty(hinbanZaiko.getHan_su());
            if (!"".equals(sWk.trim())) {
                entity.setHan_su(df.format(Double.parseDouble(sWk)));
            } else {
                entity.setHan_su("");
            }

            /* 納入数 */
            sWk = CommonTool.checkEmpty(hinbanZaiko.getSiji_su());
            if (!"現在在庫数".equals(sWk.trim())) {
                if (!"".equals(sWk.trim())) {
                    entity.setSiji_su(df.format(Double.parseDouble(sWk)));
                } else {
                    entity.setSiji_su("");
                }
            } else {
                entity.setSiji_su(sWk);
            }

            /* 理論在庫 */
            sWk = CommonTool.checkEmpty(hinbanZaiko.getW_riron_zaiko());
            if (!"".equals(sWk.trim())) {

                if ("現在在庫数".equals(CommonTool.checkEmpty(hinbanZaiko
                        .getSiji_su()))) {

                    dWork = Double.parseDouble(hinbanZaiko.getW_riron_zaiko());
                    entity.setW_riron_zaiko(df.format(dWork));

                } else if ("".equals(CommonTool.checkEmpty(
                        hinbanZaiko.getSiji_su()).trim())) {
                    // 入庫予定の場合、siji_suは無し??
                    entity.setW_riron_zaiko(df.format(dWork));
                } else {
                    if ("入庫予定".equals(CommonTool.checkEmpty(hinbanZaiko
                            .getNyusyu_kb()))) {
                        dWork = dWork
                                + Double.parseDouble(hinbanZaiko.getSiji_su());
                        entity.setW_riron_zaiko(df.format(dWork));
                    } else {
                        dWork = dWork
                                - Double.parseDouble(hinbanZaiko.getSiji_su());
                        entity.setW_riron_zaiko(df.format(dWork));
                    }
                }

            } else {
                entity.setW_riron_zaiko("");
            }
            list.add(entity);
        }
        return list;
    }

}
