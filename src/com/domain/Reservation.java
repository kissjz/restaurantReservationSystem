package com.domain;

import java.sql.Date;
import java.sql.Time;

public class Reservation extends AbstractBooking{
    private int oid;
//    private int covers;
//    private Date date;
    private Time time;
    private int table_id;
//    private int customer_id;
    
    
    Time arrivalTime;
    private Customer customer;

    public Reservation(int covers, Date date, Customer customer) {
        super(covers, date);
        if(customer == null) {
            throw new NullPointerException();
        }
        this.customer = customer;
        
        arrivalTime = null;
        
    }
    
    
    @Override
    public void setArrivalTime(Time time) {
        arrivalTime = time;
        this.time = time;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public int getOid() {
        return oid;
    }
    public void setOid(int oid) {
        this.oid = oid;
    }
    public int getCovers() {
        return covers;
    }
    public void setCovers(int covers) {
        this.covers = covers;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Time getTime() {
        return time;
    }
    public void setTime(Time time) {
        this.time = time;
    }
    public int getTable_id() {
        return table_id;
    }
    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }
    public int getCustomer_id() {
        return customer.getOid();
    }
    public void setCustomer_id(int customer_id) {
        customer.setOid(customer_id);
    }
    
}
