package iDao;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Eoin
 */
public interface IClassesDao {
    public ArrayList<Integer> selectEmptyClass(Date d);
    public ArrayList<Integer> selectSemiprivateClass(Date d);
    
}
