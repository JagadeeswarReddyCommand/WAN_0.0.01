<!DOCTYPE html>
<html>
    <head>
        <title>AimingSky-Registration</title>
        <link rel="stylesheet" type="text/css" href="css/regesterA.css" />
            <link rel="stylesheet" type="text/css" href="css/regester.css">
            
    </head>
        <body>
            <div class="split left"></div>
            <div class="split right">
                <h1 style="">Aiming sky solutions</h1>
                <p><i>Your Problems Our Creative Solutions</i></p>
                <text><i>Welcome To Our World Aiming Sky</i></text><br>
                 <text>You Want To Fly...?</text>
                    <text>Take Our ideas to do it...</text>
                <form action="RegisterServlet" method="post">
                <div id="box">
                    <pres><br>Name:
                    <input type="text" required name="name" placeholder="Enter name" minlength="5"></pres>
                    <pres>Email:         
                    <input type="email" required  name="email" placeholder="Enter email" minlength="8" maxlength="45"></pres>
                    <pres>Create Password:
                    <input type="password" name="password1" required placeholder="Enter password" minlength="8" maxlength="15"></pres>
                    <pres>Confirm Password:
                    <input type="password" name="password2" required minlength="8" placeholder="Confirm password" maxlength="15"/></pres>
                    <pres>Special code:    
                    <input type="text" name="splcode" required placeholder="Enter special code" minlength="4" maxlength="8"/></pres>
                    <input type="submit" value="Regeister" /> 
                   <text class="foot">
                   <% HttpSession hs=request.getSession();
                   try{if(!(hs.getAttribute("message").equals(null))){out.print(hs.getAttribute("message")); hs.setAttribute("message",""); }}
                   	  catch(Exception e){}
                   %>You have already account <a href="login.jsp">Click Here</a>
                   </text>
                </div>
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