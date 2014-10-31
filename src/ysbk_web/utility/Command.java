/*
 * クラス名: Command
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2004/01/14
 *
 * Copyright:
 */

package ysbk_web.utility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author EIT 該当インタフェースはアクション側の業務処理及び入力出力部分の責務を分担する。
 * アクションが発生する時、上位クラスであるアクションクラスのexecuteメソッド
 * にCommandのインスタンスを生成し、Commandのexecuteメソッドを実行する。
 * Commandのexecuteメソッドはアクションクラスのexecuteメソッドのform、
 * request、responseパラメータを受け取り、業務の処理及びユーザインタフェース
 * の入出力のコントロールを行う。アクションクラスのexecuteメソッドはフォワード
 * に必要な情報をアクションフォームから受け取り、Commandのexecuteの実行結果を 見ながら次のフォワードを決定する。
 */
public abstract class Command {
    private String messageID = null;

    /**
     * 呼出先のアクションクラスのexecuteメソッドのform、request、response
     * パラメータを受け取り、業務の処理及びユーザインタフェースの入出力の コントロールを行う。成功または正常終了の場合はtrueを返す、失敗の場合
     * はfalseを返す。異常の場合、CommandExceptionを投げる。
     * 
     * @param form
     * @param request
     * @param response
     * @return boolean
     * @throws dressy.command.CommandException
     */
    public abstract boolean execute(HttpServletRequest request,
            HttpServletResponse response) throws CommandException;

    /**
     * @return java.lang.String
     */
    public String getMessageID() {
        return this.messageID;
    }

    /**
     * @param messageID
     */
    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }
}
