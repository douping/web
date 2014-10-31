/*
 * クラス名: ZaikoEntity
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/26
 *
 * Copyright:
 */

package ysbk_web.model.zaiko;

import ysbk_web.model.BaseEntity;

/**
 * @author 在庫管理検索結果エンティティ。
 */
public class ZaikoEntity extends BaseEntity {

    /** 物流拠点 */
    private String b_kyoten;

    /** 得意先品番 */
    private String tk_hin;

    /** 収容数 */
    private String syuyo_su;

    /** 背番 */
    private String seban;

    /** 引当可能在庫数 */
    private String hiki_zaiko_su;

    /** ロケ在庫数 */
    private String loc_zaiko_su;

    /** 在庫数 */
    private String zaiko_su;

    /** 最終納入日 */
    private String lst_nou_ymd;

    /** 最終搬入日 */
    private String lst_han_ymd;

    /** アイデントNo */
    private String ident_no;

    /** BC連番 */
    private String bc_no;

    // 在庫履歴のみ
    /** 処理日 */
    private String syori_ymd;

    /** 処理時間 */
    private String syori_hms;

    /**
     * 物流拠点を取得します。
     * 
     * @return java.lang.String
     */
    public String getB_kyoten() {
        return b_kyoten;
    }

    /**
     * 物流拠点を設定します。
     * 
     * @param b_kyoten
     */
    public void setB_kyoten(String b_kyoten) {
        this.b_kyoten = b_kyoten;
    }

    /**
     * 得意先品番を取得します。
     * 
     * @return java.lang.String
     */
    public String getTk_hin() {
        return tk_hin;
    }

    /**
     * 得意先品番を設定します。
     * 
     * @param tk_hin
     */
    public void setTk_hin(String tk_hin) {
        this.tk_hin = tk_hin;
    }

    /**
     * 収容数を取得します。
     * 
     * @return java.lang.String
     */
    public String getSyuyo_su() {
        return syuyo_su;
    }

    /**
     * 収容数を設定します。
     * 
     * @param syuyo_su
     */
    public void setSyuyo_su(String syuyo_su) {
        this.syuyo_su = syuyo_su;
    }

    /**
     * 背番を取得します。
     * 
     * @return java.lang.String
     */
    public String getSeban() {
        return seban;
    }

    /**
     * 背番を設定します。
     * 
     * @param seban
     */
    public void setSeban(String seban) {
        this.seban = seban;
    }

    /**
     * 引当可能在庫数を取得します。
     * 
     * @return java.lang.String
     */
    public String getHiki_zaiko_su() {
        return hiki_zaiko_su;
    }

    /**
     * 引当可能在庫数を設定します。
     * 
     * @param hiki_zaiko_su
     */
    public void setHiki_zaiko_su(String hiki_zaiko_su) {
        this.hiki_zaiko_su = hiki_zaiko_su;
    }

    /**
     * ロケ在庫数を取得します。
     * 
     * @return java.lang.String
     */
    public String getLoc_zaiko_su() {
        return loc_zaiko_su;
    }

    /**
     * ロケ在庫数を設定します。
     * 
     * @param loc_zaiko_su
     */
    public void setLoc_zaiko_su(String loc_zaiko_su) {
        this.loc_zaiko_su = loc_zaiko_su;
    }

    /**
     * 在庫数を取得します。
     * 
     * @return java.lang.String
     */
    public String getZaiko_su() {
        return zaiko_su;
    }

    /**
     * 在庫数を設定します。
     * 
     * @param zaiko_su
     */
    public void setZaiko_su(String zaiko_su) {
        this.zaiko_su = zaiko_su;
    }

    /**
     * 最終納入日を取得します。
     * 
     * @return java.lang.String
     */
    public String getLst_nou_ymd() {
        return lst_nou_ymd;
    }

    /**
     * 最終納入日を設定します。
     * 
     * @param lst_nou_ymd
     */
    public void setLst_nou_ymd(String lst_nou_ymd) {
        this.lst_nou_ymd = lst_nou_ymd;
    }

    /**
     * 最終搬入日を取得します。
     * 
     * @return java.lang.String
     */
    public String getLst_han_ymd() {
        return lst_han_ymd;
    }

    /**
     * 最終搬入日を設定します。
     * 
     * @param lst_han_ymd
     */
    public void setLst_han_ymd(String lst_han_ymd) {
        this.lst_han_ymd = lst_han_ymd;
    }

    /**
     * 処理日を取得します。
     * 
     * @return java.lang.String
     */
    public String getSyori_ymd() {
        return syori_ymd;
    }

    /**
     * 処理日を設定します。
     * 
     * @param syori_ymd
     */
    public void setSyori_ymd(String syori_ymd) {
        this.syori_ymd = syori_ymd;
    }

    /**
     * 処理時間を取得します。
     * 
     * @return java.lang.String
     */
    public String getSyori_hms() {
        return syori_hms;
    }

    /**
     * 処理時間を設定します。
     * 
     * @param syori_hms
     */
    public void setSyori_hms(String syori_hms) {
        this.syori_hms = syori_hms;
    }

    /**
     * @return
     */
    public String getBc_no() {
        return bc_no;
    }

    /**
     * @return
     */
    public String getIdent_no() {
        return ident_no;
    }

    /**
     * @param string
     */
    public void setBc_no(String string) {
        bc_no = string;
    }

    /**
     * @param string
     */
    public void setIdent_no(String string) {
        ident_no = string;
    }

    @Override
    public String toString() {
        return "ZaikoEntity [b_kyoten=" + b_kyoten + ", tk_hin=" + tk_hin
                + ", syuyo_su=" + syuyo_su + ", seban=" + seban
                + ", hiki_zaiko_su=" + hiki_zaiko_su + ", loc_zaiko_su="
                + loc_zaiko_su + ", zaiko_su=" + zaiko_su + ", lst_nou_ymd="
                + lst_nou_ymd + ", lst_han_ymd=" + lst_han_ymd + ", ident_no="
                + ident_no + ", bc_no=" + bc_no + ", syori_ymd=" + syori_ymd
                + ", syori_hms=" + syori_hms + "]";
    }

}
