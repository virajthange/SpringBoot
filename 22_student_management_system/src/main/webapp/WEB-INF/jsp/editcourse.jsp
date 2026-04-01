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

        .hero{
            width: 100%;
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background: linear-gradient(to bottom right, rgb(232, 237, 237) , rgb(155, 236, 166) );
        }
        .hero form{
            width: 40%;
            background-color: whitesmoke;
            padding: 60px 50px;
            border-radius: 10px;
            padding-top: 5vh;
            background: linear-gradient(to bottom right, rgb(144, 228, 133) , rgb(117, 163, 123) );

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
            background-color: rgba(243, 249, 243, 0.652);
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

       .back{
                position: absolute;
                top: 20px;
                left: 20px;
                background-color: green;
                padding: 6px 15px;
                border-radius: 15px;
            }
       .back a{
                text-decoration: none;
                color: white;
       }
    </style>
</head>
<body>
    <div class="main">
          <div class="back"> <a href="/dashboard"> Back </a> </div>

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