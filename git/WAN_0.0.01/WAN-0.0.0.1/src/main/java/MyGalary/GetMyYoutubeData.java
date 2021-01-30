package MyGalary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DbOperations.GetDbName;
import Restricted.AimingSky;

public class GetMyYoutubeData {

	public YoutubeDataReturn myYouTubeData(String email){
		AimingSky as=new AimingSky();
		ArrayList<String> HomeList=new ArrayList<String>();
		ArrayList<Integer> HomeListId=new ArrayList<Integer>();
		try {
			String dbName=GetDbName.getDbName(email);
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection(as.getUrl()+dbName,as.getUser(),as.getPassword());
			Statement stm=conn.createStatement();   
			String sql="select * from urls where email='"+email+"'";
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next()) {
				HomeListId.add(rs.getInt("id"));
				HomeList.add(rs.getString("url"));
			}
			YoutubeDataReturn obj=new YoutubeDataReturn();
			obj.setHomeListId(HomeListId);
			obj.setHomeList(HomeList);
			return obj;
		}
		catch(Exception e) {}
		return null;
	}
}
