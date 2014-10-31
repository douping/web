/*
 * クラス名: PassWordServiceImpl
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/30
 *
 * Copyright:
 */
package ysbk_web.service.impl;

import org.apache.log4j.Logger;

import ysbk_web.dao.PassWordDao;
import ysbk_web.service.PassWordService;
import ysbk_web.utility.CommandException;
import ysbk_web.utility.Constants;

/**
 * @author パスワード変更サービス。
 */
public class PassWordServiceImpl implements PassWordService {
    private static Logger logger = Logger.getLogger(PassWordServiceImpl.class);

    private PassWordDao passWordDao;

    public void setPassWordDao(PassWordDao passWordDao) {
        this.passWordDao = passWordDao;
    }

    /**
     * パスワードのUPDATEを行う。
     * 
     * @param opcode
     * @param oppswd パスワード
     * @param chgoppswd 変更パスワード
     * @return boolean
     */
    @Override
    public Boolean updatePswd(String opcode, String oppswd, String chgoppswd)
            throws CommandException {
        try {
            if (passWordDao.updatePswd(opcode, oppswd, chgoppswd)) {
                logger.info("fh +test for password+ check2");
                return true;
            } else {
                return false;
            }
        } catch (CommandException e) {
            throw e;
        } catch (Exception ex) {
            throw new CommandException(ex.getMessage(),
                    "error.PassWordServiceImpl.updatePswd.Exception",
                    Constants.EXCEPTION);
        }
    }
}
