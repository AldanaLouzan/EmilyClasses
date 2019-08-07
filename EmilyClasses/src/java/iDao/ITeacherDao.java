package iDao;

import bookingclass.entity.Teacher;

public interface ITeacherDao {
    public boolean insertTeacher(Teacher t);
    public boolean checkUser(String email);
    public String checkPass (String email); 
    
}
