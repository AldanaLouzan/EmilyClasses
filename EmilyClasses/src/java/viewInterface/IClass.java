package viewInterface;

import bookingclass.entity.Classes;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public interface IClass {
    public ResultSet checkClassAvailable(String classType, String date) throws ParseException;
    //public ResultSet checkClassAvailable(String classType, Date date);
    public int selectTime (int classId);
    public int quantityStudents (String typeClass, int groupQuantity, int previousQuantity);
    public int previousQuantityStudents (int classID);
    public boolean bookClass (Classes c);
}
