package com.example.dddsample.client.exception;

import com.alibaba.cola.exception.ErrorEnumI;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created on 2021/6/8.
 *
 * @author Beiyuan Zhang
 */
@Getter
@AllArgsConstructor
public enum CustomerError implements ErrorEnumI {
    CAN_NOT_ASSIGN(100405, "不允许分配客户"),
    NOT_FOUND(100404, "客户不存在");

    private int code;
    private String message;
}
