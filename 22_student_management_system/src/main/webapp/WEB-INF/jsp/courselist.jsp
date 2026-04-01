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
      header {
        width: 100%;
        height: 5vh;
        background-color: rgb(27, 27, 93);
        color: white;
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 0 15px;
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
        /* min-height: 85vh; */
        display: flex;
        align-items: start;
        justify-content: center;
        background: linear-gradient(to bottom right, rgb(232, 237, 237) , rgb(155, 236, 166) );
        min-height: 90vh;
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
        max-height: 40px;
      }
      tr{

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

    <%
        List<Course> list = (List<Course>) request.getAttribute("courses");
    %>
      <div class="hero">
       <div class="table-container">
                <table>
                         <thead>
                           <tr>
                             <th>Id</th>
                             <th>Course Name</th>
                             <th>Duration</th>
                             <th>Students Enrolled</th>
                             <th>Actions</th>
                           </tr>
                         </thead>

                         <%
                           if(!list.isEmpty()) {
                               for(Course c: list) {
                          %>
                                     <tr>
                                               <td><%=c.getId()%></td>
                                               <td><%=c.getName()%></td>
                                               <td><%=c.getDuration()%></td>
                                               <td>
                                               <%
                                                   for(Student val: c.getStudents()){

                                                 %>
                                                      | <%=val.getName()%>
                                                   <%
                                                   }
                                               %> |
                                               </td>
                                               <td>
                                                   <button class="edit-button"><a href="/editcourse/<%= c.getId()%>">Edit</a></button>
                                                   <button class="delete-button"><a href=""><a href="/deletecourse/<%= c.getId() %>">delete</a></a></button>
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
