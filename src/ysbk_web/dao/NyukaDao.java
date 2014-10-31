/*
 * クラス名: NyukaDao
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/30
 *
 * Copyright:
 */

package ysbk_web.dao;

import java.util.List;

import ysbk_web.condition.NyukaCondition;
import ysbk_web.model.nyuka.NyukaCSVEntity;
import ysbk_web.model.nyuka.NyukaEntity;
import ysbk_web.utility.CommandException;

public interface NyukaDao {
    /**
     * 入荷情報結果表示用データ取得
     * 
     * @param nyukaCondition
     * @return
     * @throws CommandException
     */
    public List<NyukaEntity> findNyukaResult(NyukaCondition nyukaCondition)
            throws CommandException;

    /**
     * 送信フラグ更新。
     * 
     * @param NyukaCondition
     * @return
     */
    public Boolean setKousinUpdate(NyukaCondition nyukaCondition)
            throws CommandException;

    /**
     * 入荷管理CSV結果を取得します。
     * 
     * @param nyukaCondition
     * @return List ユーザーCSV結果
     */
    public List<NyukaCSVEntity> findCSVOutputResult(
            NyukaCondition nyukaCondition) throws CommandException;
}
