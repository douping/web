/*
 * クラス名: HinbanZaikoDao
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/25
 *
 * Copyright:
 */

package ysbk_web.dao;

import java.util.List;

import ysbk_web.condition.HinbanZaikoCondition;
import ysbk_web.model.hinbanZaiko.HinbanZaikoDetailEntity;
import ysbk_web.model.hinbanZaiko.HinbanZaikoEntity;
import ysbk_web.utility.CommandException;

public interface HinbanZaikoDao {

    /**
     * 品番別在庫情報初期化表示用データ取得
     * 
     * @return List<HinbanZaikoEntity>
     */
    public List<HinbanZaikoEntity> findAllHinbanZaiko() throws CommandException;

    /**
     * 品番別在庫情報照会結果表示用データ取得
     * 
     * @param hinbanZaikoCondition 検索条件
     * @return List<HinbanZaikoEntity>
     */
    public List<HinbanZaikoEntity> searchHinbanZaikoByCondtion(
            HinbanZaikoCondition hinbanZaikoCondition) throws Exception;

    /**
     * 品番別在庫管理詳細画面表示用データ取得
     * 
     * @param hinbanZaikoCondition 検索条件
     * @return List<HinbanZaikoDetailEntity>
     */
    public List<HinbanZaikoDetailEntity> findHinbanZaikoDetail(
            HinbanZaikoCondition hinbanZaikoCondition) throws CommandException;

    public void updateNumRet(HinbanZaikoCondition hinbanZaikoCondition)
            throws CommandException;

    public void deleteItemBywkiban(String wkiban) throws CommandException;

    /**
     * システム管理情報 NAIYO内容取得
     * 
     * @return
     * @throws CommandException
     */
    public String getNaiyo() throws CommandException;
}
