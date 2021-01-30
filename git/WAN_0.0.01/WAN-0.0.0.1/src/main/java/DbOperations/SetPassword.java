package DbOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import Restricted.AimingSky;

public class SetPassword { 

	public static boolean setPass(String email, String password) {
		AimingSky as=new AimingSky();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection(as.getUrl()+"Aiming",as.getUser(),as.getPassword());
			Statement stm=conn.createStatement();
			password=GetEncryptedPassword.getEncryptedPassword(password, email);
			stm.execute("update login set password='"+password+"' where email='"+email+"'");
			return true;
		}
		catch(Exception e) {return false;}
	}

}
