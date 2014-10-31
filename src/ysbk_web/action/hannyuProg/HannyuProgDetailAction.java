/*
 * クラス名: HannyuProgDetailAction
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/08/04
 *
 * Copyright:
 */

package ysbk_web.action.hannyuProg;

import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import ysbk_web.model.hannyuProg.HannyuProgDetailEntity;
import ysbk_web.service.HannyuProgService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HannyuProgDetailAction extends ActionSupport {

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

    /** 状況 */
    private String hanjou_fg;

    /** 予定箱数 */
    private String siji_hako;

    /** 搬入個数 */
    private String han_hako;

    /** 状況(DB値) */
    private String hanjou_key;

    private HannyuProgService hannyuProgService;

    private List<HannyuProgDetailEntity> hannyuProgDetails;

    private Map<String, String> request;

    /** ログインスタンス */
    private static Logger logger = Logger
            .getLogger(HannyuProgDetailAction.class);

    public String execute() throws Exception {
        request = (Map<String, String>) ActionContext.getContext().get(
                "request");
        logger.info("aaaaa" + this.hanjou_fg + "==kb=" + tokusya_kb);
        if ("搬入確定".equals(hanjou_fg)) {
            request.put("name1", "予定数");
            request.put("name2", "予定箱数");
        } else {
            request.put("name1", "指示数");
            request.put("name2", "指示箱数");
        }
        tokusya_kb = URLDecoder.decode(tokusya_kb, "UTF-8");
        tokusya_kai = URLDecoder.decode(tokusya_kai, "UTF-8");
        bin_nm = URLDecoder.decode(bin_nm, "UTF-8");
        hanjou_fg = URLDecoder.decode(hanjou_fg, "UTF-8");
        hannyuProgDetails = hannyuProgService.findHannyuProgDetail(hanjou_fg,
                bin_id, han_ymd, tokusya_kb, tokusya_kai);
        return "success";
    }

    public String getHan_ymd() {
        return han_ymd;
    }

    public void setHan_ymd(String han_ymd) {
        this.han_ymd = han_ymd;
    }

    public String getKanri_kojo() {
        return kanri_kojo;
    }

    public void setKanri_kojo(String kanri_kojo) {
        this.kanri_kojo = kanri_kojo;
    }

    public String getS_kyoten() {
        return s_kyoten;
    }

    public void setS_kyoten(String s_kyoten) {
        this.s_kyoten = s_kyoten;
    }

    public String getBin_no() {
        return bin_no;
    }

    public void setBin_no(String bin_no) {
        this.bin_no = bin_no;
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

    public String getBin_id() {
        return bin_id;
    }

    public void setBin_id(String bin_id) {
        this.bin_id = bin_id;
    }

    public String getBin_nm() {
        return bin_nm;
    }

    public void setBin_nm(String bin_nm) {
        this.bin_nm = bin_nm;
    }

    public String getHanjou_fg() {
        return hanjou_fg;
    }

    public void setHanjou_fg(String hanjou_fg) {
        this.hanjou_fg = hanjou_fg;
    }

    public String getSiji_hako() {
        return siji_hako;
    }

    public void setSiji_hako(String siji_hako) {
        this.siji_hako = siji_hako;
    }

    public String getHan_hako() {
        return han_hako;
    }

    public void setHan_hako(String han_hako) {
        this.han_hako = han_hako;
    }

    public String getHanjou_key() {
        return hanjou_key;
    }

    public void setHanjou_key(String hanjou_key) {
        this.hanjou_key = hanjou_key;
    }

    public HannyuProgService getHannyuProgService() {
        return hannyuProgService;
    }

    public void setHannyuProgService(HannyuProgService hannyuProgService) {
        this.hannyuProgService = hannyuProgService;
    }

    public List<HannyuProgDetailEntity> getHannyuProgDetails() {
        return hannyuProgDetails;
    }

    public void setHannyuProgDetails(
            List<HannyuProgDetailEntity> hannyuProgDetails) {
        this.hannyuProgDetails = hannyuProgDetails;
    }

}
