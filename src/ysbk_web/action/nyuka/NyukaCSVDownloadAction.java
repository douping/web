/*
 * クラス名: NyukaCSVDownloadAction
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

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import ysbk_web.service.NyukaService;
import ysbk_web.utility.CommandException;
import ysbk_web.utility.Constants;
import ysbk_web.utility.Keys;
import ysbk_web.view.NyukaView;
import ysbk_web.view.UserView;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class NyukaCSVDownloadAction extends ActionSupport {
    /** 搬入日 */
    private String han_ymd;

    // Downloadボタンで画面表示フラグ
    private String reSearchFlg;

    // チェックされる行番号の集合(番号,番号,番号…)
    private String checkFlag;

    // 明細の集合(項目1,項目2,項目3…)
    private List<String> checkFlg;

    // 明細件数の合計
    private Long dataCount;

    // 入荷情報結果を取得する
    private List<NyukaView> nyukas;

    private NyukaService nyukaService;

    public String execute() throws Exception {
		String target = null;
		HttpServletResponse response = ServletActionContext.getResponse();
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		UserView userView = (UserView) session.get(Keys.USER_ENTITY);

		nyukas = nyukaService.getNyukaResult(userView, han_ymd);
		dataCount = (long) nyukas.size();
		nyukaService.getCSVOutputResult(userView, han_ymd, checkFlg, response);
		StringBuffer sSosin = new StringBuffer();
		for (String str : checkFlg) {
			String[] arr = str.split(",");
			int i = arr.length - 1;
			sSosin.append(arr[i]);
			sSosin.append(",");
		}
		checkFlag = sSosin.toString();
		reSearchFlg = Keys.NO_RESEARCH;

		return target;
    }

    public String getHan_ymd() {
        return han_ymd;
    }

    public void setHan_ymd(String han_ymd) {
        this.han_ymd = han_ymd;
    }

    public String getReSearchFlg() {
        return reSearchFlg;
    }

    public void setReSearchFlg(String reSearchFlg) {
        this.reSearchFlg = reSearchFlg;
    }

    public String getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(String checkFlag) {
        this.checkFlag = checkFlag;
    }

    public List<String> getCheckFlg() {
        return checkFlg;
    }

    public void setCheckFlg(List<String> checkFlg) {
        this.checkFlg = checkFlg;
    }

    public Long getDataCount() {
        return dataCount;
    }

    public void setDataCount(Long dataCount) {
        this.dataCount = dataCount;
    }

    public List<NyukaView> getNyukas() {
        return nyukas;
    }

    public void setNyukas(List<NyukaView> nyukas) {
        this.nyukas = nyukas;
    }

    public NyukaService getNyukaService() {
        return nyukaService;
    }

    public void setNyukaService(NyukaService nyukaService) {
        this.nyukaService = nyukaService;
    }

}
