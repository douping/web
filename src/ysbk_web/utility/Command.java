/*
 * �N���X��: Command
 *
 * �o�[�W�������: 1.00
 *
 * �쐬��: 2004/01/14
 *
 * Copyright:
 */

package ysbk_web.utility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author EIT �Y���C���^�t�F�[�X�̓A�N�V�������̋Ɩ������y�ѓ��͏o�͕����̐Ӗ��𕪒S����B
 * �A�N�V�������������鎞�A��ʃN���X�ł���A�N�V�����N���X��execute���\�b�h
 * ��Command�̃C���X�^���X�𐶐����ACommand��execute���\�b�h�����s����B
 * Command��execute���\�b�h�̓A�N�V�����N���X��execute���\�b�h��form�A
 * request�Aresponse�p�����[�^���󂯎��A�Ɩ��̏����y�у��[�U�C���^�t�F�[�X
 * �̓��o�͂̃R���g���[�����s���B�A�N�V�����N���X��execute���\�b�h�̓t�H���[�h
 * �ɕK�v�ȏ����A�N�V�����t�H�[������󂯎��ACommand��execute�̎��s���ʂ� ���Ȃ��玟�̃t�H���[�h�����肷��B
 */
public abstract class Command {
    private String messageID = null;

    /**
     * �ďo��̃A�N�V�����N���X��execute���\�b�h��form�Arequest�Aresponse
     * �p�����[�^���󂯎��A�Ɩ��̏����y�у��[�U�C���^�t�F�[�X�̓��o�͂� �R���g���[�����s���B�����܂��͐���I���̏ꍇ��true��Ԃ��A���s�̏ꍇ
     * ��false��Ԃ��B�ُ�̏ꍇ�ACommandException�𓊂���B
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
