<%@page import="com.spider.__BlogPlatform.entities.Blog" %>
<%@page import="java.util.List" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Posts moderation</title>
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
        gap: 5px;
        flex-direction: column;
        justify-content: center;
        align-items: center;
      }
      nav ul li {
        border-radius: 5px;
        background-color: var(--light-color);
        text-align: center;
        width: 100%;
        list-style: none;
      }

      nav ul li a {
        padding: 5px 0;
      display: inline-block;
        width: 100%;
        text-decoration: none;
        color: white;
        font-size: 16px;
      }
      nav ul li:hover {
        background-color: #d0db6c4c;
        /* padding: 5px 10px; */
        /* border-radius: 5px; */
      }
      .hero {
        width: 100%;
        min-height: 70vh;
        background-color: var(--prim-color);
        display: flex;
        /* align-items: center; */
        padding: 5vh;
        justify-content: center;
      }
      .hero-container {
        background-color: var(--medium-color);
        width: 90%;
        height: 80%;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: start;
        gap: 20px;
        padding:  5vh;
      }

      .hero-container h2 {
        color: white;
      }

      .table-container {
        width: 100%;

      }
      .table-container table {
        width: 100%;
        color: white;
        border: none;
      }
      table thead {
        background-color: var(--dark-color);
      }
      .btn {
        width: fit-content;
        padding: 5px 15px;
        border-radius: 5px;
        border: none;
        margin: 5px;
        background-color: var(--dark-color);
        color: white;
        cursor: pointer;
      }

    a{
        display: inline-block;
        text-decoration: none;
    }

      th {
        padding: 10px;
      }
      td {
        border: none;
        padding: 10px;
        background-color: var(--light-color);
        text-align: center;
      }
      .status {
        color: white;
        border: 1px solid var(--dark-color);
        font-size: 12px;
        padding: 8px 10px;
        border-radius: 15px;
        background-color: var(--medium-color);
        width: fit-content;
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
          List<Blog> blogs = (List<Blog>) request.getAttribute("blogs");
     %>

    <div class="dashboard-page">
      <nav>
        <h2>Blog Dashboard</h2>
        <ul>
          <li><a href="/admin/dashboard">Manage posts</a></li>
          <li><a href="/admin/manage-users">Manage users</a></li>
          <li><a href="/admin/post-moderation">Post moderation</a></li>
          <li><a href="/admin/report">Reports</a></li>
        </ul>
      </nav>
      <div class="hero">
        <div class="hero-container">
          <h2>Post Moderation</h2>
         <div class="table-container">
          <table>
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Date</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                if(blogs != null) {
                    for(Blog blog : blogs) {
                %>
                         <tr>
                                 <td><%= blog.getTitle() %></td>
                                 <td><%= blog.getUser().getName() %></td>
                                  <td><%= blog.getCreatedDate() %></td>
                                  <td><span class="status"><%= blog.getStatus() %></span></td>
                                  <td>
                                              <a href="/admin/approve/<%= blog.getId() %>" class="btn ">Approve</a>
                                              <a href="/admin/reject/<%= blog.getId() %>" class="btn ">Reject</a>
                                              <a href="/admin/remove/<%= blog.getId() %>" class="btn ">Remove</a>
                                  </td>
                         </tr>

                 <%
                    }
                }
                 %>

            </tbody>
         </table>
         </div>
        </div>
      </div>
      <footer>
        <p>@2026 Blog Platform</p>
      </footer>
    </div>
  </body>
</html>
