package bookingclass.connectionDb;

import java.sql.Connection;
import java.sql.*;
 
public class DBConnection {

    //----Connecion with DataBase: emilyclasses----//
    
    private static Connection connection = null;
    private static String url = "jdbc:mysql://localhost:3306/emilyclasses";
    private static String user = "root";
    private static String pass = "";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection successful");
        } catch (SQLException ex) {
            System.out.println("Database exception: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("General exception: " + ex.getMessage());
        } 
      
        return connection;

    }
    

}
