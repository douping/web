/*
 * クラス名: SyukkaDaoImpl
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/30
 *
 * Copyright:
 */

package ysbk_web.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ysbk_web.condition.SyukkaCondition;
import ysbk_web.dao.SyukkaDao;
import ysbk_web.model.syukka.SyukkaCSVEntity;
import ysbk_web.model.syukka.SyukkaEntity;
import ysbk_web.utility.CommandException;
import ysbk_web.utility.Constants;

public class SyukkaDaoImpl implements SyukkaDao {

    @Resource(name = "sqlMapClientTemplate")
    private SqlMapClientTemplate sqlMapClientTemplate;

    /**
     * downloadType区分：0~5の検索条件
     */
    @Override
    public List<SyukkaEntity> findSyukkaResult(SyukkaCondition syukkaCondition)
            throws CommandException {
        List<SyukkaEntity> list = new ArrayList<SyukkaEntity>();
        try {
        	list = sqlMapClientTemplate.queryForList("findSyukkaResult",
                    syukkaCondition);
        } catch (Exception e) {
            throw new CommandException(e.getMessage(),
                    "error.SyukkaDao.findSyukkaResult.Exception",
                    Constants.SQL_EXCEPTION);
        }
        return list;
    }

    /**
     * downloadType区分：6の検索条件
     */
    @Override
    public List<SyukkaEntity> findSyukkaToppsTrasabiResult(
            SyukkaCondition syukkaCondition) throws CommandException {
        List<SyukkaEntity> list = new ArrayList<SyukkaEntity>();
        try {
            list = sqlMapClientTemplate.queryForList("findSyukkaToppsTrasabiResult",
                    syukkaCondition);
        } catch (Exception e) {
            throw new CommandException(e.getMessage(),
                    "error.SyukkaDao.findSyukkaResult.Exception",
                    Constants.SQL_EXCEPTION);
        }
        return list;
    }

    /**
     * downloadする前、SosinFlgを更新する
     */

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public void updateSosinFlg(SyukkaCondition syukkaCondition)
            throws CommandException {
        try {
            sqlMapClientTemplate.update("updateSosinFlgBfDownload",
                    syukkaCondition);
        } catch (Exception e) {
            throw new CommandException(e.getMessage(),
                    "error.SyukkaDao.updateSosinFlg.Exception",
                    Constants.SQL_EXCEPTION);
        }

    }

    /**
     * Download情報を取得する
     */
    @Override
    public List<SyukkaCSVEntity> findCsvOutputResult(
            SyukkaCondition syukkaCondition) throws CommandException {
        String downloadType = syukkaCondition.getDownloadType();
        List<SyukkaCSVEntity> list = new ArrayList<SyukkaCSVEntity>();
        try {
            if ("0".equals(downloadType) || "1".equals(downloadType)) {
                list = sqlMapClientTemplate.queryForList("findSyukkaCSVResult",
                        syukkaCondition);
            } else if ("6".equals(downloadType)) {
                list = sqlMapClientTemplate.queryForList(
                        "findSyukkaCSVToppsTrasabiResult", syukkaCondition);
            } else if ("4".equals(downloadType)) {
                list = sqlMapClientTemplate.queryForList(
                        "findSyukkaCSVAllResult", syukkaCondition);
            } else {
                list = sqlMapClientTemplate.queryForList(
                        "findSyukkaCSVMoreResult", syukkaCondition);
            }
        } catch (Exception e) {
            throw new CommandException(e.getMessage(),
                    "error.SyukkaDao.findCsvOutputResult.Exception",
                    Constants.SQL_EXCEPTION);
        }
        return list;
    }

    /**
     * downloadした後、SosinFlgを更新する
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public void setSabunKousinUpdate(SyukkaCondition syukkaCondition)
            throws CommandException {
        try {
            sqlMapClientTemplate
                    .update("setSabunKousinUpdate", syukkaCondition);
        } catch (Exception e) {
            throw new CommandException(e.getMessage(),
                    "error.SyukkaDao.updateSosinFlg.Exception",
                    Constants.SQL_EXCEPTION);
        }

    }

}