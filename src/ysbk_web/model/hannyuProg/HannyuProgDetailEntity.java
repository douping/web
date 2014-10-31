/*
 * クラス名: HannyuProgDetailEntity
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
 * @author 搬入進捗詳細結果エンティティ。
 */
public class HannyuProgDetailEntity extends BaseEntity {

    /** メーカー品番 */
    private String tk_hin;

    /** 収容数 */
    private String syuyo_su;

    /** 仕入先背番 */
    private String seban;

    /** 予定数(指示数) */
    private String siji_su;

    /** 予定箱数(予定箱数) */
    private String siji_hako;

    /** 搬入数 */
    private String han_su;

    /** 搬入箱数 */
    private String han_hako;

    /** 差 */
    private String sa;

    /** 出荷拠点 */
    private String s_kyoten;

    /** 製造場所 */
    private String seizo_ba;

    /**
     * @return
     */
    public String getHan_hako() {
        return han_hako;
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
    public String getS_kyoten() {
        return s_kyoten;
    }

    /**
     * @return
     */
    public String getSa() {
        return sa;
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
    public String getSiji_hako() {
        return siji_hako;
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
     * @param string
     */
    public void setHan_hako(String string) {
        han_hako = string;
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
    public void setS_kyoten(String string) {
        s_kyoten = string;
    }

    /**
     * @param string
     */
    public void setSa(String string) {
        sa = string;
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
    public void setSiji_hako(String string) {
        siji_hako = string;
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

}
