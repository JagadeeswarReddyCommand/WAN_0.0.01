package DbOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Restricted.*;
public class GetName {
	public static String getName(String email) {
		AimingSky as=new AimingSky();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection(as.getUrl()+"Aiming",as.getUser(),as.getPassword());
			PreparedStatement stm=conn.prepareStatement("select * from login where email=?");
			stm.setString(1,email);
			ResultSet rs=stm.executeQuery();
			String Name=null;
			while(rs.next()) {
	     	Name = rs.getString("name");break;}
			return Name;
		}
		catch(Exception e) {return null;}
		}
	
}
