/*
 * クラス名: NonyuProgService
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/31
 *
 * Copyright:
 */
package ysbk_web.service;

import java.util.List;
import java.util.Map;

import ysbk_web.model.nonyuProg.NonyuProgDetailEntity;
import ysbk_web.model.nonyuProg.NonyuProgEntity;
import ysbk_web.utility.CommandException;
import ysbk_web.view.UserView;

public interface NonyuProgService {
    /**
     * 納入進捗一覧取得
     * 
     * @param userView ユーザ情報
     * @return List<NonyuProgEntity>
     * @throws CommandException
     */
    public List<NonyuProgEntity> findAllNonyuProg(UserView userView)
            throws CommandException;

    /**
     * 検索を行う。データが存在しないまたはパスワード不正の場合はnullを返す。 それ以外の場合はペイジのインスタンスを返す。
     * 
     * @param userView ユーザ情報
     * @param rg RG
     * @param sort_fg 並び順
     * @param seban 仕入先背番
     * @return List<NonyuProgEntity>
     * @throws CommandException
     */
    public List<NonyuProgEntity> findAllNonyuProg(UserView userView, String rg,
            String sort_fg) throws CommandException;

    /**
     * 納入進捗詳細取得
     * 
     * @param userView ユーザ情報
     * @param nou_ymd 納入日
     * @param rg RG
     * @param bin_no 便
     * @return List<NonyuProgDetailEntity>
     * @throws CommandException
     */
    public List<NonyuProgDetailEntity> findAllNonyuProgDetail(
            UserView userView, String nou_ymd, String rg, String bin_no,
            String noujou_fg) throws CommandException;

    /**
     * DBから取得したデータを納入進捗画面レイアウトに転換
     * 
     * @param nonyuProgs納入進捗情報List
     * @return
     */
    public List<NonyuProgEntity> formatNonyuProgData(
            List<NonyuProgEntity> nonyuProgs);

    /**
     * DBから取得したデータを納入進捗詳細画面レイアウトに転換
     * 
     * @param nonyuProgDetails List<NonyuProgDetailEntity>
     * @return List<NonyuProgDetailEntity>
     */
    public List<NonyuProgDetailEntity> formatNonyuProgDetail(
            List<NonyuProgDetailEntity> nonyuProgDetails);

    /**
     * 画面パラメータ设定
     * 
     * @return Map<String, String>
     */
    public Map<String, String> setRequest() throws Exception;
}
