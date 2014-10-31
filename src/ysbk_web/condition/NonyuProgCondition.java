/*
 * クラス名: NonyuProgCondition
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2014/07/31
 *
 * Copyright:
 */
package ysbk_web.condition;

import ysbk_web.view.UserView;

public class NonyuProgCondition {
    /** RG */
    private String rg;

    /** 並び順 */
    private String sort_fg;

    /** ユーザエンティティ */
    private UserView userView;

    /** 検索条件有るフラグ */
    private Boolean cond_fg;

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSort_fg() {
        return sort_fg;
    }

    public void setSort_fg(String sort_fg) {
        this.sort_fg = sort_fg;
    }

    public UserView getUserView() {
        return userView;
    }

    public void setUserView(UserView userView) {
        this.userView = userView;
    }

    public Boolean getCond_fg() {
        return cond_fg;
    }

    public void setCond_fg(Boolean cond_fg) {
        this.cond_fg = cond_fg;
    }

}
