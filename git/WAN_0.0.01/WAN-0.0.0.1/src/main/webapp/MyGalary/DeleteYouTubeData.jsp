<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="deleteYouTubeData.css" rel="stylesheet"/>
</head>
<body>
<% 
HttpSession hs=request.getSession();
try{
if(hs.getAttribute("email").equals(null)){response.sendRedirect("../login.jsp");}}
catch(Exception e){response.sendRedirect("../login.jsp");}
%>
<br>
<br>
<form action="../deleteVideos" method="post">
<text>Id of video</text>
<input type="number" name="id" required/><br><br>
<text>choice of delete</text><br>
<input type="radio" name="choice" value="G" required/>From Global data<br>
<input type="radio" name="choice" value="A" required/> From Global and personal <br><br>
<input type="submit" />
</form>
</body>
</html>