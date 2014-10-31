/*
 * クラス名: HinbanZaikoEntity
 *
 * バージョン情報: 1.00
 *
 * 作成日: 20014/07/20
 *
 * Copyright:
 */

package ysbk_web.model.hinbanZaiko;

import ysbk_web.model.BaseEntity;

/**
 * @author 品番別在庫管理検索結果エンティティ。
 */
public class HinbanZaikoEntity extends BaseEntity {

    /** 受入 */
    private String tk_uke;

    /** メーカー背番 */
    private String tk_seban;

    /** メーカー品番 */
    private String tk_hin;

    /** 収容数 */
    private String syuyo_su;

    /** 在庫数 */
    private String zaiko_su;

    /** ロケ在庫数 */
    private String loc_zaiko_su;

    /** 引当可能在庫数 */
    private String hiki_zaiko_su;

    /** 不足総数 */
    private String fusoku_su;

    /** 管理工場 */
    private String kanri_kojo;

    /** 出荷拠点 */
    private String s_kyoten;

    /** 製造場所 */
    private String seizo_ba;

    /** 仕入背番 */
    private String seban;

    /** 当日搬入数 */
    private String han_su;

    /** ロケ */
    private String location;

    /** 最終納入日 */
    private String lst_nou_ymd;

    /** 最終搬入日 */
    private String lst_han_ymd;

    // 在庫履歴のみ
    /** 処理日 */
    private String syori_ymd;

    /** 処理時間 */
    private String syori_hms;

    /**
     * @return
     */
    public String getFusoku_su() {
        return fusoku_su;
    }

    /**
     * @return
     */
    public String getHan_su() {
        return han_su;
    }

    /**
     * @return
     */
    public String getHiki_zaiko_su() {
        return hiki_zaiko_su;
    }

    /**
     * @return
     */
    public String getKanri_kojo() {
        return kanri_kojo;
    }

    /**
     * @return
     */
    public String getLoc_zaiko_su() {
        return loc_zaiko_su;
    }

    /**
     * @return
     */
    public String getLocation() {
        return location;
    }

    /**
     * @return
     */
    public String getLst_han_ymd() {
        return lst_han_ymd;
    }

    /**
     * @return
     */
    public String getLst_nou_ymd() {
        return lst_nou_ymd;
    }

    /**
     * @return
     */
    public String getS_kyoten() {
        return s_kyoten;
    }

    /**
     * @return
     */
    public String getSeban() {
        return seban;
    }

    /**
     * @return
     */
    public String getSeizo_ba() {
        return seizo_ba;
    }

    /**
     * @return
     */
    public String getSyuyo_su() {
        return syuyo_su;
    }

    /**
     * @return
     */
    public String getTk_hin() {
        return tk_hin;
    }

    /**
     * @return
     */
    public String getTk_seban() {
        return tk_seban;
    }

    /**
     * @return
     */
    public String getTk_uke() {
        return tk_uke;
    }

    /**
     * @return
     */
    public String getZaiko_su() {
        return zaiko_su;
    }

    /**
     * @param string
     */
    public void setFusoku_su(String string) {
        fusoku_su = string;
    }

    /**
     * @param string
     */
    public void setHan_su(String string) {
        han_su = string;
    }

    /**
     * @param string
     */
    public void setHiki_zaiko_su(String string) {
        hiki_zaiko_su = string;
    }

    /**
     * @param string
     */
    public void setKanri_kojo(String string) {
        kanri_kojo = string;
    }

    /**
     * @param string
     */
    public void setLoc_zaiko_su(String string) {
        loc_zaiko_su = string;
    }

    /**
     * @param string
     */
    public void setLocation(String string) {
        location = string;
    }

    /**
     * @param string
     */
    public void setLst_han_ymd(String string) {
        lst_han_ymd = string;
    }

    /**
     * @param string
     */
    public void setLst_nou_ymd(String string) {
        lst_nou_ymd = string;
    }

    /**
     * @param string
     */
    public void setS_kyoten(String string) {
        s_kyoten = string;
    }

    /**
     * @param string
     */
    public void setSeban(String string) {
        seban = string;
    }

    /**
     * @param string
     */
    public void setSeizo_ba(String string) {
        seizo_ba = string;
    }

    /**
     * @param string
     */
    public void setSyuyo_su(String string) {
        syuyo_su = string;
    }

    /**
     * @param string
     */
    public void setTk_hin(String string) {
        tk_hin = string;
    }

    /**
     * @param string
     */
    public void setTk_seban(String string) {
        tk_seban = string;
    }

    /**
     * @param string
     */
    public void setTk_uke(String string) {
        tk_uke = string;
    }

    /**
     * @param string
     */
    public void setZaiko_su(String string) {
        zaiko_su = string;
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

}
