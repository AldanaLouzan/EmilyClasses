package bookingclass.controller;

import bookingclass.entity.Classes;
import bookingclass.entity.Slot;
import dao.SlotDaoImpl;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import viewInterface.ISlot;

/**
 *
 * @author Aldana
 */
public class SlotController implements ISlot {
     SlotDaoImpl data = new SlotDaoImpl();
    
    public Slot booking (Classes c, int studentID, String subject, String comment){
        
        Slot slotBooked = new Slot();
        
        slotBooked.setClasses(c);
        slotBooked.setStudentID(studentID);
        slotBooked.setComment(comment);
        slotBooked.setPrice(calculatePrice(c.getType()));
        slotBooked.setStatus("pending");
        slotBooked.setSubject(defineSubject(subject));
        
        return slotBooked;
        
    }
    
    public String defineSubject(String subject) {
        String value = null;
        if ("Mathematics".equals(subject)) {
            value = "M";
        } else if ("Physics".equals(subject)) {
            value = "P";
        } else {
            value = "C";
        }

        return value;
    }
    
    public int calculatePrice(String classType){
        int price = 0;
        if ("private".equals(classType)){
            price = 50;
        }else if ("semiprivate".equals(classType)){
            price = 40;
        }else{
            price = 35;
        }
        return price;
        
    }
    
    public boolean bookSlot (Slot s){
        
        boolean booking = data.insertNewSlot(s);
        return booking;
    }
    
    public ResultSet selectSlotJoinClasses(Date d){    
    
        /*Date d;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        d = sdf.parse(date);*/
        ResultSet rs;
        rs = data.selectSlotJoinClasses(d);
        
        return rs;
        
    }
    
}
