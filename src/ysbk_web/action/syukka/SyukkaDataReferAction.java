/*
 * クラス名: SyukkaDataReferAction
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/30
 *
 * Copyright:
 */

package ysbk_web.action.syukka;

import java.util.List;
import java.util.Map;

import ysbk_web.service.SyukkaService;
import ysbk_web.utility.CommandException;
import ysbk_web.utility.Constants;
import ysbk_web.utility.Keys;
import ysbk_web.view.SyukkaView;
import ysbk_web.view.UserView;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SyukkaDataReferAction extends ActionSupport {
    // download情報区分
    private String downloadType;

    // 納入日
    private String nou_ymd;

    // 出荷情報結果を取得
    private List<SyukkaView> syukkaList;

    // 情報件数
    private Long dataCount;

    // Downloadで画面表示フラグ
    private String reSearchFlg;

    private SyukkaService syukkaService;

    public String execute() throws Exception {
		String target = Constants.SUCCESS;
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		UserView userView = (UserView) session.get(Keys.USER_ENTITY);
		syukkaList = syukkaService.getSyukkaResult(userView, downloadType,
				nou_ymd);
		dataCount = (long) syukkaList.size();
		reSearchFlg = Keys.NO_RESEARCH;

		return target;
    }

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

    public void setSyukkaService(SyukkaService syukkaService) {
        this.syukkaService = syukkaService;
    }

    public Long getDataCount() {
        return dataCount;
    }

    public void setDataCount(Long dataCount) {
        this.dataCount = dataCount;
    }

    public String getReSearchFlg() {
        return reSearchFlg;
    }

    public void setReSearchFlg(String reSearchFlg) {
        this.reSearchFlg = reSearchFlg;
    }

	public List<SyukkaView> getSyukkaList() {
		return syukkaList;
	}

	public void setSyukkaList(List<SyukkaView> syukkaList) {
		this.syukkaList = syukkaList;
	}
    
    

}
