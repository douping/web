/*
 * クラス名: HinbanZaikoCondition
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/28
 *
 * Copyright:
 */

package ysbk_web.condition;

import ysbk_web.utility.Keys;
import ysbk_web.view.UserView;

public class HinbanZaikoCondition {
    /** 稼働日 */
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
    private int syuyo_su;

    private String rg;

    private String B_KYOTEN = Keys.B_KYOTEN;

    public String getB_KYOTEN() {
        return B_KYOTEN;
    }

    public void setB_KYOTEN(String b_KYOTEN) {
        B_KYOTEN = b_KYOTEN;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
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

    public int getSyuyo_su() {
        return syuyo_su;
    }

    public void setSyuyo_su(int syuyo_su) {
        this.syuyo_su = syuyo_su;
    }
}
