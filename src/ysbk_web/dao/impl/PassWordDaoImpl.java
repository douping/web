/*
 * クラス名: PassWordDaoImpl
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/30
 *
 * Copyright:
 */

package ysbk_web.dao.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ysbk_web.dao.PassWordDao;
import ysbk_web.utility.CommandException;
import ysbk_web.utility.Constants;

public class PassWordDaoImpl implements PassWordDao {
    private static Logger logger = Logger.getLogger(PassWordDaoImpl.class);

    @Resource(name = "sqlMapClientTemplate")
    private SqlMapClientTemplate sqlMapClientTemplate;

    /**
     * パスワードのUPDATEを行う。
     * 
     * @param opcode ,oppswd,chgoppswd
     * @return boolean
     * @throws CommandException
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public Boolean updatePswd(String opcode, String oppswd, String chgoppswd)
            throws CommandException {
        boolean bRet = true;
        logger.info("fh +test for password+ check1");
        try {

            Map<String, String> map = new HashMap<String, String>();
            map.put("opcode", opcode);
            map.put("oppswd", oppswd);
            map.put("chgoppswd", chgoppswd);
            // update正常終了の場合
            if (sqlMapClientTemplate.update("updatePswd", map) > 0) {
                bRet = true;
            } else {
                bRet = false;
            }

        } catch (Exception dbe) {
            bRet = false;
            throw new CommandException(dbe.getMessage(),
                    "error.PasswordBean.update.SQLException",
                    Constants.SQL_EXCEPTION);
        }

        logger.info("fh +test for password+ check6+bRet=" + bRet);
        return bRet;
    }
}
