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
public enum EmployeeError implements ErrorEnumI {
    NOT_FOUND(100404, "员工不存在");

    private int code;
    private String message;
}
