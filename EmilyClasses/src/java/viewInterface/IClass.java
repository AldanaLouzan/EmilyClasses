package viewInterface;

import bookingclass.entity.Classes;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public interface IClass {
    //public ResultSet checkClassAvailable(String classType, String date) throws ParseException;
    public ResultSet checkClassAvailable(String classType, Date date);
    public int quantityStudents (String typeClass, int groupQuantity);
    public int previousQuantityStudents (int classID);
    public void bookClass (Classes c, int previousQS);
}
