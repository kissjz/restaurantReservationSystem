package com.JdbcTest;

import java.sql.Date;
import java.sql.Time;

import com.dao.CustomerDao;
import com.dao.ReservationDao;
import com.domain.Customer;
import com.domain.Reservation;

public class UpdateReservationTest {

    public static void main(String[] args) {
        ReservationDao reservationDao = new ReservationDao();
        String date = "2018-09-19";
        CustomerDao customerDao = new CustomerDao();
        Customer customer = customerDao.find(1);
        Reservation reservation = new Reservation(66, Date.valueOf(date), customer);
        reservation.setOid(4);
        reservation.setDate(Date.valueOf(date));
        String time = "11:20:22";
        reservation.setTime(Time.valueOf(time));
        reservation.setTable_id(7);
        reservation.setCustomer_id(4);
        System.out.println(reservationDao.update(reservation));
    }

}
