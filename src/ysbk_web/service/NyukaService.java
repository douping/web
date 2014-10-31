/*
 * クラス名: NyukaService
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/08/04
 *
 * Copyright:
 */

package ysbk_web.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import ysbk_web.utility.CommandException;
import ysbk_web.view.NyukaView;
import ysbk_web.view.UserView;

public interface NyukaService {

    /**
     * 入荷情報結果表示用データ取得
     * 
     * @param userView ユーザ情報
     * @param han_ymd 搬入日
     * @return
     * @throws CommandException
     */
    public List<NyukaView> getNyukaResult(UserView userView, String han_ymd)
            throws CommandException;

    /**
     * 送信フラグ更新。
     * 
     * @param userView ユーザ情報
     * @param han_ymd 搬入日
     * @param bin_no 便No
     * @return boolean
     * @throws CommandException
     */
    public Boolean setKousinUpdate(UserView userView, String han_ymd,
            List<String> checkFlg) throws CommandException;

    /**
     * 入荷管理CSV結果を取得します。
     * 
     * @param userView ユーザ情報
     * @param han_ymd 搬入日
     * @param bin_no 便No
     * @return Boolean
     * @throws CommandException
     */
    public Boolean getCSVOutputResult(UserView userView, String han_ymd,
            List<String> checkFlg, HttpServletResponse response)
            throws Exception;
}
