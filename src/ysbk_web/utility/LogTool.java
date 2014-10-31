/*
 * クラス名:LogTool
 *
 * バージョン情報: 1.0
 *
 * 日付け: 2014/07/27
 *
 * Copyright表示:
 */
package ysbk_web.utility;

import org.apache.log4j.Logger;
//import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogTool {
    public void loggerPointcut() {
    }

    public Object doLogger(ProceedingJoinPoint joinPoint) throws Throwable {
        StringBuffer sb = new StringBuffer();
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Class targetClass = Class.forName(targetName);
        Logger logger = Logger.getLogger(targetClass);

        Object result = null;
        String target = "";

        try {
            result = joinPoint.proceed();
            return result;
        } catch (CommandException cex) {
            sb.append(cex.getMessageID() + "," + cex.getMessage());
            sb.append(targetName);
            sb.append(",");
            sb.append(methodName);
            logger.error(sb, cex);
            if (cex.getErrorType() == Constants.SQL_EXCEPTION) {
                target = Constants.DBERR;
            } else if (cex.getErrorType() == Constants.EXCEPTION) {
                target = Constants.ERR;
            }
        }

        return target;
    }

}