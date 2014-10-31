/*
 * クラス名: NonyuProgDao
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/31
 *
 * Copyright:
 */

package ysbk_web.dao;

import java.util.List;

import ysbk_web.condition.NonyuProgCondition;
import ysbk_web.condition.NonyuProgDetailCondition;
import ysbk_web.model.nonyuProg.NonyuProgDetailEntity;
import ysbk_web.model.nonyuProg.NonyuProgEntity;
import ysbk_web.utility.CommandException;

public interface NonyuProgDao {

    /**
     * 納入進捗一覧取得
     * 
     * @return List<NonyuProgEntity>
     */
    public List<NonyuProgEntity> findNonyuProgByCondtion(
            NonyuProgCondition nonyuProgCondition) throws CommandException;

    /**
     * 納入進捗詳細取得
     * 
     * @param nonyuProgDetailCondition 一覧画面情報
     * @return List<NonyuProgDetailEntity>
     */
    public List<NonyuProgDetailEntity> findNonyuProgDetailByCondtion(
            NonyuProgDetailCondition nonyuProgDetailCondition)
            throws CommandException;

}
