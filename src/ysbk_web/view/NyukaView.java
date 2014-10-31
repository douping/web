/*
 * クラス名: NyukaView
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/08/04
 *
 * Copyright:
 */

package ysbk_web.view;

public class NyukaView {

    /** 受信 */
    private String jyushin;

    /** 便No */
    private String bin_no;

    /**
     * 受信を取得します。
     * 
     * @return java.lang.String
     */
    public String getJyushin() {
        return jyushin;
    }

    /**
     * 受信を設定します。
     * 
     * @param jyushin
     */
    public void setJyushin(String jyushin) {
        this.jyushin = jyushin;
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

}
