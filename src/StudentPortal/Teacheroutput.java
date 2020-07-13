package StudentPortal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Teacheroutput {

	String password;
	String email;
	int pin;
    
    public void Output(String Email) throws SQLException {
        Connection conn = Dbconnection.dbcon();
        Statement statement = conn.createStatement();
        
        ResultSet rs = statement.executeQuery("SELECT * FROM `teacher` WHERE `Email` LIKE '"+Email+"'");
 
        while(rs.next()){
            password = rs.getString("password");
            
            email = rs.getString("email");
            pin= rs.getInt(6);
//            System.out.println(pin);
            
           
        }
        conn.close();
    }
    
}
