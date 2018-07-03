package com.JdbcTest;

import java.sql.Date;
import java.sql.Time;

import com.dao.ReservationDao;
import com.domain.Reservation;

public class InsertReservationTest {

    public static void main(String[] args) {
        ReservationDao reservationDao = new ReservationDao();
        Reservation reservation = new Reservation();
        reservation.setOid(4);
        reservation.setCovers(20);
        String date = "2018-08-08";
        reservation.setDate(Date.valueOf(date));
        String time = "11:20:00";
        reservation.setTime(Time.valueOf(time));
        reservation.setTable_id(7);
        reservation.setCustomer_id(4);
        System.out.println(reservationDao.insert(reservation));
    }

}
