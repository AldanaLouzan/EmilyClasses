package bookingclass.controller;

import dao.StudentDaoImpl;
import bookingclass.entity.Student;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import viewInterface.IStudent;

/**
 *
 * @author Aldana
 */
public class StudentController implements IStudent {

    Map<Integer, Student> studentRegistered = new HashMap();
    StudentDaoImpl data = new StudentDaoImpl();

    //Calculate age, to get Parent details if student under 18
    public int CalculateAge(String birth) throws ParseException {
        Date bdate =  new Date ();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        bdate = sdf.parse(birth);
        int age;

        Calendar c = Calendar.getInstance();
        c.setTime(bdate);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);
        LocalDate birthday = LocalDate.of(year, month, date);
        LocalDate current = LocalDate.now();
        Period diff = Period.between(birthday, current);
        age = diff.getYears();

        return age;

    }
    
    public boolean studentUnder18(int age){
        if (age < 18){
            return true;
        }
        return false;
    }

    //Register student depending on their age
    public boolean registerStudent(Student s) {
        if (s.getAge() < 18) {
            return data.insertStudentUnder18(s);   //Calling DAO
        } else {
            return data.insertStudentOver18(s);
        }

    }

     public boolean checkUser(String email)  {
        boolean registeredUser = data.checkUser(email);//Password request to DB
        return registeredUser;
        
    }
   //Check the user´s password

    /**
     *
     * @param email
     * @param password
     * @return
     */
    @Override
    public boolean checkUserPassword(String email, String password) {
        String correctPass = data.checkPass(email);//Password request to DB
        
        if (password.equals(correctPass)) {
            return true;

        }
        return false;
        
    }
    
     public int checkStudentId(String email){
        int studentID = data.selectStudentID(email);
        return studentID;
        
    }
     
     public String checkStudentName(int studentId){
        String studentName = data.selectStudentName(studentId);
        return studentName;
        
    }
     
    public Student getStudent(int idStudent){
        return data.getStudent(idStudent);
    }
}
