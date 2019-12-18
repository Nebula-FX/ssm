package com.zking.ssm.service.impl;

import com.zking.ssm.model.Customer;
import com.zking.ssm.model.Order;
import com.zking.ssm.service.ICustomerService;
import com.zking.ssm.service.IOrderService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml"})
public class CustomerServiceImplTest {

    Customer customer;
    Order order;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IOrderService orderService;

    @Before
    public void setUp() throws Exception {
        customer = new Customer();
        order = new Order();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void selectByPrimaryKey() {
        Customer customer = customerService.selectByPrimaryKey(2);
        System.out.println(customer);
    }


    @Test
    public void test() {
        Order order = orderService.selectByPrimaryKey(4);
        System.out.println(order);
    }
}