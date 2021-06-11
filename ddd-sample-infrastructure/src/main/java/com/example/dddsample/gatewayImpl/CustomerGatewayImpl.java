package com.example.dddsample.gatewayImpl;

import com.example.dddsample.domain.customer.CustomerAggregate;
import com.example.dddsample.domain.customer.facade.CustomerGateway;
import com.example.dddsample.gatewayImpl.database.dataobject.CustomerDO;
import com.example.dddsample.gatewayImpl.database.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * Created on 2021/6/8.
 *
 * @author Beiyuan Zhang
 */
@Component
public class CustomerGatewayImpl implements CustomerGateway {
    @Autowired
    CustomerMapper customerMapper;
    
    @Override
    public CustomerAggregate getCustomerAggregate(Long id) {
        return null;
    }
    public CustomerDO getCustomer(Long id) {
        return customerMapper.getById(id);
    }

    public List<CustomerDO> getCustomerList(int offset, int size){
        return customerMapper.list(offset, size);
    }

    @Override
    public int countByIdEmployee(Long id) {
        return customerMapper.countByIdEmployee(id);
    }

    @Override
    public Long add(CustomerAggregate customerAggregate) {
        CustomerDO customerDO = new CustomerDO();
        customerDO.setIdEmployee(customerAggregate.getEmployeeVO().getId());
        customerDO.setName(customerAggregate.getName());
        return customerMapper.create(customerDO);
    }

    @Override
    public int update(CustomerAggregate customerAggregate) {
        CustomerDO customerDO = new CustomerDO();
        customerDO.setId(customerAggregate.getId());
        customerDO.setIdEmployee(customerAggregate.getEmployeeVO().getId());
        customerDO.setName(customerAggregate.getName());
        return customerMapper.update(customerDO);
    }

    @Autowired
    RestTemplate restTemplate;

    @Override
    public String getSlip() {
        try {
            var rest = restTemplate.getRequestFactory().createRequest(URI.create("https://data.zhai78.com/openOneGood.php"), HttpMethod.GET);
            var str = new String(rest.execute().getBody().readAllBytes());
            var json = new JacksonJsonParser().parseMap(str);
            return (String) json.get("txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public int getCustomerTotal() {
        return customerMapper.getTotal();
    }
}
