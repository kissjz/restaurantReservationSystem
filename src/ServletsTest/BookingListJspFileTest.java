package ServletsTest;

import java.util.ArrayList;
import java.util.Iterator;

import com.controller.BookingSystem;
import com.domain.AbstractBooking;

public class BookingListJspFileTest {

    public static void main(String[] args) {
        BookingSystem bookingSystem = BookingSystem.getInstance();
        ArrayList<AbstractBooking> list = bookingSystem.getBookings();
        
        Iterator<AbstractBooking> abstractBookingIt = list.iterator();
        while(abstractBookingIt.hasNext()) {
            AbstractBooking ab = abstractBookingIt.next();
            System.out.println("table_id: " + ab.getTable_id() + " covers: " + ab.getCovers()
                    + " date: " + ab.getDate() + " time: " + ab.getTime());
        }
    }

}
