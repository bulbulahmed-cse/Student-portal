package StudentPortal;
import java.sql.*;

public class StudentOutput {
	
	String password;
	String email;
    
    public void Output(String Email) throws SQLException {
        Connection conn = Dbconnection.dbcon();
        Statement statement = conn.createStatement();
        
        ResultSet rs = statement.executeQuery("SELECT * FROM `student` WHERE `Email` LIKE '"+Email+"'");
 
        while(rs.next()){
            password = rs.getString("password");
            
            email = rs.getString("email");
            
           
        }
        conn.close();
    }
    
}