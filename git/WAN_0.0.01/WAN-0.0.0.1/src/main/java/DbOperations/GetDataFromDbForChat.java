package DbOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Restricted.AimingSky;

public class GetDataFromDbForChat {
	@SuppressWarnings("null")
	public static Message get(String dbName) {
		
		AimingSky as=new AimingSky();
		try {
			 Message data = new Message();
			Class.forName("com.mysql.jdbc.Driver");
			ArrayList<String> message = new ArrayList<String>();
			ArrayList<String> who = new ArrayList<String>();
			Connection conn= DriverManager.getConnection(as.getUrl()+"chatData",as.getUser(),as.getPassword());
			PreparedStatement stm=conn.prepareStatement("select * from "+dbName);
			ResultSet rs=stm.executeQuery();
			while(rs.next()) {
				message.add(rs.getString("message"));
				who.add(rs.getString("chatPerson"));
		}
			data.setMessage(message);
			data.setFrom(who);
			return data;
		}
		catch(Exception e) {return null;}
	}
}
