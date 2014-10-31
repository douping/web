/*
 * クラス名: HinbanZaikoView
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/24
 *
 * Copyright:
 */

package ysbk_web.view;

import ysbk_web.view.UserView;

public class HinbanZaikoView {

    private String sKadoDate;

    /** メーカー品番 */
    private String tk_hin;

    /** 受入 */
    private String tk_uke;

    /** 仕入先背番 */
    private String seban;

    /** login user */
    private UserView userView;

    /** 収容数 */
    private String syuyo_su;

    public HinbanZaikoView() {
    };

    public HinbanZaikoView(String sKadoDate, String tk_hin, String tk_uke,
            String seban, UserView userView, String syuyo_su) {
        this.sKadoDate = sKadoDate;
        this.tk_hin = tk_hin;
        this.tk_uke = tk_uke;
        this.seban = seban;
        this.userView = userView;
        this.syuyo_su = syuyo_su;
    }

    public String getsKadoDate() {
        return sKadoDate;
    }

    public void setsKadoDate(String sKadoDate) {
        this.sKadoDate = sKadoDate;
    }

    public String getTk_hin() {
        return tk_hin;
    }

    public void setTk_hin(String tk_hin) {
        this.tk_hin = tk_hin;
    }

    public String getTk_uke() {
        return tk_uke;
    }

    public void setTk_uke(String tk_uke) {
        this.tk_uke = tk_uke;
    }

    public String getSeban() {
        return seban;
    }

    public void setSeban(String seban) {
        this.seban = seban;
    }

    public UserView getUserView() {
        return userView;
    }

    public void setUserView(UserView userView) {
        this.userView = userView;
    }

    public String getSyuyo_su() {
        return syuyo_su;
    }

    public void setSyuyo_su(String syuyo_su) {
        this.syuyo_su = syuyo_su;
    }

}