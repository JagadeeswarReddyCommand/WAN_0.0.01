<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
HttpSession hs=request.getSession();
try{
if(hs.getAttribute("email").equals(null)){response.sendRedirect("login.jsp");}}
catch(Exception e){response.sendRedirect("login.jsp");}
%>
User already exist with same email just click on forgot if u forgot password <a href="forgot.jsp">Forgot password</a>
<br>if u want new account enter here <a href="Registration.jsp">Create new account</a>
<br>if u want to login click <a href="login.jsp">Login to account</a>
</body><!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-171594448-1"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-171594448-1');
</script>

</html>