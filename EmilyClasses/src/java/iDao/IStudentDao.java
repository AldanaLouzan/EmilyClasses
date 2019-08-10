package iDao;

import bookingclass.entity.Student;

public interface IStudentDao {
    public boolean insertStudentUnder18(Student st);
    public boolean insertStudentOver18(Student st);
    public boolean checkUser (String email);
    public String checkPass (String email);
    public int selectStudentID(String email);  
    public String selectStudentName(int studentId);
    public Student getStudent(int studentId);
}
