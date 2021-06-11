package com.alibaba.cola.exception;

/**
 * Created on 2021/6/8.
 *
 * @author Beiyuan Zhang
 */
public interface ErrorEnumI {
    int code = 0;
    String message = "";

    int getCode();
    String getMessage();
}
