package com.JdbcTest;

import com.dao.CustomerDao;

public class DeleteCustomerTest {

    public static void main(String[] args) {
        CustomerDao customerDao = new CustomerDao();
        System.out.println(customerDao.delete(4));
    }

}
