package com.example.dddsample.gatewayImpl;

import com.alibaba.cola.exception.BizException;
import com.example.dddsample.client.exception.CustomerError;
import com.example.dddsample.client.exception.EmployeeError;
import com.example.dddsample.domain.customer.facade.CustomerGateway;
import com.example.dddsample.domain.customer.facade.EmployeeGateway;
import com.example.dddsample.domain.customer.valobj.EmployeeVO;
import com.example.dddsample.gatewayImpl.database.dataobject.EmployeeDO;
import com.example.dddsample.gatewayImpl.database.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Created on 2021/6/10.
 *
 * @author Beiyuan Zhang
 */
@Component
public class EmployeeGatewayImpl implements EmployeeGateway {

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public EmployeeVO getEmployee(Long id) {
        EmployeeDO employeeDO = employeeMapper.getById(id);
        if(Objects.isNull(employeeDO)){
            throw new BizException(EmployeeError.NOT_FOUND);
        }
        EmployeeVO employeeVO = new EmployeeVO();
        employeeVO.setAllowingAssign(employeeDO.getAllowingAssign() > 0);
        employeeVO.setId(employeeDO.getId());
        return employeeVO;
    }
}
