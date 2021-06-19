package com.example.dddsample.domain.customer;

import com.alibaba.cola.exception.BizException;
import com.example.dddsample.client.api.CustomerDomainServiceI;
import com.example.dddsample.client.exception.CustomerError;
import com.example.dddsample.client.requestobject.CustomerRO;
import com.example.dddsample.domain.customer.facade.CustomerGateway;
import com.example.dddsample.domain.customer.facade.EmployeeGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Created on 2021/6/8.
 *
 * @author Beiyuan Zhang
 */
@Component
public class CustomerDomainServiceImpl implements CustomerDomainServiceI {

    @Autowired
    EmployeeGateway employeeGateway;
    @Autowired
    CustomerGateway customerGateway;

    @Override
    public boolean create(CustomerRO customerRO) throws BizException {
        CustomerAggregate customerAggregate = new CustomerAggregate();
        customerAggregate.setName(customerRO.getName());
        customerAggregate.setEmployeeVO(employeeGateway.getEmployee(customerRO.getIdEmployee()));
        return customerAggregate.update();
    }

    @Override
    public boolean edit(CustomerRO customerRO) {
        CustomerAggregate customerAggregate = customerGateway.getCustomerAggregate(customerRO.getId());
        if(Objects.isNull(customerAggregate)){
            throw new BizException(CustomerError.NOT_FOUND);
        }

        customerAggregate.setName(customerRO.getName());
        customerAggregate.setEmployeeVO(employeeGateway.getEmployee(customerRO.getIdEmployee()));
        return customerAggregate.update();
    }
}
