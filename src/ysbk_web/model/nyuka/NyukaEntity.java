package ysbk_web.model.nyuka;

import ysbk_web.model.BaseEntity;

public class NyukaEntity extends BaseEntity {

    /** 便No */
    private String bin_no;

    /** 数量 */
    private Long cnt;

    /** 合計 */
    private Long sumCnt;

    public String getBin_no() {
        return bin_no;
    }

    public void setBin_no(String bin_no) {
        this.bin_no = bin_no;
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
