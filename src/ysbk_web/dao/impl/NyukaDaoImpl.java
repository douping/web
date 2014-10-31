/*
 * クラス名: NyukaDaoImpl
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/08/01
 *
 * Copyright:
 */

package ysbk_web.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.ibatis.sqlmap.client.SqlMapClient;

import ysbk_web.condition.NyukaCondition;
import ysbk_web.dao.NyukaDao;
import ysbk_web.model.nyuka.NyukaCSVEntity;
import ysbk_web.model.nyuka.NyukaEntity;
import ysbk_web.utility.CommandException;
import ysbk_web.utility.Constants;
import ysbk_web.utility.Utility;

public class NyukaDaoImpl implements NyukaDao {

    @Resource(name = "sqlMapClientTemplate")
    private SqlMapClientTemplate sqlMapClientTemplate;

    /**
     * 入荷情報結果表示用データ取得
     */
    @Override
    public List<NyukaEntity> findNyukaResult(NyukaCondition nyukaCondition)
            throws CommandException {

        List<NyukaEntity> list = new ArrayList<NyukaEntity>();
        try {
            list = sqlMapClientTemplate.queryForList("findNyukaResult",
                    nyukaCondition);
        } catch (Exception e) {
            throw new CommandException(e.getMessage(),
                    "error.NyukaDaoImpl.findNyukaResult.SQLException",
                    Constants.SQL_EXCEPTION);
        }
        return list;
    }

    /**
     * 送信フラグ更新。
     */
    @Override
    public Boolean setKousinUpdate(NyukaCondition nyukaCondition)
            throws CommandException {
        try {
            sqlMapClientTemplate.update("setKousinUpdate", nyukaCondition);
            return true;
        } catch (Exception e) {
            throw new CommandException(e.getMessage(),
                    "error.NyukaDaoImpl.setKousinUpdate.Exception",
                    Constants.SQL_EXCEPTION);
        }
    }

    /**
     * 入荷管理CSV結果を取得します。
     */
    @Override
    public List<NyukaCSVEntity> findCSVOutputResult(
            NyukaCondition nyukaCondition) throws CommandException {
        List<NyukaCSVEntity> list = new ArrayList<NyukaCSVEntity>();
        try {
            list = sqlMapClientTemplate.queryForList("findNyukaCSVResult",
                    nyukaCondition);
        } catch (Exception sqle) {
            throw new CommandException(sqle.getMessage(),
                    "error.NyukaDaoImpl.findCSVOutputResult.SQLException",
                    Constants.SQL_EXCEPTION);

        }
        return list;
    }

}
