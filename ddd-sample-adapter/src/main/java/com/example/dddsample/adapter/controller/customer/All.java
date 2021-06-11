package com.example.dddsample.adapter.controller.customer;

import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.SingleResponse;
import com.example.dddsample.app.command.CustomerCmd;
import com.example.dddsample.app.query.CustomerQuery;
import com.example.dddsample.client.clientobject.CustomerCO;
import com.example.dddsample.client.requestobject.CustomerRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created on 2021/6/8.
 *
 * @author Beiyuan Zhang
 */
@RequestMapping("customer")
@RestController
public class All {
    @Autowired
    CustomerQuery customerQuery;

    @Autowired
    CustomerCmd customerCmd;

    @GetMapping("/")
    public PageResponse<CustomerCO> list(@RequestParam Optional<Integer> page){
        return customerQuery.list(page);
    }

    @PostMapping("/")
    public SingleResponse add(@RequestBody CustomerRO customerRO){
        return customerCmd.add(customerRO);
    }
}
