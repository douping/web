/*
 * クラス名: ZaikoCSVDownloadAction
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/29
 *
 * Copyright:
 */

package ysbk_web.action.zaiko;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import ysbk_web.service.ZaikoService;
import ysbk_web.utility.CommandException;
import ysbk_web.utility.Constants;
import ysbk_web.utility.Keys;
import ysbk_web.view.UserView;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ZaikoCSVDownloadAction extends ActionSupport {
    // ダウンロードタイプ
    private String downloadType;

    // 処理日
    private String syori_ymd;

    // サービス
    private ZaikoService zaikoService;

    public String execute() throws Exception {
		String target = null;
		HttpServletResponse response = ServletActionContext.getResponse();
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		UserView userView = (UserView) session.get(Keys.USER_ENTITY);
		zaikoService
				.getCsvDownload(userView, syori_ymd, downloadType, response);

		return target;
    }

    public String getDownloadType() {
        return downloadType;
    }

    public void setDownloadType(String downloadType) {
        this.downloadType = downloadType;
    }

    public String getSyori_ymd() {
        return syori_ymd;
    }

    public void setSyori_ymd(String syori_ymd) {
        this.syori_ymd = syori_ymd;
    }

    public void setZaikoService(ZaikoService zaikoService) {
        this.zaikoService = zaikoService;
    }

}
