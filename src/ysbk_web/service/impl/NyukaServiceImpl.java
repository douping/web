/*
 * クラス名: NyukaServiceImpl
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/31
 *
 * Copyright:
 */

package ysbk_web.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import ysbk_web.condition.NyukaCondition;
import ysbk_web.dao.NyukaDao;
import ysbk_web.model.nyuka.NyukaCSVEntity;
import ysbk_web.model.nyuka.NyukaEntity;
import ysbk_web.service.NyukaService;
import ysbk_web.utility.CSVDownload;
import ysbk_web.utility.CommandException;
import ysbk_web.utility.CommonTool;
import ysbk_web.utility.Constants;
import ysbk_web.view.NyukaView;
import ysbk_web.view.UserView;

public class NyukaServiceImpl implements NyukaService {
    private static NyukaDao dao;

    public NyukaDao getDao() {
        return dao;
    }

    public void setDao(NyukaDao dao) {
        this.dao = dao;
    }

    /**
     * 入荷情報結果表示用データ取得
     */
    @Override
    public List<NyukaView> getNyukaResult(UserView userView, String han_ymd)
            throws CommandException {
        NyukaCondition nyukaCondition = new NyukaCondition();
        List<NyukaEntity> nyukas = new ArrayList<NyukaEntity>();
        List<NyukaView> result = new ArrayList<NyukaView>();

        nyukaCondition.setHan_ymd(CommonTool.checkEmpty(han_ymd).replaceAll(
                "/", ""));
        nyukaCondition.setUserView(userView);
        try {
            nyukas = dao.findNyukaResult(nyukaCondition);
            result = formatNyuka(nyukas);
        } catch (CommandException cex) {
            throw cex;
        } catch (Exception e) {
            throw new CommandException(e.getMessage(),
                    "error.NyukaServiceImpl.getNyukaResult.Exception",
                    Constants.EXCEPTION);
        }
        return result;
    }

    /**
     * DBから取得したデータを入荷情報 画面レイアウトに転換
     * 
     * @param nyukas List<NyukaEntity>
     * @return
     */
    private List<NyukaView> formatNyuka(List<NyukaEntity> nyukas) {
        List<NyukaView> entitys = new ArrayList<NyukaView>();
        NyukaView entity;
        for (NyukaEntity nyuka : nyukas) {
            entity = new NyukaView();
            /* 受信状態 */
            if (nyuka.getCnt() <= nyuka.getSumCnt()) {
                entity.setJyushin("済");
            } else {
                entity.setJyushin("");
            }

            /* 便No */
            entity.setBin_no(CommonTool.checkEmpty(nyuka.getBin_no()));

            entitys.add(entity);
        }
        return entitys;
    }

    /**
     * 送信フラグ更新。
     */
    @Override
    public Boolean setKousinUpdate(UserView userView, String han_ymd,
            List<String> checkFlg) throws CommandException {
        if (checkFlg.isEmpty()) {
            return false;
        }
        try {
            NyukaCondition nyukaCondition = new NyukaCondition();
            nyukaCondition.setUserView(userView);
            nyukaCondition.setHan_ymd(CommonTool.checkEmpty(han_ymd)
                    .replaceAll("/", ""));
            for (String str : checkFlg) {
                String[] arr = str.split(",");
                nyukaCondition.setBin_no(arr[0]);
                dao.setKousinUpdate(nyukaCondition);
            }
        } catch (CommandException cex) {
            throw cex;
        } catch (Exception e) {
            throw new CommandException(e.getMessage(),
                    "error.NyukaServiceImpl.setKousinUpdate.Exception",
                    Constants.EXCEPTION);
        }

        return true;
    }

    @Override
    public Boolean getCSVOutputResult(UserView userView, String han_ymd,
            List<String> checkFlg, HttpServletResponse response)
            throws Exception {
        List<NyukaCSVEntity> nyukas = new ArrayList<NyukaCSVEntity>();
        List<NyukaCSVEntity> allNyukas = new ArrayList<NyukaCSVEntity>();
        NyukaCondition nyukaCondition = new NyukaCondition();
        try {
            nyukaCondition.setUserView(userView);
            nyukaCondition.setHan_ymd(han_ymd);
            for (String str : checkFlg) {
                String[] arr = str.split(",");
                nyukaCondition.setBin_no(arr[0]);
                nyukas = dao.findCSVOutputResult(nyukaCondition);
                allNyukas.addAll(nyukas);
            }
            List<NyukaCSVEntity> nyukaCSV = formatCSVOutputResult(allNyukas);
            String result = this.getOutputResult(nyukaCSV);
            String fname = "HANNYU-" + CommonTool.getDate() + ".txt";
            Boolean target = CSVDownload.csvWrite(fname, result, response);
            return target;
        } catch (CommandException e) {
            throw e;
        } catch (Exception ex) {
            throw ex;
        }

    }

    /**
     * DBから取得したデータを入荷情報CSVレイアウトに転換
     * 
     * @param nyukaCSVs
     * @return
     */
    private List<NyukaCSVEntity> formatCSVOutputResult(
            List<NyukaCSVEntity> nyukaCSVs) {
        List<NyukaCSVEntity> entitys = new ArrayList<NyukaCSVEntity>();

        NyukaCSVEntity entity; 

        for (NyukaCSVEntity nyukaCSV : nyukaCSVs) {
        	entity = new NyukaCSVEntity();
            /* 便ID */
            entity.setBin_id(CommonTool.checkEmpty(nyukaCSV.getBin_id()));
            /* 管理工場 */
            entity.setKanri_kojo(CommonTool.checkEmpty(nyukaCSV.getKanri_kojo()));
            /* 搬入日 */
            entity.setHan_ymd(CommonTool.checkEmpty(nyukaCSV.getHan_ymd()));
            /* 特車区分 */
            entity.setTokusya_kb(CommonTool.checkEmpty(nyukaCSV.getTokusya_kb()));
            /* 特車回数 */
            entity.setTokusya_kai(CommonTool.checkEmpty(nyukaCSV
                    .getTokusya_kai()));
            /* 得意先品番 */
            entity.setTk_hin(CommonTool.checkEmpty(nyukaCSV.getTk_hin()));
            /* 収容数 */
            entity.setSyuyo_su(CommonTool.checkEmpty(nyukaCSV.getSyuyo_su()));
            /* 矢崎背番 */
            entity.setSeban(CommonTool.checkEmpty(nyukaCSV.getSeban()));
            /* 指示箱数 */
            entity.setSiji_hako(CommonTool.checkEmpty(nyukaCSV.getSiji_hako()));
            /* 指示数 */
            entity.setSiji_su(CommonTool.checkEmpty(nyukaCSV.getSiji_su()));
            /* 搬入箱数 */
            entity.setHan_hako(CommonTool.checkEmpty(nyukaCSV.getHan_hako()));
            /* 搬入数 */
            entity.setHan_su(CommonTool.checkEmpty(nyukaCSV.getHan_su()));
            /* 出荷拠点 */
            entity.setS_kyoten(CommonTool.checkEmpty(nyukaCSV.getS_kyoten()));
            /* 製造場所 */
            entity.setSeizo_ba(CommonTool.checkEmpty(nyukaCSV.getSeizo_ba()));
            /* 処理日 */
            entity.setSyori_ymd(CommonTool.checkEmpty(nyukaCSV.getSyori_ymd()));
            /* 処理時間 */
            entity.setSyori_hms(CommonTool.checkEmpty(nyukaCSV.getSyori_hms()));
            /* 確定フラグ */
            entity.setKakutei_fg(CommonTool.checkEmpty(nyukaCSV.getKakutei_fg()));
            /* OPコード */
            entity.setOpcode(CommonTool.checkEmpty(nyukaCSV.getOpcode()));
            /* 便No */
            entity.setBin_no(CommonTool.checkEmpty(nyukaCSV.getBin_no()));
            entitys.add(entity);
        }
        return entitys;

    }

    /**
     * CSVファイル作成字符串
     * 
     * @param list 　CSVファイル内容
     * @return　String　CSVファイル作成
     */
    private String getOutputResult(List<NyukaCSVEntity> list) {
        StringBuffer result = new StringBuffer();
        DecimalFormat df5 = new DecimalFormat("00000");
        DecimalFormat df9 = new DecimalFormat("000000000");
        //DecimalFormat df4 = new DecimalFormat("0000");

        // **********************************
        // ヘッダー項目
        // **********************************

        if (list == null) {
            return result.toString();
        }
        for (int i = 0; i < list.size(); i++) {
            NyukaCSVEntity entity = (NyukaCSVEntity) list.get(i);
            /* 便ID */
            result.append(CommonTool.getLeftB(entity.getBin_id(), 3));
            /* 管理工場 */
            result.append(CommonTool.getLeftB(entity.getKanri_kojo(), 4));
            /* 搬入日 */
            result.append(CommonTool.getLeftB(entity.getHan_ymd(), 8));
            /* 特車区分 */
            result.append(CommonTool.getLeftB(entity.getTokusya_kb(), 1));
            /* 特車回数 */
            result.append(CommonTool.getLeftB(entity.getTokusya_kai(), 2));
            /* 得意先品番 */
            result.append(CommonTool.getLeftB(entity.getTk_hin(), 25));
            /* 収容数 */
            result.append(df5.format(Double.parseDouble(entity.getSyuyo_su())));
            /* 矢崎背番 */
            result.append(CommonTool.getRightB(
                    CommonTool.get0suppress(entity.getSeban().trim()), 4));
            /* 指示箱数 */
            result.append(df9.format(Double.parseDouble(entity.getSiji_hako())));
            /* 指示数 */
            result.append(df9.format(Double.parseDouble(entity.getSiji_su())));
            /* 搬入箱数 */
            result.append(df9.format(Double.parseDouble(entity.getHan_hako())));
            /* 搬入数 */
            result.append(df9.format(Double.parseDouble(entity.getHan_su())));
            /* 出荷拠点 */
            result.append(CommonTool.getLeftB(entity.getS_kyoten(), 4));
            /* 製造場所 */
            result.append(CommonTool.getLeftB(entity.getSeizo_ba(), 4));
            /* 処理日 */
            result.append(CommonTool.getLeftB(entity.getSyori_ymd(), 8));
            /* 処理時間 */
            result.append(CommonTool.getLeftB(entity.getSyori_hms(), 6));
            /* 確定フラグ */
            result.append(CommonTool.getLeftB(entity.getKakutei_fg(), 1));
            /* OPコード */
            result.append(CommonTool.getLeftB(entity.getOpcode(), 5));
            /* 便No */
            result.append(CommonTool.getLeftB(entity.getBin_no(), 2));

            result.append("\r\n");
        }
        return result.toString();
    }

}
