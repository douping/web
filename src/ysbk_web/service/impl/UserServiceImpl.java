/*
 * クラス名: UserServiceImpl
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/24
 *
 * Copyright:
 */
package ysbk_web.service.impl;

import java.text.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

//import com.opensymphony.xwork2.ActionContext;

import ysbk_web.model.UserEntity;
import ysbk_web.view.UserView;
import ysbk_web.service.UserService;
import ysbk_web.utility.CommonTool;
import ysbk_web.utility.Constants;
import ysbk_web.utility.Keys;
import ysbk_web.dao.UserDao;
import ysbk_web.utility.CommandException;

public class UserServiceImpl implements UserService {

    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    private static UserDao userDao;

    /**
     * UserEntityを取得する
     * 
     * @param opcode
     * @return UserEntity
     */
    @Override
    public UserEntity findUserByCd(String opcode, HttpServletRequest request)
            throws CommandException {

        logger.info("fh check1 ");
        // ログイン情報取得
        UserView userView = null;
        UserEntity user;
        try {
            user = userDao.findUserByCd(opcode);
            // ログイン情報取得
            logger.info("fh check2 ");
            userView = this.certifyUser(user, request);
            logger.info("fh check7 ");
            // エンティティが存在する場合は、セッションに保存します。
            if (userView != null) {
                // W08Web入出庫ワークを綺麗にしておく
                if (!this.deleteW08(userView, -2)) {
                    logger.info("fh check9 ");
                    return user = null;
                }
                logger.info("fh check10 ");
                logger.info("fh check11 userView=" + userView);
                HttpSession session = request.getSession();
                session.setAttribute(Keys.USER_ENTITY, userView);
            } else {
                return user = null;
            }
        } catch (CommandException ex) {
            throw ex;
        } catch (Exception e) {
            throw new CommandException(e.getMessage(),
                    "error.UserServiceImpl.findUserByCd.Exception",
                    Constants.EXCEPTION);
        }
        return user;
    }

    /**
     * ユーザ認証を行う。ユーザIDが存在しないまたはパスワード不正の場合は nullを返す。 それ以外の場合はUserEntityのインスタンスを返す。
     * 
     * @param user DBユーザエンティティ
     * @return model.UserEntity　ユーザエンティティ コマンド例外
     */
    public UserView certifyUser(UserEntity user, HttpServletRequest request)
            throws CommandException {

        UserView userView = null;
        logger.info("fh check4 ");
        if (user != null) {
            // IPが'ALL'で設定されていれば,IPチェックは行わない
            // KAIJI_KBが'1'の時、矢崎IPならＯＫ
            if ("ALL".equals(CommonTool.checkEmpty(user.getIp()).trim())
                    || CommonTool.checkEmpty(user.getIp()).trim()
                            .equals(request.getRemoteAddr())
                    || ("1".equals(CommonTool.checkEmpty(user.getKaiji_kb())
                            .trim()) && Keys.YAZAKI_IP.equals(request
                            .getRemoteAddr().substring(0, 8)))) {
                logger.info("fh check5 ");
                userView = new UserView();
                // ユーザID
                userView.setOpcode(user.getOpcode());
                // パスワード
                userView.setOppswd(user.getOppswd());
                // IP
                userView.setIp(request.getRemoteAddr());
                // 仕入先
                userView.setSiire(user.getSiire());
                // RG
                userView.setRg(this.getTB_WEB_RG_MA(user));
                logger.info("fhfh 1111 ==" + userView);
                // Web機番(yyyyMMddHHmmss)
                userView.setWkiban(CommonTool.getDateTime());
                // セッションID
                userView.setSessionId(request.getRequestedSessionId());
            }
        }
        return userView;
    }

    /**
     * W08Web入出庫ワークを削除する
     * 
     * @param UserView
     * @return boolean
     * @throws CommandException
     */
    public boolean deleteW08(UserView userView) throws CommandException {

        // ***** 機番でWKを削除する *****
        if (!"".equals(userView.getWkiban().trim())) {
            String wkiban = userView.getWkiban();
            if (!userDao.deleteNsyuko01(wkiban)) {
                return false;
            }
        }
        return true;
    }

    /**
     * W08Web入出庫ワークを削除する
     * 
     * @param UserView ,int
     * @return boolean
     * @throws CommandException
     */
    public boolean deleteW08(UserView userView, int iDay)
            throws CommandException {

        // ***** 機番でWKを削除する *****
        if (!userView.getWkiban().trim().equals("")) {

            // 機番から2日引いた日以前が削除対象とする
            Calendar calendar = Calendar.getInstance(TimeZone
                    .getTimeZone("JST"));
            String sWk = userView.getWkiban();
            calendar.set(Integer.parseInt(sWk.substring(0, 4)),
                    Integer.parseInt(sWk.substring(4, 6)) - 1,
                    Integer.parseInt(sWk.substring(6, 8)));
            calendar.add(Calendar.DAY_OF_MONTH, iDay);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            String time = formatter.format(calendar.getTime());
            if (!userDao.deleteNsyuko02(time)) {
                return false;
            }
        }
        logger.info("fh check8 ");
        return true;
    }

    /**
     * WEBログインRGマスタを取得する
     * 
     * @param UserEntity
     * @return String
     */
    private String[] getTB_WEB_RG_MA(UserEntity user) throws CommandException {
        String[] strOutDate = null;
        if ("0".equals(user.getRg_kb())) {
            // RG区分=0:RGを使用しない場合
            return null;
        }
        List<String> rgL;
        try {
            rgL = userDao.findRg(user.getOpcode());
            if (!rgL.isEmpty()) {
                strOutDate = rgL.toArray(new String[rgL.size()]);
            }
            logger.info("fh check6 ");
        } catch (CommandException e) {
            throw new CommandException(e.getMessage(),
                    "error.UserServiceImpl.getTB_WEB_RG_MA.Exception",
                    Constants.EXCEPTION);
        }

        return strOutDate;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

}