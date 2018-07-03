package com.JdbcTest;

import com.dao.WalkInDao;
import com.domain.WalkIn;

public class FindWalkInByIdTest {

    public static void main(String[] args) {
        WalkInDao walkInDao = new WalkInDao();
        WalkIn walkIn = new WalkIn();
        walkIn = walkInDao.find(1);
        System.out.println(walkIn.getDate());
    }

}
