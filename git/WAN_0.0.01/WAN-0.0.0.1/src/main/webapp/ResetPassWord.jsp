<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="./css/resetpassword.css" rel="stylesheet"/>
</head>
<body>
<% 
HttpSession hs=request.getSession();
try{
if(hs.getAttribute("email").equals(null)){response.sendRedirect("login.jsp");}}
catch(Exception e){response.sendRedirect("login.jsp");}
%>
<h1>Eneter password to reset for email id :<%=request.getSession().getAttribute("email") %></h1>
<form action="resetPassword" method="post">
<input type="password" required name="p1" maxlength=15 />
<input type="password" required name="p2" maxlength=15 />
<input type="submit" value="reset" />
</form>
<h1><%=request.getSession().getAttribute("message") %></h1>
</body>

<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-171594448-1"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-171594448-1');
</script>

</html>