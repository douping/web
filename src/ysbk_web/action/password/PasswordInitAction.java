/*
 * クラス名: PasswordInitAction
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/29
 *
 * Copyright:
 */

package ysbk_web.action.password;

import java.util.Map;

import org.apache.log4j.Logger;

import ysbk_web.utility.Keys;
import ysbk_web.view.UserView;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author パスワード変更初期化アクション。
 */
public class PasswordInitAction extends ActionSupport {
    /** ログインスタンス */
    private static Logger logger = Logger.getLogger(PasswordInitAction.class);

    private static final long serialVersionUID = 1L;

    public String opcode;

    /**
     * opcodeを取得します。
     * 
     * @return java.lang.String
     */
    public String getOpcode() {
        return opcode;
    }

    /**
     * opcodeを設定します。
     * 
     * @param opcode
     */
    public void setOpcode(String opcode) {
        this.opcode = opcode;
    }

    /**
     * Actionクラスのexecuteメッソドを実装します。
     * 
     * @return String　アクションフォーワード
     */
    public String execute() throws Exception {

        /* セッションチェック */
        ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
        UserView userView = (UserView) session.get(Keys.USER_ENTITY);
        opcode = userView.getOpcode().trim();
        logger.info("fh  11=" + opcode);
        return INPUT;

    }
}
