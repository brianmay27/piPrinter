<html>
<head><link rel="stylesheet" type="text/css" href="style.css"/> </head>
<body>
<!--img src="img/creator-pro-i-1-nobg-web.jpg"/-->
<div class="login">
    <form name="loginform" action="" method="post">
        <table>
            <tr><td>Username: <input type="text" name="username" /></td></tr>
            <tr><td>Password: <input type="password" name="password"/></td></tr>
            <tr><td width="10%">Remember me?<input type="checkbox" name="rememberMe"/></td>
            <td width="90%"><input type="submit" value="Login" /></td></tr>
        </table>
    </form>
</div>
<%
    String errorDescription = (String) request.getAttribute("shiroLoginFailure");
    if (errorDescription!=null) {
%>
Login attempt was unsuccessful: <%=errorDescription%>
<%
    }
%>
</body>
</html>
