/*
 * クラス名: PasswordReferAction
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
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import ysbk_web.service.PassWordService;

/**
 * @author パスワード変更機能に対するアクション。
 */
public class PasswordReferAction extends ActionSupport {

    private static Logger logger = Logger.getLogger(PasswordReferAction.class);

    private static final long serialVersionUID = 1L;

    private Map request;

    private String opcode;

    private String oppswd;

    private String chgoppswd;

    private PassWordService passWordService;

    /*@Override
    public void validate() {
        super.validate();
        if (oppswd == null || "".equals(oppswd)) {
            this.addFieldError("pswd", "MSG1200:" + this.getText("MSG1200"));
        }
        if (chgoppswd == null || "".equals(chgoppswd)) {
            this.addFieldError(chgoppswd, "MSG1201:" + this.getText("MSG1201"));
        }
    }*/

    @Override
    public String execute() throws Exception {
        logger.info("fh +test for password+ check" + opcode);
        request = (Map) ActionContext.getContext().get("request");

        if (oppswd == null || "".equals(oppswd) || chgoppswd == null
                || "".equals(chgoppswd)) {
            return INPUT;
        } else if (passWordService.updatePswd(opcode, oppswd, chgoppswd)) {
            request.put("judgeRslt", "success");
            return SUCCESS;
        } else {
            request.put("judgeRslt", "failure");
            return "failure";
        }
    }

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
     * oppswdを取得します。
     * 
     * @return java.lang.String
     */
    public String getOppswd() {
        return oppswd;
    }

    /**
     * oppswdを設定します。
     * 
     * @param oppswd
     */
    public void setOppswd(String oppswd) {
        this.oppswd = oppswd;
    }

    /**
     * chgoppswdを取得します。
     * 
     * @return java.lang.String
     */
    public String getChgoppswd() {
        return chgoppswd;
    }

    /**
     * chgoppswdを設定します。
     * 
     * @param chgoppswd
     */
    public void setChgoppswd(String chgoppswd) {
        this.chgoppswd = chgoppswd;
    }

    public PassWordService getPassWordService() {
        return passWordService;
    }

    public void setPassWordService(PassWordService passWordService) {
        this.passWordService = passWordService;
    }

}
