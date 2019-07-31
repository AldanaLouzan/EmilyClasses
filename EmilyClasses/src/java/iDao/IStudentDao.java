package iDao;

import bookingclass.entity.Student;

/**
 *
 * @author Eoin
 */
public interface IStudentDao {
    public void insertStudentUnder18(Student st);
    public void insertStudentOver18(Student st);
    public String checkPass (String email);
    
}
