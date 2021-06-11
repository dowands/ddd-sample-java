package com.example.dddsample.domain.customer.facade;

import com.example.dddsample.domain.customer.CustomerAggregate;

/**
 * Created on 2021/6/8.
 *
 * @author Beiyuan Zhang
 */
public interface CustomerGateway {
    public CustomerAggregate getCustomerAggregate(Long id);

    int countByIdEmployee(Long id);

    Long add(CustomerAggregate customerAggregate);

    int update(CustomerAggregate customerAggregate);

    String getSlip();
}
