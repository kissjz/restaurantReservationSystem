package com.JdbcTest;

import com.dao.CustomerDao;
import com.domain.Customer;

public class FindCustomerByIdTest {

    public static void main(String[] args) {
        CustomerDao customerDao = new CustomerDao();
        Customer customer = customerDao.find(1);
        System.out.println(customer.getName());
    }

}
