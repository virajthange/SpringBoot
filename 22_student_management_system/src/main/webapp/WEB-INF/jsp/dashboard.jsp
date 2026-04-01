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
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Libre+Franklin:ital,wght@0,100..900;1,100..900&family=Merriweather:ital,opsz,wght@0,18..144,300..900;1,18..144,300..900&family=Saira:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
    <style>
      * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
      }
      body{
  /* font-family: "Merriweather", serif; */
  font-family: "Merriweather", serif;
      }
      .main {
        width: 100%;
        min-height: 100vh;
      }
      /* header {
         background-color: royalblue;
        background-color: rgba(55, 215, 100, 0.477);
        width: 100%;
        height: 5vh;
        color: black;
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 0 15px;

      } */
      .main-text {
        /* background-color: rgba(128, 128, 128, 0.316); */
        background: linear-gradient(to bottom right, rgb(126, 218, 126), rgb(151, 193, 149));

        width: 100%;
        height: 10vh;
        display: flex;
        align-items: center;
        flex-direction: row;
        justify-content: space-between;
        padding: 0 10vh;

      }


      .heading{
        font-size: 1.5rem;
        font-weight: 600;
        color: rgba(0, 0, 0, 0.516);
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      }
      .middle-heading {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
      }
      .main-text h1 {
        color: darkblue;
      }
      .hero-containers {
        width: 100%;
        min-height: 85vh;
        display: flex;

      }
      .hero{
        background: linear-gradient(to bottom right, rgb(232, 237, 237) , rgb(155, 236, 166) );
      }

      .hero-left button {
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        /* background-color: royalblue; */
        color: white;
      }
      .hero-right button {
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        color: white;
      }
      .total {
        border-radius: 10px;
        width: 50%;
        height: 30%;
        /* background-color: whitesmoke; */
        background:linear-gradient(to bottom right,  rgb(181, 222, 181), rgb(149, 226, 149));
        box-shadow: 10px 10px 20px gray;

      }
      .hero button {
        background-color: green;
        font-weight: 600;
        box-shadow: 2px 2px 10px gray;

      }
      .t1-icon {
        width: 4rem;
        height: 4rem;
        border-radius: 50%;
        display: flex;
        align-items: center;
        justify-content: center;
        font-size: 2.5rem;
        background-color: rgba(255, 255, 255, 0.53);
      }
      .t1 {
        width: 100%;
        height: 80%;
        display: flex;
        align-items: center;
        justify-content: start;
        gap: 10%;
        padding: 0 10%;
        /* border-bottom: 1px solid rgba(0, 0, 0, 0.296); */
      }
      .t2 button {

        margin-bottom: 20px;
      }
      .s1 {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        gap: 10px;
      }
      .t2 {
        width: 100%;
        height: 20%;
        display: flex;
        align-items: center;
        justify-content: center;
      }
      .recents {
        width: 100%;
        height: 35%;
        display: flex;
        justify-content: center;
      }
      .recent-card {
        width: 50%;
        padding: 30px;
        border-radius: 15px;
        background:linear-gradient(to bottom right,  rgb(181, 222, 181), rgb(149, 226, 149));
        box-shadow: 10px 10px 20px gray;
      }
      .recent-card h2 {
        border-bottom: 1px solid rgba(0, 0, 0, 0.342);
        height: 20%;
        margin-bottom: 10px;
      }

      .hero-left {
        width: 50%;
        /* height: 100%; */
        /* background-color: brown; */
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: space-around;
      }

      .hero ul {
        width: 100%;
        display: flex;
        flex-direction: column;
        align-items: start;
        padding-left: 15px;
        justify-content: start;
        gap: 10%;
        height: 80%;
      }
      .hero li {
        list-style: none;

      }

      .hero-right {
        width: 50%;
        /* height: 100%; */
        /* background-color: rgb(90, 12, 12); */
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: space-around;
      }
      a {
        text-decoration: none;
        color: white;
      }
      .msg {
        font-size: 16px;
        font-weight: 600;
        height: 5vh;
        width: 100%;
        color: green;
        display: flex;
        align-items: center;
        justify-content: center;
        padding-top: 15px;
      }
    .logout-btn{
        padding: 10px 20px;
        border: none;
        font-weight: 600;
        border-radius: 17px;
        color: black;
        background-color: green;
      }
      .count{
        font-size: 1.5rem;
        background-color: rgba(255, 255, 255, 0.456);
        padding: 5px 10px;
        border-radius: 50%;
      }
      .msg p {
        background-color: rgba(255, 255, 255, 0.53);
        display: inline;
        padding: 3px 10px;
        border-radius: 10px;
      }
      @media screen and (max-width: 780px) {
        .hero-containers {
          flex-direction: column;
        }
        .hero-left {
          width: 100%;
          height: 80vh;
        }
        .hero-right {
          width: 100%;
          height: 80vh;
        }
        .main-text h1 {
          font-size: 1.5rem;
        }
        .main-text h3 {
          font-size: 1rem;
        }
        .recent-card h2 {
          font-size: 1.2rem;
        }
        button {
          padding: 3px 7px;
          font-size: 0.8rem;
        }
        .total {
          width: 80%;
          height: 40%;
        }

        .recent-card {
          width: 80%;
        }
      }
    </style>
  </head>

  <body>
    <div class="main">
      <!-- <header>
        <h3>Student management System</h3>
        <div class="icons">Icons</div>
      </header> -->
      <div class="main-text">
        <div class="heading">SMS</div>
       <div class="middle-heading"> <h1>Student Management System</h1>
        <h3>Manage Students and Courses efficiently</h3></div>

        <button class="logout-btn"><a href="/logout">Logout</a></button>
      </div>

      <div class="hero">

      <div class="msg"><p>${msg}</p></div>
      <div class="hero-containers">
              <!-- <div class="hero"> -->
        <div class="hero-left">
          <div class="total">
            <div class="t1">
              <div class="t1-icon"><i class="ri-user-line"></i></div>
              <div class="s1">
                <h3>Total Students</h3>
                <h3 class="count">${studentcount}</h3>
              </div>
            </div>
            <div class="t2">
              <button><a href="studentlist">View Students</a></button>
            </div>
          </div>
          <div class="add-button">
            <button><a href="newstudent">+ Add students</a></button>
          </div>
          <div class="recents">
            <div class="recent-card">
              <h2>Recent Students</h2>
              <%
                List<Student> students = (List<Student>) request.getAttribute("recentstudents");
              %>
              <ul>
              <%
                for(Student val : students) {
              %>
                    <li><i class="ri-user-line"></i> <%= val.getName() %></li>
              <%
                }
              %>

              </ul>
            </div>
          </div>
        </div>

        <!-- Right side  -->
        <div class="hero-right">
          <div class="total">
            <div class="t1">
              <div class="t1-icon"><i class="ri-book-ai-line"></i></div>
              <div class="s1">
                <h3>Total Courses</h3>
                <h3 class="count">${coursecount}</h3>
              </div>
            </div>
            <div class="t2">
              <button><a href="courselist">View Courses</a></button>
            </div>
          </div>
          <div class="add-button">
            <button><a href="newcourse">+ Add Course</a></button>
          </div>
          <div class="recents">
            <div class="recent-card">
              <h2>Recent Courses</h2>
              <%
                List<Course> recentcourses = (List<Course>) request.getAttribute("recentcourses");
              %>
              <ul>

              <%
                for(Course val : recentcourses){
              %>
                <li><i class="ri-book-ai-line"></i> <%= val.getName() %> </li>

              <%
                }
              %>
              </ul>
            </div>
          </div>
        </div>
      <!-- </div> -->

      </div>
      </div>

    </div>
  </body>
</html>
