package com.controller;
import java.sql.Time;
import java.util.ArrayList;

import com.dao.CustomerDao;
import com.dao.ReservationDao;
import com.dao.WalkInDao;
import com.domain.AbstractBooking;
import com.domain.Reservation;
import com.domain.WalkIn;

public class BookingSystem {
	private static BookingSystem uniqueInstance;
	private ArrayList<AbstractBooking> currentBookings = new ArrayList<>();
	private Restaurant restaurant = new Restaurant();
	
	final static int NotSelected = 0;
	final static int Selected = 1;
	int state;
	
	public static BookingSystem getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new BookingSystem();
		}
		return uniqueInstance;
	}
	
	private BookingSystem() {
		state = NotSelected;
	}
	
	public void addBooking (AbstractBooking b) {
		currentBookings.add(b);
	}
	
	public ArrayList<AbstractBooking> getBookings(){
	    return restaurant.getBookings();
	}
	
	public ArrayList<Reservation> getReservations(){
	    return restaurant.getReservaions();
	}
	
	public void makeReservation(Reservation reservation) {
	    ReservationDao reservationDao = new ReservationDao();
	    CustomerDao customerDao = new CustomerDao();
        int nextCustomerId = customerDao.getNextCustomerId();
        reservation.setCustomer_id(nextCustomerId);
        
        //插入先后不能颠倒，数据库中参照完整性
        customerDao.insert(reservation.getCustomer());
        reservationDao.insert(reservation);
	}
	
	public void makeWalkIn(WalkIn walkIn) {
	    WalkInDao walkInDao = new WalkInDao();
	    walkInDao.insert(walkIn);
	}
	
	public void recordArrival(int oid, Time time) {
	    ReservationDao reservationDao = new ReservationDao();
	    Reservation reservation = reservationDao.find(oid);
	    Reservation reservationUpdate = new Reservation(reservation.getCovers(), reservation.getDate(), reservation.getCustomer());
	    reservationUpdate.setOid(oid);
	    reservationUpdate.setArrivalTime(time);
//	    reservationUpdate.setTime(time);
	    reservationUpdate.setTable_id(reservation.getTable_id());
	    System.out.println("是否更新成功：" + reservationDao.update(reservationUpdate));
	}
	
	public void deleteReservation(int oid) {
	    ReservationDao reservationDao = new ReservationDao();
	    System.out.println("是否删除成功: " + reservationDao.delete(oid));
	}
	
}
