package viewInterface;

import bookingclass.entity.Student;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author Eoin
 */
public interface IStudent {
    public int CalculateAge(Date bdate) throws ParseException;
    public boolean studentUnder18(int age);
    public void registerStudent(Student s);
    public boolean checkUser(String email);
    public boolean checkUserPassword(String email, String password);
    public int checkStudentId(String email);
     
    
    
}
