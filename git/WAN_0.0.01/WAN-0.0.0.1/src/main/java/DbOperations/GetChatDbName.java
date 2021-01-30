package DbOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Restricted.AimingSky;

public class GetChatDbName {

	public static String getDbrequest(String myEmail, String yourEmail) {
		AimingSky as=new AimingSky();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection(as.getUrl()+"Aiming",as.getUser(),as.getPassword());
			PreparedStatement stm=conn.prepareStatement("select dbName from GlobalDb"
					+ " where myemail=? and youremail=?");
			stm.setString(1,myEmail);
			stm.setString(2,yourEmail);
			ResultSet rs=stm.executeQuery();
			String dbName=null;
			while(rs.next()) {
	     	dbName = rs.getString("Dbname");
	     	}
			return dbName;
		}
		catch(Exception e) {return null;}
	}

}
