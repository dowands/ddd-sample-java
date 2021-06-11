package com.example.dddsample.app.query;

import com.alibaba.cola.dto.PageResponse;
import com.example.dddsample.client.clientobject.CustomerCO;
import com.example.dddsample.domain.customer.facade.CustomerGateway;
import com.example.dddsample.gatewayImpl.CustomerGatewayImpl;
import com.example.dddsample.gatewayImpl.database.mapper.CustomerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created on 2021/6/8.
 *
 * @author Beiyuan Zhang
 */
@Component
@Slf4j
public class CustomerQuery {
    @Autowired
    CustomerGatewayImpl customerGateway;

    @Value("${page-size:10}")
    int pageSize;

    public PageResponse<CustomerCO> list(Optional<Integer> p){
        int page = p.orElse(1);
        if(page < 1) {
            page = 1;
        }

        var responseList = new ArrayList<CustomerCO>();
        var list = customerGateway.getCustomerList(pageSize * (page-1), pageSize);
        list.forEach((v) -> {
            var customerCO = new CustomerCO();
            customerCO.setId(v.getId());
            customerCO.setIdEmployee(v.getIdEmployee());
            customerCO.setName(v.getName());
            responseList.add(customerCO);
        });
        return PageResponse.of(responseList, customerGateway.getCustomerTotal(), pageSize, page);
    }

    public void doJob() {
    }
}
