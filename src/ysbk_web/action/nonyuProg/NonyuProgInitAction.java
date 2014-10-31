/*
 * クラス名: NonyuProgInitAction
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/04/14
 *
 * Copyright:
 */

package ysbk_web.action.nonyuProg;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import ysbk_web.model.nonyuProg.NonyuProgEntity;
import ysbk_web.service.NonyuProgService;
import ysbk_web.utility.Constants;
import ysbk_web.utility.Keys;
import ysbk_web.utility.Page;
import ysbk_web.utility.Utility;
import ysbk_web.view.UserView;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 納入進捗管理検索一覧初期化アクション。
 */
public class NonyuProgInitAction extends ActionSupport {

    /** ログインスタンス */
    private static Logger logger = Logger.getLogger(NonyuProgInitAction.class);

    /**
     * 開始データインデックスはデータ総件数以上の場合、 開始データインデックスは1ページの最大件数を引く
     */
    private int startIndex;

    private Page page;

    private NonyuProgService nonyuProgService;

    private Map<String, String> request;

    /**
     * Actionクラスのexecuteメッソドを実装します。
     * 
     * @return java.lang.String
     * @throws Exception
     */
    public String execute() throws Exception {
    	String target = Constants.SUCCESS;
        request = (Map<String, String>) ActionContext.getContext().get(
                "request");
        List<NonyuProgEntity> list;
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        UserView userView = (UserView) session.get(Keys.USER_ENTITY);
        // 納入進捗一覧取得
        list = nonyuProgService.findAllNonyuProg(userView);
        logger.info("fh for nonyu check2 list=" + list);
        request = nonyuProgService.setRequest();
        page = Utility.getPage(list, startIndex);
        return target;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public NonyuProgService getNonyuProgService() {
        return nonyuProgService;
    }

    public void setNonyuProgService(NonyuProgService nonyuProgService) {
        this.nonyuProgService = nonyuProgService;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

	public Map<String, String> getRequest() {
		return request;
	}

	public void setRequest(Map<String, String> request) {
		this.request = request;
	}
    
    
}
