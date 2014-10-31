/*
 * クラス名: FusokuDao
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/25
 *
 * Copyright:
 */

package ysbk_web.dao;

import java.util.HashMap;
import java.util.List;

import ysbk_web.model.fusoku.FusokuEntity;
import ysbk_web.utility.CommandException;

public interface FusokuDao {

    /**
     * 不足数一覧検索ビーン。
     * 
     * @param map
     * @return List<FusokuEntity>
     * @throws CommandException
     */
    public List<FusokuEntity> findFusoku(HashMap<String, String> map)
            throws CommandException;

}
