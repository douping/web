/*
 * クラス名: UserService
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/24
 *
 * Copyright:
 */
package ysbk_web.service;

import javax.servlet.http.HttpServletRequest;

import ysbk_web.model.UserEntity;
import ysbk_web.utility.CommandException;
import ysbk_web.view.UserView;

public interface UserService {

    /**
     * UserEntityを取得する
     * 
     * @param opcode
     * @return UserEntity
     */
    public UserEntity findUserByCd(String opcode, HttpServletRequest request)
            throws CommandException;

    public boolean deleteW08(UserView userView) throws CommandException;

}