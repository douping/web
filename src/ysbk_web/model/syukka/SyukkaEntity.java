/*
 * クラス名: SyukkaEntity
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2005/04/27
 *
 * Copyright:
 */

package ysbk_web.model.syukka;

import ysbk_web.model.BaseEntity;

/**
 * @author 出荷管理検索結果エンティティ。
 */
public class SyukkaEntity extends BaseEntity {

    /** 便No */
    private String bin_no;

    /** 得意先受入 */
    private String tk_uke;

    /** 納入日 */
    private String nou_ymd;

    /** RG */
    private String rg;
    
    /** グループごとの件数 */
    private Long cnt;
    
    /** グループごとのsosinFlg合計 */
    private Long sumCnt;

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

    public String getNou_ymd() {
        return nou_ymd;
    }

    public void setNou_ymd(String nou_ymd) {
        this.nou_ymd = nou_ymd;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Long getCnt() {
        return cnt;
    }

    public void setCnt(Long cnt) {
        this.cnt = cnt;
    }

    public Long getSumCnt() {
        return sumCnt;
    }

    public void setSumCnt(Long sumCnt) {
        this.sumCnt = sumCnt;
    }

}
