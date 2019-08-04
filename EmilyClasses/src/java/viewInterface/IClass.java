package viewInterface;

import bookingclass.entity.Classes;
import java.util.ArrayList;

public interface IClass {
    public ArrayList<Classes> checkClassAvailable(Classes c);
    public int previousQuantityStudents (int classID);
    public void bookClass (Classes c, int previousQS);
}
