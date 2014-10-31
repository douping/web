/*
 * クラス名: HannyuProgService
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/31
 *
 * Copyright:
 */
package ysbk_web.service;

import java.util.List;

import ysbk_web.utility.CommandException;
import ysbk_web.view.UserView;
import ysbk_web.model.hannyuProg.HannyuProgDetailEntity;
import ysbk_web.model.hannyuProg.HannyuProgEntity;

public interface HannyuProgService {
    /**
     * 搬入進捗管理検索。
     * 
     * @param userView ユーザ情報
     * @return List<HannyuProgEntity>
     * @throws CommandException
     */
    public List<HannyuProgEntity> findHannyuProg(UserView userView)
            throws CommandException;

    /**
     * 搬入進捗管理 詳細取得
     * 
     * @param hanjou_fg 状況
     * @param bin_id 便ID
     * @param han_ymd 搬入日
     * @param tokusya_kb 特車区分
     * @param tokusya_kai 回数
     * @return List<HannyuProgDetailEntity>
     * @throws CommandException
     */
    public List<HannyuProgDetailEntity> findHannyuProgDetail(String hanjou_fg,
            String bin_id, String han_ymd, String tokusya_kb, String tokusya_kai)
            throws CommandException;

    /**
     * (DBから取得したデータを搬入進捗管理画面レイアウトに転換
     * 
     * @param hannyuProgs List<HannyuProgEntity>
     * @return List<HannyuProgEntity>
     */
    public List<HannyuProgEntity> formatHannyuProgData(
            List<HannyuProgEntity> hannyuProgs);

    /**
     * DBから取得したデータを搬入進捗管理詳細画面レイアウトに転換
     * 
     * @param hannyuProgDetails List<HannyuProgDetailEntity>
     * @return List<HannyuProgDetailEntity>
     */
    public List<HannyuProgDetailEntity> formatHannyuProgDetail(
            List<HannyuProgDetailEntity> hannyuProgDetails);

}
