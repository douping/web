/*
 * クラス名: HannyuProgDaoImpl
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/31
 *
 * Copyright:
 */

package ysbk_web.dao.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import ysbk_web.condition.HannyuProgDetailCondition;
import ysbk_web.dao.HannyuProgDao;
import ysbk_web.model.hannyuProg.HannyuProgDetailEntity;
import ysbk_web.model.hannyuProg.HannyuProgEntity;
import ysbk_web.utility.CommandException;
import ysbk_web.utility.Constants;

public class HannyuProgDaoImpl implements HannyuProgDao {
    @Resource(name = "sqlMapClientTemplate")
    private SqlMapClientTemplate sqlMapClientTemplate;

    @Override
    public List<HannyuProgEntity> findHannyuProg(HashMap<String, String> map)
            throws CommandException {
        List<HannyuProgEntity> hannyuProgEntities = Collections.EMPTY_LIST;
        try {
            hannyuProgEntities = sqlMapClientTemplate.queryForList(
                    "findHannyuProg", map);
        } catch (Exception e) {
            throw new CommandException(e.getMessage(),
                    "error.HannyuProgDao.findHannyuProg.SQLException",
                    Constants.SQL_EXCEPTION);
        }
        return hannyuProgEntities;

    }

    @Override
    public List<HannyuProgDetailEntity> findHannyuProgDetail(
            HannyuProgDetailCondition hannyuProgDetailCondition)
            throws CommandException {
        List<HannyuProgDetailEntity> list = Collections.EMPTY_LIST;
        try {
            list = sqlMapClientTemplate.queryForList("findHannyuProgDetail",
                    hannyuProgDetailCondition);
        } catch (Exception e) {
            throw new CommandException(e.getMessage(),
                    "error.HannyuProgDao.findHannyuProgDetail.SQLException",
                    Constants.SQL_EXCEPTION);
        }
        return list;
    }

}
