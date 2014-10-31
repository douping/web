/*
 * クラス名: SyukkaDao
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/30
 *
 * Copyright:
 */

package ysbk_web.dao;

import java.util.List;

import ysbk_web.condition.SyukkaCondition;
import ysbk_web.model.syukka.SyukkaCSVEntity;
import ysbk_web.model.syukka.SyukkaEntity;
import ysbk_web.utility.CommandException;

public interface SyukkaDao {

    /**
     * downloadType区分：0~5の検索条件
     * 
     * @param syukkaCondition
     * @return
     * @throws CommandException
     */
    public List<SyukkaEntity> findSyukkaResult(SyukkaCondition syukkaCondition)
            throws CommandException;

    /**
     * downloadType区分：6の検索条件
     * 
     * @param syukkaCondition
     * @return
     * @throws CommandException
     */
    public List<SyukkaEntity> findSyukkaToppsTrasabiResult(
            SyukkaCondition syukkaCondition) throws CommandException;

    /**
     * downloadする前、SosinFlgを更新する
     * 
     * @param syukkaCondition
     * @throws CommandException
     */
    public void updateSosinFlg(SyukkaCondition syukkaCondition)
            throws CommandException;

    /**
     * Download情報を取得する
     * 
     * @param syukkaCondition
     * @return
     * @throws CommandException
     */
    public List<SyukkaCSVEntity> findCsvOutputResult(
            SyukkaCondition syukkaCondition) throws CommandException;

    /**
     * downloadした後、SosinFlgを更新する
     * 
     * @param syukkaCondition
     * @throws CommandException
     */
    public void setSabunKousinUpdate(SyukkaCondition syukkaCondition)
            throws CommandException;
}
