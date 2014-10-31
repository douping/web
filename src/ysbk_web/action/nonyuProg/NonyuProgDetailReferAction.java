/*
 * クラス名: NonyuProgDetailReferAction
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/08/04
 *
 * Copyright:
 */

package ysbk_web.action.nonyuProg;

import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import ysbk_web.model.nonyuProg.NonyuProgDetailEntity;
import ysbk_web.service.NonyuProgService;
import ysbk_web.utility.Constants;
import ysbk_web.utility.Keys;
import ysbk_web.view.UserView;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 納入進捗管理の詳細表示に対するアクション。
 */
public class NonyuProgDetailReferAction extends ActionSupport {

    /** ログインスタンス */
    private static Logger logger = Logger
            .getLogger(NonyuProgDetailReferAction.class);

    private NonyuProgService nonyuProgService;

    /** 納入日 */
    private String nou_ymd;

    /** RG */
    private String rg;

    /** 便 */
    private String bin_no;

    /** 出発時間 */
    private String nou_tim;

    /** 受注区分(表示名) */
    private String juchu_kb_name;

    /** 追 */
    private String tuika_fg;

    /** Ｔ */
    private String w_topps_jyucyu;

    /** 手 */
    private String w_hand_jyucyu;

    /** 書 */
    private String w_siji_hakko;

    /** 中 */
    private String w_jyunbi_cyu;

    /** 完 */
    private String w_jyunbi_kan;

    /** 出 */
    private String w_syukka_kan;

    /** 引当 */
    private String hikiate;

    /** 指示箱数 */
    private String siji_hako;

    /** 不足箱数 */
    private String fusoku_hako;

    /** 準備箱数 */
    private String junbi_hako;

    /** 積載容積 */
    private String seki_vol;

    /** 受注区分 */
    private String juchu_kb;

    /** 異常区分 */
    private String ijou_kb;

    /** 納入状況フラグ */
    private String noujou_fg;

    /** 引当抑止フラグ */
    private String hikiyokusi_fg;

    /** 引当フラグ */
    private String hiki_fg;

    /** 納入日 + 納入時間 yyyymmddhhmmss */
    private String nou_daytime;

    /** 納入進捗詳細結果エンティティ list */
    private List<NonyuProgDetailEntity> nonyuProgDetails;

    /** request */
    private Map<String, String> request;

    /** check result */
    private Boolean hasDetail;

    /**
     * Actionクラスのexecuteメッソドを実装します。
     * 
     * @return String
     * @throws Exception
     */
    public String execute() throws Exception {
    	String target = Constants.SUCCESS;
        request = (Map<String, String>) ActionContext.getContext().get(
                "request");
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        UserView userView = (UserView) session.get(Keys.USER_ENTITY);
        tuika_fg = URLDecoder.decode(tuika_fg, "UTF-8");
        rg = URLDecoder.decode(rg, "UTF-8");
        w_topps_jyucyu = URLDecoder.decode(w_topps_jyucyu, "UTF-8");
        w_hand_jyucyu = URLDecoder.decode(w_hand_jyucyu, "UTF-8");
        w_siji_hakko = URLDecoder.decode(w_siji_hakko, "UTF-8");
        w_jyunbi_cyu = URLDecoder.decode(w_jyunbi_cyu, "UTF-8");
        w_jyunbi_kan = URLDecoder.decode(w_jyunbi_kan, "UTF-8");
        w_syukka_kan = URLDecoder.decode(w_syukka_kan, "UTF-8");
        hikiate = URLDecoder.decode(hikiate, "UTF-8");
        hiki_fg = URLDecoder.decode(hiki_fg, "UTF-8");
        juchu_kb_name = URLDecoder.decode(juchu_kb_name, "UTF-8");
        nonyuProgDetails = nonyuProgService.findAllNonyuProgDetail(userView,
                nou_ymd, rg, bin_no, noujou_fg);
        hasDetail = nonyuProgDetails.isEmpty();
        Map<String, String> rqst = nonyuProgService.setRequest();
        request.put("kado_date1", rqst.get("kado_date1"));
        request.put("kado_date2", rqst.get("kado_date2"));
        logger.info("fhfh" + nou_ymd + "===" + bin_no + "----" + tuika_fg
                + "+++" + w_topps_jyucyu);
        return target;

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

    public String getBin_no() {
        return bin_no;
    }

    public void setBin_no(String bin_no) {
        this.bin_no = bin_no;
    }

    public String getNou_tim() {
        return nou_tim;
    }

    public void setNou_tim(String nou_tim) {
        this.nou_tim = nou_tim;
    }

    public String getJuchu_kb_name() {
        return juchu_kb_name;
    }

    public void setJuchu_kb_name(String juchu_kb_name) {
        this.juchu_kb_name = juchu_kb_name;
    }

    public String getTuika_fg() {
        return tuika_fg;
    }

    public void setTuika_fg(String tuika_fg) {
        this.tuika_fg = tuika_fg;
    }

    public String getW_topps_jyucyu() {
        return w_topps_jyucyu;
    }

    public void setW_topps_jyucyu(String w_topps_jyucyu) {
        this.w_topps_jyucyu = w_topps_jyucyu;
    }

    public String getW_hand_jyucyu() {
        return w_hand_jyucyu;
    }

    public void setW_hand_jyucyu(String w_hand_jyucyu) {
        this.w_hand_jyucyu = w_hand_jyucyu;
    }

    public String getW_siji_hakko() {
        return w_siji_hakko;
    }

    public void setW_siji_hakko(String w_siji_hakko) {
        this.w_siji_hakko = w_siji_hakko;
    }

    public String getW_jyunbi_cyu() {
        return w_jyunbi_cyu;
    }

    public void setW_jyunbi_cyu(String w_jyunbi_cyu) {
        this.w_jyunbi_cyu = w_jyunbi_cyu;
    }

    public String getW_jyunbi_kan() {
        return w_jyunbi_kan;
    }

    public void setW_jyunbi_kan(String w_jyunbi_kan) {
        this.w_jyunbi_kan = w_jyunbi_kan;
    }

    public String getW_syukka_kan() {
        return w_syukka_kan;
    }

    public void setW_syukka_kan(String w_syukka_kan) {
        this.w_syukka_kan = w_syukka_kan;
    }

    public String getHikiate() {
        return hikiate;
    }

    public void setHikiate(String hikiate) {
        this.hikiate = hikiate;
    }

    public String getSiji_hako() {
        return siji_hako;
    }

    public void setSiji_hako(String siji_hako) {
        this.siji_hako = siji_hako;
    }

    public String getFusoku_hako() {
        return fusoku_hako;
    }

    public void setFusoku_hako(String fusoku_hako) {
        this.fusoku_hako = fusoku_hako;
    }

    public String getJunbi_hako() {
        return junbi_hako;
    }

    public void setJunbi_hako(String junbi_hako) {
        this.junbi_hako = junbi_hako;
    }

    public String getSeki_vol() {
        return seki_vol;
    }

    public void setSeki_vol(String seki_vol) {
        this.seki_vol = seki_vol;
    }

    public String getJuchu_kb() {
        return juchu_kb;
    }

    public void setJuchu_kb(String juchu_kb) {
        this.juchu_kb = juchu_kb;
    }

    public String getIjou_kb() {
        return ijou_kb;
    }

    public void setIjou_kb(String ijou_kb) {
        this.ijou_kb = ijou_kb;
    }

    public String getNoujou_fg() {
        return noujou_fg;
    }

    public void setNoujou_fg(String noujou_fg) {
        this.noujou_fg = noujou_fg;
    }

    public String getHikiyokusi_fg() {
        return hikiyokusi_fg;
    }

    public void setHikiyokusi_fg(String hikiyokusi_fg) {
        this.hikiyokusi_fg = hikiyokusi_fg;
    }

    public String getHiki_fg() {
        return hiki_fg;
    }

    public void setHiki_fg(String hiki_fg) {
        this.hiki_fg = hiki_fg;
    }

    public String getNou_daytime() {
        return nou_daytime;
    }

    public void setNou_daytime(String nou_daytime) {
        this.nou_daytime = nou_daytime;
    }

    public List<NonyuProgDetailEntity> getNonyuProgDetails() {
        return nonyuProgDetails;
    }

    public void setNonyuProgDetails(List<NonyuProgDetailEntity> nonyuProgDetails) {
        this.nonyuProgDetails = nonyuProgDetails;
    }

    public Boolean getHasDetail() {
        return hasDetail;
    }

    public void setHasDetail(Boolean hasDetail) {
        this.hasDetail = hasDetail;
    }

    public void setNonyuProgService(NonyuProgService nonyuProgService) {
        this.nonyuProgService = nonyuProgService;
    }

	public Map<String, String> getRequest() {
		return request;
	}

	public void setRequest(Map<String, String> request) {
		this.request = request;
	}
    
}
