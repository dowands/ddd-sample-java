package com.example.dddsample.gatewayImpl.database.mapper;

import com.example.dddsample.gatewayImpl.database.dataobject.CustomerDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 2021/6/8.
 *
 * @author Beiyuan Zhang
 */
@Mapper
@Repository
public interface CustomerMapper {
    CustomerDO getById(Long id);

    List<CustomerDO> list(int offset, int size);

    int getTotal();

    int countByIdEmployee(Long id);

    Long create(CustomerDO customerDO);
    int update(CustomerDO customerDO);
}
