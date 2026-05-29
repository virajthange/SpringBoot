<%@page import="com.spider.__BlogPlatform.entities.User" %>
<%@page import="com.spider.__BlogPlatform.entities.Blog" %>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <style>
      * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
      }
      :root {
        --dark-color: #2f311c;
        --light-color: #55593a;
        --medium-color: #4a4d2e;
        --prim-color: #3b3d24;
      }
      body {
        min-height: 100vh;
        width: 100%;
        background-color: var(--dark-color);
      }
      .dashboard-page {
        width: 100%;
        height: 100%;
      }
      nav {
        width: 100%;
        padding: 10px 5vh;
        min-height: 25vh;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        background-color: var(--medium-color);
        color: white;
      }
      nav h2 {
        font-weight: 700;
      }
      nav ul {
        margin-top: 10px;
        width: 100%;
        display: flex;
        border-radius: 5px;
        flex-direction: column;
        justify-content: center;
        align-items: center;

      }
      nav ul li {
        margin: 5px 0;
        text-align: center;
        width: 100%;
        list-style: none;
        background-color: var(--light-color);
      }
      nav ul li a {
      display: inline-block;
       padding: 6px 10px;
        width: 100%;
        text-decoration: none;
        color: white;
        font-size: 16px;
      }
    nav ul li:hover {
               background-color: #d0db6c4c;
          }
      .hero {
        width: 100%;
        min-height: 70vh;
        background-color: var(--prim-color);
        display: flex;
        align-items: center;
        justify-content: center;
        padding: 5vh 0;
      }
      .hero-container {
        background-color: var(--medium-color);
        width: 90%;
        min-height: 90%;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: start;
        gap: 20px;
        padding: 10vh;
      }
      .hero-container input,
      .hero-container button {
        width: 100%;
        padding: 8px 10px;
        border-radius: 5px;
        border: none;
        outline: none;
      }
      .hero-container h2,
      .hero-container p,
      .hero-container h1 {
        color: white;
      }
      .hero-container button {
        background-color: var(--dark-color);
        color: white;
        cursor: pointer;

      }
      .blog {
        width: 100%;
        padding: 8px 10px;
        border: none;
        border-radius: 5px;
        background-color: rgba(245, 245, 245, 0.723);
      }
      .blog h3,
      .blog button {
        margin-bottom: 5px;
      }
      footer {
        width: 100%;
        height: 5vh;
        background-color: var(--medium-color);
        color: white;
      }
      footer p {
        height: 5vh;
        align-content: center;
        text-align: center;
      }
      button a {
        color: white;
        text-decoration: none;
        font-weight: 600;
      }

      @media screen and (max-width: 600px) {
        nav {
          height: 20vh;
        }
        .hero {
          height: 75vh;
        }
        .hero-container {
          padding: 5vh;
        }
      }
    </style>
  </head>
  <body>

    <%
        User user =  (User) request.getAttribute("user");
    %>
    <div class="dashboard-page">
      <nav>
        <h2>Blog Dashboard</h2>
        <ul>
          <li><a href="/user/dashboard">Home</a></li>
          <li><a href="/user/create-post">Create new post</a></li>
          <li><a href="/user/profile">Profile</a></li>
        </ul>
      </nav>
      <div class="hero">
        <div class="hero-container">
          <h2>User Profile</h2>
          <p>Name: <%= user.getName() %></p>
          <p>Email: <%= user.getEmail() %> </p>

          <h1>Your posts</h1>
          <%
          for(Blog blog : user.getBlogs()) {
          %>
             <div class="blog">
                        <h3 style="color: black"><%= blog.getTitle() %></h3>
                        <button>Edit</button>
                        <button>Delete</button>
             </div>
          <%
          }
          %>


          <button ><a href="/logout">Logout</a></button>
        </div>
      </div>
      <footer>
        <p>@2026 Blog Platform</p>
      </footer>
    </div>
  </body>
</html>
