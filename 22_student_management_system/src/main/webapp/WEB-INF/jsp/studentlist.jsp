<%@page import="com.example.__student_management_system.entities.Student"%>
<%@page import="com.example.__student_management_system.entities.Course"%>
<%@page import="java.util.List"%>


<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link
      href="https://cdn.jsdelivr.net/npm/remixicon@4.9.0/fonts/remixicon.css"
      rel="stylesheet"
    />
    <style>
      * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
      }

       .main-text {
                   background-color: rgba(128, 128, 128, 0.316);
                   width: 100%;
                   height: 10vh;
                   display: flex;
                   align-items: center;
                   justify-content: space-between;
                   background: linear-gradient(to bottom right, rgb(126, 218, 126), rgb(151, 193, 149));
                   padding: 0 10vh;
           }
              .main-text a{
                    text-decoration: none;
                    font-size: 18px;
                    background-color: green;
                    color: white;
                    padding: 7px 20px;
                    border-radius: 20px;

                  }
      .hero {
        width: 100%;
        height: 90vh;
        /* min-height: 85vh; */
        display: flex;
        background: linear-gradient(to bottom right, rgb(232, 237, 237) , rgb(155, 236, 166) );
        justify-content: center;
      }
      table {
        background-color: whitesmoke;
        /* border-radius: 10px; */
        width: 60%;
        border-collapse: collapse;
        text-align: center;
      }
      table button {
        margin-left: 10px;
        padding: 5px 10px;
        border: none;
        border-radius: 5px;
        background-color: royalblue;
        color: white;
      }
      table .delete-button {
        background-color: red;
      }
      table .edit-button {
        background-color: green;
      }

      table thead {
             background-color: green;
             color: white;
           }
      table th,
      table td {
        padding: 10px;
        border: 1px solid black;
      }
      a{
         text-decoration: none;
      }
      button a{
        color: white;
      }
      .table-container{
              padding-top: 10vh;
              width: 100%;
              height: 100%;
              display: flex;
              align-items: start;
              justify-content: center;
           }

    </style>
  </head>

  <body>
    <div class="main">

      <div class="main-text">
                   <a href="dashboard">Home</a>
                   <h1>Course List</h1>
                   <div class="icons">

                   </div>
                 </div>

      <div class="hero">
       <%
                      List<Student> students = (List<Student>) request.getAttribute("students");

       %>
      <div class="table-container">
          <table>
                  <thead>
                    <tr>
                      <th>Id</th>
                      <th>Name</th>
                      <th>email</th>
                      <th>Course</th>
                      <th>Actions</th>
                    </tr>
                  </thead>



                  <%
                        if(!students.isEmpty()){
                        for(Student val: students){
                   %>
                             <tr>

                                   <td><%= val.getId() %></td>
                                   <td><%= val.getName() %></td>
                                   <td><%= val.getEmail() %></td>
                                   <td>
                                        <%
                                            List<Course> courseList = val.getCourses();
                                            for(Course course : courseList){
                                        %>
                                               | <%=course.getName()%>
                                        <%
                                            }
                                        %> |
                                   </td>
                                   <td>
                                         <button class="edit-button"><a href="/editstudent/<%=val.getId()%>">Edit</a></button>
                                        <button class="delete-button"><a href="/deletestudent/<%=val.getId()%>">Delete</a></button>
                                   </td>
                              </tr>
                     <%
                        }
                        }
                     %>

                </table>
      </div>
      </div>
    </div>
  </body>
</html>
