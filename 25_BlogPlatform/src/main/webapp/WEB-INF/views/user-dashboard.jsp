<%@page import="com.spider.__BlogPlatform.entities.Blog" %>
<%@page import="org.springframework.data.domain.Page" %>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>User Dashboard</title>
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
        height: 100vh;
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
        height: 25vh;
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
        background-color: var(--light-color);
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
        height: 70vh;
        background-color: var(--prim-color);
        display: flex;
        align-items: center;
        justify-content: center;
      }
      .hero-container {
        background-color: var(--medium-color);
        width: 90%;
        height: 90%;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: start;
        gap: 20px;
        padding: 10vh;
      }
      .hero-container input, .hero-container a  {
        width: 100%;
        padding: 8px 10px;
        border-radius: 5px;
        border: none;
        outline: none;
      }

      .hero-container h2 {
        color: white;
      }
      .hero-container a {
        background-color: var(--dark-color);
        color: white;
        cursor: pointer;
        text-align: center;
        text-decoration: none;
      }
      .blog {
        width: 100%;
        padding: 8px 10px;
        border: none;
        border-radius: 5px;
        background-color: rgba(245, 245, 245, 0.723);
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

      @media screen and (max-width: 600px){
        nav{
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
        Page<Blog> pg = (Page<Blog>) request.getAttribute("page");
        Blog blog = pg.getContent().get(0);
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
                <h2>Blog posts</h2>
                <input type="text" name="posts" id="posts" placeholder="Search posts...">
                <input type="text" placeholder="sort by date">

                <div class="blog">
                <%
                if(blog != null) {
                %>
                    <h3><%= blog.getTitle() %></h3>
                    <p>Author: <%= blog.getUser().getName() %> | Date: <%= blog.getCreatedDate() %></p>
                    <p>Excerpt: <%= blog.getContent() %> </p>
                    <p>Read more...</p>
                <%
                }
                %>
                </div>
                <%
                    if(!pg.isFirst()) {
                %>
                        <a href="/user/dashboard?pageNumber= <%= pg.getNumber() - 1 %>"> << prev</a>
                <%
                    }
                %>

                 <%
                    if(!pg.isLast()) {
                %>
                    <a href="/user/dashboard?pageNumber= <%= pg.getNumber() + 1 %>">  Next >> </Next></a>
                <%
                    }
                %>
            </div>
        </div>
        <footer>
            <p>@2026 Blog Platform</p>
        </footer>
    </div>
  </body>
</html>
