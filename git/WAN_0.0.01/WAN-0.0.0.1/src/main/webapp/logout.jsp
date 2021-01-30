<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

@media only screen and (max-width: 980px) {
body{
	display:flex;
	flex-direction:column;
	font-size:1in;
}
}

</style>
</head>

<body>
<% 
HttpSession hs=request.getSession();
try{
if(hs.getAttribute("email").equals(null)){response.sendRedirect("login.jsp");}}
catch(Exception e){response.sendRedirect("login.jsp");}
%>
<%
hs.setAttribute("email", null);
%>
u r logout from sessions.......... <a href="login.jsp">Login again</a>
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