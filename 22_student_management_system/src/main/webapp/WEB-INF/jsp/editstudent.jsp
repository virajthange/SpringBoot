<%@page import="com.example.__student_management_system.entities.Student"%>
<%@page import="com.example.__student_management_system.entities.Course"%>
<%@page import="java.util.List"%>

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
            padding: 5vh 0;
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

      .checkbox-container {
  padding: 15px;
  border-radius: 8px;

  display: flex;
  align-items: center;
  flex-direction: column;
  gap: 20px;
  justify-content: center;
}

.checkbox-container label {
    display: inline;
  display: flex;
  align-items: center;
  gap: 8px;
  cursor: pointer;
}


.checkbox-container {
    padding: 20px;
    border-radius: 10px;

    display: flex;
    flex-wrap: wrap;   /* allows items to go to next row */
    gap: 15px;
    justify-content: space-between;
}

.checkbox-item {
    display: flex;
    align-items: center;
    gap: 8px;

    width: 45%;   /* 2 items per row */
    background: white;
    padding: 10px;
    border-radius: 6px;
    cursor: pointer;
    transition: 0.3s;
}

.checkbox-item:hover {
    background-color: #f0f0f0;
}

.checkbox-item input {
    width: auto;
    cursor: pointer;
}
.checkbox-container label input{
    width: 18px;
    height: 18px;
    margin-right: 10px;
    cursor: pointer;
}
.checkbox-container label {
    width: 100%;
  display: flex;
  align-items: start;
  justify-content: start;
  /* gap: 8px; */
  cursor: pointer;
}
    form h2{
        text-align: center;
        margin-bottom: 40px;
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

        <%
            Student student = (Student) request.getAttribute("student");
        %>
        <div class="hero">
                <div class="back"> <a href="/dashboard"> Back </a> </div>

            <form action="/editstudent" method="post">
                <h2>Edit Student</h2>
                 <label for="id">Name:</label>
                 <input type="number" id="id" value="<%=student.getId()%>" readonly name="id"><br><br>
                <label for="sname">Name:</label>
                <input type="text" id="sname" value="<%=student.getName()%>" name="name"><br><br>
                <label for="duration">Email:</label><br>
                <input type="text" id="email" value="<%=student.getEmail()%>" name="email"><br><br>
<label>Select Courses</label>

<%
    List<Course> courses =(List<Course>) request.getAttribute("courses");
    List<Course> allCourses =(List<Course>) request.getAttribute("allcourses");
%>
<div class="checkbox-container">

    <%
        if(!allCourses.isEmpty()) {
            for(Course val: allCourses) {
    %>
               <label>
                     <input type="checkbox" <%=
                        courses.contains(val) ? "checked" : ""
                      %> name="courseIds" value="<%=val.getId()%>"> <%=val.getName()%>
               </label>
    <%
        }
        }
    %>
</div>

                <div class="btn">
                    <button type="submit">Save Student</button>
                </div>
            </form>
    </div>
</body>
</html>