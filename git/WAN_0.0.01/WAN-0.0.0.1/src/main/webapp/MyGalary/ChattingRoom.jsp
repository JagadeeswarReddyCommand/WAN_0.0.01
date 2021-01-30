<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="DbOperations.*" %>
<!DOCTYPE html>
<html>
<head><link href="chat.css" rel="stylesheet"/>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
HttpSession hs=request.getSession();
try{
if(hs.getAttribute("email").equals(null)){response.sendRedirect("../login.jsp");}}
catch(Exception e){response.sendRedirect("../login.jsp");}
%>
<div id="root">
<div id="left">
<form action="../storeMessages" method="post">
<input type="text" size=30 placeholder="message drop here" required name="message" maxlength=29 /><br>
<input type="submit" value="send" />
</form>
<a href="../logout.jsp">Logout</a>
</div>
<div id="right"><div id="messages">
<%
Message obj=new Message();
try{
obj=GetDataFromDbForChat.get((String)request.getSession().getAttribute("dbName"));
String email= (String)request.getSession().getAttribute("email");
String emails="";
String id="who";
for(int i=obj.getMessage().size()-1;i>=0;i--){
	if(!obj.getFrom().get(i).equals(emails)){
		if(obj.getFrom().get(i).equals(email)){
		id="who";
		out.print("<span class=\""+id+"\">From : "+(obj.getFrom().get(i))+"</span><br>");
		emails=obj.getFrom().get(i);
		}
		else{
			id="whoTo";
			out.print("<span class=\""+id+"\">From : "+(obj.getFrom().get(i))+"</span><br>");
			emails=obj.getFrom().get(i);
		}
		}
	out.print("<span class=\"message "+id+"\">"+(obj.getMessage().get(i))+"</span><br>");}
}
catch(Exception e){out.print("No data previously");}
%>
</div>
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