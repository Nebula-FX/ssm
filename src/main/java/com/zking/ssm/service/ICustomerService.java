package com.zking.ssm.service;

import com.zking.ssm.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerService {

    Customer selectByPrimaryKey(Integer customerId);

}