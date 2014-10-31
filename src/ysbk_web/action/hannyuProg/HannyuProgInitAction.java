/*
 * クラス名: HannyuProgInitAction
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/08/05
 *
 * Copyright:
 */

package ysbk_web.action.hannyuProg;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import ysbk_web.model.hannyuProg.HannyuProgEntity;
import ysbk_web.service.HannyuProgService;
import ysbk_web.utility.Keys;
import ysbk_web.utility.Page;
import ysbk_web.utility.Utility;
import ysbk_web.view.UserView;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 搬入進捗管理検索一覧初期化アクション。
 */
public class HannyuProgInitAction extends ActionSupport {

    /** ログインスタンス */
    private static Logger logger = Logger.getLogger(HannyuProgInitAction.class);

    /**
     * 開始データインデックスはデータ総件数以上の場合、 開始データインデックスは1ページの最大件数を引く
     */
    private int startIndex = 0;

    private Page page;

    private HannyuProgService hannyuProgService;

    /**
     * Actionクラスのexecuteメッソドを実装します。
     * 
     * @return String
     * @throws Exception
     */
    public String execute() throws Exception {
        List<HannyuProgEntity> list;
        /* セッションチェック */
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        UserView userView = (UserView) session.get(Keys.USER_ENTITY);
        list = hannyuProgService.findHannyuProg(userView);
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

    public HannyuProgService getHannyuProgService() {
        return hannyuProgService;
    }

    public void setHannyuProgService(HannyuProgService hannyuProgService) {
        this.hannyuProgService = hannyuProgService;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

}
