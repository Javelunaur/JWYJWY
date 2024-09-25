package sqltest_jwy;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLTEST_JWY {
    
    //Connection Method to SQLITE
public static Connection connectDB() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC"); // Load the SQLite JDBC driver
            con = DriverManager.getConnection("jdbc:sqlite:javeluna.db"); // Establish connection
            System.out.println("Connection Successful");
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e);
        }
        return con;
    }
    public static void main(String[] args) {
        connectDB();
        Scanner n = new Scanner(System.in);
        
        System.out.println("Enter Student First Name: ");
        String fname = n.nextLine();
        System.out.println("Enter Student Last Name: ");
        String lname = n.nextLine();
        System.out.println("Enter Student Contact: ");
        String contact = n.nextLine();
        System.out.println("Enter Student Status: ");
        String stat = n.nextLine();
        
        String sql = "INSERT INTO students (f_name, l_name, s_contact, s_stat) VALUES (?, ?, ?, ?)";
        
        try{
            Connection con = connectDB();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, fname);
            pst.setString(2, lname);
            pst.setString(3, contact);
            pst.setString(4, stat);
            pst.executeUpdate();
            System.out.println("Successfully Inserted!");      
    }catch(SQLException ex){
            System.out.println("Connection Error: "+ex.getMessage());
    }
    
    }
    
}
//jarfile - conect data bae and netbeans