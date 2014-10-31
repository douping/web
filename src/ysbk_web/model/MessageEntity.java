/*
 * 作成日: 2014/07/24
 *
 * この生成されたコメントの挿入されるテンプレートを変更するため
 * ウィンドウ > 設定 > Java > コード生成 > コードとコメント
 */
package ysbk_web.model;

import java.io.Serializable;

/**
 * @author
 * 
 * この生成されたコメントの挿入されるテンプレートを変更するため ウィンドウ > 設定 > Java > コード生成 > コードとコメント
 */
public class MessageEntity implements Serializable {
    /**
     * メッセージ
     */
    private String message;

    /**
     * メッセージID、値はプロパティファイルに定義するキーです。
     */
    private String messageID = null;

    /**
     * エラータイプ。
     */
    private int errorType;

    public MessageEntity(String message, String messageID, int errorType) {
        this.message = message;
        this.messageID = messageID;
        this.errorType = errorType;
    }

    /**
     * メッセージを取得します。
     * 
     * @return　メッセージ　
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * メッセージIDを取得します。
     * 
     * @return　メッセージID　
     */
    public String getMessageID() {
        return this.messageID;
    }

    /**
     * エラータイプを取得します。
     * 
     * @return　エラータイプ　
     */
    public int getErrorType() {
        return this.errorType;
    }

}
