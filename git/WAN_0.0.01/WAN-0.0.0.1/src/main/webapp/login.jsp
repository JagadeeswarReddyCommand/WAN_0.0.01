<!DOCTYPE html>
<html>
    <head>
        <title>AimingSky-Login</title>
        <link rel="stylesheet" type="text/css" href="./css/loginA.css">
        <link rel="stylesheet" type="text/css" href="./css/login.css">
    </head>
    <body>
        <div class="split left" id="image">
        </div>
        <div class="split right">
            <h1 style="margin-block-end: 0em;" id="title" >AimingSky Solutions</h1><br>
            <p><i><strong>Your Problems Our Creative Solutions</strong></i></p>
         <br><br><br>
            <form action="Validate" method="post">
                <label for="name">User Name:</label>
                <input name="email" type="email" required minlength="8" maxlength="45"><br>
                <label for="pwd" >Password : </label>
                <input type="password" name="password" minlength="8" maxlength="15" required><br>
                <input type="submit" value="Login" /><br>
                <a href="Registration.jsp">New Registration</a><br><br>
                <a href="forgot.jsp">Forget Password</a>              
                <%
                HttpSession hs=request.getSession();
                try{
                Object s=hs.getAttribute("message");
                if(s.equals(null)){}
                else out.write("<h5>"+s+"</h5>"); hs.setAttribute("message",""); 
                }
                catch(Exception e){}
                %>
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