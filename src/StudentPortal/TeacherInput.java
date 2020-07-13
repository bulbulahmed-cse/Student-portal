package StudentPortal;
import java.io.NotActiveException;
import java.sql.*;

import javax.swing.*;
//public static void main()

public class TeacherInput {
	int counter;
	 public void Insert(String name, String id,String email,String password, int pin,String dept ){
		    try{
		            
		            Connection connection = Dbconnection.dbcon();
		            PreparedStatement ps = connection.prepareStatement("INSERT INTO `teacher` (`Name`, `Id`, `Email`, `Password`, `Security_Pin`, `Department`, `Phone_NO`, `Permanent_ad`, `Present_ad`) VALUES ( ? , ? , ? , ? , ? , ? , '', '', '');");
		            ps.setString(1, name);
		            ps.setString(2, id);
		            ps.setString(3, email);
		            ps.setString(4, password);
		            ps.setInt(5, pin);
		            ps.setString(6, dept);
		            ps.executeUpdate();   
		            //System.out.println("Inserted");
		            JOptionPane.showMessageDialog(null,"Sign Up Successfully");
		            counter=1;
		            
		        }catch(SQLException e){
		            //System.err.println(e.getMessage());
		            JOptionPane.showMessageDialog(null,e.getMessage());
		        }
		    }
		    
	

}
