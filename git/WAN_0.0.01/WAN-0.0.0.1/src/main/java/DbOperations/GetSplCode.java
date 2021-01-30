package DbOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Restricted.AimingSky;

public class GetSplCode {

	public static String getSplCode(String email) {
		AimingSky as=new AimingSky();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection(as.getUrl()+"Aiming",as.getUser(),as.getPassword());
			PreparedStatement stm=conn.prepareStatement("select * from login where email=?");
			stm.setString(1,email);
			ResultSet rs=stm.executeQuery();
			String splcode=null;
			while(rs.next()) {
	     	splcode = rs.getString("splcode");break;}
			return splcode;
		}
		catch(Exception e) {return null;}
		}
	
}
