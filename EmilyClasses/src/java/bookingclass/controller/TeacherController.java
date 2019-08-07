package bookingclass.controller;

import bookingclass.entity.Teacher;
import dao.TeacherDaoImpl;
import viewInterface.ITeacher;


public class TeacherController implements ITeacher {
    TeacherDaoImpl data = new TeacherDaoImpl();
    
    
    public boolean registerTeacher (Teacher t){
        return data.insertTeacher(t);
    }
    
    public boolean checkTeacher(String email) {
        boolean registeredTeacher = data.checkUser(email);//Password request to DB
        return registeredTeacher; 
    }

    
    public boolean checkTeacherPassword(String email, String password) {
        String correctPass = data.checkPass(email);//Password request to DB
        
        if (password.equals(correctPass)) {
            return true;

        }
        return false;
        
    }
}
