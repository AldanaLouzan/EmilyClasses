package viewInterface;

import bookingclass.entity.Classes;
import java.util.ArrayList;

/**
 *
 * @author Eoin
 */
public interface IClass {
    public ArrayList<Classes> chechClassAvailable(Classes c);
    public int previousQuantityStudents (int classID);
    public void bookClass (Classes c, int previousQS);
    
}
