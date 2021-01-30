<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="MyGalary.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Galary</title>
<link href="myYoutubeVideos.css" rel="stylesheet" />
</head>
<body>
<% 
HttpSession hs=request.getSession();
try{
if(hs.getAttribute("email").equals(null)){response.sendRedirect("../login.jsp");}}
catch(Exception e){response.sendRedirect("../login.jsp");}
%>
<header>
<div id="logout"> <div id="log">
<% HttpSession obj=request.getSession();
out.print("<span id=\"one\"> Welcome to your videos page mr/mis "+
		obj.getAttribute("person")+"</span>");
%>
<span id="Two"><br><a href="../logout.jsp">Logout</a><br>|||
<a class="homebutton" href="../Home.jsp" style="text-decoration: none;font-size: larger;">Home</a>
</span>
</div></div>
<br>
</header>
<text>Bellow are your videos.. due you want to upload more <a href="MyYouTube.jsp">click here</a></text>

<div id="root">
<%
try{
GetMyYoutubeData getHomeData=new GetMyYoutubeData();
YoutubeDataReturn youtubeDataReturn =new YoutubeDataReturn();
String MyEmail=(String) hs.getAttribute("email");
youtubeDataReturn =getHomeData.myYouTubeData(MyEmail);
out.print("<div>");

for(int i=youtubeDataReturn.getHomeListId().size()-1;i>=0;i--){
	out.print("<div class=\"videos\"><h1>"+youtubeDataReturn.getHomeListId().get(i)+"</h1>");
	out.print("<iframe class=\"iframevideos\" src=\""+youtubeDataReturn.getHomeList().get(i)
					+"\" autoplay;  allowfullscreen ></iframe>");
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