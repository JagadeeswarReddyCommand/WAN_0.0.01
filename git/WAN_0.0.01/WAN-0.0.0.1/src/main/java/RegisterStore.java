import java.sql.*;
import java.util.Random;

import Restricted.AimingSky;
import jaggu.CreteUserDb;

public class RegisterStore {
	
	
	public boolean newReg(Register reg){
		 AimingSky as=new AimingSky();
		try {
			Random rn=new Random();
		    int number=rn.nextInt(500000);
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection(as.getUrl()+"Aiming",as.getUser(),as.getPassword());
			PreparedStatement stm=conn.prepareStatement
					("insert into login values(?,?,?,?,?)");
			stm.setString(2, reg.getEmail());
			stm.setString(3, reg.getPassword(reg.getEmail()));
			stm.setString(1, reg.getName());
			stm.setString(4, reg.getSplcode());
			stm.setString(5, "Users"+number);
			stm.executeUpdate();
			return CreteUserDb.creteUserDb(number);
		 }
		catch(Exception e) { return false;}  
	 }
	
}
