package bookingclass.controller;

import bookingclass.entity.Classes;
import bookingclass.entity.Slot;
import dao.SlotDaoImpl;
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
        slotBooked.setSubject(subject);
        
        return slotBooked;
        
    }
    
    public int calculatePrice(String classType){
        int price = 0;
        if (classType == "private"){
            price = 50;
        }else if (classType == "semiprivate"){
            price = 40;
        }else{
            price = 35;
        }
        return price;
        
    }
    
    public void confirmBooking (ClassController cc, Classes c, Slot slotBooked, int previousQS){
        cc.bookClass(c, previousQS);
        data.insertNewSlot(slotBooked);
    }

    
    
}
