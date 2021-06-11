package com.example.dddsample.gatewayImpl.database.mapper;

import com.example.dddsample.gatewayImpl.database.dataobject.CustomerDO;
import com.example.dddsample.gatewayImpl.database.dataobject.EmployeeDO;
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
public interface EmployeeMapper {
    EmployeeDO getById(Long id);
}
