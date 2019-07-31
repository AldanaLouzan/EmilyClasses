package dao;

import static bookingclass.connectionDb.DBConnection.getConnection;
import bookingclass.entity.Student;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDaoImpl
        
{
    PreparedStatement pst;
    Statement st; 
    ResultSet rs;
    
    //----Insert Student under 18----//
    public void insertStudentUnder18(Student st) {
        Connection con = null;
        
        String sql = "INSERT INTO STUDENT (s_name, s_surname, phone, email, birth, age, college, level, idparent, password) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";

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
            
            int res = pst.executeUpdate();
            
            if(res > 0){
                System.out.println("You have been registered");
            }else{
                System.out.println("Error");
            }
            
            //con.commit();
            con.close();
            
    
        } catch (Exception e) {
            System.err.println(e);
        }


    }
    
    //----Insert Student Over 18, without paretn details----//
        public void insertStudentOver18(Student st) {
        Connection con = null;
        String sql = "INSERT INTO STUDENT (age, birth, college, email, level, phone, s_name, s_surname, password) "
                + "VALUES(?,?,?,?,?,?,?,?,?)";

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
           
            int res = pst.executeUpdate();
            
            if(res > 0){
                 System.out.println("You have been registered");
            }else{
                System.out.println("Error");
            }
            
            //con.commit();
            con.close();
    
        } catch (Exception e) {
            System.err.println(e);
        }
        
        
    }
        
        //Request password
        public String checkPass (String email){
        String pass = null;
        Connection con = null;
        String sql = "SELECT password FROM student WHERE email = '"+email+"';";
        
        try{
            con = getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                pass = rs.getString("password");
            }
            //con.commit();
            con.close();
            
        }catch (Exception e) {
            System.err.println(e);
        }
        return pass;
            
        }
        

}
