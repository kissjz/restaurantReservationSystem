package com.JdbcTest;

import java.util.ArrayList;
import java.util.Iterator;

import com.dao.WalkInDao;
import com.domain.WalkIn;

public class FindAllWalkInTest {

    public static void main(String[] args) {
        WalkInDao walkInDao = new WalkInDao();
        ArrayList<WalkIn> list = walkInDao.findAll();
        Iterator<WalkIn> walkInIt = list.iterator();
        while(walkInIt.hasNext()) {
            WalkIn walkIn = walkInIt.next();
            System.out.println(walkIn.getDate() + "time: " + walkIn.getTable_id());
        }
    }

}
