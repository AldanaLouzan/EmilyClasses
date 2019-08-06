package bookingclass.controller;

import bookingclass.entity.Teacher;

/**
 *
 * @author Eoin
 */
public class TeacherController {
    Teacher t = new Teacher ();
    
    public Teacher createTeacher (){
        int id = 3010;
        String name = "Emily";
        String surname = "Loudi";
        String email = "emily.loudi@gmail.com";
        String password = "loveMaths";
        
        t.setIdTeacher(id);
        t.setName(name);
        t.setSurname(surname);
        t.setEmail(email);
        t.setPassword(password);
                
        return t;
    }
    
    public boolean checkTeacher (String email){
        if (email.equals(t.getEmail())){
            return true;    
        }
        
        return false;
    }
    
    public boolean checkTeacherPass (String pass){
        if (pass.equals(t.getPassword())){
            return true;
        }
        return false;
    }
}
