<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <div>
        <h1>User Data </h1>
        <h2>Using Expression language</h2>
        <p>Username: ${username}</p>
        <p>Useremail: ${useremail}</p>
        <p>Userpassword: ${userpassword}</p>


        <h2>Using Scriplet tag</h2>
        <%
            String name = request.getParameter("username");
            String email = request.getParameter("useremail");
            String password = request.getParameter("userpassword");
        %>
        <p>Username: <%= name %> </p>
        <p>Useremail: <%= email %> </p>
        <p>Userpassword: <%= password %> </p>
    </div>

</body>
</html>