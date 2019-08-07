package viewInterface;

import bookingclass.entity.Teacher;

public interface ITeacher {
    public boolean registerTeacher (Teacher t);
    public boolean checkTeacher(String email);
    public boolean checkTeacherPassword(String email, String password);
    
}
