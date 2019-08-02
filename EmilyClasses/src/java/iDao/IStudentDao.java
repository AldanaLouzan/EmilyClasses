package iDao;

import bookingclass.entity.Student;

/**
 *
 * @author Eoin
 */
public interface IStudentDao {
     public void insertStudentUnder18(Student st);
    public void insertStudentOver18(Student st);
    public boolean checkUser (String email);
    public String checkPass (String email);
    public int selectStudentID(String email);  
    
}
