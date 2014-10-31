/*
 * クラス名:Page
 *
 * バージョン情報: 1.0
 *
 * 日付け: 2014/07/22
 *
 * Copyright表示:
 */

package ysbk_web.utility;

import java.io.Serializable;
import java.util.*;

/**
 * ページごとのデータを格納して、また前ページと次ページの情報を格納します。
 * 
 * @author EIT
 */
public class Page implements Serializable {
    // ページのデータがないを示すPageのインスタンス。
    public static final Page EMPTY_PAGE = new Page(Collections.EMPTY_LIST, 0,
            false, 0);

    // ページごとに表示するデータ件数
    private int pageMax = Constants.PAGE_MAX;

    // データを開始するを示す値。
    private int startIndex;

    // 結果セットのデータ総件数。
    private int resultDataCount;

    // 次のページがあるかどうかを示す値。
    private boolean hasNext;

    // 現在のページのデータを保有するリストコレクション
    private List list = new ArrayList();

    /**
     * Pageのインスタンスを初期化します。
     * 
     * @param select DBSelectオブジェクト。
     * @param list 現在のページのデータを保有するリストコレクション。
     * @param startIndex 開始のデータインデックス。
     * @param pageMax ページごとに最大表示件数。
     */
    public Page(List list, int startIndex, boolean hasNext, int resultDataCount) {
        this.list = list;
        this.startIndex = startIndex;
        this.hasNext = hasNext;
        this.resultDataCount = resultDataCount;
    }

    /**
     * 次のページが有効かどうかを示す値を取得します。
     * 
     * @return　次のページが有効かどうかを示す値
     */
    public boolean isNextPageAvailable() {
        return hasNext;
    }

    /**
     * 前のページが有効かどうかを示す値を取得します。
     * 
     * @return　前のページが有効かどうかを示す値
     */
    public boolean isPreviousPageAvailable() {
        return startIndex > 0;
    }

    /**
     * 次のページが表示するデータの最初のデータ件数を取得します。
     * 
     * @return　次のページが表示するデータの最初のデータ件数。
     */
    public int getStartOfNextPage() {
        return startIndex + this.list.size();
    }

    /**
     * 前のページが表示するデータの最初のデータ件数を取得します。
     * 
     * @return　前のページが表示するデータの最初のデータ件数。
     */
    public int getStartOfPreviousPage() {
        return Math.max(this.startIndex - pageMax, 0);
    }

    /**
     * 開始インデックスを取得します。
     * 
     * @return　startIndex
     */
    public int getStartIndex() {
        return this.startIndex;
    }

    /**
     * 開始データ数を取得します。
     * 
     * @return　開始データ数
     */
    public int getStartNo() {
        return this.startIndex + 1;
    }

    /**
     * 総データ件数を取得します。
     * 
     * @return int
     */
    public int getDataCount() {
        return this.resultDataCount;
    }

    /**
     * 現在ページのデータ件数を取得します。
     * 
     * @return
     */
    public int getCurrentDataCount() {
        return list.size();
    }

    /**
     * 次ページのデータ件数を取得します。
     * 
     * @return
     */
    public int getNextPageCount() {
        return Math.min(this.resultDataCount - this.getStartOfNextPage(),
                this.pageMax);
    }

    /**
     * ページごとに最大表示データ件数を取得します。
     * 
     * @return int
     */
    public int getPageMax() {
        return this.pageMax;
    }

    /**
     * 現在のページ数を取得します。
     * 
     * @return int
     */
    public int getCurrentPageNo() {
        return this.startIndex / this.pageMax + 1;
    }

    /**
     * 総ページ数を取得します。
     * 
     * @return int
     */
    public int getPageCount() {
        return (int) Math.ceil((double) this.resultDataCount / this.pageMax);
    }

    /**
     * 現在のページのデータを保有するリストコレクションを取得します。
     * 
     * @return　現在のページのデータを保有するリストコレクション。
     */
    public List getList() {
        return this.list;
    }

    /**
     * ページごとに表示するデータ件数を設定します
     * 
     * @param pageMax
     */
    public void setPageMax(int pageMax) {
        this.pageMax = pageMax;
    }

    /**
     * ページ番号はnullかを判断します
     * 
     * @return boolean
     */
    public boolean isPageNotEmpty() {
        return this.list.size() > 0;
    }
}
