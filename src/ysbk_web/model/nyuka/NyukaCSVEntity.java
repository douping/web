/*
 * クラス名: NyukaCSVEntity
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/08/04
 *
 * Copyright:
 */

package ysbk_web.model.nyuka;

import ysbk_web.model.BaseEntity;

/**
 * @author 入荷管理Download検索結果エンティティ。
 */
public class NyukaCSVEntity extends BaseEntity {

    /** 便ID */
    private String bin_id;

    /** 管理工場 */
    private String kanri_kojo;

    /** 搬入日 */
    private String han_ymd;

    /** 特車区分 */
    private String tokusya_kb;

    /** 特車回数 */
    private String tokusya_kai;

    /** 得意先品番 */
    private String tk_hin;

    /** 収容数 */
    private String syuyo_su;

    /** 矢崎背番 */
    private String seban;

    /** 指示箱数 */
    private String siji_hako;

    /** 指示数 */
    private String siji_su;

    /** 搬入箱数 */
    private String han_hako;

    /** 搬入数 */
    private String han_su;

    /** 出荷拠点 */
    private String s_kyoten;

    /** 製造場所 */
    private String seizo_ba;

    /** 処理日 */
    private String syori_ymd;

    /** 処理時間 */
    private String syori_hms;

    /** 確定フラグ */
    private String kakutei_fg;

    /** OPコード */
    private String opcode;

    /** 仕入先 */
    private String siire;

    /** 便No */
    private String bin_no;

    /**
     * 便IDを取得します。
     * 
     * @return java.lang.String
     */
    public String getBin_id() {
        return bin_id;
    }

    /**
     * 便IDを設定します。
     * 
     * @param bin_id
     */
    public void setBin_id(String bin_id) {
        this.bin_id = bin_id;
    }

    /**
     * 管理工場を取得します。
     * 
     * @return java.lang.String
     */
    public String getKanri_kojo() {
        return kanri_kojo;
    }

    /**
     * 管理工場を設定します。
     * 
     * @param kanri_kojo
     */
    public void setKanri_kojo(String kanri_kojo) {
        this.kanri_kojo = kanri_kojo;
    }

    /**
     * 搬入日を取得します。
     * 
     * @return java.lang.String
     */
    public String getHan_ymd() {
        return han_ymd;
    }

    /**
     * 搬入日を設定します。
     * 
     * @param han_ymd
     */
    public void setHan_ymd(String han_ymd) {
        this.han_ymd = han_ymd;
    }

    /**
     * 特車区分を取得します。
     * 
     * @return java.lang.String
     */
    public String getTokusya_kb() {
        return tokusya_kb;
    }

    /**
     * 特車区分を設定します。
     * 
     * @param tokusya_kb
     */
    public void setTokusya_kb(String tokusya_kb) {
        this.tokusya_kb = tokusya_kb;
    }

    /**
     * 特車回数を取得します。
     * 
     * @return java.lang.String
     */
    public String getTokusya_kai() {
        return tokusya_kai;
    }

    /**
     * 特車回数を設定します。
     * 
     * @param tokusya_kai
     */
    public void setTokusya_kai(String tokusya_kai) {
        this.tokusya_kai = tokusya_kai;
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
     * 矢崎背番を取得します。
     * 
     * @return java.lang.String
     */
    public String getSeban() {
        return seban;
    }

    /**
     * 矢崎背番を設定します。
     * 
     * @param seban
     */
    public void setSeban(String seban) {
        this.seban = seban;
    }

    /**
     * 指示箱数を取得します。
     * 
     * @return java.lang.String
     */
    public String getSiji_hako() {
        return siji_hako;
    }

    /**
     * 指示箱数を設定します。
     * 
     * @param siji_hako
     */
    public void setSiji_hako(String siji_hako) {
        this.siji_hako = siji_hako;
    }

    /**
     * 指示数を取得します。
     * 
     * @return java.lang.String
     */
    public String getSiji_su() {
        return siji_su;
    }

    /**
     * 指示数を設定します。
     * 
     * @param siji_su
     */
    public void setSiji_su(String siji_su) {
        this.siji_su = siji_su;
    }

    /**
     * 搬入箱数を取得します。
     * 
     * @return java.lang.String
     */
    public String getHan_hako() {
        return han_hako;
    }

    /**
     * 搬入箱数を設定します。
     * 
     * @param han_hako
     */
    public void setHan_hako(String han_hako) {
        this.han_hako = han_hako;
    }

    /**
     * 搬入数を取得します。
     * 
     * @return java.lang.String
     */
    public String getHan_su() {
        return han_su;
    }

    /**
     * 搬入数を設定します。
     * 
     * @param han_su
     */
    public void setHan_su(String han_su) {
        this.han_su = han_su;
    }

    /**
     * 出荷拠点を取得します。
     * 
     * @return java.lang.String
     */
    public String getS_kyoten() {
        return s_kyoten;
    }

    /**
     * 出荷拠点を設定します。
     * 
     * @param s_kyoten
     */
    public void setS_kyoten(String s_kyoten) {
        this.s_kyoten = s_kyoten;
    }

    /**
     * 製造場所を取得します。
     * 
     * @return java.lang.String
     */
    public String getSeizo_ba() {
        return seizo_ba;
    }

    /**
     * 製造場所を設定します。
     * 
     * @param seizo_ba
     */
    public void setSeizo_ba(String seizo_ba) {
        this.seizo_ba = seizo_ba;
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
     * 確定フラグを取得します。
     * 
     * @return java.lang.String
     */
    public String getKakutei_fg() {
        return kakutei_fg;
    }

    /**
     * 確定フラグを設定します。
     * 
     * @param kakutei_fg
     */
    public void setKakutei_fg(String kakutei_fg) {
        this.kakutei_fg = kakutei_fg;
    }

    /**
     * OPコードを取得します。
     * 
     * @return java.lang.String
     */
    public String getOpcode() {
        return opcode;
    }

    /**
     * OPコードを設定します。
     * 
     * @param opcode
     */
    public void setOpcode(String opcode) {
        this.opcode = opcode;
    }

    /**
     * 仕入先を取得します。
     * 
     * @return java.lang.String
     */
    public String getSiire() {
        return siire;
    }

    /**
     * 仕入先を設定します。
     * 
     * @param siire
     */
    public void setSiire(String siire) {
        this.siire = siire;
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

	@Override
	public String toString() {
		return "NyukaCSVEntity [bin_id=" + bin_id + ", kanri_kojo="
				+ kanri_kojo + ", han_ymd=" + han_ymd + ", tokusya_kb="
				+ tokusya_kb + ", tokusya_kai=" + tokusya_kai + ", tk_hin="
				+ tk_hin + ", syuyo_su=" + syuyo_su + ", seban=" + seban
				+ ", siji_hako=" + siji_hako + ", siji_su=" + siji_su
				+ ", han_hako=" + han_hako + ", han_su=" + han_su
				+ ", s_kyoten=" + s_kyoten + ", seizo_ba=" + seizo_ba
				+ ", syori_ymd=" + syori_ymd + ", syori_hms=" + syori_hms
				+ ", kakutei_fg=" + kakutei_fg + ", opcode=" + opcode
				+ ", siire=" + siire + ", bin_no=" + bin_no + "]";
	}

}
