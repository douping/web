/*
 * クラス名: SyukkaService
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/08/03
 *
 * Copyright:
 */

package ysbk_web.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import ysbk_web.utility.CommandException;
import ysbk_web.view.SyukkaView;
import ysbk_web.view.UserView;

public interface SyukkaService {

    /**
     * 出荷情報明細取得
     * 
     * @param userView ユーザ情報
     * @param downloadType download情報区分
     * @param nou_ymd 納入日
     * @return List<SyukkaEntity>
     * @throws CommandException
     */
    public List<SyukkaView> getSyukkaResult(UserView userView,
            String downloadType, String nou_ymd) throws CommandException;

    /**
     * download前SosinFlgの更新;
     * Download => SosinFlg '1',差分Download => SosinFlg '2'
     * 
     * @param userView ユーザ情報
     * @param downloadType download情報区分
     * @param downFlg Download或いは差分Download区分
     * @param checkFlg チェックフラグ
     * @throws CommandException
     */
    public void updateSosinFlg(UserView userView, String downloadType,
            String downFlg, List<String> checkFlg) throws CommandException;

    /**
     * CSV取得
     * 
     * @param userView ユーザ情報
     * @param downloadType download情報区分
     * @param downFlg Download或いは差分Download区分
     * @param checkFlg Download或いは差分Download区分
     * @param nou_ymd 納入日
     * @param response HttpServletResponseはoutputstreamを取得するため
     * @throws Exception
     */
    public void getCsvOutputResult(UserView userView, String downloadType,
            String downFlg, List<String> checkFlg, String nou_ymd,
            HttpServletResponse response) throws CommandException;
}
