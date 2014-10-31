/*
 * クラス名: HinbanZaikoInitAction
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/23
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

public class HinbanZaikoInitAction extends ActionSupport {

    private HinbanZaikoService hinbanZaikoService;

    /**
     * 開始データインデックスはデータ総件数以上の場合、 開始データインデックスは1ページの最大件数を引く
     */
    private int startIndex = 0;

    private Page page;

    public String execute() throws Exception {
        List<HinbanZaikoEntity> list;
        String target = Constants.SUCCESS;
       
            ActionContext actionContext = ActionContext.getContext();
            Map session = actionContext.getSession();
            UserView userView = (UserView) session.get(Keys.USER_ENTITY);
            // 品番別の在庫情報結果を取得する
            list = hinbanZaikoService.getAllHinbanZaiko(userView);
            // 検索結果でPageを作成する
            page = Utility.getPage(list, startIndex);
        return target;
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
