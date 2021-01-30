
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DbOperations.StoreYouTube;


@WebServlet("/MyYoutubeUpload")
public class MyYoutubeUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	if(request.getSession().getAttribute("email").equals(null)) {
		request.getSession().setAttribute("message",
				"email not found login again<a href=\"login.jsp\">Login</a>");
		response.sendRedirect("error.jsp");
	}
	if(request.getParameter("decession").equals("G")) {
		if(StoreYouTube.store(request.getParameter("url"),
			request.getParameter("category"),
			(String)request.getSession().getAttribute("email") )){
			response.sendRedirect("MyGalary/MyYouTubeVideos.jsp");	}
		else {response.sendRedirect("MyGalary/MyYouTube.jsp");}
	}
	else if(request.getParameter("decession").equals("P")){
		if(StoreYouTube.storePersonal(request.getParameter("url"),
				request.getParameter("category"),
				(String)request.getSession().getAttribute("email") )){
				response.sendRedirect("MyGalary/MyYouTubeVideos.jsp");	}
			else {response.sendRedirect("MyGalary/MyYouTube.jsp");}
		}
	}
  }
