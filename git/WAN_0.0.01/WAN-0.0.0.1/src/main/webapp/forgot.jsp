<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="./css/forgot.css" rel="stylesheet"/>
</head>
<body>
<form action="forgotRecovery" method="post">
Email :<input type="email" required maxlength=50 name="email"/>
SplCode :<input type="text" required name="splcode"/><br>
<input type="submit" value="GetPassword" />
 </form>
<% try{
String b=(String)request.getSession().getAttribute("message");
if(b.equals(null)) {out.write("");
}else{ out.print(request.getSession().getAttribute("message"));}
}catch(Exception e){}
%>
</body>
</html>