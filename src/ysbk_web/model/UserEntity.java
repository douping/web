/*
 * クラス名: UserEntity
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/24
 *
 * Copyright:
 */
package ysbk_web.model;

import java.io.Serializable;

/**
 * @author DBユーザエンティティ。
 */
public class UserEntity implements Serializable {

    // ユーザID
    private String opcode;

    // パスワード
    private String oppswd;

    // IP
    private String ip;

    // 仕入先
    private String siire;

    // RG_KB
    private String rg_kb;

    // KAIJI_KB
    private String kaiji_kb;

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
     * RG_KBを取得します。
     * 
     * @return java.lang.String
     */
    public String getRg_kb() {
        return rg_kb;
    }

    /**
     * RG_KBを設定します。
     * 
     * @param Rg_kb
     */
    public void setRg_kb(String rg_kb) {
        this.rg_kb = rg_kb;
    }

    /**
     * KAIJI_KBを取得します。
     * 
     * @return java.lang.String
     */
    public String getKaiji_kb() {
        return kaiji_kb;
    }

    /**
     * KAIJI_KBを設定します。
     * 
     * @param kaiji_kb
     */
    public void setKaiji_kb(String kaiji_kb) {
        this.kaiji_kb = kaiji_kb;
    }

}
