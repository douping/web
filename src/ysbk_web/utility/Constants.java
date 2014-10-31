/*
 * クラス名:Constants
 *
 * バージョン情報: 1.0
 *
 * 日付け: 2014/07/22
 *
 * Copyright表示:
 */

package ysbk_web.utility;

/**
 * Constants情報
 * 
 * @author
 */
public class Constants {

    /** ページ毎に表示する最大データ件数。 */
    public static final int PAGE_MAXDATA = 10;

    /** ページ毎に表示する最大データ件数。 */
    public static final int PAGE_MAX = 20;

    /** YSBK_WEBデータソースのJDBCのJNDI名 */
    public static final String YSBK_WEB_DATASOURCE = "java:comp/env/jdbc/ysbk_web";

    /** フォワードのキーview。 */
    public static final String VIEW = "view";

    /** フォワードのキーnextView。 */
    public static final String NEXT_VIEW = "nextview";

    /** フォワードのキーsuccess。 */
    public static final String SUCCESS = "success";

    /** フォワードのキーfailure。 */
    public static final String FAILURE = "failure";

    /** フォワードのキーfailure。 */
    public static final String NOPRIVILEGE = "noPrivilege";

    /** フォワードのキーfailure。 */
    public static final String DATANOTFOUND = "datanotfound";

    /** フォワードのキーfailure。 */
    public static final String DBERR = "dbErr";

    /** フォワードのキーfailure。 */
    public static final String ERR = "err";

    /** フォワードのキーloginerr。 */
    public static final String LOGIN_ERR = "loginerr";

    /** フォワードのキーloginmaxcount。 */
    public static final String LOGIN_MAX_COUNT = "loginmaxcount";

    /** フォワードのキーloginunable。 */
    public static final String LOGIN_PREMISSION = "loginpermission";

    /** フォワードのキーfailure。 */
    public static final String INSERTERR = "insertErr";

    /** フォワードのキーsessionerr。 */
    public static final String SESSION_ERR = "sessionerr";

    /** フォワードのキーpasswordSuccess。 */
    public static final String PASSWORD_SUCCESS = "passwordSuccess";

    /** フォワードのキーpasswordFailure。 */
    public static final String PASSWORD_FAILURE = "passwordFailure";

    /** メッセージID：ysbk_webErrorMessage */
    public static final String YSBK_WEB_ERROR_MESSAGE = "ysbk_webErrorMessage";

    /** 無権限 */
    public static final String YSBK_WEB_NOPRIVILEGE_ID = "error.noPrivilege";

    /** データがありません */
    public static final String YSBK_WEB_DATA_NOTFOUND = "error.datanotfound";

    /** Exceptionを示すエラータイプ値 */
    public static final int EXCEPTION = 0;

    /** SQLExceptionを示すエラータイプ値 */
    public static final int SQL_EXCEPTION = 1;

    /** IOExceptionを示すエラータイプ値 */
    public static final int IO_EXCEPTION = 2;

    /** ServiceLocatorExceptionを示すエラータイプ値 */
    public static final int SERVICE_LOCATOR_EXCEPTION = 3;

    /** NoPermissionを示すエラータイプ値 */
    public static final int PERMISSION_EXCEPTION = 4;

    /** 一意制約を示すエラータイプ値 */
    public static final int SQL_INSERT_EXCEPTION = 5;

    /** 一意制約を示すエラータイプ値 */
    public static final int SQL_NOTFOUND_EXCEPTION = 6;

}
