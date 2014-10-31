/*
 * クラス名: HannyuProgDetailCondition
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/31
 *
 * Copyright:
 */

package ysbk_web.condition;

/**
 * @author 搬入進捗管理 【詳細画面】詳細condition
 */
public class HannyuProgDetailCondition {

    /** 状況 */
    private String hanjou_fg;

    /** 便ID */
    private String bin_id;

    /** 搬入日 */
    private String han_ymd;

    /** 特車区分 */
    private String tokusya_kb;

    /** 回数 */
    private String tokusya_kai;

    public String getHanjou_fg() {
        return hanjou_fg;
    }

    public void setHanjou_fg(String hanjou_fg) {
        this.hanjou_fg = hanjou_fg;
    }

    public String getBin_id() {
        return bin_id;
    }

    public void setBin_id(String bin_id) {
        this.bin_id = bin_id;
    }

    public String getHan_ymd() {
        return han_ymd;
    }

    public void setHan_ymd(String han_ymd) {
        this.han_ymd = han_ymd;
    }

    public String getTokusya_kb() {
        return tokusya_kb;
    }

    public void setTokusya_kb(String tokusya_kb) {
        this.tokusya_kb = tokusya_kb;
    }

    public String getTokusya_kai() {
        return tokusya_kai;
    }

    public void setTokusya_kai(String tokusya_kai) {
        this.tokusya_kai = tokusya_kai;
    }

}
