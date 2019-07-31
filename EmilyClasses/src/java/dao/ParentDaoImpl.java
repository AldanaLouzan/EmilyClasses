package dao;

import static bookingclass.connectionDb.DBConnection.getConnection;
import bookingclass.entity.Parent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ParentDaoImpl {
    PreparedStatement pst;
    ResultSet rs;
    
    //Insert Parent Details
    public void insertParent(Parent p) {
        Connection con = null;
        
        String sql = "INSERT INTO  PARENT(idparent, p_name, p_surname, phone) "
                + "VALUES(?,?,?,?)";

        try {
            
            con = getConnection();
            pst = con.prepareStatement(sql);
            
            pst.setInt(1, p.getIdParent());
            pst.setString(2, p.getName());
            pst.setString(3, p.getSurname());
            pst.setString(4, p.getPhone());
            
            int res = pst.executeUpdate();
            
            if(res > 0){
                System.out.println("Your parent´s details have been saved");
            }else{
                System.out.println("Error");
            }
            
            //con.commit();
            
            con.close();
            
    
        } catch (Exception e) {
            System.err.println(e);
        }


    }
}
