/*
 * クラス名: HinbanZaikoDetailEntity
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/24
 *
 * Copyright:
 */

package ysbk_web.model.hinbanZaiko;

import ysbk_web.model.BaseEntity;

/**
 * @author 品番別在庫管理 詳細 検索結果エンティティ。
 */
public class HinbanZaikoDetailEntity extends BaseEntity {

    /** 予定日 */
    private String yotei_ymd;

    /** 予定時刻 */
    private String yotei_hms;

    /** 相手先 */
    private String a_jigyo_cd;

    /** 受入 */
    private String tk_uke;

    /** 便 */
    private String bin_no;

    /** 納入番号 */
    private String tp_noban;

    /** 入出庫 */
    private String nyusyu_kb;

    /** 搬入数 */
    private String han_su;

    /** 納入数 */
    private String siji_su;

    /** 理論在庫 */
    private String w_riron_zaiko;

    /**
     * @return
     */
    public String getA_jigyo_cd() {
        return a_jigyo_cd;
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
    public String getHan_su() {
        return han_su;
    }

    /**
     * @return
     */
    public String getNyusyu_kb() {
        return nyusyu_kb;
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
    public String getW_riron_zaiko() {
        return w_riron_zaiko;
    }

    /**
     * @return
     */
    public String getYotei_hms() {
        return yotei_hms;
    }

    /**
     * @return
     */
    public String getYotei_ymd() {
        return yotei_ymd;
    }

    /**
     * @param string
     */
    public void setA_jigyo_cd(String string) {
        a_jigyo_cd = string;
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
    public void setHan_su(String string) {
        han_su = string;
    }

    /**
     * @param string
     */
    public void setNyusyu_kb(String string) {
        nyusyu_kb = string;
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
    public void setW_riron_zaiko(String string) {
        w_riron_zaiko = string;
    }

    /**
     * @param string
     */
    public void setYotei_hms(String string) {
        yotei_hms = string;
    }

    /**
     * @param string
     */
    public void setYotei_ymd(String string) {
        yotei_ymd = string;
    }

	@Override
	public String toString() {
		return "HinbanZaikoDetailEntity [yotei_ymd=" + yotei_ymd
				+ ", yotei_hms=" + yotei_hms + ", a_jigyo_cd=" + a_jigyo_cd
				+ ", tk_uke=" + tk_uke + ", bin_no=" + bin_no + ", tp_noban="
				+ tp_noban + ", nyusyu_kb=" + nyusyu_kb + ", han_su=" + han_su
				+ ", siji_su=" + siji_su + ", w_riron_zaiko=" + w_riron_zaiko
				+ "]";
	}
    
    
}
