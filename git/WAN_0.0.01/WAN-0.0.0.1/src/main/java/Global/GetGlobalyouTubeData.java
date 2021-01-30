package Global;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import DbOperations.GetName;
import Restricted.AimingSky;

public class GetGlobalyouTubeData {
	public YoutubeDataReturnForGlobal myYouTubeData(String email){
	AimingSky as=new AimingSky();
	ArrayList<String> HomeList=new ArrayList<String>();
	ArrayList<Integer> HomeListId=new ArrayList<Integer>();
	ArrayList<String> HomeListName=new ArrayList<String>();
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn= DriverManager.getConnection(as.getUrl()+"Aiming",as.getUser(),as.getPassword());
		Statement stm=conn.createStatement();   
		String sql="select * from urls where email='"+email+"'";
		ResultSet rs=stm.executeQuery(sql);
		while(rs.next()) {
			HomeListId.add(rs.getInt("id"));
			HomeList.add(rs.getString("url"));
			String name=GetName.getName(rs.getString("email"));
			HomeListName.add(name);
		}
		YoutubeDataReturnForGlobal obj=new YoutubeDataReturnForGlobal();
		obj.setHomeListId(HomeListId);
		obj.setHomeListName(HomeListName);
		obj.setHomeList(HomeList);
		return obj;
	}
	catch(Exception e) {}
	return null;
}
}
