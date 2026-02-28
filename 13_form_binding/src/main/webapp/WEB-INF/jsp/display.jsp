<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <div>
        <h1> Displaying data using expression language</h1>
        <h3>Username: ${userdata.username} </h3>
        <h3>Useremail: ${userdata.useremail} </h3>
        <h3>Userpassword: ${userdata.userpassword} </h3>

        <h1> Displaying data using scriplet tag</h1>
        <%
            String uname = (String)request.getParameter("username");
            String uemail = (String)request.getParameter("useremail");
            String upassword = (String)request.getParameter("userpassword");
            System.out.println(uname);
            System.out.println(uemail);
            System.out.println(upassword);
        %>
        <h3>Username: <%= uname %> </h3>
        <h3>Useremail: <%= uemail %> </h3>
        <h3>Userpassword: <%= upassword %> </h3>


    </div>
</body>
</html>