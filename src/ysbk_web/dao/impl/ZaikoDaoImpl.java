/*
 * クラス名: ZaikoDaoImpl
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/24
 *
 * Copyright:
 */

package ysbk_web.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import ysbk_web.condition.ZaikoCondition;
import ysbk_web.dao.ZaikoDao;
import ysbk_web.model.zaiko.ZaikoEntity;
import ysbk_web.utility.CommandException;
import ysbk_web.utility.Constants;

public class ZaikoDaoImpl implements ZaikoDao {

    @Resource(name = "sqlMapClientTemplate")
    private SqlMapClientTemplate sqlMapClientTemplate;

    /**
     * 在庫管理CSV結果を取得します。
     * 
     * @param zaikoCondition ユーザーフォーム。
     * @return List ユーザーCSV結果
     */
    @Override
    public List csvOutput(ZaikoCondition zaikoCondition)
            throws CommandException {
        List<ZaikoEntity> zaikos = new ArrayList<ZaikoEntity>();
        try {
            zaikos = sqlMapClientTemplate.queryForList("findZaikodata",
                    zaikoCondition);
        } catch (Exception e) {
            throw new CommandException(e.getMessage(),
                    "error.ZaikoDaoImpl.csvOutput.Exception",
                    Constants.SQL_EXCEPTION);
        }
        return zaikos;
    }

    /**
     * 在庫管理履歴データCSV結果を取得します。
     * 
     * @param zaikoCondition ユーザーフォーム。
     * @return List ユーザーCSV結果
     */
    @Override
    public List csvRirekiOutput(ZaikoCondition zaikoCondition)
            throws CommandException {
        List<ZaikoEntity> zaikos = new ArrayList<ZaikoEntity>();
        try {
            zaikos = sqlMapClientTemplate.queryForList("findZaikoHistoryData",
                    zaikoCondition);
        } catch (Exception e) {
            throw new CommandException(e.getMessage(),
                    "error.ZaikoDaoImpl.csvRirekiOutput.Exception",
                    Constants.SQL_EXCEPTION);
        }
        return zaikos;
    }

}