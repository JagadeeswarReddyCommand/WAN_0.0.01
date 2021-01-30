<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="DbOperations.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="myskill.css" rel="stylesheet"/>
</head>
<body>

<%
String email=null;
HttpSession hs=request.getSession();
try{if(hs.getAttribute("email").equals(null)){ response.sendRedirect("../login.jsp");}
else{email=(String) hs.getAttribute("email");}}
catch(Exception e){ response.sendRedirect("../login.jsp");}
%>
<div>

<%="Hello "+GetName.getName(email)+" now you can upload your images" %>
<form method="post" action="../storeMySkills" enctype="multipart/form-data">
Title of skill : <input type="text" name="tag" required maxlength=15 placeholder="Enter tag"/>
<!-- Enter Path of file:<input type="text" name="path" required /> -->
Upload file : <input type="file" name="files" required/>
<input type="submit" value="submit"/>
</form>

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