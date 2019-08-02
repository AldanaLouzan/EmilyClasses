package viewInterface;

import bookingclass.controller.ClassController;
import bookingclass.entity.Classes;
import bookingclass.entity.Slot;

/**
 *
 * @author Eoin
 */
public interface ISlot {
    public Slot booking (Classes c, int studentID, String subject, String comment);
    public int calculatePrice(String classType);
    public void confirmBooking (ClassController cc, Classes c, Slot slotBooked, int previousQS);
    
}
