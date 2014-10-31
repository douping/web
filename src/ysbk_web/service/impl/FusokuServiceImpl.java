/*
 * クラス名: FusokuServiceImpl
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/30
 *
 * Copyright:
 */
package ysbk_web.service.impl;

import java.text.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import ysbk_web.dao.FusokuDao;
import ysbk_web.model.fusoku.FusokuEntity;
import ysbk_web.service.FusokuService;
import ysbk_web.utility.CheckTool;
import ysbk_web.utility.CommandException;
import ysbk_web.utility.CommonTool;
import ysbk_web.utility.Constants;
import ysbk_web.utility.Utility;
import ysbk_web.view.UserView;

/**
 * @author 不足数一覧検索ビーン。
 */
public class FusokuServiceImpl implements FusokuService {
    private static Logger logger = Logger.getLogger(FusokuServiceImpl.class);

    private FusokuDao fusokuDao;

    public void setFusokuDao(FusokuDao fusokuDao) {
        this.fusokuDao = fusokuDao;
    }

    @Override
    public List<FusokuEntity> findFusoku(UserView userView)
            throws CommandException {
        List<FusokuEntity> listDB = Collections.EMPTY_LIST;
        try {
            HashMap<String, String> map = new HashMap<String, String>();
            StringBuffer selSqlWhere = new StringBuffer();
            // 検索条件取得
            /* 管理工場 */
            if (CheckTool.isNotEmpty(userView.getSiire())) {
                selSqlWhere.append("AND M01.KANRI_KOJO = '"
                        + userView.getSiire() + "'");
            }
            /* RG */
            if (userView.getRg() != null) {
                // TB_WEB_RG_MAに登録したデータ分追加する
                selSqlWhere.append(Utility.getRG_SQL(userView));
            }
            map.put("selSqlWhere", selSqlWhere.toString());
            logger.info("fh for fusoku check0 selSqlWhere="
                    + selSqlWhere.toString());
            listDB = fusokuDao.findFusoku(map);
            logger.info("fh for fusoku check1 selSqlWhere="
                    + selSqlWhere.toString() + "listDB=" + listDB);

        } catch (CommandException e) {
            throw e;
        } catch (Exception e) {
            throw new CommandException(e.getMessage(),
                    "error.FusokuServiceImpl.findFusoku.Exception",
                    Constants.EXCEPTION);
        }
        return formatFusokuData(listDB);
    }

    @Override
    public List<FusokuEntity> formatFusokuData(List<FusokuEntity> fusokus) {
        if (fusokus.isEmpty()) {
            return fusokus;
        }
        List<FusokuEntity> entitys = new ArrayList<FusokuEntity>();
        DecimalFormat df;
        String wk;
        for (FusokuEntity fusoku : fusokus) {
            FusokuEntity entity = new FusokuEntity();

            /* 納入日 */
            wk = CommonTool.checkEmpty(fusoku.getNou_ymd());
            entity.setNou_ymd(wk.substring(0, 4) + "/" + wk.substring(4, 6)
                    + "/" + wk.substring(6));

            /* RG */
            entity.setRg(CommonTool.checkEmpty(fusoku.getRg()));

            /* 便 */
            entity.setBin_no(CommonTool.checkEmpty(fusoku.getBin_no()));

            /* 受入 */
            entity.setTk_uke(CommonTool.checkEmpty(fusoku.getTk_uke()));

            /* 得意先品番 */
            wk = new String(CommonTool.checkEmpty(fusoku.getTk_hin()));
            entity.setTk_hin(wk.substring(0, 5) + "-" + wk.substring(5, 10)
                    + "-" + wk.substring(10));

            /* 収容数 */
            df = new DecimalFormat("##,##0");
            entity.setSyuyo_su(df.format(Double.valueOf(fusoku.getSyuyo_su())));

            /* 不足数 */
            df = new DecimalFormat("###,###,##0");
            entity.setFusoku_su(df.format(Double.valueOf(fusoku.getFusoku_su())));

            /* 指示数 */
            df = new DecimalFormat("###,###,##0");
            entity.setSiji_su(df.format(Double.valueOf(fusoku.getSiji_su())));

            /* 得意先背番 */
            entity.setTk_seban(CommonTool.checkEmpty(fusoku.getTk_seban()));

            /* 管理工場 */
            entity.setKanri_kojo(CommonTool.checkEmpty(fusoku.getKanri_kojo()));

            /* 出荷拠点 */
            entity.setS_kyoten(CommonTool.checkEmpty(fusoku.getS_kyoten()));

            /* 製造場所 */
            entity.setSeizo_ba(CommonTool.checkEmpty(fusoku.getSeizo_ba()));

            /* ロケーション */
            entity.setLocation(CommonTool.checkEmpty(fusoku.getLocation()));

            entitys.add(entity);
        }
        return entitys;
    }
}
