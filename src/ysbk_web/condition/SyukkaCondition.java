/*
 * クラス名: SyukkaCondition
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/30
 *
 * Copyright:
 */

package ysbk_web.condition;

import ysbk_web.view.UserView;

public class SyukkaCondition {

    /** 納入日 */
    private String nou_ymd;

    /** 指定テーブル名 */
    private String sTbl;

    /** column 便No */
    private String sBinNm;

    /** column 納入日 */
    private String sNou_Ymd;

    /** ユーザ情報 */
    private UserView userView;

    /** テーブル元区分 */
    private String downloadType;

    /** download或いは差分download */
    private String downFlg;

    /** 便No */
    private String bin_no;

    /** 得意先受入 */
    private String tk_uke;

    /** RG */
    private String rg;
    /** 納入便のTBL項目名  */
    private String sCSVBinNm;
    /** 指示数のTBL項目名  */
    private String sSijiSuNm;
    /** 指示箱数のTBL項目名 */
    private String sSijiHakoNm;
    /** 支給先のTBL項目名 */
    private String sSikyuSakiNm;
    /** 納入日のTBL項目名  */
    private String sCSVNouYmd;

    public String getDownloadType() {
        return downloadType;
    }

    public void setDownloadType(String downloadType) {
        this.downloadType = downloadType;
    }

    public String getNou_ymd() {
        return nou_ymd;
    }

    public void setNou_ymd(String nou_ymd) {
        this.nou_ymd = nou_ymd;
    }

    public String getsTbl() {
        return sTbl;
    }

    public void setsTbl(String sTbl) {
        this.sTbl = sTbl;
    }

    public String getsBinNm() {
        return sBinNm;
    }

    public void setsBinNm(String sBinNm) {
        this.sBinNm = sBinNm;
    }

    public String getsNou_Ymd() {
        return sNou_Ymd;
    }

    public void setsNou_Ymd(String sNou_Ymd) {
        this.sNou_Ymd = sNou_Ymd;
    }

    public UserView getUserView() {
        return userView;
    }

    public void setUserView(UserView userView) {
        this.userView = userView;
    }

    public String getDownFlg() {
        return downFlg;
    }

    public void setDownFlg(String downFlg) {
        this.downFlg = downFlg;
    }

    public String getBin_no() {
        return bin_no;
    }

    public void setBin_no(String bin_no) {
        this.bin_no = bin_no;
    }

    public String getTk_uke() {
        return tk_uke;
    }

    public void setTk_uke(String tk_uke) {
        this.tk_uke = tk_uke;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getsCSVBinNm() {
        return sCSVBinNm;
    }

    public void setsCSVBinNm(String sCSVBinNm) {
        this.sCSVBinNm = sCSVBinNm;
    }

    public String getsSijiSuNm() {
        return sSijiSuNm;
    }

    public void setsSijiSuNm(String sSijiSuNm) {
        this.sSijiSuNm = sSijiSuNm;
    }

    public String getsSijiHakoNm() {
        return sSijiHakoNm;
    }

    public void setsSijiHakoNm(String sSijiHakoNm) {
        this.sSijiHakoNm = sSijiHakoNm;
    }

    public String getsSikyuSakiNm() {
        return sSikyuSakiNm;
    }

    public void setsSikyuSakiNm(String sSikyuSakiNm) {
        this.sSikyuSakiNm = sSikyuSakiNm;
    }

    public String getsCSVNouYmd() {
        return sCSVNouYmd;
    }

    public void setsCSVNouYmd(String sCSVNouYmd) {
        this.sCSVNouYmd = sCSVNouYmd;
    }

	@Override
	public String toString() {
		return "SyukkaCondition [nou_ymd=" + nou_ymd + ", sTbl=" + sTbl
				+ ", sBinNm=" + sBinNm + ", sNou_Ymd=" + sNou_Ymd
				+ ", userView=" + userView + ", downloadType=" + downloadType
				+ ", downFlg=" + downFlg + ", bin_no=" + bin_no + ", tk_uke="
				+ tk_uke + ", rg=" + rg + ", sCSVBinNm=" + sCSVBinNm
				+ ", sSijiSuNm=" + sSijiSuNm + ", sSijiHakoNm=" + sSijiHakoNm
				+ ", sSikyuSakiNm=" + sSikyuSakiNm + ", sCSVNouYmd="
				+ sCSVNouYmd + "]";
	}
    
}