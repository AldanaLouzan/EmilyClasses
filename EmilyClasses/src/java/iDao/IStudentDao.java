package iDao;

import bookingclass.entity.Student;

/**
 *
 * @author Eoin
 */
public interface IStudentDao {
     public boolean insertStudentUnder18(Student st);
    public boolean insertStudentOver18(Student st);
    public boolean checkUser (String email);
    public String checkPass (String email);
    public int selectStudentID(String email);  
    public String selectStudentName(int studentId);
    
}
