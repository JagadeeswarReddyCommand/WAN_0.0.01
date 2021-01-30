<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Global.*, DbOperations.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="Global.css" rel="stylesheet"/>
</head>
<%!
String email=null;
String name=null;
ReturnGlobalTalents rGT=new ReturnGlobalTalents();
long id=rGT.count();
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
	email= (String) hs.getAttribute("email");
if(hs.getAttribute("email").equals(null)){response.sendRedirect("../login.jsp");}}
catch(Exception e){response.sendRedirect("../login.jsp");}
%>
<% 
try{id=Integer.parseInt(request.getParameter("id"));}
catch(Exception e){id=rGT.count();
}
%>
<div id="root">
<div id="left"><%out.write("Hi "+GetName.getName(email));%><br>
<h1><a href="../logout.jsp">Logout</a></h1>
<%out.write("<br/>Top "+id+" to "+(id>10?(id-9):1)+" images are displayed only");%>
<pre></pre>
<a href="../Home.jsp" style="color:black">Back <br>to Home</a><br>
<a class="operations" href="Global.jsp?id=<%=(id>10)?id-10:id%>"> Next </a><br/>
<a class="operations" href="Global.jsp?id=<%=(id<=(rGT.count()-10)?id+10:rGT.count())%>" > Previous </a>
</div>
<div id="right">
<%  
out.write("<pre></pre><div>");
if(id==0){out.write("No data "); }
int count=1;
for(long i=id;i>0;i--){
out.write("<div>Id : "+i+"<br>");
out.write(" Email : "+rGT.getEmail(i)+"<br>");
out.write("Tag : "+rGT.getTag(i)+"<br>");
out.write("<img src=\"../getImage?id="+ i +"\" width=\"200\" height=\"240\" alt=\"one\"/>");
out.write("</div>");
if(count%5==0){out.write("</div><div>");count=1;continue;}
count++;
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