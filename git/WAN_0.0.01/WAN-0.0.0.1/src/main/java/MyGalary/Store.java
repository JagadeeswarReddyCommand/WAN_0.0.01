package MyGalary;
import java.sql.*;

import Restricted.AimingSky;

public class Store {
	
	public static String store(String tag, String email, byte[] files) {
		 AimingSky as=new AimingSky();
		String url=as.getUrl()+"Aiming";
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=null;
		PreparedStatement pstmt = null;
		conn=DriverManager.getConnection(url, as.getUser(), as.getPassword());
		pstmt = conn.prepareStatement("insert into image(email,tag,files) values(?,?,?)");
		pstmt.setString(1, email);
		pstmt.setString(2, tag);
		pstmt.setBytes(3, files);
		return pstmt.executeUpdate()>0?"sucess":"something error";
	 }
		catch(Exception ex){ return "error "+ex;}
} }


//File image=new File(file);
//FileInputStream fis=new FileInputStream(image);
//pstmt.setBinaryStream(3, (InputStream) fis, (int) (image.length()));