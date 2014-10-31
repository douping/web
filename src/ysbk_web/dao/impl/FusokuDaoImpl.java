/*
 * クラス名: FusokuDaoImpl
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/30
 *
 * Copyright:
 */

package ysbk_web.dao.impl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.ibatis.sqlmap.client.SqlMapClient;

import ysbk_web.dao.FusokuDao;
import ysbk_web.model.fusoku.FusokuEntity;
import ysbk_web.utility.CommandException;
import ysbk_web.utility.Constants;
import ysbk_web.utility.Utility;

public class FusokuDaoImpl implements FusokuDao {

    @Resource(name = "sqlMapClientTemplate")
    private SqlMapClientTemplate sqlMapClientTemplate;

    private static Logger logger = Logger.getLogger(FusokuDaoImpl.class);

    /**
     * 不足数一覧検索ビーン。
     * 
     * @param map
     * @return boolean
     * @throws CommandException
     */
    @Override
    public List<FusokuEntity> findFusoku(HashMap<String, String> map)
            throws CommandException {
        List<FusokuEntity> fusokuEntities = Collections.EMPTY_LIST;
        try {
            fusokuEntities = sqlMapClientTemplate.queryForList("findFusoku",
                    map);
        } catch (Exception e) {
            throw new CommandException(e.getMessage(),
                    "error.FusokuDao.findFusoku.SQLException",
                    Constants.SQL_EXCEPTION);
        }
        return fusokuEntities;
    }
}
