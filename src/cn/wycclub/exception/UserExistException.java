package cn.wycclub.exception;

/**
 * 用户不存在异常
 *
 * @author WuYuchen
 * @date 2017-10-27 16:29
 */

public class UserExistException extends Exception{
    public UserExistException() {
        super();
    }

    public UserExistException(String message) {
        super(message);
    }

    public UserExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserExistException(Throwable cause) {
        super(cause);
    }

    protected UserExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
