/*
 * クラス名: SyukkaCSVEntity
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/31
 *
 * Copyright:
 */

package ysbk_web.model.syukka;

import ysbk_web.model.BaseEntity;

/**
 * @author 出荷管理Download検索結果エンティティ。
 */
public class SyukkaCSVEntity extends BaseEntity {

    /** T得意先コード */
    private String ttk_cd;

    /** 得意先受入 */
    private String tk_uke;

    /** 支給先 */
    private String sikyu_saki;

    /** 直送区分 */
    private String choku_kb;

    /** 仕入先 */
    private String siire;

    /** 工区 */
    private String koku;

    /** TP機番 */
    private String tp_kiban;

    /** TP納番 */
    private String tp_noban;

    /** 得意先背番 */
    private String tk_seban;

    /** 得意先品番 */
    private String tk_hin;

    /** 収容数 */
    private String syuyo_su;

    /** 指示箱数 */
    private String siji_hako;

    /** 指示数 */
    private String siji_su;

    /** 納入日 */
    private String nou_ymd;

    /** 納入便 */
    private String nou_bin;

    /** 打切フラグ */
    private String uchi_fg;

    /** 打切残数 */
    private String uchi_zan_su;

    /** TP発注区分 */
    private String tp_hachu_kb;

    /** かんばん区分 */
    private String kanban_kb;

    /** 出荷場 */
    private String syukaba;

    /** アイデントNo */
    private String ident_no;

    /** 吊上げ時間 */
    private String tsuri_hm;

    /** 実納入日 */
    private String j_nou_ymd;

    /** 実納入便 */
    private String j_nou_bin;

    /** QR内容 */
    private String qr_naiyo;

    /** BC連番 */
    // 2006/10/07 Add
    private String bc_no;

    /**
     * T得意先コードを取得します。
     * 
     * @return java.lang.String
     */
    public String getTtk_cd() {
        return ttk_cd;
    }

    /**
     * T得意先コードを設定します。
     * 
     * @param ttk_cd
     */
    public void setTtk_cd(String ttk_cd) {
        this.ttk_cd = ttk_cd;
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
     * 支給先を取得します。
     * 
     * @return java.lang.String
     */
    public String getSikyu_saki() {
        return sikyu_saki;
    }

    /**
     * 支給先を設定します。
     * 
     * @param sikyu_saki
     */
    public void setSikyu_saki(String sikyu_saki) {
        this.sikyu_saki = sikyu_saki;
    }

    /**
     * 直送区分を取得します。
     * 
     * @return java.lang.String
     */
    public String getChoku_kb() {
        return choku_kb;
    }

    /**
     * 直送区分を設定します。
     * 
     * @param choku_kb
     */
    public void setChoku_kb(String choku_kb) {
        this.choku_kb = choku_kb;
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
     * 工区を取得します。
     * 
     * @return java.lang.String
     */
    public String getKoku() {
        return koku;
    }

    /**
     * 工区を設定します。
     * 
     * @param koku
     */
    public void setKoku(String koku) {
        this.koku = koku;
    }

    /**
     * TP機番を取得します。
     * 
     * @return java.lang.String
     */
    public String getTp_kiban() {
        return tp_kiban;
    }

    /**
     * TP機番を設定します。
     * 
     * @param tp_kiban
     */
    public void setTp_kiban(String tp_kiban) {
        this.tp_kiban = tp_kiban;
    }

    /**
     * TP納番を取得します。
     * 
     * @return java.lang.String
     */
    public String getTp_noban() {
        return tp_noban;
    }

    /**
     * TP納番を設定します。
     * 
     * @param tp_noban
     */
    public void setTp_noban(String tp_noban) {
        this.tp_noban = tp_noban;
    }

    /**
     * 得意先背番を取得します。
     * 
     * @return java.lang.String
     */
    public String getTk_seban() {
        return tk_seban;
    }

    /**
     * 得意先背番を設定します。
     * 
     * @param tk_seban
     */
    public void setTk_seban(String tk_seban) {
        this.tk_seban = tk_seban;
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
     * 納入便を取得します。
     * 
     * @return java.lang.String
     */
    public String getNou_bin() {
        return nou_bin;
    }

    /**
     * 納入便を設定します。
     * 
     * @param nou_bin
     */
    public void setNou_bin(String nou_bin) {
        this.nou_bin = nou_bin;
    }

    /**
     * 打切フラグを取得します。
     * 
     * @return java.lang.String
     */
    public String getUchi_fg() {
        return uchi_fg;
    }

    /**
     * 打切フラグを設定します。
     * 
     * @param uchi_fg
     */
    public void setUchi_fg(String uchi_fg) {
        this.uchi_fg = uchi_fg;
    }

    /**
     * 打切残数を取得します。
     * 
     * @return java.lang.String
     */
    public String getUchi_zan_su() {
        return uchi_zan_su;
    }

    /**
     * 打切残数を設定します。
     * 
     * @param uchi_zan_su
     */
    public void setUchi_zan_su(String uchi_zan_su) {
        this.uchi_zan_su = uchi_zan_su;
    }

    /**
     * TP発注区分を取得します。
     * 
     * @return java.lang.String
     */
    public String getTp_hachu_kb() {
        return tp_hachu_kb;
    }

    /**
     * TP発注区分を設定します。
     * 
     * @param tp_hachu_kb
     */
    public void setTp_hachu_kb(String tp_hachu_kb) {
        this.tp_hachu_kb = tp_hachu_kb;
    }

    /**
     * かんばん区分を取得します。
     * 
     * @return java.lang.String
     */
    public String getKanban_kb() {
        return kanban_kb;
    }

    /**
     * かんばん区分を設定します。
     * 
     * @param kanban_kb
     */
    public void setKanban_kb(String kanban_kb) {
        this.kanban_kb = kanban_kb;
    }

    /**
     * 出荷場を取得します。
     * 
     * @return java.lang.String
     */
    public String getSyukaba() {
        return syukaba;
    }

    /**
     * 出荷場を設定します。
     * 
     * @param syukaba
     */
    public void setSyukaba(String syukaba) {
        this.syukaba = syukaba;
    }

    /**
     * アイデントNoを取得します。
     * 
     * @return java.lang.String
     */
    public String getIdent_no() {
        return ident_no;
    }

    /**
     * アイデントNoを設定します。
     * 
     * @param ident_no
     */
    public void setIdent_no(String ident_no) {
        this.ident_no = ident_no;
    }

    /**
     * 吊上げ時間を取得します。
     * 
     * @return java.lang.String
     */
    public String getTsuri_hm() {
        return tsuri_hm;
    }

    /**
     * 吊上げ時間を設定します。
     * 
     * @param tsuri_hm
     */
    public void setTsuri_hm(String tsuri_hm) {
        this.tsuri_hm = tsuri_hm;
    }

    /**
     * 実納入日を取得します。
     * 
     * @return java.lang.String
     */
    public String getJ_nou_ymd() {
        return j_nou_ymd;
    }

    /**
     * 実納入日を設定します。
     * 
     * @param j_nou_ymd
     */
    public void setJ_nou_ymd(String j_nou_ymd) {
        this.j_nou_ymd = j_nou_ymd;
    }

    /**
     * 実納入便を取得します。
     * 
     * @return java.lang.String
     */
    public String getJ_nou_bin() {
        return j_nou_bin;
    }

    /**
     * 実納入便を設定します。
     * 
     * @param j_nou_bin
     */
    public void setJ_nou_bin(String j_nou_bin) {
        this.j_nou_bin = j_nou_bin;
    }

    /**
     * QR内容を取得します。
     * 
     * @return java.lang.String
     */
    public String getQr_naiyo() {
        return qr_naiyo;
    }

    /**
     * QR内容を設定します。
     * 
     * @param qr_naiyo
     */
    public void setQr_naiyo(String qr_naiyo) {
        this.qr_naiyo = qr_naiyo;
    }

    /**
     * @return
     */
    public String getBc_no() {
        return bc_no;
    }

    /**
     * @param string
     */
    public void setBc_no(String string) {
        bc_no = string;
    }
    // End

}
