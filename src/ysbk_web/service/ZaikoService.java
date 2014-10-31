/*
 * クラス名: ZaikoService
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/29
 *
 * Copyright:
 */

package ysbk_web.service;

import javax.servlet.http.HttpServletResponse;

import ysbk_web.utility.CommandException;
import ysbk_web.view.UserView;

public interface ZaikoService {
    /**
     * 在庫データを取得する
     * 
     * @param userView ユーザ情報
     * @param syori_ymd 処理日
     * @param downloadType
     * @throws CommandException
     */
    public void getCsvDownload(UserView userView, String syori_ymd,
            String downloadType, HttpServletResponse response)
            throws CommandException;
}
