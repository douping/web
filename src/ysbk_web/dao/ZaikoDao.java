/*
 * クラス名: ZaikoDao
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/24
 *
 * Copyright:
 */

package ysbk_web.dao;

import java.util.List;

import ysbk_web.condition.ZaikoCondition;
import ysbk_web.utility.CommandException;

public interface ZaikoDao {

    /**
     * 在庫管理CSV結果を取得します。
     * 
     * @param zaikoCondition ユーザーフォーム。
     * @return List ユーザーCSV結果
     */
    public List csvOutput(ZaikoCondition zaikoCondition)
            throws CommandException;

    /**
     * 在庫管理履歴データCSV結果を取得します。
     * 
     * @param zaikoCondition ユーザーフォーム。
     * @return List ユーザーCSV結果
     */
    public List csvRirekiOutput(ZaikoCondition zaikoCondition)
            throws CommandException;
}
