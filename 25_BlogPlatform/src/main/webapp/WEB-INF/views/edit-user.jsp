<%@page import="com.spider.__BlogPlatform.entities.Blog" %>
<%@page import="com.spider.__BlogPlatform.dtos.UserDTO" %>
<%@page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit post</title>

    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
         :root{
            --dark-color: #2F311C;
            --light-color: #55593A;
            --medium-color: #4A4D2E;
            --prim-color: #3B3D24;
        }
        .hero {
            width: 100%;
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            background-color: var(--dark-color);

        }
        .form-container {
            background-color: whitesmoke;
            padding: 10vh 5vh;
            width: 25%;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            border: none;
            border-radius: 8px;

        }
        .form-container h2 {
            text-align: center;
            margin-bottom: 5vh;
        }
        form {
            width: 100%;
            display: flex;
            flex-direction: column;
            gap: 10px;

        }
        form input {
            background-color: white;
            padding: 6px 12px;
            border: none;
            border-radius: 8px;
            width: 100%;

        }
        input[type=submit] {
            background-color: var(--medium-color);
            color: white;
        }
    </style>
</head>
<body>
   <%
        UserDTO user = (UserDTO)request.getAttribute("userDTO");
   %>
    <div class="hero">
        <div class="form-container">
            <h2>Edit Blog</h2>
            <form action="/admin/edit-user" method="post">
                <label for="id">Id</label>
                <input type="text" name="id" id="id" value="<%= user.getId() %>" readonly>
                <label for="title">Name</label>
                <input type="text" name="name" id="name" value="<%= user.getName() %>">
                <label for="content">Username</label>
                <input type="text" name="username" id="username" value="<%= user.getUsername() %>">
                <label for="tags">Email</label>
                <input type="text" name="email" id="email" value="<%= user.getEmail() %>">
                <input type="submit" value="Submit">
            </form>
        </div>
    </div>
</body>
</html>