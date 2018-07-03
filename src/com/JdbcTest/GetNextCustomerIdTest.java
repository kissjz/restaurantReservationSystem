package com.JdbcTest;

import com.dao.CustomerDao;

public class GetNextCustomerIdTest {

    public static void main(String[] args) {
        CustomerDao customerDao = new CustomerDao();
        System.out.println(customerDao.getNextCustomerId());
    }

}
