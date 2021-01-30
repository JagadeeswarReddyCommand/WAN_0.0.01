import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getImage")
public class GetImage extends HttpServlet {
	
private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

Connection con = null;
Statement stmt = null;
ResultSet rs = null;
ServletOutputStream sos=response.getOutputStream();
try {
	
    Class.forName("com.mysql.jdbc.Driver");
    con =DriverManager.getConnection("jdbc:mysql://localhost:3306/Aiming","root","Sri@14378");
    stmt = con.createStatement();
    rs = stmt.executeQuery("select * from image where id="+request.getParameter("id"));
    rs.next();
    sos.write(rs.getBytes("files"));
} catch(Exception e) {}
	}

}
