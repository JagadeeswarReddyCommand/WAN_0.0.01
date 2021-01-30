
import java.sql.*;
import DbOperations.*;
import Restricted.AimingSky;

public class ValidateLogin {
	 static boolean validate(Login log) {
		 AimingSky as=new AimingSky();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection(as.getUrl()+"Aiming",as.getUser(),as.getPassword());
			PreparedStatement stm=conn.prepareStatement
					("select * from login where email=? and password=?");
			stm.setString(1, log.getEmail());
			stm.setString(2, GetEncryptedPassword.getEncryptedPassword(log.getPassword(),log.getEmail()));
			ResultSet rs=stm.executeQuery();
			while(rs.next()) {
				return true;
			}
		}
 		catch(Exception e) {return false;}
		return false;
	 }
}