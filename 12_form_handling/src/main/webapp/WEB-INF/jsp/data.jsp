<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.spider.__form_handling.User" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <div>
        <h1> Displaying data using model , expression language</h1>

        <h3> ${username} </h3>
        <h3> ${userage} </h3>
        <h3> ${user} </h3>
        <h1> Displaying data using scriplet tag</h1>
        <%
            String uname = (String) request.getAttribute("username");
            int uage = (int) request.getAttribute("userage");
            User user = (User) request.getAttribute("user");
        %>

        <h4>Username : <%= uname %> </h4>
        <h4>User age : <%= uage %> </h4>
        <h4>User Details : <%= user %> </h4>
    </div>
</body>
</html>