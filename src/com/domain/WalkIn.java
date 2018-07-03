package com.domain;

import java.sql.Date;
import java.sql.Time;

public class WalkIn extends AbstractBooking{
    public WalkIn(int covers, Date date) {
        super(covers, date);
    }
    private int oid;
    private Time time;
    private int table_id;
    
    @Override
    public void setArrivalTime(Time time) {
        this.time = time;
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
    
    
}
