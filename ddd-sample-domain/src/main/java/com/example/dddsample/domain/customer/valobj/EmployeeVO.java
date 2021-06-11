package com.example.dddsample.domain.customer.valobj;

import com.example.dddsample.domain.ApplicationContextUtils;
import com.example.dddsample.domain.customer.CustomerAggregate;
import com.example.dddsample.domain.customer.facade.CustomerGateway;
import com.example.dddsample.domain.customer.facade.EmployeeGateway;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created on 2021/6/8.
 *
 * @author Beiyuan Zhang
 */
@Data
public class EmployeeVO {
    private Long id;
    private Boolean allowingAssign;

    CustomerGateway customerGateway;
    public EmployeeVO(){
        this.customerGateway = ApplicationContextUtils.getApplicationContext().getBean(CustomerGateway.class);
    }

    /**
    不允许分配超过3个客户
     */
    public Boolean getAllowingAssign(){
        if(!this.allowingAssign){
            return false;
        }

        int count = customerGateway.countByIdEmployee(this.id);
        return count <= 3;
    }
}
