<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <style><%@include file="/WEB-INF/css/login.css"%></style>
     



<!DOCTYPE html>
<html>
<head>
<title>Login Page
</title>
</head>


 

<body class="main-bg">
        <div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->
    <h2 class="active"> Sign In </h2>
    <!-- Login Form -->
    <form action="/homepage" method="POST" modelAttribute="loginModel">
      <input type="text" name="userid"  id="Username" class="fadeIn second" placeholder="enter username" required="required">
      <input type="password" name="password"  id="Password" class="fadeIn third" name="login" placeholder="enter password" required="required">
      <input type="submit" name="Login" class="fadeIn fourth"  font-weight: bold;" value="Login">
    </form>

    <!-- Remind Passowrd -->
    <div id="formFooter">
      <a class="underlineHover" href="/ForgetPassword">Forgot Password?</a>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
      <a class="underlineHover" href="/ForgetUserID">Forgot User ID?</a>
    </div>

 

    <h4 style="color: #FF0000">${message}</h4>
  </div>
</div>
</body>
</html>













