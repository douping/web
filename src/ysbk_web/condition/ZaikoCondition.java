/*
 * クラス名: ZaikoCondition
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/28
 *
 * Copyright:
 */

package ysbk_web.condition;

import ysbk_web.view.UserView;

public class ZaikoCondition {
    // ダウンロードタイプ
    private String downloadType;

    // 処理日
    private String syori_ymd;

    // ユーザ情報
    private UserView userView;

    public String getDownloadType() {
        return downloadType;
    }

    public void setDownloadType(String downloadType) {
        this.downloadType = downloadType;
    }

    public String getSyori_ymd() {
        return syori_ymd;
    }

    public void setSyori_ymd(String syori_ymd) {
        this.syori_ymd = syori_ymd;
    }

    public UserView getUserView() {
        return userView;
    }

    public void setUserView(UserView userView) {
        this.userView = userView;
    }

}
