package com.domain;
import java.sql.Date;
import java.sql.Time;

public abstract class AbstractBooking {
	protected int covers;
	protected Date date;
	protected Time time;
	
	protected AbstractBooking(int covers, Date date) {
		this.covers = covers;
		this.date = date;
	}
	
	public abstract void setArrivalTime(Time t) ;
	
	public void setCovers (int c) {
		covers = c;
	}
	
    public abstract Date getDate();
    public abstract Time getTime();
    public abstract int getCovers();
    public abstract int getTable_id();
    
}
