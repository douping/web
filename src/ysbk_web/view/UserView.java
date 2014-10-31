/*
 * クラス名: UserView
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/28
 *
 * Copyright:
 */

package ysbk_web.view;

import java.io.Serializable;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * @author ユーザエンティティ。
 */
public class UserView implements Serializable, HttpSessionBindingListener {

    // ユーザID
    private String opcode;

    // パスワード
    private String oppswd;

    // IP
    private String ip;

    // 仕入先
    private String siire;

    // RG
    private String rg[];

    // セッションID
    private String sessionId;

    // Web機番
    private String wkiban;

    /**
     * ユーザIDを取得します。
     * 
     * @return java.lang.String
     */
    public String getOpcode() {
        return opcode;
    }

    /**
     * ユーザIDを設定します。
     * 
     * @param opcode
     */
    public void setOpcode(String opcode) {
        this.opcode = opcode;
    }

    /**
     * パスワードを取得します。
     * 
     * @return java.lang.String
     */
    public String getOppswd() {
        return oppswd;
    }

    /**
     * パスワードを設定します。
     * 
     * @param oppswd
     */
    public void setOppswd(String oppswd) {
        this.oppswd = oppswd;
    }

    /**
     * IPを取得します。
     * 
     * @return java.lang.String
     */
    public String getIp() {
        return ip;
    }

    /**
     * IPを設定します。
     * 
     * @param ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 仕入先を取得します。
     * 
     * @return java.lang.String
     */
    public String getSiire() {
        return siire;
    }

    /**
     * 仕入先を設定します。
     * 
     * @param Siire
     */
    public void setSiire(String siire) {
        this.siire = siire;
    }

    /**
     * RGを取得します。
     * 
     * @return java.lang.String
     */
    public String[] getRg() {
        return rg;
    }

    /**
     * RGを設定します。
     * 
     * @param Rg
     */
    public void setRg(String[] rg) {
        this.rg = rg;
    }

    /**
     * Web機番を取得します。
     * 
     * @return java.lang.String
     */
    public String getWkiban() {
        return wkiban;
    }

    /**
     * Web機番を設定します。
     * 
     * @param wkiban
     */
    public void setWkiban(String wkiban) {
        this.wkiban = wkiban;
    }

    /**
     * セッションIDを取得します。
     * 
     * @return java.lang.String
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * セッションIDを設定します。
     * 
     * @param sessionId
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    // セッション開始時の処理
    public void valueBound(HttpSessionBindingEvent event) {
    }

    // セッション時の処理
    public void valueUnbound(HttpSessionBindingEvent event) {
    }

    // セッション開始時の処理
    public void sessionDidActivate(HttpSessionEvent se) {
    }

    // セッション開始時の処理
    public void sessionWillPassivate(HttpSessionEvent se) {
    }
}
