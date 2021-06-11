package com.example.dddsample.app.command;

import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.cola.exception.BizException;
import com.example.dddsample.client.api.CustomerDomainServiceI;
import com.example.dddsample.client.requestobject.CustomerRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 2021/6/8.
 *
 * @author Beiyuan Zhang
 */
@Component
public class CustomerCmd {
    
    @Autowired(required = false)
    CustomerDomainServiceI customerDomainServiceI;

    public SingleResponse add(CustomerRO customerRO){
        try {
            customerDomainServiceI.create(customerRO);
        } catch (BizException bizException){
            return SingleResponse.buildFailure(bizException.getErrCode(), bizException.getMessage());
        }

        return SingleResponse.buildSuccess();
    }

    public void doEvent() {
    }
}
