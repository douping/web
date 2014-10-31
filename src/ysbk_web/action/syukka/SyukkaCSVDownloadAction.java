/*
 * クラス名: SyukkaCSVDownloadAction
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/31
 *
 * Copyright:
 */

package ysbk_web.action.syukka;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import ysbk_web.service.SyukkaService;
import ysbk_web.utility.CommandException;
import ysbk_web.utility.Constants;
import ysbk_web.utility.Keys;
import ysbk_web.view.SyukkaView;
import ysbk_web.view.UserView;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SyukkaCSVDownloadAction extends ActionSupport {
    // Downloadデータ元区分
    private String downloadType;

    // Downloadボタンで画面表示フラグ
    private String reSearchFlg;

    // チェックされる行番号の集合(番号,番号,番号…)
    private String sSosinFlg;

    // 明細の集合(項目1,項目2,項目3…)
    private List<String> checkFlg;

    // 差分Download或いはDownload
    private String downFlg;

    // 明細件数の合計
    private Long dataCount;

    private SyukkaService syukkaService;

    // 出荷情報結果を取得
    private List<SyukkaView> syukkas;

    // 納入日
    private String nou_ymd;

    public String execute() throws Exception {
		String target = null;
		HttpServletResponse response = ServletActionContext.getResponse();
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		UserView userView = (UserView) session.get(Keys.USER_ENTITY);
		syukkaService.getCsvOutputResult(userView, downloadType, downFlg,
				checkFlg, nou_ymd, response);

		syukkas = syukkaService
				.getSyukkaResult(userView, downloadType, nou_ymd);
		dataCount = (long) syukkas.size();
		reSearchFlg = Keys.NO_RESEARCH;

		return target;
    }

    public String getDownloadType() {
        return downloadType;
    }

    public void setDownloadType(String downloadType) {
        this.downloadType = downloadType;
    }

    public String getReSearchFlg() {
        return reSearchFlg;
    }

    public void setReSearchFlg(String reSearchFlg) {
        this.reSearchFlg = reSearchFlg;
    }

    public String getsSosinFlg() {
        return sSosinFlg;
    }

    public void setsSosinFlg(String sSosinFlg) {
        this.sSosinFlg = sSosinFlg;
    }

    public List<String> getCheckFlg() {
        return checkFlg;
    }

    public void setCheckFlg(List<String> checkFlg) {
        this.checkFlg = checkFlg;
    }

    public String getDownFlg() {
        return downFlg;
    }

    public void setDownFlg(String downFlg) {
        this.downFlg = downFlg;
    }

    public Long getDataCount() {
        return dataCount;
    }

    public void setDataCount(Long dataCount) {
        this.dataCount = dataCount;
    }

    public List<SyukkaView> getSyukkas() {
        return syukkas;
    }

    public void setSyukkas(List<SyukkaView> syukkas) {
        this.syukkas = syukkas;
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

}
