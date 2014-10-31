/*
 * クラス名: NyukaCondition
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/29
 *
 * Copyright:
 */

package ysbk_web.condition;

import ysbk_web.view.UserView;

public class NyukaCondition {
    /** 搬入日 */
    private String han_ymd;

    /** ユーザ情報 */
    private UserView userView;

    /** 便No */
    private String bin_no;

    public String getHan_ymd() {
        return han_ymd;
    }

    public void setHan_ymd(String han_ymd) {
        this.han_ymd = han_ymd;
    }

    public UserView getUserView() {
        return userView;
    }

    public void setUserView(UserView userView) {
        this.userView = userView;
    }

    public String getBin_no() {
        return bin_no;
    }

    public void setBin_no(String bin_no) {
        this.bin_no = bin_no;
    }

}