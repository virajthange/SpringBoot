<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <div>
        <h1> Displaying data using ModelAndView</h1>
        <h3>Username: ${name} </h3>
        <h3>Age: ${age} </h3>
        <h3>User:  ${user} </h3>

        <h1> Displaying data using ModelAndView through scriplet tag</h1>
        <%
            String uname = (String) request.getAttribute("name");
        %>

        <%= uname%>
    </div>
</body>
</html>