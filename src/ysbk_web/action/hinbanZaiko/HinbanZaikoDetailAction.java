/*
 * クラス名: HinbanZaikoDetailAction
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/25
 *
 * Copyright:
 */

package ysbk_web.action.hinbanZaiko;

import java.util.List;
import java.util.Map;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import ysbk_web.view.UserView;
import ysbk_web.model.hinbanZaiko.HinbanZaikoDetailEntity;
import ysbk_web.service.HinbanZaikoService;
import ysbk_web.utility.CommandException;
import ysbk_web.utility.Constants;
import ysbk_web.utility.Keys;

public class HinbanZaikoDetailAction extends ActionSupport {
    /** 受入 */
    private String tk_uke;

    /** メーカー背番 */
    private String tk_seban;

    /** メーカー品番 */
    private String tk_hin;

    /** 収容数 */
    private String syuyo_su;

    /** 在庫数 */
    private String zaiko_su;

    /** ロケ在庫数 */
    private String loc_zaiko_su;

    /** 引当可能在庫数 */
    private String hiki_zaiko_su;

    /** 不足総数 */
    private String fusoku_su;

    /** 管理工場 */
    private String kanri_kojo;

    /** 出荷拠点 */
    private String s_kyoten;

    /** 製造場所 */
    private String seizo_ba;

    /** 仕入背番 */
    private String seban;

    /** 当日搬入数 */
    private String han_su;

    /** ロケ */
    private String location;

    /** 最終納入日 */
    private String lst_nou_ymd;

    /** 最終搬入日 */
    private String lst_han_ymd;

    private List<HinbanZaikoDetailEntity> hinbanZaikoDetails;

    private HinbanZaikoService hinbanZaikoService;

    public String execute() throws Exception {
		String target = Constants.SUCCESS;
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		UserView userView = (UserView) session.get(Keys.USER_ENTITY);
		hinbanZaikoDetails = hinbanZaikoService.getAllHinbanZaikoDetail(
				userView, tk_hin, syuyo_su);
		return target;
    }

    public String getTk_uke() {
        return tk_uke;
    }

    public void setTk_uke(String tk_uke) {
        this.tk_uke = tk_uke;
    }

    public String getTk_seban() {
        return tk_seban;
    }

    public void setTk_seban(String tk_seban) {
        this.tk_seban = tk_seban;
    }

    public String getTk_hin() {
        return tk_hin;
    }

    public void setTk_hin(String tk_hin) {
        this.tk_hin = tk_hin;
    }

    public String getSyuyo_su() {
        return syuyo_su;
    }

    public void setSyuyo_su(String syuyo_su) {
        this.syuyo_su = syuyo_su;
    }

    public String getZaiko_su() {
        return zaiko_su;
    }

    public void setZaiko_su(String zaiko_su) {
        this.zaiko_su = zaiko_su;
    }

    public String getLoc_zaiko_su() {
        return loc_zaiko_su;
    }

    public void setLoc_zaiko_su(String loc_zaiko_su) {
        this.loc_zaiko_su = loc_zaiko_su;
    }

    public String getHiki_zaiko_su() {
        return hiki_zaiko_su;
    }

    public void setHiki_zaiko_su(String hiki_zaiko_su) {
        this.hiki_zaiko_su = hiki_zaiko_su;
    }

    public String getFusoku_su() {
        return fusoku_su;
    }

    public void setFusoku_su(String fusoku_su) {
        this.fusoku_su = fusoku_su;
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

    public String getSeizo_ba() {
        return seizo_ba;
    }

    public void setSeizo_ba(String seizo_ba) {
        this.seizo_ba = seizo_ba;
    }

    public String getSeban() {
        return seban;
    }

    public void setSeban(String seban) {
        this.seban = seban;
    }

    public String getHan_su() {
        return han_su;
    }

    public void setHan_su(String han_su) {
        this.han_su = han_su;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLst_nou_ymd() {
        return lst_nou_ymd;
    }

    public void setLst_nou_ymd(String lst_nou_ymd) {
        this.lst_nou_ymd = lst_nou_ymd;
    }

    public String getLst_han_ymd() {
        return lst_han_ymd;
    }

    public void setLst_han_ymd(String lst_han_ymd) {
        this.lst_han_ymd = lst_han_ymd;
    }

    public HinbanZaikoService getHinbanZaikoService() {
        return hinbanZaikoService;
    }

    public void setHinbanZaikoService(HinbanZaikoService hinbanZaikoService) {
        this.hinbanZaikoService = hinbanZaikoService;
    }

    public List<HinbanZaikoDetailEntity> getHinbanZaikoDetails() {
        return hinbanZaikoDetails;
    }

    public void setHinbanZaikoDetails(
            List<HinbanZaikoDetailEntity> hinbanZaikoDetails) {
        this.hinbanZaikoDetails = hinbanZaikoDetails;
    }
}
