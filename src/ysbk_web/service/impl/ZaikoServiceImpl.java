/*
 * クラス名: ZaikoServiceImpl
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/28
 *
 * Copyright:
 */

package ysbk_web.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.HttpServletResponse;

import ysbk_web.condition.ZaikoCondition;
import ysbk_web.dao.ZaikoDao;
import ysbk_web.model.zaiko.ZaikoEntity;
import ysbk_web.service.ZaikoService;
import ysbk_web.utility.CSVDownload;
import ysbk_web.utility.CommandException;
import ysbk_web.utility.CommonTool;
import ysbk_web.utility.Constants;
import ysbk_web.view.UserView;

public class ZaikoServiceImpl implements ZaikoService {
    private static ZaikoDao dao;

    public void setDao(ZaikoDao dao) {
        this.dao = dao;
    }

    /**
     * 在庫データを取得する
     * 
     * @param userView ユーザ情報
     * @param syori_ymd 処理日
     * @param downloadType
     * @throws CommandException
     */
    @Override
    public void getCsvDownload(UserView userView, String syori_ymd,
            String downloadType, HttpServletResponse response)
            throws CommandException {
        List<ZaikoEntity> list = new ArrayList<ZaikoEntity>();
        ZaikoCondition zaikoCondition = new ZaikoCondition();
        zaikoCondition.setUserView(userView);

        try {
            if ("1".equals(downloadType)) {
                zaikoCondition.setDownloadType(downloadType);
                list = dao.csvOutput(zaikoCondition);
            } else {
                zaikoCondition.setDownloadType(downloadType);
                zaikoCondition.setSyori_ymd(syori_ymd);
                list = dao.csvRirekiOutput(zaikoCondition);
            }

            List<ZaikoEntity> entitys = this
                    .formatCsvOutput(list, downloadType);
            String result = this.getOutputResult(entitys, downloadType);

            String fname = null;
            if ("1".equals(downloadType)) {
                fname = "ZAIKO-" + CommonTool.getDate() + ".txt";
            } else {
                fname = "ZAIKO-RIREKI-" + CommonTool.getDate() + ".txt";
            }
            CSVDownload.csvWrite(fname, result, response);
        } catch (CommandException e) {
            throw e;
        } catch (Exception ex) {
            throw new CommandException(
                    ex.getMessage(),
                    "error.ZaikoCSVDownloadServiceImpl.getCsvDownload.Exception",
                    Constants.EXCEPTION);
        }

    }

    public List<ZaikoEntity> formatCsvOutput(List<ZaikoEntity> zaikos,
            String downloadType) {
        List<ZaikoEntity> list = new ArrayList<ZaikoEntity>();
        if (zaikos.isEmpty()) {
            return list;
        }
        DecimalFormat df;
        String wk;
        ZaikoEntity entity;
        for (ZaikoEntity zaiko : zaikos) {
            entity = new ZaikoEntity();

            if ("2".equals(downloadType)) {

                /* 処理日 */
                wk = CommonTool.checkEmpty(zaiko.getSyori_ymd());
                entity.setSyori_ymd(wk.substring(0, 4) + "/"
                        + wk.substring(4, 6) + "/" + wk.substring(6));

                /* 処理時刻 */
                wk = CommonTool.checkEmpty(zaiko.getSyori_hms());
                entity.setSyori_hms(wk.substring(0, 2) + ":"
                        + wk.substring(2, 4) + ":" + wk.substring(4));
            }

            /* 物流拠点 */
            entity.setB_kyoten(CommonTool.checkEmpty(zaiko.getB_kyoten()));

            /* 得意先品番 */
            wk = new String(CommonTool.checkEmpty(zaiko.getTk_hin()));
            entity.setTk_hin(wk.substring(0, 5) + "-" + wk.substring(5, 10)
                    + "-" + wk.substring(10));

            /* 収容数 */
            df = new DecimalFormat("##,##0");
            entity.setSyuyo_su(df.format(Double.parseDouble(zaiko.getSyuyo_su())));

            /* 矢崎背番 */
            entity.setSeban(CommonTool.checkEmpty(zaiko.getSeban()));

            /* 引当可能在庫数 */
            df = new DecimalFormat("###,###,##0");
            entity.setHiki_zaiko_su(df.format(Double.parseDouble(zaiko
                    .getHiki_zaiko_su())));

            /* ロケ在庫数 */
            df = new DecimalFormat("###,###,##0");
            entity.setLoc_zaiko_su(df.format(Double.parseDouble(zaiko
                    .getLoc_zaiko_su())));

            /* 在庫数 */
            df = new DecimalFormat("###,###,##0");
            entity.setZaiko_su(df.format(Double.parseDouble(zaiko.getZaiko_su())));
            if (downloadType.equals("2")) {
                /* 最終納入日 */
                entity.setLst_nou_ymd("");

                /* 最終搬入日 */
                entity.setLst_han_ymd("");
            } else {
                /* 最終納入日 */
                wk = CommonTool.checkEmpty(zaiko.getLst_nou_ymd());
                entity.setLst_nou_ymd(wk.substring(0, 4) + "/"
                        + wk.substring(4, 6) + "/" + wk.substring(6));

                /* 最終搬入日 */
                wk = CommonTool.checkEmpty(zaiko.getLst_han_ymd());
                entity.setLst_han_ymd(wk.substring(0, 4) + "/"
                        + wk.substring(4, 6) + "/" + wk.substring(6));
            }

            /* アイデントNo */
            entity.setIdent_no(CommonTool.checkEmpty(zaiko.getIdent_no()));

            /* BC連番 */
            entity.setBc_no(CommonTool.checkEmpty(zaiko.getBc_no()));

            list.add(entity);
        }

        return list;
    }

    /**
     * CSVファイル作成字符串
     * 
     * @param list 　CSVファイル内容
     * @return　String　CSVファイル作成
     */
    private String getOutputResult(List<ZaikoEntity> list, String downloadType) {
        StringBuffer result = new StringBuffer();
        DecimalFormat df5 = new DecimalFormat("00000");
        DecimalFormat df9 = new DecimalFormat("000000000");
        DecimalFormat df2 = new DecimalFormat("00");
        DecimalFormat df4 = new DecimalFormat("0000");
        StringBuffer wk;
        Date date = new Date();
        // カレンダーオブジェクトを生成
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("JST"));
        // カレンダーオブジェクトに現在の日付を設定
        calendar.setTime(date);

        if (list == null) {
            return result.toString();
        }
        for (int i = 0; i < list.size(); i++) {
            ZaikoEntity entity = (ZaikoEntity) list.get(i);

            result.append(CommonTool.getLeftB(entity.getB_kyoten(), 4));

            /* メーカー品番 */
            result.append(CommonTool.getLeftB(
                    entity.getTk_hin().replaceAll("-", ""), 25));

            /* 収容数 */

            result.append(CommonTool.getRightB(
                    entity.getSyuyo_su().replaceAll(",", ""), 5));

            /* 矢崎背番 */

            result.append(CommonTool.getRightB(
                    CommonTool.get0suppress(entity.getSeban().trim()), 4));

            /* 引当可能在庫数 */

            result.append(CommonTool.getRightB(entity.getHiki_zaiko_su()
                    .replaceAll(",", ""), 9));

            /* ロケ在庫数 */
            result.append(CommonTool.getRightB(entity.getLoc_zaiko_su()
                    .replaceAll(",", ""), 9));

            /* 在庫数 */
            result.append(CommonTool.getRightB(
                    entity.getZaiko_su().replaceAll(",", ""), 9));

            /* 最終納入日 */
            result.append(CommonTool.getLeftB(entity.getLst_nou_ymd()
                    .replaceAll("/", ""), 8));

            /* 最終搬入日 */
            result.append(CommonTool.getLeftB(entity.getLst_han_ymd()
                    .replaceAll("/", ""), 8));

            // 履歴検索の場合
            if ("2".equals(downloadType)) {
                /* 処理日 */
                result.append(CommonTool.getLeftB(entity.getSyori_ymd()
                        .replaceAll("/", ""), 8));

                /* 処理時間 */
                result.append(CommonTool.getLeftB(entity.getSyori_hms()
                        .replaceAll(":", ""), 6));

                // 在庫情報の場合、現在日時を付与
            } else {
                wk = new StringBuffer();
                wk.append(df4.format(calendar.get(Calendar.YEAR)));
                wk.append(df2.format(calendar.get(Calendar.MONTH) + 1));
                wk.append(df2.format(calendar.get(Calendar.DATE)));
                /* 現在日 */
                result.append(wk.toString());

                /* 現在時間 */
                result.append(CommonTool.GetTime());
            }
            // End
            // アイデントNo
            result.append(CommonTool.getLeftB(entity.getIdent_no(), 10));
            // BC連番
            result.append(CommonTool.getLeftB(entity.getBc_no(), 3));
            // End
            result.append("\r\n");
        }
        return result.toString();
    }

}
