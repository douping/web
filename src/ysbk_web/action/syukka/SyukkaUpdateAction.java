/*
 * クラス名: SyukkaUpdateAction
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

import ysbk_web.service.SyukkaService;
import ysbk_web.utility.CommandException;
import ysbk_web.utility.Constants;
import ysbk_web.utility.Keys;
import ysbk_web.view.SyukkaView;
import ysbk_web.view.UserView;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SyukkaUpdateAction extends ActionSupport {
    // Downloadデータ元区分
    private String downloadType;

    // Downloadボタンで画面表示フラグ
    private String reSearchFlg;

    // チェックされる行番号の集合(番号,番号,番号…)
    private String checkFlag;

    // 明細の集合(項目1,項目2,項目3…)
    private List<String> checkFlg;

    // 差分Download或いはDownload
    private String downFlg;

    // 明細件数の合計
    private Long dataCount;

    private SyukkaService syukkaService;

    // 納入日
    private String nou_ymd;

    // 明細の集合リスト
    private List<SyukkaView> syukkaList;

    public String execute() throws Exception {
		String target = Constants.SUCCESS;
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		UserView userView = (UserView) session.get(Keys.USER_ENTITY);

		StringBuffer sSosin = new StringBuffer();
		for (String str : checkFlg) {
			String[] arr = str.split(",");
			int i = arr.length - 1;
			sSosin.append(arr[i]);
			sSosin.append(",");
		}
		checkFlag = sSosin.toString();

		syukkaService.updateSosinFlg(userView, downloadType, downFlg, checkFlg);
		reSearchFlg = Keys.DO_RESEARCH;

		syukkaList = syukkaService.getSyukkaResult(userView, downloadType,
				nou_ymd);

		dataCount = (long) syukkaList.size();

		return target;
    }

    public String getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(String checkFlag) {
        this.checkFlag = checkFlag;
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

    public String getNou_ymd() {
        return nou_ymd;
    }

    public void setNou_ymd(String nou_ymd) {
        this.nou_ymd = nou_ymd;
    }

    public List<SyukkaView> getSyukkaList() {
		return syukkaList;
	}

	public void setSyukkaList(List<SyukkaView> syukkaList) {
		this.syukkaList = syukkaList;
	}

	public void setSyukkaService(SyukkaService syukkaService) {
        this.syukkaService = syukkaService;
    }

    public SyukkaService getSyukkaService() {
        return syukkaService;
    }
}
