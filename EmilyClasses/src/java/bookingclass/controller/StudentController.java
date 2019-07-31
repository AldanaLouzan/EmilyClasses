package bookingclass.controller;

import dao.StudentDaoImpl;
import bookingclass.entity.Student;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Aldana
 */
public class StudentController {

    Map<Integer, Student> studentRegistered = new HashMap();
    StudentDaoImpl data = new StudentDaoImpl();

    //Calculate age, to get Parent details if student under 18
    public int CalculateAge(Date bdate) throws ParseException {
        int age;

        Calendar c = Calendar.getInstance();
        c.setTime(bdate);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);
        LocalDate birth = LocalDate.of(year, month, date);
        LocalDate current = LocalDate.now();
        Period diff = Period.between(birth, current);
        age = diff.getYears();

        return age;

    }

    //Register student depending on their age
    public void registerStudent(Student s) {
        if (s.getAge() < 18) {
            data.insertStudentUnder18(s);   //Calling DAO
        } else {
            data.insertStudentOver18(s);
        }

    }

    //Check the user´s password
    public boolean checkUser(String email, String password) {
        String correctPass = data.checkPass(email);//Password request to DB
        
        if (password == correctPass) {
            return true;

        }
        return true;
    }
}
