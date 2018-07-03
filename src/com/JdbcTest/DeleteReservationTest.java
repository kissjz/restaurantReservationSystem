package com.JdbcTest;

import com.dao.ReservationDao;

public class DeleteReservationTest {

    public static void main(String[] args) {
        ReservationDao reservationDao = new ReservationDao();
        System.out.println(reservationDao.delete(4));
    }

}
