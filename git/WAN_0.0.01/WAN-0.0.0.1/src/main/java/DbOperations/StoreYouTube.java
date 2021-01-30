package DbOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import Restricted.AimingSky;

public class StoreYouTube {

	public static boolean store(String url, String category, String email) {
		
		AimingSky as=new AimingSky();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection(as.getUrl()+"Aiming",as.getUser(),as.getPassword());
			Statement stm=conn.createStatement();
			stm.execute("insert into urls(email,url,category) values('"+email+"','"+url+"','"+category+"')");
			if(StoreYouTube .storePersonal(url, category, email)) {}
			return true;
		}
		catch(Exception e) {return false;}
	}
public static boolean storePersonal(String url, String category, String email) {	
		AimingSky as=new AimingSky();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbName=GetDbName.getDbName(email);
			Connection conn= DriverManager.getConnection(as.getUrl()+dbName,as.getUser(),as.getPassword());
			Statement stm=conn.createStatement();
			stm.execute("insert into urls(email,url,category) values('"+email+"','"+url+"','"+category+"')");
			return true;
		}
		catch(Exception e) {return false;}
	}
}
