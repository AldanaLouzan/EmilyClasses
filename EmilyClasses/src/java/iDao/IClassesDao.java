package iDao;

import bookingclass.entity.Classes;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Eoin
 */
public interface IClassesDao {
    public ResultSet selectEmptyClass(Date d);
    //public ArrayList<Classes> selectSemiprivateClass(Date d);
    public ResultSet selectSemiprivateClass(Date d);
    public boolean book(Classes c);
    public void insertQuantityStudents(Classes c, int qs);
    public int selectTimeChosen (int classId);
    
}
