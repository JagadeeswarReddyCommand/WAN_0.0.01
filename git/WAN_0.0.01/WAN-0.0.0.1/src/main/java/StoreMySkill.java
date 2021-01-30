
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import MyGalary.Store;

@WebServlet("/storeMySkills")
public class StoreMySkill extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		  
		FileItemFactory itemfactory = new DiskFileItemFactory(); 
		ServletFileUpload upload = new ServletFileUpload(itemfactory);
		  try {
	   	    List<FileItem>  items = upload.parseRequest(request);
		    String tag=items.get(0).getString();
		    byte[] files=items.get(1).get();
		    String type=items.get(1).getContentType();
		    if(!type.equalsIgnoreCase("image/jpg") && !type.equalsIgnoreCase("image/jpeg")
		    		&& !type.equalsIgnoreCase("image/png")) 
		    {response.sendRedirect("MyGalary/MySkillError.jsp?error=format error");}
		    else {
			HttpSession hs=request.getSession();
			String email=(String) hs.getAttribute("email");
			String message=Store.store(tag,email,files);
			 if(message.equals("sucess")) {
					response.sendRedirect("Home.jsp");}
				else{
					response.sendRedirect("MyGalary/MySkillError.jsp?error="+ message); }	
		}//for end
		  } catch(Exception ex){response.sendRedirect("MyGalary/MySkillError.jsp?error= "+ex);}
	}
}
//
//String path="";
//File uploadDir = new File("D:\\jag");
//File file = File.createTempFile("imgs",".jpg",uploadDir);
//path=file.getAbsolutePath();
//items.get(1).write(file);
//BufferedImage bImage = ImageIO.read(new File(path));
//ByteArrayOutputStream bos = new ByteArrayOutputStream();
//ImageIO.write(bImage, ".jpg", bos );
//byte[] data = bos.toByteArray();