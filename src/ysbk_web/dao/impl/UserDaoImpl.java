/*
 * クラス名: UserDaoImpl
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/24
 *
 * Copyright:
 */
package ysbk_web.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ysbk_web.dao.UserDao;
import ysbk_web.model.UserEntity;
import ysbk_web.utility.CommandException;
import ysbk_web.utility.Constants;

public class UserDaoImpl implements UserDao {
    private static Logger logger = Logger.getLogger(UserDaoImpl.class);

    // private static SqlMapClient sqlMapClient = Utility.getSqlMap();
    @Resource(name = "sqlMapClientTemplate")
    private SqlMapClientTemplate sqlMapClientTemplate;

    /*
     * // DB connection static { try { Reader reader =
     * Resources.getResourceAsReader("SqlMapConfig.xml"); sqlMapClient =
     * SqlMapClientBuilder.buildSqlMapClient(reader); reader.close(); } catch
     * (IOException e) { e.printStackTrace(); }
     * 
     * }
     */

    /**
     * ユーザエンティティ取得
     * 
     * @param opcode
     * @return UserEntity
     */
    @Override
    public UserEntity findUserByCd(String opcode) throws CommandException {
        UserEntity user = null;
        try{
        	user = (UserEntity) sqlMapClientTemplate.queryForObject("findUserByCd",
                    opcode);
        } catch (Exception e) {
            throw new CommandException(e.getMessage(),
                    "error.UserDaoImpl.findUserByCd.Exception",
                    Constants.SQL_EXCEPTION);
        }
        
        // logger.info("fhfh+class=" + user.getClass() + "fhfh  ip" +
        // user.getIp() + "code=" + user.getOpcode() + "Rg_kb=" +
        // user.getRg_kb() + "Sire="
        // + user.getSiire() + "kaiji_kb=" + user.getKaiji_kb());

        return user;
    }

    /**
     * W08Web入出庫ワークを削除
     * 
     * @param time
     * @return Boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public Boolean deleteNsyuko01(String wkiban) throws CommandException {
    	try{
    		sqlMapClientTemplate.delete("deleteNsyuko01", wkiban);
    	} catch (Exception e) {
            throw new CommandException(e.getMessage(),
                    "error.UserDaoImpl.deleteNsyuko01.Exception",
                    Constants.SQL_EXCEPTION);
        }
        return true;

    }

    /**
     * W08Web入出庫ワークを削除
     * 
     * @param time
     * @return Boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public Boolean deleteNsyuko02(String time) throws CommandException {
        try {
            sqlMapClientTemplate.delete("deleteNsyuko02", time);
        } catch (Exception e) {
            throw new CommandException(e.getMessage(),
                    "error.SyukkaDao.updateSosinFlg.Exception",
                    Constants.SQL_EXCEPTION);
        }

        return true;

    }

    /**
     * WEBログインRGマスタより取得
     * 
     * @param opcode
     * @return List<String>
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<String> findRg(String opcode) throws CommandException {
        List<String> rgL = null;
        try{
        	rgL = sqlMapClientTemplate.queryForList("findRg", opcode);
        } catch (Exception e) {
            throw new CommandException(e.getMessage(),
                    "error.UserDaoImpl.findRg.Exception",
                    Constants.SQL_EXCEPTION);
        }
        
        logger.info("fhfh  rgL=" + rgL);

        return rgL;
    }

}