package com.JdbcTest;

import com.dao.WalkInDao;

public class DeleteWalkInTest {

    public static void main(String[] args) {
        WalkInDao walkInDao = new WalkInDao();
        System.out.println(walkInDao.delete(4));
    }

}
