/*
 * クラス名:CSVDownload
 *
 * バージョン情報: 1.0
 *
 * 日付け: 2014/07/29
 *
 * Copyright表示:
 */

package ysbk_web.utility;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

/**
 * @author CSVDownload
 */
public class CSVDownload {

    private static String[] byteToStr = { "%00", "%01", "%02", "%03", "%04",
            "%05", "%06", "%07", "%08", "%09", "%0A", "%0B", "%0C", "%0D",
            "%0E", "%0F", "%10", "%11", "%12", "%13", "%14", "%15", "%16",
            "%17", "%18", "%19", "%1A", "%1B", "%1C", "%1D", "%1E", "%1F", "+",
            "%21", "%22", "%23", "%24", "%25", "%26", "%27", "%28", "%29", "*",
            "%2B", "%2C", "-", ".", "%2F", "0", "1", "2", "3", "4", "5", "6",
            "7", "8", "9", "%3A", "%3B", "%3C", "%3D", "%3E", "%3F", "%40",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "%5B", "%5C", "%5D", "%5E", "_", "%60", "a", "b", "c", "d", "e",
            "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
            "s", "t", "u", "v", "w", "x", "y", "z", "%7B", "%7C", "%7D", "%7E",
            "%7F", "%80", "%81", "%82", "%83", "%84", "%85", "%86", "%87",
            "%88", "%89", "%8A", "%8B", "%8C", "%8D", "%8E", "%8F", "%90",
            "%91", "%92", "%93", "%94", "%95", "%96", "%97", "%98", "%99",
            "%9A", "%9B", "%9C", "%9D", "%9E", "%9F", "%A0", "%A1", "%A2",
            "%A3", "%A4", "%A5", "%A6", "%A7", "%A8", "%A9", "%AA", "%AB",
            "%AC", "%AD", "%AE", "%AF", "%B0", "%B1", "%B2", "%B3", "%B4",
            "%B5", "%B6", "%B7", "%B8", "%B9", "%BA", "%BB", "%BC", "%BD",
            "%BE", "%BF", "%C0", "%C1", "%C2", "%C3", "%C4", "%C5", "%C6",
            "%C7", "%C8", "%C9", "%CA", "%CB", "%CC", "%CD", "%CE", "%CF",
            "%D0", "%D1", "%D2", "%D3", "%D4", "%D5", "%D6", "%D7", "%D8",
            "%D9", "%DA", "%DB", "%DC", "%DD", "%DE", "%DF", "%E0", "%E1",
            "%E2", "%E3", "%E4", "%E5", "%E6", "%E7", "%E8", "%E9", "%EA",
            "%EB", "%EC", "%ED", "%EE", "%EF", "%F0", "%F1", "%F2", "%F3",
            "%F4", "%F5", "%F6", "%F7", "%F8", "%F9", "%FA", "%FB", "%FC",
            "%FD", "%FE", "%FF", };

    public static String encode(String str, String encoding)
            throws UnsupportedEncodingException {
        byte[] array = str.getBytes(encoding);
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < array.length; i++) {
            buf.append(byteToStr[byteToInt(array[i])]);
        }
        return buf.toString();
    }

    private static int byteToInt(byte b) {
        return (b < 0) ? 256 + b : b;
    }

    public static boolean csvWrite(String fileName, String csvString,
            HttpServletResponse response) throws UnsupportedEncodingException {
        ServletOutputStream out = null;
        ByteArrayInputStream in = null;
        int iCnt = 0;

        // ダウンロードファイル名日本語対応 Start
        String chgfname = null;
        // fileName="TOPPS受注20050101.txt";

        // chgfname = new String(fileName.getBytes("Shift_JIS"), "ISO8859_1");
        // chgfname = new String(fileName.getBytes("windows-31j"), "ISO8859_1");

        // MSIEで日本語を使用する場合
        // chgfname = encode(fileName, "UTF-8");
        // JDK1.4以上ならこれでOK
        // chgfname = URLEncoder.encode(fileName, "UTF-8");

        // 日本語を使用しない場合
        chgfname = new String(fileName);
        // ダウンロードファイル名日本語対応 End

        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setHeader("Content-Disposition", "attachment; filename=\""
        // org +fileName + ".csv\"");
                + chgfname);

        try {
            out = response.getOutputStream();
            in = new ByteArrayInputStream(csvString.getBytes("shift_jis"));
            byte[] buffer = new byte[2048];
            int bytesRead = 0;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
                iCnt++;
            }
            return true;
        } catch (Exception e) {
            e.toString();
        } finally {
            try {

                in.close();
                out.close();

            } catch (Exception e) {
            }
        }
        return false;
    }
}
