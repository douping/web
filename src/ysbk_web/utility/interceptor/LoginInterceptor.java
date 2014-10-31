/*
 * クラス名: LoginInterceptor
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/26
 *
 * Copyright:
 */

package ysbk_web.utility.interceptor;

import java.util.Map;

import ysbk_web.utility.Constants;
import ysbk_web.utility.Keys;
import ysbk_web.view.UserView;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        Map<String, Object> session = invocation.getInvocationContext()
                .getSession();
        UserView userView = (UserView) session.get(Keys.USER_ENTITY);
        if (userView == null || userView.getOpcode() == null
                || "".equals(userView.getOpcode())) {
            return Constants.SESSION_ERR;
        }
        return invocation.invoke();
    }

}