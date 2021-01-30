<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Global.*, DbOperations.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="../Global/Global.css" rel="stylesheet"/>
</head>
<%!
String email=null;
String name=null;
ReturnGlobalTalents rGT=new ReturnGlobalTalents();
%>
<style>footer{
  position: absolute;
    bottom: 0;
}
</style>
<body>
<% 
HttpSession hs=request.getSession();
try{
email= (String)hs.getAttribute("email");
if(hs.getAttribute("email").equals(null)){response.sendRedirect("../login.jsp");}}
catch(Exception e){response.sendRedirect("../login.jsp");}
%>
<div id="root">
<div id="left"><br><br>
<%out.write("Hi "+GetName.getName(email));%>
<pre></pre><br/>
<h4><a href="../Home.jsp" style="text-decoration:none;"> ~Home</a></h4>
<h4><a href="../logout.jsp" style="text-decoration:none;">~Logout</a></h4>
</div>
<div id="right">
<%  
long id=rGT.count(email);
out.write("<pre></pre><div>");
int counter=1;
if(id==0){out.write("No videos found");}
for(long i=id;i>0;i--){
out.write("<div>Id : "+i+"<br>");
out.write(" Email : "+rGT.getEmail(id)+"<br>");
out.write("Tag : "+rGT.getTag(id)+"<br>");
out.write("<img src=\"../getImage?id="+ i +"\" width=\"200\" height=\"240\" alt=\"one\"/>");
out.write("</div>");
if(counter%5==0){out.write("</div><div>"); counter=1;continue;}
counter++;
}
out.write("</div>");
%>
</div>
</div>
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