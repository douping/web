/*
 * クラス名: NonyuProgServiceImpl
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/31
 *
 * Copyright:
 */
package ysbk_web.service.impl;

import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.apache.log4j.Logger;

import ysbk_web.condition.NonyuProgCondition;
import ysbk_web.condition.NonyuProgDetailCondition;
import ysbk_web.dao.HinbanZaikoDao;
import ysbk_web.dao.NonyuProgDao;
import ysbk_web.model.nonyuProg.NonyuProgDetailEntity;
import ysbk_web.model.nonyuProg.NonyuProgEntity;
import ysbk_web.service.NonyuProgService;
import ysbk_web.utility.CommandException;
import ysbk_web.utility.CommonTool;
import ysbk_web.utility.Constants;
import ysbk_web.utility.Keys;
import ysbk_web.utility.Utility;
import ysbk_web.view.UserView;

public class NonyuProgServiceImpl implements NonyuProgService {

    private static Logger logger = Logger.getLogger(NonyuProgServiceImpl.class);

    private NonyuProgDao nonyuProgDao;

    public void setNonyuProgDao(NonyuProgDao nonyuProgDao) {
        this.nonyuProgDao = nonyuProgDao;
    }

    private static HinbanZaikoDao dao;

    public void setDao(HinbanZaikoDao dao) {
        this.dao = dao;
    }

    @Override
    public List<NonyuProgEntity> findAllNonyuProg(UserView userView)
            throws CommandException {
        List<NonyuProgEntity> listDB = Collections.EMPTY_LIST;
        try {
            // 検索条件取得
            NonyuProgCondition nonyuProgCondition = new NonyuProgCondition();
            nonyuProgCondition.setSort_fg("0");
            nonyuProgCondition.setCond_fg(false);
            listDB = nonyuProgDao.findNonyuProgByCondtion(nonyuProgCondition);
            logger.info("fh for nonyuProg check1 listDB=" + listDB);

        } catch (CommandException e) {
            throw e;
        } catch (Exception e) {
            throw new CommandException(e.getMessage(),
                    "error.NonyuProgServiceImpl.findAllNonyuProg.Exception",
                    Constants.EXCEPTION);
        }
        return formatNonyuProgData(listDB);
    }

    @Override
    public List<NonyuProgEntity> findAllNonyuProg(UserView userView, String rg,
            String sort_fg) throws CommandException {
        List<NonyuProgEntity> listDB = Collections.EMPTY_LIST;
        // List<NonyuProgEntity> list = Collections.EMPTY_LIST;
        try {
            // 検索条件取得
            if (("").equals(sort_fg) || null == sort_fg) {
                sort_fg = "0";
            }
            NonyuProgCondition nonyuProgCondition = new NonyuProgCondition();
            nonyuProgCondition.setRg(rg);
            nonyuProgCondition.setSort_fg(sort_fg);
            nonyuProgCondition.setCond_fg(true);
            listDB = nonyuProgDao.findNonyuProgByCondtion(nonyuProgCondition);
            logger.info("fh for nonyuProg check1 listDB=" + listDB);

        } catch (CommandException e) {
            throw e;
        } catch (Exception e) {
            throw new CommandException(e.getMessage(),
                    "error.NonyuProgServiceImpl.findAllNonyuProg.Exception",
                    Constants.EXCEPTION);
        }
        return formatNonyuProgData(listDB);
    }

    /**
     * 納入進捗 詳細 選択した一覧画面情報を取得
     */
    @Override
    public List<NonyuProgDetailEntity> findAllNonyuProgDetail(
            UserView userView, String nou_ymd, String rg, String bin_no,
            String noujou_fg) throws CommandException {
    	List<NonyuProgDetailEntity> nonyuProgDetails = new ArrayList<NonyuProgDetailEntity>();
        try{
        	   NonyuProgDetailCondition nonyuProgDetailCondition = new NonyuProgDetailCondition();
               nonyuProgDetailCondition.setSiire(userView.getSiire());
               nonyuProgDetailCondition.setNou_ymd(nou_ymd.replaceAll("/", ""));
               nonyuProgDetailCondition.setRg(rg);
               nonyuProgDetailCondition.setBin_no(bin_no);
               nonyuProgDetailCondition.setB_kyoten(Keys.B_KYOTEN);
               nonyuProgDetailCondition.setNoujou_fg(noujou_fg);
               logger.info("fh  check condition "
                       + nonyuProgDetailCondition.getNoujou_fg());
               List<NonyuProgDetailEntity> listDB = nonyuProgDao
                       .findNonyuProgDetailByCondtion(nonyuProgDetailCondition);
               logger.info("fh  check listDB=size= " + listDB.size()); 
               nonyuProgDetails = formatNonyuProgDetail(listDB);
            } catch (CommandException e) {
                throw e;
            } catch (Exception e) {
                throw new CommandException(e.getMessage(),
                        "error.NonyuProgServiceImpl.findAllNonyuProgDetail.Exception",
                        Constants.EXCEPTION);
            }
        return nonyuProgDetails;

    }

    @Override
    public List<NonyuProgEntity> formatNonyuProgData(
            List<NonyuProgEntity> nonyuProgs) {
        if (nonyuProgs.isEmpty()) {
            return nonyuProgs;
        }
        List<NonyuProgEntity> entitys = new ArrayList<NonyuProgEntity>();
        DecimalFormat df;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String wk;
        for (NonyuProgEntity nonyuProg : nonyuProgs) {
            NonyuProgEntity entity = new NonyuProgEntity();

            /* 納入日 */
            entity.setNou_ymd(CommonTool.checkEmpty(new SimpleDateFormat(
                    "yyyy/MM/dd").format(sdf.parse(nonyuProg.getNou_ymd(),
                    new ParsePosition(0)))));

            /* RG */
            entity.setRg(CommonTool.checkEmpty(nonyuProg.getRg()));

            /* 便 */
            entity.setBin_no(CommonTool.checkEmpty(nonyuProg.getBin_no()));

            /* 出発時間 */
            wk = new String(CommonTool.checkEmpty(nonyuProg.getNou_tim()));
            entity.setNou_tim(wk.substring(0, 2) + ":" + wk.substring(2, 4));

            /* 受注区分(表示名) */
            if ("0".equals(nonyuProg.getJuchu_kb())) {
                entity.setJuchu_kb_name("TOPPS");
            } else if ("1".equals(nonyuProg.getJuchu_kb())) {
                entity.setJuchu_kb_name("その他");
            }

            /* 追 */
            if ("1".equals(nonyuProg.getTuika_fg())) {
                entity.setTuika_fg("●");
            } else {
                entity.setTuika_fg("");
            }

            /* Ｔ */
            if ("0".equals(nonyuProg.getJuchu_kb())
                    || "2".equals(nonyuProg.getJuchu_kb())) {
                entity.setW_topps_jyucyu("Ｔ");
            } else if ("1".equals(nonyuProg.getJuchu_kb())) {
                entity.setW_topps_jyucyu("*");
            }

            /* 手 */
            if ("1".equals(nonyuProg.getJuchu_kb())
                    || "2".equals(nonyuProg.getJuchu_kb())) {
                entity.setW_hand_jyucyu("手");
            } else if ("0".equals(nonyuProg.getJuchu_kb())) {
                entity.setW_hand_jyucyu("*");
            }

            /* 書 */
            if (!"".equals(nonyuProg.getHako_ymd().trim())) {
                entity.setW_siji_hakko("書");
            } else {
                entity.setW_siji_hakko("");
            }

            /* 中 */
            if (Double.valueOf(nonyuProg.getJunbi_hako()) > 0) {
                entity.setW_jyunbi_cyu("中");
            } else {
                entity.setW_jyunbi_cyu("");
            }

            /* 完 */
            if (Double.valueOf(nonyuProg.getSiji_hako()).equals(
                    Double.valueOf(nonyuProg.getJunbi_hako()))) {
                entity.setW_jyunbi_kan("完");
            } else {
                entity.setW_jyunbi_kan("");
            }

            /* 出 */
            if (!"0".equals(nonyuProg.getNoujou_fg())) {
                entity.setW_syukka_kan("出");
            } else {
                entity.setW_syukka_kan("");
            }

            /* 引当 */
            wk = null;
            if ("0".equals(nonyuProg.getHiki_fg())) {
                wk = " ";
            } else if ("1".equals(nonyuProg.getHiki_fg())) {
                wk = "○";
            } else if ("2".equals(nonyuProg.getHiki_fg())) {
                wk = "▲";
            } else if ("3".equals(nonyuProg.getHiki_fg())) {
                wk = "×";
            } else {
                wk = "";
            }

            entity.setHiki_fg(wk);
            // 引当抑止フラグ情報追加
            if ("0".equals(nonyuProg.getHikiyokusi_fg())) {
                entity.setHikiate(wk + " ");
            } else if ("1".equals(nonyuProg.getHikiyokusi_fg())) {
                entity.setHikiate(wk + "抑");
            }

            /* 指示箱数 */
            df = new DecimalFormat("###,###,##0");
            entity.setSiji_hako(df.format(Double.valueOf(nonyuProg
                    .getSiji_hako())));

            /* 不足箱数 */
            df = new DecimalFormat("###,###,##0");
            entity.setFusoku_hako(df.format(Double.valueOf(nonyuProg
                    .getFusoku_hako())));

            /* 準備箱数 */
            df = new DecimalFormat("###,###,##0");
            entity.setJunbi_hako(df.format(Double.valueOf(nonyuProg
                    .getJunbi_hako())));
            /* 積載容積 */
            df = new DecimalFormat("0.000");
            entity.setSeki_vol(df.format(Double.valueOf(nonyuProg.getSeki_vol())));

            /* 受注区分 */
            entity.setJuchu_kb(CommonTool.checkEmpty(nonyuProg.getJuchu_kb()));
            /* 異常区分 */
            entity.setIjou_kb(CommonTool.checkEmpty(nonyuProg.getIjou_kb()));
            /* 納入状況フラグ */
            entity.setNoujou_fg(CommonTool.checkEmpty(nonyuProg.getNoujou_fg()));
            /* 引当抑止フラグ */
            entity.setHikiyokusi_fg(CommonTool.checkEmpty(nonyuProg
                    .getHikiyokusi_fg()));

            /* 納入日 + 納入時間 yyyymmddhhmmss */
            entity.setNou_daytime(nonyuProg.getNou_ymd()
                    + nonyuProg.getNou_tim() + "00");
            // logger.info("fh for nonyu check3 list(i)="+entity.getW_jyunbi_kan()+"nonyuProg.getSiji_hako()"+nonyuProg.getSiji_hako()+"nonyuProg.getJunbi_hako()"+nonyuProg.getJunbi_hako());
            entitys.add(entity);
        }
        return entitys;
    }

    @Override
    public List<NonyuProgDetailEntity> formatNonyuProgDetail(
            List<NonyuProgDetailEntity> nonyuProgDetails) {
        if (nonyuProgDetails.isEmpty()) {
            return nonyuProgDetails;
        }
        List<NonyuProgDetailEntity> entitys = new ArrayList<NonyuProgDetailEntity>();
        DecimalFormat df = new DecimalFormat("###,###,##0");
        String sWk = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        for (NonyuProgDetailEntity nonyuProgDetail : nonyuProgDetails) {
            NonyuProgDetailEntity entity = new NonyuProgDetailEntity();

            /* 追 */
            if ("1".equals(nonyuProgDetail.getTuika_fg())) {
                entity.setTuika_fg("●");
            } else {
                entity.setTuika_fg("");
            }
            /* 支給先 */
            entity.setTk_kojo(nonyuProgDetail.getTk_kojo());
            /* 受入 */
            entity.setTk_uke(nonyuProgDetail.getTk_uke());
            /* メーカー背番 */
            entity.setTk_seban(nonyuProgDetail.getTk_seban());
            /* メーカー品番 */
            sWk = new String(CommonTool.checkEmpty(nonyuProgDetail.getTk_hin()));
            entity.setTk_hin(sWk.substring(0, 5) + "-" + sWk.substring(5, 10)
                    + "-" + sWk.substring(10));
            /* 枝番 */
            entity.setEdaban(nonyuProgDetail.getEdaban());
            /* 仕入背番 */
            entity.setSeban(nonyuProgDetail.getSeban());
            /* 収容数 */
            df = new DecimalFormat("##,##0");
            entity.setSyuyo_su(df.format(Double.valueOf(nonyuProgDetail
                    .getSyuyo_su())));
            /* 納入番号 */
            entity.setTp_noban(nonyuProgDetail.getTp_noban());
            /* 受注数 */
            df = new DecimalFormat("###,###,##0");
            entity.setSiji_su(df.format(Double.valueOf(nonyuProgDetail
                    .getSiji_su())));
            /* 不足数 */
            df = new DecimalFormat("###,###,##0");
            entity.setFusoku_su(df.format(Double.valueOf(nonyuProgDetail
                    .getFusoku_su())));
            /* 準備数 */
            if (" ".equals(nonyuProgDetail.getJunbi_su())) {
                entity.setJunbi_su("");
            } else {
                df = new DecimalFormat("###,###,##0");
                entity.setJunbi_su(df.format(Double.valueOf(nonyuProgDetail
                        .getJunbi_su())));
            }
            /* 打切残数 */
            df = new DecimalFormat("###,###,##0");
            entity.setUchi_zan_su(df.format(Double.valueOf(nonyuProgDetail
                    .getUchi_zan_su())));
            /* ｵﾘｼﾞﾅﾙ納入日 */
            entity.setOrg_nou_ymd(CommonTool.checkEmpty(new SimpleDateFormat(
                    "yyyy/MM/dd").format(sdf.parse(
                    nonyuProgDetail.getOrg_nou_ymd(), new ParsePosition(0)))));
            /* ｵﾘｼﾞﾅﾙ便 */
            entity.setOrg_bin_no(nonyuProgDetail.getOrg_bin_no());
            /* ｵﾘｼﾞﾅﾙ指示数 */
            df = new DecimalFormat("###,###,##0");
            entity.setOrg_siji_su(df.format(Double.valueOf(nonyuProgDetail
                    .getOrg_siji_su())));
            /* ｵﾘｼﾞﾅﾙ枝番 */
            entity.setOrg_edaban(nonyuProgDetail.getOrg_edaban());

            /* 打切フラグ */
            entity.setUchi_fg(nonyuProgDetail.getUchi_fg());
            /* 引当フラグ */
            entity.setHiki_fg(nonyuProgDetail.getHiki_fg());

            entitys.add(entity);
        }
        return entitys;
    }

    @Override
    public Map<String, String> setRequest() throws Exception {
        Map request = new HashMap<String, String>();
        try{
        	 // システム管理情報 NAIYO内容取得
            String naiyo = dao.getNaiyo();
            /* 稼働日１ 黄色判定 */
            // (指定分後の出発予定だが、完了していない場合)
            Date date = new Date();
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("JST"));
            calendar.setTime(date);
            calendar.add(Calendar.MINUTE, 30);

            String sInDate = new SimpleDateFormat("yyyyMMdd").format(calendar
                    .getTime());
            String sInTime = new SimpleDateFormat("HHmmss").format(calendar
                    .getTime());
            request.put("kado_date1", Utility.getKadoDate(naiyo, sInDate, sInTime));

            /* 稼働日２ ピンク判定 */
            // (現在日時より古いくて、出荷完了していない場合)
            request.put("kado_date2", Utility.getKadoDate(naiyo));
        } catch (CommandException e) {
            throw e;
        } catch (Exception e) {
            throw new CommandException(e.getMessage(),
                    "error.NonyuProgServiceImpl.findAllNonyuProgDetail.Exception",
                    Constants.EXCEPTION);
        }
       
        return request;
    }
}
