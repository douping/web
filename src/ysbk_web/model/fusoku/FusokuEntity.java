/*
 * クラス名: FusokuEntity
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/08/05
 *
 * Copyright:
 */

package ysbk_web.model.fusoku;

import ysbk_web.model.BaseEntity;

/**
 * @author 不足数検索結果エンティティ。
 */
public class FusokuEntity extends BaseEntity {

    /** 納入日 */
    private String nou_ymd;

    /** RG */
    private String rg;

    /** 便 */
    private String bin_no;

    /** 受入 */
    private String tk_uke;

    /** 得意先品番 */
    private String tk_hin;

    /** 収容数 */
    private String syuyo_su;

    /** 不足数 */
    private String fusoku_su;

    /** 指示数 */
    private String siji_su;

    /** 得意先背番 */
    private String tk_seban;

    /** 管理工場 */
    private String kanri_kojo;

    /** 出荷拠点 */
    private String s_kyoten;

    /** 製造場所 */
    private String seizo_ba;

    /** ロケーション */
    private String location;

    /**
     * @return
     */
    public String getBin_no() {
        return bin_no;
    }

    /**
     * @return
     */
    public String getFusoku_su() {
        return fusoku_su;
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
    public String getLocation() {
        return location;
    }

    /**
     * @return
     */
    public String getNou_ymd() {
        return nou_ymd;
    }

    /**
     * @return
     */
    public String getRg() {
        return rg;
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
    public String getSeizo_ba() {
        return seizo_ba;
    }

    /**
     * @return
     */
    public String getSiji_su() {
        return siji_su;
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
     * @param string
     */
    public void setBin_no(String string) {
        bin_no = string;
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
    public void setKanri_kojo(String string) {
        kanri_kojo = string;
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
    public void setNou_ymd(String string) {
        nou_ymd = string;
    }

    /**
     * @param string
     */
    public void setRg(String string) {
        rg = string;
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
    public void setSeizo_ba(String string) {
        seizo_ba = string;
    }

    /**
     * @param string
     */
    public void setSiji_su(String string) {
        siji_su = string;
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

}
