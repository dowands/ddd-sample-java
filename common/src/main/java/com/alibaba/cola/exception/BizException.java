package com.alibaba.cola.exception;

/**
 * Created on 2021/6/8.
 *
 * @author Beiyuan Zhang
 */
public class BizException extends BaseException {
    private static final long serialVersionUID = 1L;
    private static final String DEFAULT_ERR_CODE = "BIZ_ERROR";

    public BizException(String errMessage) {
        super("BIZ_ERROR", errMessage);
    }

    public BizException(ErrorEnumI errorEnumI) {
        super(String.valueOf(errorEnumI.getCode()), errorEnumI.getMessage());
    }

    public BizException(String errCode, String errMessage) {
        super(errCode, errMessage);
    }

    public BizException(String errMessage, Throwable e) {
        super("BIZ_ERROR", errMessage, e);
    }

    public BizException(String errorCode, String errMessage, Throwable e) {
        super(errorCode, errMessage, e);
    }
}
