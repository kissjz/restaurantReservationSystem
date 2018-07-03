package com.JdbcTest;

import java.util.ArrayList;
import java.util.Iterator;

import com.dao.CustomerDao;
import com.domain.Customer;

public class FindAllCustomersTest {

    public static void main(String[] args) {
        CustomerDao customerDao = new CustomerDao();
        ArrayList<Customer> list = customerDao.findAll();
        Iterator<Customer> customerIt = list.iterator();
        while(customerIt.hasNext()) {
            Customer customer = customerIt.next();
            System.out.println("name: " + customer.getName());
        }
        
    }

}
