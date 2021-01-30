package jaggu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Restricted.AimingSky;

public class ChechChat {

	public static boolean check(String myEmail, String yourEmail) {
		AimingSky as=new AimingSky();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection(as.getUrl()+"Aiming",as.getUser(),as.getPassword());
			PreparedStatement stm=conn.prepareStatement("select * from GlobalDb where myemail=? and youremail=?");
			stm.setString(1,myEmail);
			stm.setString(2, yourEmail);
			ResultSet rs=stm.executeQuery();
			rs.next();
			return rs.getString("dbname").isBlank()? false:true ;
		}
		catch(Exception e) {return false;}
}	
	public static String checkCross(String myEmail, String yourEmail) {
		AimingSky as=new AimingSky();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection(as.getUrl()+"Aiming",as.getUser(),as.getPassword());
			PreparedStatement stm=conn.prepareStatement("select * from GlobalDb where myemail=? and youremail=?");
			stm.setString(2,myEmail);
			stm.setString(1, yourEmail);
			ResultSet rs=stm.executeQuery();
			rs.next();
			return (String)rs.getString("dbname") ;
		}
		catch(Exception e) {return "";}
}
public static boolean crossStore(String myEmail, String yourEmail,String tableName) {
		AimingSky as=new AimingSky();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection(as.getUrl()+"Aiming",as.getUser(),as.getPassword());
			Statement stm=conn.createStatement();
			stm.executeUpdate("insert into GlobalDb values('"+myEmail+"','"+yourEmail+"','"+tableName+"')");
			return true;
			}
		catch(Exception e) {return false;}
}
public static boolean createChat(String myEmail, String yourEmail,String tableName) {
		AimingSky as=new AimingSky();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection(as.getUrl()+"Aiming",as.getUser(),as.getPassword());
			Statement stm=conn.createStatement();
			stm.executeUpdate("insert into GlobalDb values('"+myEmail+"','"+yourEmail+"','"+tableName+"')");
			stm.execute("use chatData");
			stm.execute("create table "+tableName+"(chatPerson varchar(50) not null," 
			+ "message varchar(30) not null,id int auto_increment not null,primary key(id));");
			return true;}
		
		catch(Exception e) { return false; }
}
public static boolean check(String yourEmail) {
	
	AimingSky as=new AimingSky();
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn= DriverManager.getConnection(as.getUrl()+"Aiming",as.getUser(),as.getPassword());
		PreparedStatement stm=conn.prepareStatement("select email from login where email=?");
		stm.setString(1, yourEmail);
		ResultSet rs=stm.executeQuery();
		rs.next();
		return rs.getString("email") != null ? true: false ;
		}
	catch(Exception e) { return false; }
}

}