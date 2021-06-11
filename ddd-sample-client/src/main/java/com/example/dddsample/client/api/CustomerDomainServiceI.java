package com.example.dddsample.client.api;

import com.alibaba.cola.dto.PageResponse;
import com.example.dddsample.client.clientobject.CustomerCO;
import com.example.dddsample.client.requestobject.CustomerRO;

/**
 * Created on 2021/6/8.
 *
 * @author Beiyuan Zhang
 */
public interface CustomerDomainServiceI {
    boolean create(CustomerRO customerRO);
    boolean edit(CustomerRO customerRO);
}
