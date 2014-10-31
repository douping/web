/*
 * クラス名: LogoutAction
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/08/06
 *
 * Copyright:
 */

package ysbk_web.action;

import java.util.Map;

import ysbk_web.service.UserService;
import ysbk_web.utility.Constants;
import ysbk_web.utility.Keys;
import ysbk_web.view.UserView;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {

    private UserService userService;

    public String execute() throws Exception {
        String target = Constants.SUCCESS;
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        UserView userView = (UserView) session.get(Keys.USER_ENTITY);
        if (userView == null) {
            return target;
        } else {
            Boolean flg = userService.deleteW08(userView);
            if (!flg) {
                return Constants.ERR;
            }
            session.clear();
            return target;
        }
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
