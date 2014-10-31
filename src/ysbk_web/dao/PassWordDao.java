/*
 * クラス名: PassWordDao
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/25
 *
 * Copyright:
 */

package ysbk_web.dao;

import ysbk_web.utility.CommandException;

public interface PassWordDao {

    /**
     * パスワードのUPDATEを行う。
     * 
     * @param opcode ,oppswd,chgoppswd
     * @return boolean
     * @throws CommandException
     */
    public Boolean updatePswd(String opcode, String oppswd, String chgoppswd)
            throws CommandException;

}
