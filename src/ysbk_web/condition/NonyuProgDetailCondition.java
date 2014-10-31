/*
 * クラス名: NonyuProgDetailCondition
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/31
 *
 * Copyright:
 */

package ysbk_web.condition;

/**
 * @author 納入進捗管理検索詳細フォーム
 */
public class NonyuProgDetailCondition {

    /** 納入日 */
    private String nou_ymd;

    /** RG */
    private String rg;

    /** 便 */
    private String bin_no;

    /** 仕入先 */
    private String siire;

    /** 物流拠点 */
    private String b_kyoten;

    /** 納入状況フラグ */
    private String noujou_fg;

    public String getNou_ymd() {
        return nou_ymd;
    }

    public void setNou_ymd(String nou_ymd) {
        this.nou_ymd = nou_ymd;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getBin_no() {
        return bin_no;
    }

    public void setBin_no(String bin_no) {
        this.bin_no = bin_no;
    }

    public String getSiire() {
        return siire;
    }

    public void setSiire(String siire) {
        this.siire = siire;
    }

    public String getB_kyoten() {
        return b_kyoten;
    }

    public void setB_kyoten(String b_kyoten) {
        this.b_kyoten = b_kyoten;
    }

    public String getNoujou_fg() {
        return noujou_fg;
    }

    public void setNoujou_fg(String noujou_fg) {
        this.noujou_fg = noujou_fg;
    }

    @Override
    public String toString() {
        return "NonyuProgDetailCondition [nou_ymd=" + nou_ymd + ", rg=" + rg
                + ", bin_no=" + bin_no + ", siire=" + siire + ", b_kyoten="
                + b_kyoten + ", noujou_fg=" + noujou_fg + "]";
    }

}
