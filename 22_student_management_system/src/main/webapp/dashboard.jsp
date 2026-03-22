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
      .main {
        width: 100%;
        min-height: 100vh;
        background-color: rgba(135, 207, 235, 0.425);
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
        flex-direction: column;
        justify-content: center;
      }
      .main-text h1 {
        color: darkblue;
      }
      .hero {
        width: 100%;
        min-height: 85vh;
        display: flex;
      }

      .hero-left button {
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        background-color: royalblue;
        color: white;
      }
      .hero-right button {
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        background-color: green;
        color: white;
      }
      .total {
        border-radius: 10px;
        width: 60%;
        height: 30%;
        background-color: whitesmoke;
      }
      .t1-icon {
        width: 20%;
        height: 100%;
        display: flex;
        align-items: center;
        justify-content: center;
        font-size: 2.5rem;
      }
      .t1 {
        width: 100%;
        height: 80%;
        display: flex;
        align-items: center;
        justify-content: start;
        gap: 10%;
        padding: 0 10%;
        border-bottom: 1px solid rgba(0, 0, 0, 0.296);
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
        width: 60%;
        padding: 30px;
        border-radius: 15px;
        background-color: whitesmoke;
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
        justify-content: space-between;
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
      a{
        text-decoration: none;
        color: white;
      }

      @media screen and (max-width: 780px) {
        .hero {
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
        .main-text h1{
          font-size: 1.5rem;
        }
        .main-text h3{
          font-size: 1rem;
        }
        .recent-card h2{
          font-size: 1.2rem;
        }
        button{
          padding: 3px 7px;
          font-size: 0.8rem;
        }
      .total {
        width: 80%;
        height: 40%;
      }
      .recent-card{
        width: 80%;
      }
    </style>
  </head>

  <body>
    <div class="main">
      <header>
        <h3>Student management System</h3>
        <div class="icons">Icons</div>
      </header>
      <div class="main-text">
        <h1>Student Management System</h1>
        <h3>Manage Students and Courses efficiently</h3>
      </div>

      <div class="hero">
        <div class="hero-left">
          <div class="total">
            <div class="t1">
              <div class="t1-icon"><i class="ri-user-line"></i></div>
              <div class="s1">
                <h3>Total Students</h3>
                <h3>5</h3>
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
              <ul>
                <li><i class="ri-user-line"></i> Kashi</li>
                <li><i class="ri-user-line"></i> Amit</li>
                <li><i class="ri-user-line"></i> Sneha</li>
                <li><i class="ri-user-line"></i> Rahul</li>
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
                <h3>5</h3>
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
              <h2>Recent Course</h2>
              <ul>
                <li><i class="ri-book-ai-line"></i> Java</li>
                <li><i class="ri-book-ai-line"></i> Spring</li>
                <li><i class="ri-book-ai-line"></i> Spring Boot</li>
                <li><i class="ri-book-ai-line"></i> React</li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
