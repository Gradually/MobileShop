package cn.wycclub.exception;

/**
 * 用户名或密码错误异常
 *
 * @author WuYuchen
 * @date 2017-10-29 11:26
 */

public class UsernameOrPasswordErrorException extends Exception {
    public UsernameOrPasswordErrorException() {
        super();
    }

    public UsernameOrPasswordErrorException(String message) {
        super(message);
    }

    public UsernameOrPasswordErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameOrPasswordErrorException(Throwable cause) {
        super(cause);
    }

    protected UsernameOrPasswordErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
