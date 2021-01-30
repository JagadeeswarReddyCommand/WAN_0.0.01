<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
text{
font-size:30px;
font-weight:bold;}
input[type="submit"]{
margin-left:3in;
width:1in;
font-weight:bold;
font-size:20px;
}
#one{
font-size:20px;
display:flex;
flex:1;
height:0.4in;
justify-content:center;
}
#Two{
font-size:20px;
height:0.4in;
justify-content:center;
display:flex;
}
#log{
display:flex;
flex:2;
}
header{
font-weight:bold;}
</style>
</head>
<body>
<header>
<div id="logout"> <div id="log">
<% HttpSession obj=request.getSession();
out.print("<span id=\"one\"> Welcome to your youtube page mr/mis "+
		obj.getAttribute("person")+"</span>");
%>
<span id="Two"><br><a href="../logout.jsp">Logout </a></span>
</div></div>
<h3><a href="../Home.jsp" style="margin-right:20px;">~Home</a><a href="../Global/GlobalVideos.jsp">~Global videos</a></h3>
</header>
<% 
HttpSession hs=request.getSession();
try{
if(hs.getAttribute("email").equals(null)){response.sendRedirect("../login.jsp");}}
catch(Exception e){response.sendRedirect("../login.jsp");}
%>
<br><br><br>
<form action="../MyYoutubeUpload"  enctype="multipart/form-data">
<text>Enter valid links that one embeded only : </text>
<input type="url" required name="url"/><br>
<text>select Type of video link : </text>
<select name="category">
<option value="other">Other</option>
<option value="comedy">Comedy</option>
<option value="historical">Historical</option>
<option value="action">Action</option>
<option value="romantic">Romantic</option>
</select><br>
<text>Type of uploading : </text> 
<input type="radio" required name="decession" value="G"/>Global view
<input type="radio" required name="decession" value="P"/>Personal View <br><br>
<input type="submit" value="upload" />
</form>
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