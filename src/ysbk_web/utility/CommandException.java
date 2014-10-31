/*
 * クラス名: CommandException
 *
 * バージョン情報: 1.00
 *
 * 作成日: 2004/01/14
 *
 * Copyright:
 */

package ysbk_web.utility;

import ysbk_web.model.MessageEntity;

/**
 * @author EIT コマンドを実行時発生する例外を示すクラス。
 */
public class CommandException extends Exception {
    private MessageEntity messageEntity;

    /**
     * @param message
     */
    public CommandException(String message) {
        super(message);
        this.messageEntity = new MessageEntity(message, null, -1);
    }

    /**
     * @param message
     */
    public CommandException(MessageEntity messageEntity) {
        super(messageEntity.getMessage());
        this.messageEntity = messageEntity;
    }

    /**
     * @param message
     * @param messageID
     * @param errorType
     */
    public CommandException(String message, String messageID, int errorType) {
        super(message);
        this.messageEntity = new MessageEntity(message, messageID, errorType);
    }

    /**
     * return getMessageID
     */
    public String getMessageID() {
        return this.messageEntity.getMessageID();
    }

    /**
     * return getErrorType
     */
    public int getErrorType() {
        return this.messageEntity.getErrorType();
    }

    /**
     * return messageEntity
     */
    public MessageEntity getMessageEntity() {
        return this.messageEntity;
    }
}
