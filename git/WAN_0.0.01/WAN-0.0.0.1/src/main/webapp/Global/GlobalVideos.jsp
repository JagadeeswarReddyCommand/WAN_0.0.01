<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Global.*,MyGalary.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>	
<link href="globalVideo.css" rel="stylesheet" />

</head>
<body>
<% 
String email;
HttpSession hs=request.getSession();
try{
	email= (String) hs.getAttribute("email");
if(hs.getAttribute("email").equals(null)){response.sendRedirect("../login.jsp");}}
catch(Exception e){response.sendRedirect("../login.jsp");}
%>

<header>
<div id="logout"> <div id="log">
<% HttpSession obj=request.getSession();
out.print("<span id=\"one\"> Welcome to Global youtube page mr/mis "+
		obj.getAttribute("person")+"</span>");
%>
<span id="Two"><br>
<a href="../logout.jsp">Logout</a><br>...
<a href="../Home.jsp" style="text-decoration: none;font-size: larger;">Home</a>
</span>
</div></div><br>
</header>
<text>Bellow are Global videos.. Do you want to upload <a href="../MyGalary/MyYouTube.jsp">click here</a>
<a><br></a>
</text>

<div id="root">
<%
try{
GetGlobalyouTubeData  getHomeData=new GetGlobalyouTubeData();
YoutubeDataReturnForGlobal youtubeDataReturnForGlobal =new YoutubeDataReturnForGlobal();
String MyEmail=(String) hs.getAttribute("email");
youtubeDataReturnForGlobal =getHomeData.myYouTubeData(MyEmail);
out.print("<div><br>");

for(int i=youtubeDataReturnForGlobal.getHomeListId().size()-1;i>=0;i--){
	out.print("<div class=\"videos\"><text>"+youtubeDataReturnForGlobal.getHomeListId().get(i)+"</text>");
	out.print("<text>Name : "+youtubeDataReturnForGlobal.getHomeListName().get(i)+"</text>");
	out.print("<iframe  src=\""+youtubeDataReturnForGlobal.getHomeList().get(i)
					+"\" autoplay;  allowfullscreen width=\"250px\" height=\"250px\" controls></iframe>");
	out.print("</div>");
	if(i%4==0){ out.print("</div><br><div>");}
}
out.print("</div>");
}catch(Exception e){out.print(e);}
%>
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