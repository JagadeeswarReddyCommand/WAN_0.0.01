package DbOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import Restricted.AimingSky;

public class DeleteVideosFromDb {

	public static boolean deleteData(String email,String id){
		AimingSky as=new AimingSky();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection(as.getUrl()+"Aiming",as.getUser(),as.getPassword());
			Statement stm=conn.createStatement();
			String sql="delete  from urls where email='"+email+"' and id="+id;
			stm.execute(sql);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public static boolean deleteDataAll(String email,String id){
		AimingSky as=new AimingSky();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbName=GetDbName.getDbName(email);
			Connection conn= DriverManager.getConnection(as.getUrl()+dbName,as.getUser(),as.getPassword());
			Statement stm=conn.createStatement();
			DeleteVideosFromDb.deleteData(email, id);
			stm.execute("delete from urls where email='"+email+"' and id="+id);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
