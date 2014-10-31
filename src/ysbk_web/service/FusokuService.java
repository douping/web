/*
 * クラス名: FusokuService
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/29
 *
 * Copyright:
 */

package ysbk_web.service;

import java.util.List;

import ysbk_web.model.fusoku.FusokuEntity;
import ysbk_web.utility.CommandException;
import ysbk_web.view.UserView;

/**
 * 不足数一覧検索ビーン。
 */
public interface FusokuService {

    /**
     * 不足数一覧検索ビーン。
     * 
     * @param userview
     * @return List<HinbanZaikoEntity> List<HinbanZaikoEntity>
     */
    public List<FusokuEntity> findFusoku(UserView userview)
            throws CommandException;

    /**
     * DBから取得したデータを画面レイアウトに転換
     * 
     * @param fusokus List<FusokuEntity>
     * @return List<FusokuEntity> List<FusokuEntity>
     */
    public List<FusokuEntity> formatFusokuData(List<FusokuEntity> fusokus);
}
