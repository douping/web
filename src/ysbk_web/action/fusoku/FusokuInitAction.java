/*
 * クラス名: FusokuInitAction
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/08/05
 *
 * Copyright:
 */

package ysbk_web.action.fusoku;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import ysbk_web.model.fusoku.FusokuEntity;
import ysbk_web.service.FusokuService;
import ysbk_web.utility.Keys;
import ysbk_web.utility.Page;
import ysbk_web.utility.Utility;
import ysbk_web.view.UserView;

/**
 * @author 不足数検索一覧初期化アクション。
 */
public class FusokuInitAction extends ActionSupport {

    /** ログインスタンス */
    private static Logger logger = Logger.getLogger(FusokuInitAction.class);

    /**
     * 開始データインデックスはデータ総件数以上の場合、 開始データインデックスは1ページの最大件数を引く
     */
    private int startIndex = 0;

    private Page page;

    private FusokuService fusokuService;

    /**
     * Actionクラスのexecuteメッソドを実装します。
     * 
     * @return String
     * @throws Exception
     */
    public String execute() throws Exception {
        List<FusokuEntity> list;
        /* セッションチェック */
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        UserView userView = (UserView) session.get(Keys.USER_ENTITY);
        list = fusokuService.findFusoku(userView);
        logger.info("fh for fusoku check2 list=" + list);
        page = Utility.getPage(list, startIndex);
        return SUCCESS;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public FusokuService getFusokuService() {
        return fusokuService;
    }

    public void setFusokuService(FusokuService fusokuService) {
        this.fusokuService = fusokuService;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

}
