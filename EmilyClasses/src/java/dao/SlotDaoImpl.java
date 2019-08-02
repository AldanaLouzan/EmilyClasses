/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static bookingclass.connectionDb.DBConnection.getConnection;
import bookingclass.entity.Slot;
import iDao.ISlotDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Eoin
 */
public class SlotDaoImpl implements ISlotDao {
       PreparedStatement pst;
    ResultSet rs;
    
    public void insertNewSlot (Slot s){
        Connection con = null;
        
        String sql = "INSERT INTO slot (idclasses, idstudent, comment, price, status, subject) "
                + "VALUES(?,?,?,?,?,?)";

        try {
            
            con = getConnection();
            pst = con.prepareStatement(sql);

            pst.setInt(1, s.getClasses().getId());
            pst.setInt(2, s.getStudentID());
            pst.setString(3, s.getComment());
            pst.setInt(4, s.getPrice());
            pst.setString(5, s.getStatus());
            pst.setString(6, s.getSubject());
            
            int res = pst.executeUpdate();
            
            if(res > 0){
                System.out.println("You have been registered");
            }else{
                System.out.println("Error");
            }
            
            
            con.close();
            
    
        } catch (Exception e) {
            System.err.println(e);
        }


    }
    
        
    
}
