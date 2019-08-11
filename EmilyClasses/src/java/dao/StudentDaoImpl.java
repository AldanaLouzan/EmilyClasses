package dao;

import static bookingclass.connectionDb.DBConnection.getConnection;
import bookingclass.entity.Parent;
import bookingclass.entity.Student;
import bookingclass.entity.Teacher;
import iDao.IStudentDao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class StudentDaoImpl implements IStudentDao {

    PreparedStatement pst;
    Statement st;
    ResultSet rs;

    //----Insert Student under 18----//
    public boolean insertStudentUnder18(Student st) {
        Connection con = null;
        boolean value;

        String sql = "INSERT INTO student"
                + "(s_name, s_surname, phone, email, birth, age, college, level, idparent, password, idteacher) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        try {

            con = getConnection();
            pst = con.prepareStatement(sql);

            pst.setString(1, st.getName());
            pst.setString(2, st.getSurname());
            pst.setString(3, st.getPhone());
            pst.setString(4, st.getEmail());
            pst.setDate(5, Date.valueOf(st.getBirth()));
            pst.setInt(6, st.getAge());
            pst.setString(7, st.getCollege());
            pst.setString(8, st.getLevel());
            pst.setInt(9, st.getParent().getIdParent());
            pst.setString(10, st.getPassword());
            //pst.setInt(11, st.getTeacher().getId());
            pst.setInt(10, 1);  //For now it will be teacherid = 1, as it is just one teacher
            
            int res = pst.executeUpdate();

            if (res > 0) {
                System.out.println("You have been registered");
                value = true;
            } else {
                System.out.println("Error");
                value = false;
            }

            con.close();
            return value;

        } catch (Exception e) {
            System.err.println(e);
            return false;
        }

    }

    //----Insert Student Over 18, without paretn details----//
    public boolean insertStudentOver18(Student st) {
        Connection con = null;
        boolean value;
        String sql = "INSERT INTO STUDENT (age, birth, college, email, level, phone, s_name, s_surname, password, idteacher) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";

        try {

            con = getConnection();
            pst = con.prepareStatement(sql);

            pst.setInt(1, st.getAge());
            pst.setDate(2, Date.valueOf(st.getBirth()));
            pst.setString(3, st.getCollege());
            pst.setString(4, st.getEmail());
            pst.setString(5, st.getLevel());
            pst.setString(6, st.getPhone());
            pst.setString(7, st.getName());
            pst.setString(8, st.getSurname());
            pst.setString(9, st.getPassword());
            //pst.setInt(10, st.getTeacher().getId());
            pst.setInt(10, 1);  //For now it will be teacherid = 1, as it is just one teacher

            int res = pst.executeUpdate();

            if (res > 0) {
                System.out.println("You have been registered");
                value = true;

            } else {
                System.out.println("Error");
                value = false;
            }
            con.close();
            return value;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }

    }

    //check User
    public boolean checkUser(String email) {
        Connection con = null;
        String registeredUser = null;

        String sql = "SELECT email "
                + "FROM student "
                + "WHERE email = '" + email + "';";

        try {
            con = getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                registeredUser = rs.getString("email");
                if (registeredUser != null) {
                    return true;
                } else {
                    con.close();
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;

    }

    //Request password
    public String checkPass(String email) {
        Connection con = null;
        String pass = null;

        String sql = "SELECT password "
                + "FROM student "
                + "WHERE email = ?";

        try {
            con = getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, email);
            rs = pst.executeQuery();

            while (rs.next()) {
                pass = rs.getString("password");
            }

            con.close();

        } catch (Exception e) {
            System.err.println(e);
        }
        return pass;

    }

    public int selectStudentID(String email) {
        int studentID = 0;
        Connection con = null;
        String sql = "SELECT "
                + "idstudent "
                + "FROM student "
                + "WHERE email = '" + email + "';";

        try {
            con = getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                studentID = rs.getInt("idstudent");
            }
            con.close();

        } catch (Exception e) {
            System.err.println(e);
        }

        return studentID;

    }
    
    public String selectStudentName(int studentId) {
        String name = null;
        Connection con = null;
        String sql = "SELECT "
                + "s_name "
                + "FROM student "
                + "WHERE idstudent = '" + studentId + "';";

        try {
            con = getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                name = rs.getString("s_name");
            }
            con.close();

        } catch (Exception e) {
            System.err.println(e);
        }

        return name;

    }
    
    public Student getStudent(int studentId) {
        Student stu = null;
        Parent par = new Parent();
        Teacher tea = new Teacher();
        //Fields
        String name = null;
        String surname = null;
        String password = null;
        String college = null;
        String email = null;
        String level = null;
        int phone = 0;
        int age = 0;
        int idparent = 0;
        int idteacher = 0;
        Date birth = null;
                     
        Connection con = null;
        String sql = "SELECT "
                + "s_name,  s_surname, age, birth, college, email, level, phone, idparent, password, idteacher "
                + "FROM student "
                + "WHERE idstudent = '" + studentId + "';";
        try {
            con = getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                name = rs.getString("s_name");
                surname = rs.getString("s_surname");
                age = rs.getInt("age");
                birth = rs.getDate("birth");
                college = rs.getString("college");
                email = rs.getString("email");
                level = rs.getString("level");
                phone = rs.getInt("phone");
                idparent = rs.getInt("idparent");
                password = rs.getString("password");
                idteacher = rs.getInt("idteacher");
            }
            //Generate one Teacher and one Parent for the Constructor...
            par.setIdParent(idparent);
            tea.setId(idteacher);
            //Parse Date to String
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String birthAsString = sdf.format(birth);
            //Parse Phone Int To String
            String phoneToString = Integer.toString(phone);
            
            stu = new Student(birthAsString, age, college, level, par, tea, studentId, email, password, phoneToString, name, surname);
            
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return stu;
    }
    
}
