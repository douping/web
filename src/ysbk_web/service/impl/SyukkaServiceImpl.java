/*
 * クラス名: SyukkaServiceImpl
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/30
 *
 * Copyright:
 */

package ysbk_web.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import ysbk_web.condition.SyukkaCondition;
import ysbk_web.dao.SyukkaDao;
import ysbk_web.model.syukka.SyukkaCSVEntity;
import ysbk_web.model.syukka.SyukkaEntity;
import ysbk_web.service.SyukkaService;
import ysbk_web.utility.CSVDownload;
import ysbk_web.utility.CommandException;
import ysbk_web.utility.CommonTool;
import ysbk_web.utility.Constants;
import ysbk_web.utility.Keys;
import ysbk_web.view.SyukkaView;
import ysbk_web.view.UserView;

public class SyukkaServiceImpl implements SyukkaService {

    private static SyukkaDao dao;

    public void setDao(SyukkaDao dao) {
        this.dao = dao;
    }

    /**
     * 出荷情報明細取得
     */
    @Override
    public List<SyukkaView> getSyukkaResult(UserView userView,
            String downloadType, String nou_ymd) throws CommandException {
        String sTbl = this.getTblName(downloadType);
        String sBinNm = this.getDBBinName(downloadType);
        String sNou_Ymd = this.getDBNouYmdName(downloadType);
        SyukkaCondition syukkaCondition = new SyukkaCondition();
        List<SyukkaEntity> list = new ArrayList<SyukkaEntity>();
        List<SyukkaView> result = new ArrayList<SyukkaView>();
        try {
        	syukkaCondition.setDownloadType(downloadType);
            syukkaCondition.setNou_ymd(nou_ymd);
            syukkaCondition.setsNou_Ymd(sNou_Ymd);
            syukkaCondition.setsBinNm(sBinNm);
            syukkaCondition.setUserView(userView);
            syukkaCondition.setsTbl(sTbl);
            if ("6".equals(downloadType)) {
            	list = dao.findSyukkaToppsTrasabiResult(syukkaCondition);
            } else {
                list = dao.findSyukkaResult(syukkaCondition);
            }
            result = formatSyukkaList(list);
        } catch (CommandException e) {
            throw e;
        } catch (Exception ex) {
            throw new CommandException(ex.getMessage(),
                    "error.SyukkaServiceImpl.getSyukkaResult.Exception",
                    Constants.EXCEPTION);
        }
        return result;
    }

    /**
     * DBから取得したデータを出荷情報画面レイアウトに転換
     */
    public List<SyukkaView> formatSyukkaList(List<SyukkaEntity> syukkaEntitys) {
        SyukkaView entity;
        String wk = null;
        List<SyukkaView> list = new ArrayList<SyukkaView>();
        for (SyukkaEntity syukkaEntity : syukkaEntitys) {
            entity = new SyukkaView();
            if (syukkaEntity.getCnt() <= syukkaEntity.getSumCnt()) {
                entity.setJyushin("済");
            } else {
                entity.setJyushin("");
            }

            /* 納入日 */
            wk = CommonTool.checkEmpty(syukkaEntity.getNou_ymd());
            entity.setNou_ymd(wk.substring(0, 4) + "/" + wk.substring(4, 6)
                    + "/" + wk.substring(6, 8));

            /* 便No */
            entity.setBin_no(CommonTool.checkEmpty(syukkaEntity.getBin_no()));

            /* 得意先受入 */
            entity.setTk_uke(CommonTool.checkEmpty(syukkaEntity.getTk_uke()));

            /* RG */
            entity.setRg(CommonTool.checkEmpty(syukkaEntity.getRg()));

            list.add(entity);
        }
        return list;
    }

    /**
     * download前SosinFlgの更新
     */
    @Override
    public void updateSosinFlg(UserView userView, String downloadType,
            String downFlg, List<String> checkFlg) throws CommandException {
        if (checkFlg.isEmpty()) {
            return;
        } else {
            try {
                String sTbl = this.getTblName(downloadType);
                String sBinNm = this.getDBBinName(downloadType);
                String sNou_Ymd = this.getDBNouYmdName(downloadType);
                SyukkaCondition syukkaCondition = new SyukkaCondition();
                syukkaCondition.setUserView(userView);
                syukkaCondition.setsTbl(sTbl);
                syukkaCondition.setsBinNm(sBinNm);
                syukkaCondition.setsNou_Ymd(sNou_Ymd);
                syukkaCondition.setDownloadType(downloadType);
                syukkaCondition.setDownFlg(downFlg);
                for (String str : checkFlg) {
                    String[] arr = str.split(",");
                    // 納入日
                    syukkaCondition.setNou_ymd(arr[0].replaceAll("/", ""));
                    // 便No
                    syukkaCondition.setBin_no(arr[1]);
                    // 受入
                    syukkaCondition.setTk_uke(arr[2]);
                    // RG
                    syukkaCondition.setRg(arr[3]);

                    dao.updateSosinFlg(syukkaCondition);
                }

            } catch (CommandException e) {
                throw e;
            } catch (Exception ex) {
                throw new CommandException(ex.getMessage(),
                        "error.SyukkaServiceImpl.updateSosinFlg.Exception",
                        Constants.EXCEPTION);
            }
        }
    }

    /**
     * CSV取得
     */
    public void getCsvOutputResult(UserView userView, String downloadType,
            String downFlg, List<String> checkFlg, String nou_ymd,
            HttpServletResponse response) throws CommandException {
        String sTbl = this.getTblName(downloadType);
        String sCSVBinNm = this.getDBCSVBinName(downloadType);
        String sSijiSuNm = this.getDBSijiSuName(downloadType);
        String sSijiHakoNm = this.getDBSijiHakoName(downloadType);
        String sSikyuSakiNm = this.getDBSikyuSakiName(downloadType);
        String sCSVNouYmd = this.getDBCSVNouYmdName(downloadType);
        String sNouYmd = this.getDBNouYmdName(downloadType);
        String sBinNm = this.getDBBinName(downloadType);

        try {
            List<SyukkaCSVEntity> syukkaAll = new ArrayList<SyukkaCSVEntity>();
            List<SyukkaCSVEntity> syukkaCsvs = new ArrayList<SyukkaCSVEntity>();

            SyukkaCondition syukkaCondition = new SyukkaCondition();

            syukkaCondition.setUserView(userView);
            /* 納入日 */
            syukkaCondition.setNou_ymd(nou_ymd);
            if (!"6".equals(downloadType)) {
                syukkaCondition.setsTbl(sTbl);
                syukkaCondition.setsBinNm(sBinNm);
                syukkaCondition.setsNou_Ymd(sNouYmd);
                syukkaCondition.setDownloadType(downloadType);
                syukkaCondition.setDownFlg(downFlg);

                syukkaCondition.setsCSVNouYmd(sCSVNouYmd);
                syukkaCondition.setsCSVBinNm(sCSVBinNm);
                syukkaCondition.setsSijiSuNm(sSijiSuNm);
                syukkaCondition.setsSijiHakoNm(sSijiHakoNm);
                syukkaCondition.setsSikyuSakiNm(sSikyuSakiNm);
            } else {
            	syukkaCondition.setDownloadType(downloadType);
                syukkaCondition.setDownFlg(downFlg);
            }

            for (String str : checkFlg) {
                String[] arr = str.split(",");
                // 納入日
                syukkaCondition.setNou_ymd(arr[0].replaceAll("/", ""));
                // 便No
                syukkaCondition.setBin_no(arr[1]);
                // 受入
                syukkaCondition.setTk_uke(arr[2]);
                // RG
                syukkaCondition.setRg(arr[3]);

                syukkaCsvs = dao.findCsvOutputResult(syukkaCondition);

                syukkaAll.addAll(syukkaCsvs);
                
                if ("2".equals(downFlg)) {
                    dao.setSabunKousinUpdate(syukkaCondition);
                }
            }
            

            String result = this.getOutputResult(syukkaAll, userView,
                    downloadType);
            String fname = this.getfname(downloadType);
            CSVDownload.csvWrite(fname, result, response);

        } catch (CommandException e) {
            throw e;
        } catch (Exception ex) {
        	ex.printStackTrace();
            throw new CommandException(ex.getMessage(),
                    "error.SyukkaServiceImpl.getCsvOutputResult.Exception",
                    Constants.EXCEPTION);
        }
    }

    /**
     * ダウンロードフォームによって、該当テーブル名を取得します。
     * 
     * @param downloadType 　ダウンロードフォーム。
     * @return　SQL文。
     */
    private String getTblName(String downloadType) {

        String sTbl = null;

        if ("0".equals(downloadType)) {
            // TOPPS受注履歴
            sTbl = "TB_TJUCHU_RI";
        } else if ("1".equals(downloadType)) {
            // TOPPS実績履歴
            sTbl = "TB_TJISEKI_RI";
        } else if ("6".equals(downloadType)) {
            // TOPPS・出荷トレーサビリティー
            sTbl = "TB_NOUNYU_RI";
        } else if ("2".equals(downloadType) || "3".equals(downloadType)
                || "4".equals(downloadType) || "5".equals(downloadType)) {
            // 順引き受信履歴
            sTbl = "TB_JUNJSN_RI";

        }

        return sTbl;
    }

    /**
     * ダウンロードフォームによって、便NoのTBL項目名を取得します。
     * 
     * @param downloadType 　ダウンロードフォーム。
     * @return　SQL文。
     */
    private String getDBBinName(String downloadType) {

        String sBinName = null;

        if ("0".equals(downloadType) || "1".equals(downloadType)) {
            // TOPPS受注履歴 or TOPPS実績履歴
            sBinName = "NOU_BIN";
        } else if ("6".equals(downloadType)) {
            // TOPPSトレーサビリティー
            sBinName = "BIN_NO";
        } else {
            // 順引き受信履歴
            sBinName = "J_NOU_BIN";
        }

        return sBinName;
    }

    /**
     * ダウンロードフォームによって、納入日のTBL項目名を取得します。
     * 
     * @param downloadType 　ダウンロードフォーム。
     * @return　SQL文。
     */
    private String getDBNouYmdName(String downloadType) {

        String sNouYmdNm = null;

        if ("0".equals(downloadType) || "1".equals(downloadType)) {
            // TOPPS受注履歴 or TOPPS実績履歴
            sNouYmdNm = "NOU_YMD";
        } else if ("6".equals(downloadType)) {
            // TOPPS出荷トレーサビリティー
            sNouYmdNm = "NOU_YMD";
        } else {
            // 順引き受信履歴
            sNouYmdNm = "J_NOU_YMD";
        }

        return sNouYmdNm;
    }

    /**
     * ダウンロードフォームによって、便NoのTBL項目名を取得します。
     * 
     * @param downloadType 　ダウンロードフォーム。
     * @return　SQL文。
     */
    private String getDBCSVBinName(String downloadType) {

        String sBinName = null;

        if ("0".equals(downloadType) || "1".equals(downloadType)) {
            // TOPPS受注履歴 or TOPPS実績履歴
            sBinName = "NOU_BIN";
        } else if ("6".equals(downloadType)) {
            // TOPPSトレーサビリティー
            sBinName = "BIN_NO";
        } else {
            // 順引き受信履歴
            sBinName = "BIN_NO";
        }

        return sBinName;
    }

    /**
     * ダウンロードフォームによって、指示数のTBL項目名を取得します。
     * 
     * @param downloadType 　ダウンロードフォーム。
     * @return　SQL文。
     */
    private String getDBSijiSuName(String downloadType) {

        String sSijiSuName = "SIJI_SU";

        return sSijiSuName;
    }

    /**
     * ダウンロードフォームによって、指示箱数のTBL項目名を取得します。
     * 
     * @param downloadType 　ダウンロードフォーム。
     * @return　SQL文。
     */
    private String getDBSijiHakoName(String downloadType) {

        String sSijiHakoName = "SIJI_HAKO";

        return sSijiHakoName;
    }

    /**
     * ダウンロードフォームによって、支給先のTBL項目名を取得します。
     * 
     * @param downloadType 　ダウンロードフォーム。
     * @return　SQL文。
     */
    private String getDBSikyuSakiName(String downloadType) {

        String sSikyuSakiNm = null;

        if ("0".equals(downloadType) || "1".equals(downloadType)) {
            // TOPPS受注履歴 or TOPPS実績履歴
            sSikyuSakiNm = "SIKYU_SAKI";
        } else {
            // 順引き受信履歴
            sSikyuSakiNm = "TSIKYU_SAKI";
        }

        return sSikyuSakiNm;
    }

    /**
     * ダウンロードフォームによって、納入日のTBL項目名を取得します。
     * 
     * @param downloadType 　ダウンロードフォーム。
     * @return　SQL文。
     */
    private String getDBCSVNouYmdName(String downloadType) {

        String sNouYmdNm = null;

        if ("0".equals(downloadType) || "1".equals(downloadType)) {
            // TOPPS受注履歴 or TOPPS実績履歴
            sNouYmdNm = "NOU_YMD";
        } else if ("6".equals(downloadType)) {
            // TOPPS出荷トレーサビリティー
            sNouYmdNm = "NOU_YMD"; // ※現在未使用だが、一応残しておく
        } else {
            // 順引き受信履歴
            sNouYmdNm = "NOU_YMD";
        }

        return sNouYmdNm;
    }

    /**
     * DBから取得したデータを出荷情報CSVレイアウトに転換
     */
    private List<SyukkaCSVEntity> formatSyukkaCSV(
            List<SyukkaCSVEntity> syukkaCSVs, String downloadType) {
        List<SyukkaCSVEntity> entitys = new ArrayList<SyukkaCSVEntity>();
        SyukkaCSVEntity entity;
        DecimalFormat df;
       
        for (SyukkaCSVEntity syukka : syukkaCSVs) {
            entity = new SyukkaCSVEntity();
            /* T得意先コード */
            entity.setTtk_cd(CommonTool.checkEmpty(syukka.getTtk_cd()));

            /* T得意先コード */
            entity.setTtk_cd(CommonTool.checkEmpty(syukka.getTtk_cd()));

            /* 得意先受入 */
            entity.setTk_uke(CommonTool.checkEmpty(syukka.getTk_uke()));

            /* 支給先 */
            entity.setSikyu_saki(CommonTool.checkEmpty(syukka.getSikyu_saki()));

            /* 直送区分 */
            entity.setChoku_kb(CommonTool.checkEmpty(syukka.getChoku_kb()));

            /* 仕入先 */
            entity.setSiire(CommonTool.checkEmpty(syukka.getSiire()));

            /* 工区 */
            entity.setKoku(CommonTool.checkEmpty(syukka.getKoku()));

            /* TP機番 */
            entity.setTp_kiban(CommonTool.checkEmpty(syukka.getTp_kiban()));

            /* TP納番 */
            entity.setTp_noban(CommonTool.checkEmpty(syukka.getTp_noban()));

            /* 得意先背番 */
            entity.setTk_seban(CommonTool.checkEmpty(syukka.getTk_seban()));

            /* 得意先品番 */
            entity.setTk_hin(CommonTool.checkEmpty(syukka.getTk_hin()));

            /* 収容数 */
            df = new DecimalFormat("##,##0");
            entity.setSyuyo_su(df.format(Double.parseDouble(syukka
                    .getSyuyo_su())));

            /* 指示箱数 */
            df = new DecimalFormat("##0");
            entity.setSiji_hako(df.format(Double.parseDouble(syukka
                    .getSiji_hako())));

            /* 指示数 */
            df = new DecimalFormat("###,##0");
            entity.setSiji_su(df.format(Double.parseDouble(syukka.getSiji_su())));

            /* 納入日 */
            entity.setNou_ymd(CommonTool.checkEmpty(syukka.getNou_ymd()));

            /* 納入便 */
            entity.setNou_bin(CommonTool.checkEmpty(syukka.getJ_nou_bin()));

            /* 打切フラグ */
            entity.setUchi_fg(CommonTool.checkEmpty(syukka.getUchi_fg()));

            /* 打切残数 */
            entity.setUchi_zan_su(CommonTool.checkEmpty(syukka.getUchi_zan_su()));

            /* TP発注区分 */
            entity.setTp_hachu_kb(CommonTool.checkEmpty(syukka.getTp_hachu_kb()));

            /* かんばん区分 */
            entity.setKanban_kb(CommonTool.checkEmpty(syukka.getKanban_kb()));

            /* 出荷場 */
            entity.setSyukaba(CommonTool.checkEmpty(syukka.getSyukaba()));

            /* 実納入日 */
            entity.setJ_nou_ymd(CommonTool.checkEmpty(syukka.getJ_nou_ymd()));

            /* 実納入便 */
            entity.setJ_nou_bin(CommonTool.checkEmpty(syukka.getJ_nou_bin()));

            //
            if ("2".equals(downloadType) || "3".equals(downloadType)
                    || "4".equals(downloadType) || "5".equals(downloadType)) {

                // ***順引き***
                /* アイデントNo */
                entity.setIdent_no(CommonTool.checkEmpty(syukka.getIdent_no()));
                /* 吊上げ時間 */
                entity.setTsuri_hm(CommonTool.checkEmpty(syukka.getTsuri_hm()));
                // BC連番
                entity.setBc_no(CommonTool.checkEmpty(syukka.getBc_no()));

                // QR内容
                if ("4".equals(downloadType)) {
                    // 順引き・出荷トレーサビリティーのみ
                    entity.setQr_naiyo(CommonTool.checkEmpty(syukka
                            .getQr_naiyo()));
                } else {
                    entity.setQr_naiyo("");
                }

            }
            entitys.add(entity);
        }
        return entitys;
    }

    /**
     * CSVファイル名生成
     * 
     * @param downloadType
     * @return
     */
    private String getfname(String downloadType) {
        StringBuffer fname = new StringBuffer();
        if ("0".equals(downloadType)) {
            // TOPPS受注
            fname.append("TOPPS-JYUTYU-");
        } else if ("1".equals(downloadType)) {
            // TOPPS実績
            fname.append("TOPPS-JISSEKI-");
        } else if ("2".equals(downloadType)) {
            // 受注・受注
            fname.append("JYUNBIKI-JYUTYU-");
        } else if ("3".equals(downloadType)) {
            // 受注・出荷実績
            fname.append("JYUNBIKI-JISSEKI-");
        } else if ("4".equals(downloadType)) {
            // 受注・出荷トレーサビリティー
            fname.append("JYUNBIKI-TRASABI-");
        } else if ("5".equals(downloadType)) {
            // 受注・削除
            fname.append("JYUNBIKI-SAKUJYO-");
        } else if ("6".equals(downloadType)) {
            // Topps・出荷トレーサビリティー
            fname.append("TOPPS-TRASABI-");
        }
        fname.append(CommonTool.getDate() + ".txt");
        return fname.toString();
    }

    /**
     * CSVファイル作成字符串
     * 
     * @param list 　CSVファイル内容
     * @return　String　CSVファイル作成
     */
    private String getOutputResult(List<SyukkaCSVEntity> list,
            UserView userView, String downloadType) {
        StringBuffer result = new StringBuffer();
        DecimalFormat df5 = new DecimalFormat("00000");
        DecimalFormat df3 = new DecimalFormat("000");
        DecimalFormat df6 = new DecimalFormat("000000");
        DecimalFormat df4 = new DecimalFormat("0000");
        String sWk = null;

        // **********************************
        // ヘッダー項目
        // **********************************

        if (list == null) {
            return result.toString();
        }
        for (int i = 0; i < list.size(); i++) {
            SyukkaCSVEntity entity = (SyukkaCSVEntity) list.get(i);

            if (Keys.FURUKAWA_SIIRE.equals(userView.getSiire().trim())) { // 古河電工

                /* 納入先メーカーコード */
                result.append(CommonTool.getLeftB(entity.getTtk_cd(), 4));
                /* 納入先受入 */
                result.append(CommonTool.getLeftB(entity.getTk_uke(), 2));
                /* 空き */
                result.append(" ");
                /* 仕入先メーカーコード */
                result.append(Keys.FURUKAWA_SIIRE);
                /* 仕入先工場区分 */
                result.append(CommonTool.getLeftB(entity.getKoku(), 1));
                /* 空き */
                result.append(" ");
                /* 支給先 */
                result.append(CommonTool.getLeftB(entity.getSikyu_saki(), 4));
                /* 受入 */
                result.append(CommonTool.getLeftB(entity.getTk_uke(), 2));
                /* 空き */
                result.append("   ");
                /* 直送区分 */
                result.append(CommonTool.getLeftB(entity.getChoku_kb(), 1));
                /* OCR機番 */
                result.append(CommonTool.getLeftB(entity.getTp_kiban(), 2));
                /* 納入番号 */
                result.append(CommonTool.getLeftB(entity.getTp_noban(), 5));
                /* 空き */
                result.append("   ");
                /* 背番号 */
                // 先頭ブランク or ４桁入っている
                if (entity.getTk_seban().trim().length() > 3) {
                    sWk = CommonTool.getRightB(
                            CommonTool.get0suppress(entity.getTk_seban().trim()
                                    .substring(1)), 3);
                } else {

                    sWk = CommonTool.getRightB(CommonTool.get0suppress(entity
                            .getTk_seban().trim()), 3);
                }
                result.append(sWk);
                /* 品番 */
                result.append(CommonTool.getLeftB(entity.getTk_hin(), 12));
                /* 収容数 */
                // カンマが含まれている
                result.append(df5.format(Double.parseDouble(entity
                        .getSyuyo_su().replaceAll(",", ""))));
                /* 箱数 */
                result.append(df3.format(Double.parseDouble(entity
                        .getSiji_hako().replaceAll(",", ""))));
                /* 納入数 */
                result.append(df6.format(Double.parseDouble(entity.getSiji_su()
                        .replaceAll(",", ""))));
                /* 納入日 */
                result.append(CommonTool.getLeftB(entity.getNou_ymd()
                        .substring(2), 6));
                /* 納入便 */
                result.append(CommonTool.getLeftB(entity.getNou_bin(), 2));
                /* 空き */
                result.append(CommonTool.getLeftB(" ", 57));
                /* 伝票区分 */
                result.append("2");
                /* 納入区分 */
                if ("0".equals(downloadType) || "1".equals(downloadType)) {

                    // Topps受注履歴 or Topps実績履歴
                    result.append("01");
                } else {
                    // 順引き受信履歴
                    result.append("02");
                }
                // 順引き・出荷トレーサビリティー or Topps・出荷トレーサビリティー
                if ("4".equals(downloadType) || "6".equals(downloadType)) {
                    result.append(CommonTool.getLeftB(entity.getQr_naiyo(), 100));
                }

            } else { // 古河電工以外

                /* 得意先 */
                if (!"6".equals(downloadType)) {
                    result.append(CommonTool.getLeftB(entity.getTtk_cd(), 6));
                } else {
                    // Topps・出荷トレーサビリティー(T支給先(4) + 受入(2))
                    result.append(CommonTool.getLeftB(entity.getSikyu_saki(), 4));
                    result.append(CommonTool.getLeftB(entity.getTk_uke(), 2));
                }
                /* 支給先 */
                result.append(CommonTool.getLeftB(entity.getSikyu_saki(), 4));
                /* 受入 */
                result.append(CommonTool.getLeftB(entity.getTk_uke(), 2));
                /* 直送区分 */
                result.append(CommonTool.getLeftB(entity.getChoku_kb(), 1));
                /* 仕入先 */
                result.append(CommonTool.getLeftB(entity.getSiire(), 4)
                        + CommonTool.getLeftB(entity.getKoku(), 1));
                /* TP機番 */
                result.append(CommonTool.getLeftB(entity.getTp_kiban(), 2));
                /* TP納番 */
                result.append(CommonTool.getLeftB(entity.getTp_noban(), 5));
                /* DUMMY */

                result.append(CommonTool.getLeftB(
                        CommonTool.checkEmpty(entity.getBc_no()), 3));
                /* メーカー背番号 */

                result.append(CommonTool.getRightB(
                        CommonTool.get0suppress(entity.getTk_seban().trim()), 4));

                /* メーカー品番 */
                result.append(CommonTool.getLeftB(entity.getTk_hin(), 12));
                /* 収容数 */
                result.append(df5.format(Double.parseDouble(entity
                        .getSyuyo_su().replaceAll(",", ""))));
                /* 箱数 */
                result.append(df3.format(Double.parseDouble(entity
                        .getSiji_hako().replaceAll(",", ""))));
                /* 納入数 */
                result.append(df6.format(Double.parseDouble(entity.getSiji_su()
                        .replaceAll(",", ""))));
                /* 実納入日 */
                result.append(CommonTool.getLeftB(entity.getJ_nou_ymd()
                        .substring(2), 6));
                /* 実納入便 */
                result.append(CommonTool.getLeftB(entity.getJ_nou_bin(), 2));
                /* 打切フラグ */
                result.append(CommonTool.getLeftB(entity.getUchi_fg(), 1));
                /* 打切残数 */
                result.append(df6.format(Double.parseDouble(entity
                        .getUchi_zan_su().replaceAll(",", ""))));
                /* TP発注区分 */
                result.append(CommonTool.getLeftB(entity.getTp_hachu_kb(), 1));
                /* かん区分 */
                result.append(CommonTool.getLeftB(entity.getKanban_kb(), 1));
                /* 納入日 */
                result.append(CommonTool.getLeftB(entity.getNou_ymd()
                        .substring(2), 6));
                /* 納入便 */
                result.append(CommonTool.getLeftB(entity.getNou_bin(), 2));
                /* 出荷場 */
                result.append(CommonTool.getLeftB(entity.getSyukaba(), 3));
                /* アイデントNo. */
                result.append(CommonTool.getLeftB(
                        CommonTool.checkEmpty(entity.getIdent_no()), 10));
                /* 吊上げ時間 */
                result.append(CommonTool.getLeftB(
                        CommonTool.checkEmpty(entity.getTsuri_hm()), 4));
                // 順引き・出荷トレーサビリティー or Topps・出荷トレーサビリティー
                if ("4".equals(downloadType) || "6".equals(downloadType)) {
                    result.append(CommonTool.getLeftB(entity.getQr_naiyo(), 100));
                }

            }
            result.append("\r\n");
        }
        return result.toString();
    }

}