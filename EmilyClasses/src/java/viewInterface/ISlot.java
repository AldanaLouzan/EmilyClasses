package viewInterface;

import bookingclass.controller.ClassController;
import bookingclass.entity.Classes;
import bookingclass.entity.Slot;

public interface ISlot {
    public Slot booking (Classes c, int studentID, String subject, String comment);
    public int calculatePrice(String classType);
    public boolean bookSlot (Slot s);   
    public String defineSubject(String subject);
    public int getIdSlotByParameters(Slot s);
}
