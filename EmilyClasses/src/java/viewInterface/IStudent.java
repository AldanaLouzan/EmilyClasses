package viewInterface;

import bookingclass.entity.Student;
import java.text.ParseException;
import java.util.Date;

public interface IStudent {
    public int CalculateAge(String birth) throws ParseException;
    public boolean studentUnder18(int age);
    public boolean registerStudent(Student s);
    public boolean checkUser(String email);
    public boolean checkUserPassword(String email, String password);
    public int checkStudentId(String email); 
}
