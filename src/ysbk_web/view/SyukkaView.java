/*
 * クラス名: SyukkaView
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/08/01
 *
 * Copyright:
 */

package ysbk_web.view;

public class SyukkaView {

    /** 受信 */
    private String jyushin;

    /** 便No */
    private String bin_no;

    /** 得意先受入 */
    private String tk_uke;

    /** 納入日 */
    private String nou_ymd;

    /** RG */
    private String rg;

    /**
     * 受信を取得します。
     * 
     * @return java.lang.String
     */
    public String getJyushin() {
        return jyushin;
    }

    /**
     * 受信を設定します。
     * 
     * @param jyushin
     */
    public void setJyushin(String jyushin) {
        this.jyushin = jyushin;
    }

    /**
     * 便Noを取得します。
     * 
     * @return java.lang.String
     */
    public String getBin_no() {
        return bin_no;
    }

    /**
     * 便Noを設定します。
     * 
     * @param bin_no
     */
    public void setBin_no(String bin_no) {
        this.bin_no = bin_no;
    }

    /**
     * 得意先受入を取得します。
     * 
     * @return java.lang.String
     */
    public String getTk_uke() {
        return tk_uke;
    }

    /**
     * 得意先受入を設定します。
     * 
     * @param tk_uke
     */
    public void setTk_uke(String tk_uke) {
        this.tk_uke = tk_uke;
    }

    /**
     * 納入日を取得します。
     * 
     * @return java.lang.String
     */
    public String getNou_ymd() {
        return nou_ymd;
    }

    /**
     * 納入日を設定します。
     * 
     * @param nou_ymd
     */
    public void setNou_ymd(String nou_ymd) {
        this.nou_ymd = nou_ymd;
    }

    /**
     * RGを取得します。
     * 
     * @return java.lang.String
     */
    public String getRg() {
        return rg;
    }

    /**
     * RGを設定します。
     * 
     * @param rg
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

}