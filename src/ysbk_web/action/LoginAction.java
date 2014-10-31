/*
 * クラス名: LoginAction
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/24
 *
 * Copyright:
 */
package ysbk_web.action;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import ysbk_web.model.UserEntity;
import ysbk_web.service.UserService;
import ysbk_web.utility.CommandException;
import ysbk_web.utility.Constants;

public class LoginAction extends ActionSupport {
    private static Logger logger = Logger.getLogger(LoginAction.class);

    private static final long serialVersionUID = 1L;

    private String opcode;

    private String oppswd;

    public String message;// execute()

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * messageを取得します。
     * 
     * @return java.lang.String
     */
    public String getMessage() {
        return message;
    }

    /**
     * messageを設定します。
     * 
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /*@Override
    public void validate() {
        // super.validate();
        String opcode = this.opcode;
        String oppswd = this.oppswd;
        if (opcode == null || "".equals(opcode)) {
            this.addFieldError(opcode, "MSG1100:" + this.getText("MSG1100"));
        }
        if (oppswd == null || "".equals(oppswd)) {
            this.addFieldError(oppswd, "MSG1101:" + this.getText("MSG1101"));
        }
    }*/

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String target = Constants.SUCCESS;
        try{
        	UserEntity user = userService.findUserByCd(opcode, request);
            if (opcode == null || "".equals(opcode) || oppswd == null
                    || "".equals(oppswd)) {
                target =  INPUT;
            } else if (user != null && oppswd.equals(user.getOppswd().trim())) {
                message = opcode + "password is ok";
                target = SUCCESS;
            } else {
                target = ERROR;
            }
        } catch (CommandException cex) {
            if (cex.getErrorType() == Constants.SQL_EXCEPTION) {
                target = Constants.DBERR;
            } else if (cex.getErrorType() == Constants.EXCEPTION) {
                target = Constants.ERR;
            }
        }
        return target;
    }

    public String getOpcode() {
        return opcode;
    }

    public void setOpcode(String opcode) {
        this.opcode = opcode;
    }

    public String getOppswd() {
        return oppswd;
    }

    public void setOppswd(String oppswd) {
        this.oppswd = oppswd;
    }

}