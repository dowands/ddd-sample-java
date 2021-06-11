package com.example.dddsample.domain.customer.facade;

import com.example.dddsample.domain.customer.valobj.EmployeeVO;

/**
 * Created on 2021/6/8.
 *
 * @author Beiyuan Zhang
 */
public interface EmployeeGateway {
    EmployeeVO getEmployee(Long id);
}
