package com.JdbcTest;

import com.dao.ReservationDao;

public class FindReservationByIdTest {

    public static void main(String[] args) {
        ReservationDao reservationDao = new ReservationDao();
        System.out.println(reservationDao.find(1).getCustomer_id());
    }

}
