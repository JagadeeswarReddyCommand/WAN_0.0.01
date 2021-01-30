package Global;

import java.sql.*;


public class ReturnGlobalTalents {
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
public String getEmail(Long id) {
try {
    Class.forName("com.mysql.jdbc.Driver");
    con =DriverManager.getConnection("jdbc:mysql://localhost:3306/Aiming","root","Sri@14378");
    stmt = con.createStatement();
    rs = stmt.executeQuery("select * from image where id="+id);
    rs.next();
    return rs.getString("email");
} catch(Exception e) {}
return null;
}
public String getTag(Long id) {
try {
    Class.forName("com.mysql.jdbc.Driver");
    con =DriverManager.getConnection("jdbc:mysql://localhost:3306/Aiming","root","Sri@14378");
    stmt = con.createStatement();
    rs = stmt.executeQuery("select * from image where id="+id);
    rs.next();
    return rs.getString("tag");
} catch(Exception e) {}
return null;
}
public long count() {
try {
    Class.forName("com.mysql.jdbc.Driver");
    con =DriverManager.getConnection("jdbc:mysql://localhost:3306/Aiming","root","Sri@14378");
    stmt = con.createStatement();
    rs = stmt.executeQuery("select id from image order by id desc");
    rs.next();
    return Long.parseLong(rs.getString("id"));
} catch(Exception e) {return 0;}
}

public long count(String email) {
try {
    Class.forName("com.mysql.jdbc.Driver");
    con =DriverManager.getConnection("jdbc:mysql://localhost:3306/Aiming","root","Sri@14378");
    stmt = con.createStatement();
    rs = stmt.executeQuery("select id from image where email='"+email+"' order by id desc");
    rs.next();
    return Long.parseLong(rs.getString("id"));
} catch(Exception e) {return 0;}
}
}