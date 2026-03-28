<%@page import="com.example.__student_management_system.entities.Course"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add New Course</title>

    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        .main{
            width: 100%;
            min-height: 100vh;
            background-color: rgba(135, 207, 235, 0.425);
        }
        header{
            width: 100%;
            height: 5vh;
            background-color: rgb(27, 27, 93);
            color: white;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 0 15px;
        }
        .icons a{
            text-decoration: none;
            color: white;
        }
        .hero{
            width: 100%;
            min-height: 85vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .hero form{
            width: 40%;
            background-color: whitesmoke;
            padding: 60px 50px;
            border-radius: 10px;
        }
        form label{
            font-size: 18px;
        }
        form input{
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            margin-bottom: 20px;
            border: none;
            border-radius: 5px;
        }
        .btn{
            width: 100%;
            display: flex;
            justify-content: center;
        }
        form button{
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            background-color: green;
            color: white;
        }
    </style>
</head>
<body>
    <div class="main">
        <header>
            <h1>Edit Course</h1>
            <div class="icons">
               <a href="/dashboard">X</a>
            </div>
        </header>
        <div class="hero">

        <%
            Course course = (Course) request.getAttribute("course");
        %>
            <form action="/editcourse" method="post">
                 <label for="courseName">Course Name:</label><br>
                                <input type="text" id="courseName" value="<%= course.getId() %>" readonly name="id"><br><br>
                <label for="courseName">Course Name:</label><br>
                <input type="text" id="courseName" value="<%= course.getName() %>" name="name"><br><br>
                <label for="duration">Duration:</label><br>
                <input type="text" id="duration" name="duration" value="<%= course.getDuration() %>" placeholder="e.g, 3 months"><br><br>
                <div class="btn">
                    <button type="submit">Save Course</button>
                </div>
            </form>
    </div>
</body>
</html>