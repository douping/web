/*
 * クラス名: hinbanZaikoSearchAction
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/24
 *
 * Copyright:
 */

package ysbk_web.action.hinbanZaiko;

import java.util.List;
import java.util.Map;

import ysbk_web.view.UserView;
import ysbk_web.model.hinbanZaiko.HinbanZaikoEntity;
import ysbk_web.service.HinbanZaikoService;

import ysbk_web.utility.CommandException;
import ysbk_web.utility.Constants;
import ysbk_web.utility.Keys;
import ysbk_web.utility.Page;
import ysbk_web.utility.Utility;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HinbanZaikoSearchAction extends ActionSupport {
    private List<HinbanZaikoEntity> hinbanZaikos;

    /** メーカー品番 */
    private String tk_hin;

    /** 受入 */
    private String tk_uke;

    /** 仕入先背番 */
    private String seban;

    /**
     * 開始データインデックスはデータ総件数以上の場合、 開始データインデックスは1ページの最大件数を引く
     */
    private int startIndex;

    private Page page;

    private HinbanZaikoService hinbanZaikoService;

    public String execute() throws Exception {
		List<HinbanZaikoEntity> list;
		String target = Constants.SUCCESS;
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		UserView userView = (UserView) session.get(Keys.USER_ENTITY);
		list = hinbanZaikoService.getAllHinbanZaiko(userView, tk_hin, tk_uke,
				seban);
		page = Utility.getPage(list, startIndex);
		return target;
    }

    public List<HinbanZaikoEntity> getHinbanZaikos() {
        return hinbanZaikos;
    }

    public void setHinbanZaikos(List<HinbanZaikoEntity> hinbanZaikos) {
        this.hinbanZaikos = hinbanZaikos;
    }

    public String getTk_hin() {
        return tk_hin;
    }

    public void setTk_hin(String tk_hin) {
        this.tk_hin = tk_hin;
    }

    public String getTk_uke() {
        return tk_uke;
    }

    public void setTk_uke(String tk_uke) {
        this.tk_uke = tk_uke;
    }

    public String getSeban() {
        return seban;
    }

    public void setSeban(String seban) {
        this.seban = seban;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public void setHinbanZaikoService(HinbanZaikoService hinbanZaikoService) {
        this.hinbanZaikoService = hinbanZaikoService;
    }

}
