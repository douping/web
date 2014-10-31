/*
 * クラス名: NonyuProgEntity
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
 * @author 納入進捗一覧結果エンティティ。
 */
public class NonyuProgEntity extends BaseEntity {

    /** 納入日 */
    private String nou_ymd;

    /** RG */
    private String rg;

    /** 便 */
    private String bin_no;

    /** 出発時間 */
    private String nou_tim;

    /** 受注区分(表示名) */
    private String juchu_kb_name;

    /** 追 */
    private String tuika_fg;

    /** Ｔ */
    private String w_topps_jyucyu;

    /** 手 */
    private String w_hand_jyucyu;

    /** 書 */
    private String w_siji_hakko;

    /** 中 */
    private String w_jyunbi_cyu;

    /** 完 */
    private String w_jyunbi_kan;

    /** 出 */
    private String w_syukka_kan;

    /** 引当 */
    private String hikiate;

    /** 指示箱数 */
    private String siji_hako;

    /** 不足箱数 */
    private String fusoku_hako;

    /** 準備箱数 */
    private String junbi_hako;

    /** 積載容積 */
    private String seki_vol;

    /** 受注区分 */
    private String juchu_kb;

    /** 異常区分 */
    private String ijou_kb;

    /** 納入状況フラグ */
    private String noujou_fg;

    /** 引当抑止フラグ */
    private String hikiyokusi_fg;

    /** 引当フラグ */
    private String hiki_fg;

    /** 納入日 + 納入時間 yyyymmddhhmmss */
    private String nou_daytime;

    private String hako_ymd;

    /**
     * @return
     */
    public String getBin_no() {
        return bin_no;
    }

    /**
     * @return
     */
    public String getFusoku_hako() {
        return fusoku_hako;
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
    public String getHikiyokusi_fg() {
        return hikiyokusi_fg;
    }

    /**
     * @return
     */
    public String getIjou_kb() {
        return ijou_kb;
    }

    /**
     * @return
     */
    public String getJuchu_kb() {
        return juchu_kb;
    }

    /**
     * @return
     */
    public String getJuchu_kb_name() {
        return juchu_kb_name;
    }

    /**
     * @return
     */
    public String getJunbi_hako() {
        return junbi_hako;
    }

    /**
     * @return
     */
    public String getNou_tim() {
        return nou_tim;
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
    public String getNoujou_fg() {
        return noujou_fg;
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
    public String getSeki_vol() {
        return seki_vol;
    }

    /**
     * @return
     */
    public String getSiji_hako() {
        return siji_hako;
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
    public String getW_hand_jyucyu() {
        return w_hand_jyucyu;
    }

    /**
     * @return
     */
    public String getW_jyunbi_cyu() {
        return w_jyunbi_cyu;
    }

    /**
     * @return
     */
    public String getW_jyunbi_kan() {
        return w_jyunbi_kan;
    }

    /**
     * @return
     */
    public String getW_siji_hakko() {
        return w_siji_hakko;
    }

    /**
     * @return
     */
    public String getW_syukka_kan() {
        return w_syukka_kan;
    }

    /**
     * @return
     */
    public String getW_topps_jyucyu() {
        return w_topps_jyucyu;
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
    public void setFusoku_hako(String string) {
        fusoku_hako = string;
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
    public void setHikiyokusi_fg(String string) {
        hikiyokusi_fg = string;
    }

    /**
     * @param string
     */
    public void setIjou_kb(String string) {
        ijou_kb = string;
    }

    /**
     * @param string
     */
    public void setJuchu_kb(String string) {
        juchu_kb = string;
    }

    /**
     * @param string
     */
    public void setJuchu_kb_name(String string) {
        juchu_kb_name = string;
    }

    /**
     * @param string
     */
    public void setJunbi_hako(String string) {
        junbi_hako = string;
    }

    /**
     * @param string
     */
    public void setNou_tim(String string) {
        nou_tim = string;
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
    public void setNoujou_fg(String string) {
        noujou_fg = string;
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
    public void setSeki_vol(String string) {
        seki_vol = string;
    }

    /**
     * @param string
     */
    public void setSiji_hako(String string) {
        siji_hako = string;
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
    public void setW_hand_jyucyu(String string) {
        w_hand_jyucyu = string;
    }

    /**
     * @param string
     */
    public void setW_jyunbi_cyu(String string) {
        w_jyunbi_cyu = string;
    }

    /**
     * @param string
     */
    public void setW_jyunbi_kan(String string) {
        w_jyunbi_kan = string;
    }

    /**
     * @param string
     */
    public void setW_siji_hakko(String string) {
        w_siji_hakko = string;
    }

    /**
     * @param string
     */
    public void setW_syukka_kan(String string) {
        w_syukka_kan = string;
    }

    /**
     * @param string
     */
    public void setW_topps_jyucyu(String string) {
        w_topps_jyucyu = string;
    }

    /**
     * @return
     */
    public String getHikiate() {
        return hikiate;
    }

    /**
     * @param string
     */
    public void setHikiate(String string) {
        hikiate = string;
    }

    /**
     * @return
     */
    public String getNou_daytime() {
        return nou_daytime;
    }

    /**
     * @param string
     */
    public void setNou_daytime(String string) {
        nou_daytime = string;
    }

    public String getHako_ymd() {
        return hako_ymd;
    }

    public void setHako_ymd(String hako_ymd) {
        this.hako_ymd = hako_ymd;
    }

}
