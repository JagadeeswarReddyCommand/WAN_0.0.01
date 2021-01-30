package jaggu;

import java.sql.*;
import Restricted.AimingSky;
public class CreteUserDb {
	
	   public static boolean creteUserDb(int me) {
	   AimingSky as=new AimingSky();
	  
	   try{
		  Connection conn = null;
		  Statement stmt = null;
	      Class.forName("com.mysql.jdbc.Driver");
	      conn = DriverManager.getConnection(as.getUrl(),as.getUser(),as.getPassword());
	      stmt = conn.createStatement();
	      String sql = "CREATE DATABASE Users"+me;
	      stmt.executeUpdate(sql);
	      String sql2 = "CREATE table UsersChat(ChatEmailFrom varchar(50) not null,"
	      		+ "ChatEmailTo varchar(50) not null,"
	      		+ "ChatAddress varchar(50) not null,"
	      		+ "primary key(ChatEmailFrom,ChatEmailTo,ChatAddress),"
	      		+ "unique(ChatEmailTo))";
	      stmt.execute("use Users"+me);
	      stmt.execute(sql2);
	      stmt.execute("create table urls(email varchar(50) not null,url varchar(100) not null,category varchar(10) not null,"
	      		+ "id int not null auto_increment,primary key(id),unique(id))");
	      return true;
	   }catch(Exception e){return false;}
	   }
	}
