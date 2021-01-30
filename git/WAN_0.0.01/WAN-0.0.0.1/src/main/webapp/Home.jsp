<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList,jaggu.GetHomeData" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/home.css"/>
<link rel="stylesheet" href="./css/homeA.css"/>
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
<div id="header">
<div id="logout"> <div>
<% HttpSession obj=request.getSession();
out.print("<span id=\"one\"> Welcome to home page mr/mis "+
		obj.getAttribute("person")+"</span>");
%>
<span id="Two"><br><a href="logout.jsp">Logout </a></span>
</div></div></div>
<div id="root">
<div id="left-r">
<h4>Enter email to chat with a person</h4>
<form method="post" action="StoreChatNewData">
<input type="text" required name="chatNewEntryName" maxlength=50 minlength=7 placeholder="Enter name" /><br><br>
<input type="submit" value="FIND"/>
<h2><%try{
if(!(hs.getAttribute("chatNewMessage").equals(null))){out.print(hs.getAttribute("chatNewMessage"));}}
catch(Exception e){}
 %></h2>
</form>
<br><br>
<%
GetHomeData getHomeData=new GetHomeData();
String MyEmail=(String) hs.getAttribute("email");
ArrayList<String> data=new ArrayList<String>();
data=getHomeData.homeData(MyEmail);
for(String item:data){
	out.write("<a class=\"chat\" href=\"chatRoom?from="+MyEmail+"&to="
      +item+"\" target=\"_blank\">"+item+"</a>"); }
%>
</div>
<div id="right-r">
<a href="./MyGalary/MySkill.jsp">promoting your skills</a>
<a href="./Global/Global.jsp">see global skill talents</a>
<a href="./MyGalary/MySkills.jsp">see My skill talents</a>
<a href="./MyGalary/MyYouTube.jsp">Upload video link your youTube video</a>
<a href="./MyGalary/MyYouTubeVideos.jsp">My video Gallery </a>
<a href="./Global/GlobalVideos.jsp">Global video Gallery </a>
<a href="./MyGalary/DeleteYouTubeData.jsp">Delete videos from Gallery </a>
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