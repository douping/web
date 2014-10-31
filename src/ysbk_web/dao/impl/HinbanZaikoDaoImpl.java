/*
 * クラス名: HinbanZaikoDaoImpl
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/24
 *
 * Copyright:
 */

package ysbk_web.dao.impl;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ysbk_web.condition.HinbanZaikoCondition;
import ysbk_web.dao.HinbanZaikoDao;
import ysbk_web.model.hinbanZaiko.HinbanZaikoDetailEntity;
import ysbk_web.model.hinbanZaiko.HinbanZaikoEntity;
import ysbk_web.utility.CommandException;
import ysbk_web.utility.Constants;

public class HinbanZaikoDaoImpl implements HinbanZaikoDao {

    @Resource(name = "sqlMapClientTemplate")
    private SqlMapClientTemplate sqlMapClientTemplate;

    /**
     * 品番別在庫情報初期化表示用データ取得
     */
    @Override
    public List<HinbanZaikoEntity> findAllHinbanZaiko() throws CommandException {
        List<HinbanZaikoEntity> hinbanZaikoEntities = null;
        // SqlMapClient sqlMap = Utility.getSqlMap();
        try {
            hinbanZaikoEntities = sqlMapClientTemplate.queryForList(
                    "findHinbanZaiko", null);
        } catch (Exception ex) {
            throw new CommandException(ex.getMessage(),
                    "error.HinbanZaikoDao.findAllHinbanZaiko.SQLException",
                    Constants.SQL_EXCEPTION);
        }

        return hinbanZaikoEntities;
    }

    /**
     * 品番別在庫情報照会結果表示用データ取得
     */
    @Override
    public List<HinbanZaikoEntity> searchHinbanZaikoByCondtion(
            HinbanZaikoCondition hinbanZaikoCondition) throws Exception {
        List<HinbanZaikoEntity> hinbanZaikoEntities = Collections.EMPTY_LIST;
        // SqlMapClient sqlMap = Utility.getSqlMap();
        try {
        	hinbanZaikoEntities = sqlMapClientTemplate.queryForList(
                    "findHinbanZaikoByCondtion", hinbanZaikoCondition);
        } catch (Exception ex) {
        	throw new CommandException(ex.getMessage(),
                    "error.HinbanZaikoDao.searchHinbanZaikoByCondtion.SQLException",
                    Constants.SQL_EXCEPTION);
        }
        return hinbanZaikoEntities;

    }

    /**
     * 品番別在庫管理詳細画面表示用データ取得
     */
    @Override
    public List<HinbanZaikoDetailEntity> findHinbanZaikoDetail(
            HinbanZaikoCondition hinbanZaikoCondition) throws CommandException {
        List<HinbanZaikoDetailEntity> list = Collections.EMPTY_LIST;
        // SqlMapClient sqlMap = Utility.getSqlMap();
        try {
            list = sqlMapClientTemplate.queryForList("findHinbanZaikoDetail",
                    hinbanZaikoCondition);
        } catch (Exception e) {
            throw new CommandException(e.getMessage(),
                    "error.HinbanZaikoDao.findHinbanZaikoDetail.SQLException",
                    Constants.SQL_EXCEPTION);
        }
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public void updateNumRet(HinbanZaikoCondition hinbanZaikoCondition)
            throws CommandException {
        // SqlMapClient sqlMap = Utility.getSqlMap();
        try {
            sqlMapClientTemplate.update("updateNumRet", hinbanZaikoCondition);
        } catch (Exception e) {
            throw new CommandException(e.getMessage(),
                    "error.HinbanZaikoDao.updateNumRet.SQLException",
                    Constants.SQL_EXCEPTION);
        }

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public void deleteItemBywkiban(String wkiban) throws CommandException {
        try {
            sqlMapClientTemplate.delete("deleteItemBywkiban", wkiban);
        } catch (Exception e) {
            throw new CommandException(e.getMessage(),
                    "error.HinbanZaikoDao.deleteItemBywkiban.SQLException",
                    Constants.SQL_EXCEPTION);
        }

    }

    @Override
    public String getNaiyo() throws CommandException {
    	String naiyo = "";
    	try{
    		naiyo = (String) sqlMapClientTemplate.queryForObject(
                    "getNaiyoBykomokuNo", "01");
    	} catch (Exception e) {
            throw new CommandException(e.getMessage(),
                    "error.HinbanZaikoDao.getNaiyo.SQLException",
                    Constants.SQL_EXCEPTION);
        }
        
        return naiyo;
    }

    public void setSqlMapClientTemplate(
            SqlMapClientTemplate sqlMapClientTemplate) {
        this.sqlMapClientTemplate = sqlMapClientTemplate;
    }

}
