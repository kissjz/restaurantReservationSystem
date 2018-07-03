package com.JdbcTest;

import com.dao.WalkInDao;
import com.domain.WalkIn;
import java.sql.Date;
import java.sql.Time;


public class InsertWalkInTest {

    public static void main(String[] args) {
        WalkInDao walkInDao = new WalkInDao();
        WalkIn walkIn = new WalkIn();
        walkIn.setOid(6);
        walkIn.setCovers(10);
        String date = "2018-07-18";
        walkIn.setDate(Date.valueOf(date));
        String time = "22:00:00";
        walkIn.setTime(Time.valueOf(time));
        walkIn.setTable_id(7);
        System.out.println(walkInDao.insert(walkIn));
    }

}
