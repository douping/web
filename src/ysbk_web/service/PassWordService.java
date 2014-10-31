/*
 * クラス名: PassWordService
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/29
 *
 * Copyright:
 */

package ysbk_web.service;

import ysbk_web.utility.CommandException;

/**
 * @author パスワード変更サービス。
 */
public interface PassWordService {

    /**
     * パスワードのUPDATEを行う。
     * 
     * @param opcode ,oppswd,chgoppswd
     * @return boolean
     */
    public Boolean updatePswd(String opcode, String oppswd, String chgoppswd)
            throws CommandException;
}
