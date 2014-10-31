/*
 * クラス名:CheckTool
 *
 * バージョン情報: 1.0
 *
 * 日付け: 2004/02/06
 *
 * Copyright表示:
 */
package ysbk_web.utility;

/**
 * ログファイルに情報を書き込む処理ログツールです。
 * 
 * @author EIT
 */

public class CheckTool {

    /**
     * 指定した文字列は空白かどうかをチェックします。
     * 
     * @param text 　文字列
     * @return　指定文字列はNULL或いは長さは0の場合はtrue。 それ以外の場合はfalse。
     */
    public static boolean isEmpty(String text) {
        if (text == null || text.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 指定した文字列は空白かどうかをチェックします。
     * 
     * @param text 　文字列
     * @return　指定文字列はNULL或いは長さは0の場合はfalse。 それ以外の場合はtrue。
     */
    public static boolean isNotEmpty(String text) {
        if (text == null || text.length() == 0) {
            return false;
        } else {
            return true;
        }
    }
}
