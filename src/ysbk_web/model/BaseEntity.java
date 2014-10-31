/*
 * クラス名: BaseEntity
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
 * @author オード順フラグエンテイテイ
 */
public class BaseEntity implements Serializable {

    // オード順フラグ
    private int orderBy;

    /**
     * オード順フラグを取得します。
     * 
     * @return int
     */
    public int getOrderBy() {
        return this.orderBy;
    }

    /**
     * オード順フラグを設定します。
     * 
     * @param orderBy
     */
    public void setOrderBy(int orderBy) {
        this.orderBy = orderBy;
    }
}
