/*
 * クラス名: Utility
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/26
 *
 * Copyright:
 */

package ysbk_web.utility;

import java.io.IOException;
import java.io.Reader;
import java.util.*;
import java.text.*;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import ysbk_web.view.UserView;

/**
 * @author COMMONビーン
 */
public class Utility {

    private static Logger logger = Logger.getLogger(Utility.class);

    private SqlMapClientTemplate sqlMapClientTemplate;

    /**
     * 稼働日を取得する
     * 
     * @param
     * @return String
     * @throws Exception
     */
    public static String getKadoDate(String naiyo) throws Exception {
        String sKadoDate, strInTime, strOutDate, strOutTime;
        if (CommonTool.checkEmpty(naiyo).trim().isEmpty()) {
            // データが存在しない場合は、４時を切替時刻とする
            sKadoDate = "040000";
        } else {
            sKadoDate = CommonTool.checkEmpty(naiyo).trim() + "00";
        }

        // 現在時取得
        strInTime = CommonTool.getTime();

        // 現在時が稼動切替時間より小さい場合
        if (Integer.parseInt(strInTime) < Integer.parseInt(sKadoDate)) {

            // 稼働日を１日前の日付にする
            Date date = new Date();
            Calendar calendar = Calendar.getInstance(TimeZone
                    .getTimeZone("JST"));
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_MONTH, -1);

            strOutDate = new SimpleDateFormat("yyyyMMdd").format(calendar
                    .getTime());
            strOutTime = new SimpleDateFormat("HHmmss").format(calendar
                    .getTime());

        } else {
            strOutDate = CommonTool.getDate2();
            strOutTime = CommonTool.getTime();
        }

        return strOutDate + strOutTime;

    }

    /**
     * 稼働日を取得する
     * 
     * @param
     * @return String yyyymmddhhmmss
     * @throws Exception
     */
    public static String getKadoDate(String naiyo, String strInDate,
            String strInTime) throws Exception {
        String strOutDate = null;
        String strOutTime = null;
        String strKiriHHMM = null;
        long lngTime = 0;

        // データが存在しない場合は、４時を切替時刻とする
        if (CommonTool.checkEmpty(naiyo).trim() == "") {
            strKiriHHMM = "0400";
        } else {
            // データが存在しない場合は、４時を切替時刻とする
            strKiriHHMM = CommonTool.checkEmpty(naiyo).trim();
        }

        // 時分秒で入力されている場合は合わせる
        if (strInTime.length() == 6) {
            strKiriHHMM = strKiriHHMM + "00";
            lngTime = 240000;
        } else {
            lngTime = 2400;
        }

        // 引数時刻が稼動切替時間より小さい場合
        if (Integer.parseInt(strInTime) < Integer.parseInt(strKiriHHMM)) {

            // 稼働日を１日前の日付にする
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            DateFormat df = DateFormat.getDateTimeInstance();
            Date date = df.parse(new SimpleDateFormat("yyyy/MM/dd").format(sdf
                    .parse(strInDate, new ParsePosition(0))) + " 0:0:0");
            Calendar calendar = Calendar.getInstance(TimeZone
                    .getTimeZone("JST"));
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_MONTH, -1);

            strOutDate = new SimpleDateFormat("yyyyMMdd").format(calendar
                    .getTime());

            // 時刻を2400を足した値に変換する
            strOutTime = Long.toString(Integer.parseInt(strInTime) + lngTime);

        } else {

            strOutDate = strInDate;
            strOutTime = strInTime;
        }

        return strOutDate + strOutTime;

    }

    public static Page getPage(List list, int startIndex) throws Exception {
        Page page = null;
        int resultDataCount;
        int pageSize = Constants.PAGE_MAX;
        int endIndex = 0;
        resultDataCount = list.size();
        while (startIndex >= resultDataCount) {
            startIndex = startIndex - pageSize;
        }
        endIndex = startIndex + pageSize;
        if (startIndex < resultDataCount && startIndex >= 0
                && resultDataCount <= endIndex) {
            page = new Page(list.subList(startIndex, resultDataCount),
                    startIndex, false, resultDataCount);
        } else if (startIndex >= 0 && resultDataCount > endIndex) {
            page = new Page(list.subList(startIndex, endIndex), startIndex,
                    true, resultDataCount);
        } else {
            page = Page.EMPTY_PAGE;
        }

        return page;
    }

    

    public SqlMapClientTemplate getSqlMapClientTemplate() {
        return sqlMapClientTemplate;
    }

    public void setSqlMapClientTemplate(
            SqlMapClientTemplate sqlMapClientTemplate) {
        this.sqlMapClientTemplate = sqlMapClientTemplate;
    }

    /**
     * RG検索SQL生成
     * 
     * @param
     * @return　String
     */
    public static String getRG_SQL(UserView userEntity) {
        StringBuffer sbWk = new StringBuffer(" ");
        String[] sRg = userEntity.getRg();
        boolean bAddFlg = true;
        if (sRg != null) {
            sbWk.append(CommonTool.getAnd(bAddFlg));
            sbWk.append(" (");
            for (int iCnt = 0; iCnt < sRg.length; iCnt++) {
                if (iCnt != 0) {
                    sbWk.append(" OR");
                }
                sbWk.append(" ( (M01.RG = '" + sRg[iCnt] + "'");
                sbWk.append("    AND (M01.RG2 = '" + sRg[iCnt]
                        + "' OR M01.RG2 = ' '))");
                sbWk.append(" OR M01.RG2 = '" + sRg[iCnt] + "' )");
            }
            sbWk.append(" )");

        }

        return sbWk.toString();

    }
}
