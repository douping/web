/*
 * クラス名: UserDao
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/24
 *
 * Copyright:
 */
package ysbk_web.dao;

import java.util.List;

import ysbk_web.model.UserEntity;
import ysbk_web.utility.CommandException;

public interface UserDao {
    /**
     * ユーザエンティティ取得
     * 
     * @param opcode
     * @return UserEntity
     */
    public UserEntity findUserByCd(String opcode) throws CommandException;

    /**
     * W08Web入出庫ワークを削除
     * 
     * @param time
     * @return Boolean
     */
    public Boolean deleteNsyuko01(String wkiban) throws CommandException;

    /**
     * W08Web入出庫ワークを削除
     * 
     * @param time
     * @return Boolean
     */
    public Boolean deleteNsyuko02(String time) throws CommandException;

    /**
     * WEBログインRGマスタより取得
     * 
     * @param opcode
     * @return List<String>
     */
    public List<String> findRg(String opcode) throws CommandException;
}