/*
 * クラス名: HinbanZaikoService
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/24
 *
 * Copyright:
 */

package ysbk_web.service;

import java.util.List;

import ysbk_web.model.hinbanZaiko.HinbanZaikoDetailEntity;
import ysbk_web.model.hinbanZaiko.HinbanZaikoEntity;
import ysbk_web.utility.CommandException;
import ysbk_web.view.UserView;

public interface HinbanZaikoService {
    /**
     * 品番別在庫情報初期化表示用データ取得
     * 
     * @param userView ユーザ情報
     * @return List<HinbanZaikoEntity>
     * @throws CommandException
     */
    public List<HinbanZaikoEntity> getAllHinbanZaiko(UserView userView)
            throws CommandException;

    /**
     * 品番別在庫情報照会結果表示用データ取得
     * 
     * @param userView ユーザ情報
     * @param tk_hin メーカー品番
     * @param tk_uke 受入
     * @param seban 仕入先背番
     * @return List<HinbanZaikoEntity>
     * @throws CommandException
     */
    public List<HinbanZaikoEntity> getAllHinbanZaiko(UserView userView,
            String tk_hin, String tk_uke, String seban) throws CommandException;

    /**
     * 品番別在庫管理詳細画面表示用データ取得
     * 
     * @param userView ユーザ情報
     * @param tk_hin メーカー品番
     * @param syuyo_su 収容数
     * @return List<HinbanZaikoDetailEntity>
     * @throws CommandException
     */
    public List<HinbanZaikoDetailEntity> getAllHinbanZaikoDetail(
            UserView userView, String tk_hin, String syuyo_su)
            throws CommandException;

    /**
     * DBから取得したデータを品番別在庫管理画面レイアウトに転換
     * 
     * @param hinbanZaikos 品番別在庫情報List
     * @return
     */
    public List<HinbanZaikoEntity> formatHinbanData(
            List<HinbanZaikoEntity> hinbanZaikos);

    /**
     * DBから取得したデータを品番別在庫管理詳細画面レイアウトに転換
     * 
     * @param hinbanZaikoDetails List<HinbanZaikoDetailEntity>
     * @return List<HinbanZaikoDetailEntity>
     */
    public List<HinbanZaikoDetailEntity> formatHinbanDetail(
            List<HinbanZaikoDetailEntity> hinbanZaikoDetails);
}
