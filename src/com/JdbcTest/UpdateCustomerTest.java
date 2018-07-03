package com.JdbcTest;

import com.dao.CustomerDao;
import com.domain.Customer;

public class UpdateCustomerTest {

    public static void main(String[] args) {
        CustomerDao customerDao = new CustomerDao();
        Customer customer = new Customer();
        customer.setOid(4);
        customer.setName("lalala");
        customer.setPhonenumber("80080880");
        System.out.println(customerDao.update(customer));
    }

}
