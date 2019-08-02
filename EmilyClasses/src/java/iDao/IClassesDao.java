package iDao;

import bookingclass.entity.Classes;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Eoin
 */
public interface IClassesDao {
    public ArrayList<Classes> selectEmptyClass(Date d);
    public ArrayList<Classes> selectSemiprivateClass(Date d);
    public void book(Classes c);
    public void insertQuantityStudents(Classes c, int qs);
    
}
