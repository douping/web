/*
 * クラス名: NyukaDataReferAction
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/08/01
 *
 * Copyright:
 */

package ysbk_web.action.nyuka;

import java.util.List;
import java.util.Map;

import ysbk_web.service.NyukaService;
import ysbk_web.utility.CommandException;
import ysbk_web.utility.Constants;
import ysbk_web.utility.Keys;
import ysbk_web.view.NyukaView;
import ysbk_web.view.UserView;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class NyukaDataReferAction extends ActionSupport {
    // 搬入日
    private String han_ymd;

    // 入荷情報結果を取得する
    private List<NyukaView> nyukas;

    // 明細件数の合計
    private Long dataCount;

    private NyukaService nyukaService;

    public String execute() throws Exception {
		String target = Constants.SUCCESS;
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		UserView userView = (UserView) session.get(Keys.USER_ENTITY);
		nyukas = nyukaService.getNyukaResult(userView, han_ymd);
		dataCount = (long) nyukas.size();

		return target;
    }

    public String getHan_ymd() {
        return han_ymd;
    }

    public void setHan_ymd(String han_ymd) {
        this.han_ymd = han_ymd;
    }

    public List<NyukaView> getNyukas() {
        return nyukas;
    }

    public void setNyukas(List<NyukaView> nyukas) {
        this.nyukas = nyukas;
    }

    public Long getDataCount() {
        return dataCount;
    }

    public void setDataCount(Long dataCount) {
        this.dataCount = dataCount;
    }

    public NyukaService getNyukaService() {
        return nyukaService;
    }

    public void setNyukaService(NyukaService nyukaService) {
        this.nyukaService = nyukaService;
    }

}
