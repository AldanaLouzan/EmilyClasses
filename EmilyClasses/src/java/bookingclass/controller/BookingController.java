package bookingclass.controller;

import bookingclass.entity.Booking;
import bookingclass.entity.Classes;
import bookingclass.entity.Slot;
import bookingclass.entity.Student;
import dao.BookingDaoImpl;
import java.sql.ResultSet;
import viewInterface.IBooking;

public class BookingController implements IBooking{
    BookingDaoImpl data = new BookingDaoImpl();
    
    @Override
    public Booking getBooking(int bookingId) {
        return data.getBooking(bookingId);
    }

    @Override
    public boolean insertNewBooking(Classes c, Slot sl, Student stu) {
        boolean booking = data.insertNewBooking(c, sl, stu);
        return booking;
    }

    @Override
    public ResultSet getAllBookings() {
        return data.getAllBookings();
    }
    
}
