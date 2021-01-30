
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jaggu.StoreData;

@WebServlet("/StoreChatNewData")
public class StoreChatNewData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ToEmail=request.getParameter("chatNewEntryName");
		HttpSession hs=request.getSession();
		String myEmail= (String) hs.getAttribute("email");
		String messageofChat;
		try{
			messageofChat = StoreData.storeId(myEmail,ToEmail);
			hs.setAttribute("chatNewMessage", messageofChat);	}
		catch (Exception e) {}
		response.sendRedirect("Home.jsp");
	}

}
