/*
F * クラス名: HannyuProgDao
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/31
 *
 * Copyright:
 */

package ysbk_web.dao;

import java.util.HashMap;
import java.util.List;

import ysbk_web.condition.HannyuProgDetailCondition;
import ysbk_web.model.hannyuProg.HannyuProgDetailEntity;
import ysbk_web.model.hannyuProg.HannyuProgEntity;
import ysbk_web.utility.CommandException;

public interface HannyuProgDao {

    /**
     * 搬入進捗管理検索
     * 
     * @return List<HannyuProgEntity>
     */
    public List<HannyuProgEntity> findHannyuProg(HashMap<String, String> map)
            throws CommandException;

    /**
     * 搬入進捗管理 詳細取得
     * 
     * @param hannyuProgDetailCondition 一覧画面情報
     * @return List<HannyuProgDetailEntity>
     */
    public List<HannyuProgDetailEntity> findHannyuProgDetail(
            HannyuProgDetailCondition hannyuProgDetailCondition)
            throws CommandException;

}
