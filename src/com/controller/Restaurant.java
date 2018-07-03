package com.controller;

import java.util.ArrayList;

import com.dao.ReservationDao;
import com.dao.TableDao;
import com.dao.WalkInDao;
import com.domain.AbstractBooking;
import com.domain.Reservation;
import com.domain.Table;

public class Restaurant {
    public ArrayList<AbstractBooking> getBookings() {
        ArrayList<AbstractBooking> ans = new ArrayList<AbstractBooking>();
        WalkInDao walkInDao = new WalkInDao();
        ReservationDao reservationDao = new ReservationDao();
        ans.addAll(walkInDao.findAll());
        ans.addAll(reservationDao.findAll());
        return ans;
    }
    
    public ArrayList<Reservation> getReservaions(){
        ReservationDao reservationDao = new ReservationDao();
        return reservationDao.findAll();
    }
    
    public Table getTable(int id){
        TableDao tableDao = new TableDao();
        return tableDao.find(id);
    }
}
