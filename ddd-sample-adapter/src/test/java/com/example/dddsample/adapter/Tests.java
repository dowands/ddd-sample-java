package com.example.dddsample.adapter;

import com.example.dddsample.app.command.CustomerCmd;
import com.example.dddsample.app.query.CustomerQuery;
import com.example.dddsample.client.requestobject.CustomerRO;
import com.example.dddsample.DddSampleApplicationTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest(classes = DddSampleApplicationTests.class)
class Tests {

    @Autowired
    CustomerCmd customerCmd;
    @Autowired
    CustomerQuery customerQuery;

    @Test
    public void tests(){
        CustomerRO customerRO = new CustomerRO();
        customerRO.setName("testname 1");
        customerRO.setIdEmployee(6L);
        customerCmd.add(customerRO);

        Assertions.assertEquals(4, customerQuery.list(Optional.of(1)).getTotalCount());

        customerRO = new CustomerRO();
        customerRO.setId(3L);
        customerRO.setName("testname 1");
        customerRO.setIdEmployee(7L);
        customerCmd.add(customerRO);

        Assertions.assertNotEquals(4, customerQuery.list(Optional.of(1)).getTotalCount());
    }
}