package com.JdbcTest;

import java.util.ArrayList;
import java.util.Iterator;

import com.dao.ReservationDao;
import com.domain.Reservation;

public class FindAllResrervationTest {

    public static void main(String[] args) {
        ReservationDao reservationDao = new ReservationDao();
        ArrayList<Reservation> list = reservationDao.findAll();
        Iterator<Reservation> reservationIt = list.iterator();
        while(reservationIt.hasNext()) {
            Reservation reservation = reservationIt.next();
            System.out.println(reservation.getDate() + "time: " + reservation.getCustomer_id());
        }
    }

}
