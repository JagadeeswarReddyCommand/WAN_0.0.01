package DbOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import Restricted.AimingSky;

public class StoreFeedBack {
	public static boolean store(String message) { 
		 AimingSky as=new AimingSky();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=null;
			PreparedStatement pstmt = null;
			conn=DriverManager.getConnection(as.getUrl()+"Aiming", as.getUser(), as.getPassword());
			pstmt = conn.prepareStatement("insert into feedback(message) values(?)");
			pstmt.setString(1, message);
			pstmt.execute();
			return true;
		 }
			catch(Exception e){return false;	}
	}

}
