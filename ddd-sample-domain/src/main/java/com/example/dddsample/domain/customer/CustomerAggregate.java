package com.example.dddsample.domain.customer;

import com.alibaba.cola.exception.BizException;
import com.example.dddsample.client.exception.CustomerError;
import com.example.dddsample.domain.ApplicationContextUtils;
import com.example.dddsample.domain.customer.facade.CustomerGateway;
import com.example.dddsample.domain.customer.valobj.EmployeeVO;
import lombok.Data;

import java.util.Objects;

/**
 * Created on 2021/6/8.
 *
 * @author Beiyuan Zhang
 */
@Data
public class CustomerAggregate {
    private Long id;
    private EmployeeVO employeeVO;
    private String name;

    private CustomerGateway customerGateway;
    public CustomerAggregate(){
        this.customerGateway = ApplicationContextUtils.getApplicationContext().getBean(CustomerGateway.class);
    }

    public boolean update(){
        if(!employeeVO.getAllowingAssign()) {
            throw new BizException(CustomerError.NOT_FOUND);
        }
        if(Objects.isNull(this.id)){
            this.id = customerGateway.add(this);
        }else{
            var rows = customerGateway.update(this);
            return rows > 0;
        }

        return !Objects.isNull(id) && id > 0;
    }
}
