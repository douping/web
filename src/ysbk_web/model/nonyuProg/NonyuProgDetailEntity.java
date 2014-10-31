/*
 * クラス名: NonyuProgDetailEntity
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/31
 *
 * Copyright:
 */

package ysbk_web.model.nonyuProg;

import ysbk_web.model.BaseEntity;

/**
 * @author 納入進捗詳細結果エンティティ。
 */
public class NonyuProgDetailEntity extends BaseEntity {

    /** 追 */
    private String tuika_fg;

    /** 支給先 */
    private String tk_kojo;

    /** 受入 */
    private String tk_uke;

    /** メーカー背番 */
    private String tk_seban;

    /** メーカー品番 */
    private String tk_hin;

    /** 枝番 */
    private String edaban;

    /** 仕入背番 */
    private String seban;

    /** 収容数 */
    private String syuyo_su;

    /** 納入番号 */
    private String tp_noban;

    /** 受注数 */
    private String siji_su;

    /** 不足数 */
    private String fusoku_su;

    /** 準備数 */
    private String junbi_su;

    /** 打切残数 */
    private String uchi_zan_su;

    /** ｵﾘｼﾞﾅﾙ納入日 */
    private String org_nou_ymd;

    /** ｵﾘｼﾞﾅﾙ便 */
    private String org_bin_no;

    /** ｵﾘｼﾞﾅﾙ指示数 */
    private String org_siji_su;

    /** ｵﾘｼﾞﾅﾙ枝番 */
    private String org_edaban;

    /** 打切フラグ */
    private String uchi_fg;

    /** 引当フラグ */
    private String hiki_fg;

    /**
     * @return
     */
    public String getEdaban() {
        return edaban;
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
    public String getJunbi_su() {
        return junbi_su;
    }

    /**
     * @return
     */
    public String getOrg_bin_no() {
        return org_bin_no;
    }

    /**
     * @return
     */
    public String getOrg_edaban() {
        return org_edaban;
    }

    /**
     * @return
     */
    public String getOrg_nou_ymd() {
        return org_nou_ymd;
    }

    /**
     * @return
     */
    public String getOrg_siji_su() {
        return org_siji_su;
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
    public String getTk_kojo() {
        return tk_kojo;
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
    public String getTp_noban() {
        return tp_noban;
    }

    /**
     * @return
     */
    public String getTuika_fg() {
        return tuika_fg;
    }

    /**
     * @return
     */
    public String getUchi_zan_su() {
        return uchi_zan_su;
    }

    /**
     * @param string
     */
    public void setEdaban(String string) {
        edaban = string;
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
    public void setJunbi_su(String string) {
        junbi_su = string;
    }

    /**
     * @param string
     */
    public void setOrg_bin_no(String string) {
        org_bin_no = string;
    }

    /**
     * @param string
     */
    public void setOrg_edaban(String string) {
        org_edaban = string;
    }

    /**
     * @param string
     */
    public void setOrg_nou_ymd(String string) {
        org_nou_ymd = string;
    }

    /**
     * @param string
     */
    public void setOrg_siji_su(String string) {
        org_siji_su = string;
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
    public void setTk_kojo(String string) {
        tk_kojo = string;
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
    public void setTp_noban(String string) {
        tp_noban = string;
    }

    /**
     * @param string
     */
    public void setTuika_fg(String string) {
        tuika_fg = string;
    }

    /**
     * @param string
     */
    public void setUchi_zan_su(String string) {
        uchi_zan_su = string;
    }

    /**
     * @return
     */
    public String getHiki_fg() {
        return hiki_fg;
    }

    /**
     * @return
     */
    public String getUchi_fg() {
        return uchi_fg;
    }

    /**
     * @param string
     */
    public void setHiki_fg(String string) {
        hiki_fg = string;
    }

    /**
     * @param string
     */
    public void setUchi_fg(String string) {
        uchi_fg = string;
    }

}
