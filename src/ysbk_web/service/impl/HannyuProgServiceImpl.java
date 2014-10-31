/*
 * クラス名: HannyuProgServiceImpl
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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import ysbk_web.condition.HannyuProgDetailCondition;
import ysbk_web.dao.HannyuProgDao;
import ysbk_web.model.hannyuProg.HannyuProgDetailEntity;
import ysbk_web.model.hannyuProg.HannyuProgEntity;
import ysbk_web.service.HannyuProgService;
import ysbk_web.utility.CommandException;
import ysbk_web.utility.CommonTool;
import ysbk_web.utility.Constants;
import ysbk_web.view.UserView;

public class HannyuProgServiceImpl implements HannyuProgService {

    private static Logger logger = Logger
            .getLogger(HannyuProgServiceImpl.class);

    private HannyuProgDao hannyuProgDao;

    public void setHannyuProgDao(HannyuProgDao hannyuProgDao) {
        this.hannyuProgDao = hannyuProgDao;
    }

    @Override
    public List<HannyuProgEntity> findHannyuProg(UserView userView)
            throws CommandException {
        List<HannyuProgEntity> listDB = Collections.EMPTY_LIST;
        try {
            // 検索条件取得
            HashMap<String, String> map = new HashMap<String, String>();
            /* 管理工場 */
            String siire = userView.getSiire();
            map.put("siire", siire);
            /* YYMMDD */
            String han_ymd = CommonTool.getDate2();
            map.put("han_ymd", han_ymd);
            listDB = hannyuProgDao.findHannyuProg(map);
            logger.info("fh for hannyuProg check1 listDB=" + listDB);
        } catch (CommandException e) {
            throw e;
        } catch (Exception e) {
            throw new CommandException(e.getMessage(),
                    "error.HannyuProgServiceImpl.findHannyuProg.Exception",
                    Constants.EXCEPTION);
        }
        return formatHannyuProgData(listDB);
    }

    @Override
    public List<HannyuProgDetailEntity> findHannyuProgDetail(String hanjou_fg,
            String bin_id, String han_ymd, String tokusya_kb, String tokusya_kai)
            throws CommandException {
        List<HannyuProgDetailEntity> listDB = Collections.EMPTY_LIST;
        try {
            // 検索条件取得
            HannyuProgDetailCondition hannyuProgDetailCondition = new HannyuProgDetailCondition();
            hannyuProgDetailCondition.setBin_id(bin_id);
            hannyuProgDetailCondition.setHan_ymd(han_ymd.replaceAll("/", ""));
            if ("通常".equals(tokusya_kb)) {
                hannyuProgDetailCondition.setTokusya_kb("0");
            } else {
                hannyuProgDetailCondition.setTokusya_kb("1");
            }
            hannyuProgDetailCondition.setHanjou_fg(hanjou_fg);
            hannyuProgDetailCondition.setTokusya_kai(tokusya_kai);

            listDB = hannyuProgDao
                    .findHannyuProgDetail(hannyuProgDetailCondition);
            logger.info("fh for hannyuProg check1 listDB=" + listDB);

        } catch (CommandException e) {
            throw e;
        } catch (Exception e) {
            throw new CommandException(e.getMessage(),
                    "error.HannyuProgServiceImpl.findHannyuProgDetail.Exception",
                    Constants.EXCEPTION);
        }
        return formatHannyuProgDetail(listDB);

    }

    @Override
    public List<HannyuProgEntity> formatHannyuProgData(
            List<HannyuProgEntity> hannyuProgs) {
        if (hannyuProgs.isEmpty()) {
            return hannyuProgs;
        }
        List<HannyuProgEntity> entitys = new ArrayList<HannyuProgEntity>();
        DecimalFormat df;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        for (HannyuProgEntity hannyuProg : hannyuProgs) {
            HannyuProgEntity entity = new HannyuProgEntity();
            /* 搬入日 */
            entity.setHan_ymd(CommonTool.checkEmpty(new SimpleDateFormat(
                    "yyyy/MM/dd").format(sdf.parse(hannyuProg.getHan_ymd(),
                    new ParsePosition(0)))));

            /* 管理工場 */
            entity.setKanri_kojo(CommonTool.checkEmpty(hannyuProg
                    .getKanri_kojo()));

            /* 出荷拠点 */
            entity.setS_kyoten(CommonTool.checkEmpty(hannyuProg.getS_kyoten()));

            /* 便 */
            entity.setBin_no(CommonTool.checkEmpty(hannyuProg.getBin_no()));

            /* 特車区分 */
            if ("0".equals(CommonTool.checkEmpty(hannyuProg.getTokusya_kb()))) {
                entity.setTokusya_kb("通常");
            } else {
                entity.setTokusya_kb("特車");
            }

            /* 回数 */
            entity.setTokusya_kai(CommonTool.checkEmpty(hannyuProg
                    .getTokusya_kai()));

            /* 便ID */
            entity.setBin_id(CommonTool.checkEmpty(hannyuProg.getBin_id()));

            /* 便名 */
            entity.setBin_nm(CommonTool.checkEmpty(hannyuProg.getBin_nm()));

            /* 状況 */
            entity.setHanjou_key(CommonTool.checkEmpty(hannyuProg
                    .getHanjou_fg()));
            if ("2".equals(CommonTool.checkEmpty(hannyuProg.getHanjou_fg()))) {
                entity.setHanjou_fg("照合中");
            } else if ("3".equals(CommonTool.checkEmpty(hannyuProg
                    .getHanjou_fg()))) {
                entity.setHanjou_fg("搬入確定");
            } else if ("4".equals(CommonTool.checkEmpty(hannyuProg
                    .getHanjou_fg()))) {
                entity.setHanjou_fg("指示有り");
            } else if ("5".equals(CommonTool.checkEmpty(hannyuProg
                    .getHanjou_fg()))) {
                entity.setHanjou_fg("指示有り");
            } else if ("6".equals(CommonTool.checkEmpty(hannyuProg
                    .getHanjou_fg()))) {
                entity.setHanjou_fg("照合済み");
            } else {
                entity.setHanjou_fg("");
            }

            /* 予定箱数 */
            df = new DecimalFormat("###,###,##0");
            entity.setSiji_hako(df.format(Double.valueOf(hannyuProg
                    .getSiji_hako())));
            /* 搬入箱数 */
            df = new DecimalFormat("###,###,##0");
            entity.setHan_hako(df.format(Double.valueOf(hannyuProg
                    .getHan_hako())));

            entitys.add(entity);
        }
        return entitys;
    }

    @Override
    public List<HannyuProgDetailEntity> formatHannyuProgDetail(
            List<HannyuProgDetailEntity> hannyuProgDetails) {
        if (hannyuProgDetails.isEmpty()) {
            return hannyuProgDetails;
        }
        List<HannyuProgDetailEntity> entitys = new ArrayList<HannyuProgDetailEntity>();
        String sWk = null;
        DecimalFormat df = new DecimalFormat("###,###,##0");
        for (HannyuProgDetailEntity hannyuProgDetail : hannyuProgDetails) {
            HannyuProgDetailEntity entity = new HannyuProgDetailEntity();
            /* メーカー品番 */
            sWk = new String(
                    CommonTool.checkEmpty(hannyuProgDetail.getTk_hin()));
            entity.setTk_hin(sWk.substring(0, 5) + "-" + sWk.substring(5, 10)
                    + "-" + sWk.substring(10));
            /* 収容数 */
            df = new DecimalFormat("##,##0");
            entity.setSyuyo_su(df.format(Double.valueOf(hannyuProgDetail
                    .getSyuyo_su())));
            /* 仕入背番 */
            entity.setSeban(hannyuProgDetail.getSeban());
            /* 予定数(指示数) */
            df = new DecimalFormat("###,###,##0");
            entity.setSiji_su(df.format(Double.valueOf(hannyuProgDetail
                    .getSiji_su())));
            /* 予定箱数(指示箱数) */
            df = new DecimalFormat("###,###,##0");
            entity.setSiji_hako(df.format(Double.valueOf(hannyuProgDetail
                    .getSiji_hako())));
            /* 搬入数 */
            df = new DecimalFormat("###,###,##0");
            entity.setHan_su(df.format(Double.valueOf(hannyuProgDetail
                    .getHan_su())));
            /* 搬入箱数 */
            df = new DecimalFormat("###,###,##0");
            entity.setHan_hako(df.format(Double.valueOf(hannyuProgDetail
                    .getHan_hako())));
            /* 差 */
            df = new DecimalFormat("###,###,##0");
            entity.setSa(df.format(Double.valueOf(hannyuProgDetail.getSa())));
            /* 出荷拠点 */
            entity.setS_kyoten(hannyuProgDetail.getS_kyoten());
            /* 製造場所 */
            entity.setSeizo_ba(hannyuProgDetail.getSeizo_ba());

            entitys.add(entity);
        }
        return entitys;
    }
}
