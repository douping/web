/*
 * クラス名: NonyuProgDaoImpl
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/31
 *
 * Copyright:
 */

package ysbk_web.dao.impl;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import ysbk_web.condition.NonyuProgCondition;
import ysbk_web.condition.NonyuProgDetailCondition;
import ysbk_web.dao.NonyuProgDao;
import ysbk_web.model.nonyuProg.NonyuProgDetailEntity;
import ysbk_web.model.nonyuProg.NonyuProgEntity;
import ysbk_web.utility.CommandException;
import ysbk_web.utility.Constants;

public class NonyuProgDaoImpl implements NonyuProgDao {
    @Resource(name = "sqlMapClientTemplate")
    private SqlMapClientTemplate sqlMapClientTemplate;

    @Override
    public List<NonyuProgEntity> findNonyuProgByCondtion(
            NonyuProgCondition nonyuProgCondition) throws CommandException {
        List<NonyuProgEntity> nonyuProgEntities = Collections.EMPTY_LIST;
        try {
            nonyuProgEntities = sqlMapClientTemplate.queryForList(
                    "findNonyuProgByCondtion", nonyuProgCondition);
            
        } catch (Exception e) {
            throw new CommandException(e.getMessage(),
                    "error.NonyuProgDao.findNonyuProgByCondtion.SQLException",
                    Constants.SQL_EXCEPTION);
        }
        return nonyuProgEntities;

    }

    @Override
    public List<NonyuProgDetailEntity> findNonyuProgDetailByCondtion(
            NonyuProgDetailCondition nonyuProgDetailCondition)
            throws CommandException {
        List<NonyuProgDetailEntity> list = Collections.EMPTY_LIST;
        try {
            list = sqlMapClientTemplate.queryForList(
                    "findNonyuProgDetailByCondtion", nonyuProgDetailCondition);
        } catch (Exception e) {
            throw new CommandException(e.getMessage(),
                    "error.NonyuProgDao.findNonyuProgDetail.SQLException",
                    Constants.SQL_EXCEPTION);
        }
        return list;
    }

}
