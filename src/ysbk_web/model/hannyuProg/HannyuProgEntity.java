/*
 * クラス名: HannyuProgEntity
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/08/01
 *
 * Copyright:
 */

package ysbk_web.model.hannyuProg;

import ysbk_web.model.BaseEntity;

/**
 * @author 搬入進捗一覧結果エンティティ。
 */
public class HannyuProgEntity extends BaseEntity {

    /** 搬入日 */
    private String han_ymd;

    /** 管理工場 */
    private String kanri_kojo;

    /** 出荷拠点 */
    private String s_kyoten;

    /** 便 */
    private String bin_no;

    /** 特車区分 */
    private String tokusya_kb;

    /** 回数 */
    private String tokusya_kai;

    /** 便ID */
    private String bin_id;

    /** 便名 */
    private String bin_nm;

    /** 状況(名称) */
    private String hanjou_fg;

    /** 予定箱数 */
    private String siji_hako;

    /** 搬入個数 */
    private String han_hako;

    /** 状況(DB値) */
    private String hanjou_key;

    /**
     * @return
     */
    public String getBin_id() {
        return bin_id;
    }

    /**
     * @return
     */
    public String getBin_nm() {
        return bin_nm;
    }

    /**
     * @return
     */
    public String getBin_no() {
        return bin_no;
    }

    /**
     * @return
     */
    public String getHan_hako() {
        return han_hako;
    }

    /**
     * @return
     */
    public String getHan_ymd() {
        return han_ymd;
    }

    /**
     * @return
     */
    public String getHanjou_fg() {
        return hanjou_fg;
    }

    /**
     * @return
     */
    public String getHanjou_key() {
        return hanjou_key;
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
    public String getS_kyoten() {
        return s_kyoten;
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
    public String getTokusya_kai() {
        return tokusya_kai;
    }

    /**
     * @return
     */
    public String getTokusya_kb() {
        return tokusya_kb;
    }

    /**
     * @param string
     */
    public void setBin_id(String string) {
        bin_id = string;
    }

    /**
     * @param string
     */
    public void setBin_nm(String string) {
        bin_nm = string;
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
    public void setHan_hako(String string) {
        han_hako = string;
    }

    /**
     * @param string
     */
    public void setHan_ymd(String string) {
        han_ymd = string;
    }

    /**
     * @param string
     */
    public void setHanjou_fg(String string) {
        hanjou_fg = string;
    }

    /**
     * @param string
     */
    public void setHanjou_key(String string) {
        hanjou_key = string;
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
    public void setS_kyoten(String string) {
        s_kyoten = string;
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
    public void setTokusya_kai(String string) {
        tokusya_kai = string;
    }

    /**
     * @param string
     */
    public void setTokusya_kb(String string) {
        tokusya_kb = string;
    }

}
