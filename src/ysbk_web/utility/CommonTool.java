/*
 * クラス名: CommonTool.java
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/22
 *
 * Copyright:
 */

package ysbk_web.utility;

import org.apache.log4j.Logger;
import java.util.*;
import java.text.*;

/**
 * @author COMMONビーン。
 */
public class CommonTool {

    private static Logger logger = Logger.getLogger(CommonTool.class);

    /**
     * NULL値判定
     * 
     * @param String
     * @return　String
     */
    public static String checkEmpty(String str) {
        if (str == null) {
            return "";
        } else {
            return str;
        }
    }

    /**
     * 曜日を取得する。
     * 
     * @param thisForm 詳細画面情報
     * @return ysbk_web.entity.zaisyo.IdouDetailEntity
     * @throws CommandException
     */
    public static String getWeek_Day(String yy, String mm, String dd) {
        try {
            DateFormat df = DateFormat.getDateTimeInstance();
            String wk = "20" + yy + "/" + mm + "/" + dd + " 0:0:0";
            Date date = df.parse(wk.toString());
            Calendar calendar = Calendar.getInstance(TimeZone
                    .getTimeZone("JST"));
            calendar.setTime(date);
            int week = calendar.get(Calendar.DAY_OF_WEEK);
            switch (week) {
            case 1:
                return "日";
            case 2:
                return "月";
            case 3:
                return "火";
            case 4:
                return "水";
            case 5:
                return "木";
            case 6:
                return "金";
            case 7:
                return "土";
            default:
                return "";
            }
        } catch (Exception e) {
            return "";
        }

    }

    /**
     * 日付を取得 フォーマット yyyyMMddhhMMss
     * 
     * @param
     * @return　String
     */
    // 非推奨 ⇒ getDateTime()参照
    public static String getDate() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("JST"));
        calendar.setTime(date);

        DecimalFormat df = new DecimalFormat("00");
        StringBuffer buff = new StringBuffer();
        buff.append(calendar.get(Calendar.YEAR));
        buff.append(df.format(calendar.get(Calendar.MONTH) + 1));
        buff.append(df.format(calendar.get(Calendar.DATE)));
        if (calendar.get(Calendar.AM_PM) == 0) {
            buff.append(df.format(calendar.get(Calendar.HOUR)));
        } else {
            buff.append(df.format(calendar.get(Calendar.HOUR) + 12));
        }
        buff.append(df.format(calendar.get(Calendar.MINUTE)));
        buff.append(df.format(calendar.get(Calendar.SECOND)));
        return buff.toString();
    }

    /**
     * 指定桁数未満の場合、右にブランクを追加する
     * 
     * @param StringBuffer, int
     * @return　String
     */
    public static String getLeftB(String wk, int iKeta) {

        StringBuffer sb = new StringBuffer(wk);
        int iLen = wk.length();
        if (iLen < iKeta) {
            // 桁数までブランク追加
            for (int i = 1; i + iLen <= iKeta; i++) {
                sb.append(" ");
            }
            // 桁数より長い場合、桁数より後ろ削除
        } else if (iLen > iKeta) {
            sb.delete(iKeta, wk.length());
        }
        return sb.toString();
    }

    /**
     * 指定桁数未満の場合、左にブランクを追加する
     * 
     * @param StringBuffer, int
     * @return　String
     */
    public static String getRightB(String wk, int iKeta) {

        StringBuffer sb = new StringBuffer(wk);
        int iLen = wk.length();
        if (iLen < iKeta) {
            // 桁数まで先頭ブランク追加
            for (int i = 1; i + iLen <= iKeta; i++) {
                sb.insert(0, " ");
            }
            // 桁数より長い場合、桁数より後ろ削除
        } else if (iLen > iKeta) {
            sb.delete(iKeta, wk.length());
        }
        return sb.toString();
    }

    /**
     * 先頭の0を除去する
     * 
     * @param String
     * @return　String
     */
    public static String get0suppress(String wk) {

        try {

            Integer iWk = new Integer(Integer.parseInt(wk));
            return iWk.toString();

        } catch (Exception e) {
            // wkがブランク or 数値以外の場合
            if ("".equals(wk.trim())) {
                return wk.toString();
            } else {
                StringBuffer retSWk = new StringBuffer();
                boolean bFlg = false;
                retSWk.append("");
                for (int i = 0; i < wk.length(); i++) {
                    if (!"0".equals(wk.substring(i, 1))) {
                        retSWk.append(wk.substring(i));
                        return retSWk.toString();
                    }
                }
            }
        }
        return "";
    }

    /*
     * システム時刻を取得する
     * 
     * @return String システム時刻 HHMMSS
     */
    // 非推奨 ⇒ getTime()参照
    public static String GetTime() {
        Calendar calendar = new GregorianCalendar();
        Date trialtime = new Date();
        calendar.setTime(trialtime);
        int intTodayHH = calendar.get(Calendar.HOUR_OF_DAY);
        int intTodayMM = calendar.get(Calendar.MINUTE);
        int intTodaySS = calendar.get(Calendar.SECOND);

        String strSdayHH;
        if (intTodayHH < 10) {
            strSdayHH = "0" + Integer.toString(intTodayHH);
        } else {
            strSdayHH = Integer.toString(intTodayHH);
        }

        String strSdayMM;
        if (intTodayMM < 10) {
            strSdayMM = "0" + Integer.toString(intTodayMM);
        } else {
            strSdayMM = Integer.toString(intTodayMM);
        }

        String strSdaySS;
        if (intTodaySS < 10) {
            strSdaySS = "0" + Integer.toString(intTodaySS);
        } else {
            strSdaySS = Integer.toString(intTodaySS);
        }

        return strSdayHH + strSdayMM + strSdaySS;
    }

    /**
     * GetTime2メソッド システム時刻を取得する
     * 
     * @return String システム時刻 HHMMSSMS(1/100秒)
     */
    /** システム時間取得 */
    public static String GetTime2() {
        Calendar calendar = new GregorianCalendar();
        Date trialtime = new Date();
        calendar.setTime(trialtime);
        int todayHH = calendar.get(Calendar.HOUR_OF_DAY);
        int todayMM = calendar.get(Calendar.MINUTE);
        int todaySS = calendar.get(Calendar.SECOND);
        int todayMS = calendar.get(Calendar.MILLISECOND);

        String SdayHH;
        if (todayHH < 10) {
            SdayHH = "0" + Integer.toString(todayHH);
        } else {
            SdayHH = Integer.toString(todayHH);
        }

        String SdayMM;
        if (todayMM < 10) {
            SdayMM = "0" + Integer.toString(todayMM);
        } else {
            SdayMM = Integer.toString(todayMM);
        }

        String SdaySS;
        if (todaySS < 10) {
            SdaySS = "0" + Integer.toString(todaySS);
        } else {
            SdaySS = Integer.toString(todaySS);
        }

        String SdayMS;
        // 1/1000→1/100
        SdayMS = Integer.toString(todayMS);
        SdayMS = SdayMS.substring(0, 2);

        return SdayHH + SdayMM + SdaySS + SdayMS;
    }

    /**
     * SQL作成時、引数がTrueの場合、"AND" を返す
     * 
     * @param boolean
     * @return　String
     */
    public static String getAnd(boolean bAndFlg) {

        if (bAndFlg) {
            return " AND ";
        } else {
            return "";
        }
    }

    /**
     * 現在日(yyyyMMdd)を返す
     * 
     * @param
     * @return　String
     */
    public static String getDate2() {

        return new SimpleDateFormat("yyyyMMdd").format(new java.util.Date());
    }

    /**
     * 現在時(HHmmss)を返す
     * 
     * @param
     * @return　String
     */
    public static String getTime() {

        return new SimpleDateFormat("HHmmss").format(new java.util.Date());
    }

    /**
     * 現在日時(yyyyMMddHHmmss)を返す
     * 
     * @param
     * @return　String
     */
    public static String getDateTime() {

        return new SimpleDateFormat("yyyyMMddHHmmss")
                .format(new java.util.Date());
    }

}
