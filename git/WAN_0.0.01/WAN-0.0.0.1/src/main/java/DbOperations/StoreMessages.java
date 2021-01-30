package DbOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import Restricted.AimingSky;

public class StoreMessages {
	public static boolean store(String email, String message, String tableName) {
		 AimingSky as=new AimingSky();
		 String url=as.getUrl()+"chatData";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=null;
			PreparedStatement pstmt = null;
			conn=DriverManager.getConnection(url, as.getUser(), as.getPassword());
			pstmt = conn.prepareStatement("insert into "+tableName+"(chatPerson,message) values(?,?)");
			pstmt.setString(1, email);
			pstmt.setString(2, message);
			pstmt.execute();
			return true;
		 }
			catch(Exception ex){	return false;	}
	}

}
