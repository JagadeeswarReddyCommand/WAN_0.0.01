package jaggu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import Restricted.AimingSky;

public class GetHomeData {

	AimingSky as=new AimingSky();
	public ArrayList<String> homeData(String MyEmail){
	ArrayList<String> HomeList=new ArrayList<String>();
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn= DriverManager.getConnection(as.getUrl()+"Aiming",as.getUser(),as.getPassword());
		Statement stm=conn.createStatement();   
		String sql="select * from GlobalDb where myemail='"+MyEmail+"'";
		ResultSet rs=stm.executeQuery(sql);
		while(rs.next()) {
			HomeList.add(rs.getString("youremail"));
		}
		return HomeList;
	}
	catch(Exception e) {}
	return HomeList;
	}
}
