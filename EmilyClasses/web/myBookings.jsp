<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Bookings</title>
    </head>
    
    <body>
    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark navbar-custom fixed-top">
        <div class="container">
            <a class="navbar-brand" href="home.jsp">Book a class</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="home.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="metodology.jsp">Metodology</a>
                    </li>
                    <!--<li class="nav-item">
                            <a class="nav-link" href="./privatepage2.html#contactform">Newsletter</a>
                        </li>-->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="myAccount.jsp" id="navbarDropdown" role="button"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            My Account
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="bookClass.jsp">Book a class</a>
                            <a class="dropdown-item" href="myBookings.jsp">My bookings</a>
                            <div class="dropdown-divider"></div>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./index.jsp">Log Out</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <header class="masthead text-center text-white">
        <div class="masthead-content">
            <div class="container">
                <%
                    String name = (String)session.getAttribute("studentName"); 
                %>
              <h1 class="masthead-heading mb-0"><%=name%> if you say Yes, you are saying yes to succeed</h1>
            </div>
        </div>
        <div class="bg-circle-1 bg-circle"></div>
        <div class="bg-circle-2 bg-circle"></div>
        <div class="bg-circle-3 bg-circle"></div>
        <div class="bg-circle-4 bg-circle"></div>
    </header>
    
    <section>

    <div class="controls">
        <h2 class="masthead-subheading mb-0">This is your booking</h2>
    </div>
    <form action="MyBookingsServlet" method="post">
        <%
            
            ResultSet rs = (ResultSet)session.getAttribute("bookingsResultSet");
            
        %>
    <table class="table table-bordered table-hover">
        <tr>
            <th>ID</th>
            <th>Date</th>
            <th>Time</th>
            <th>Class Type</th>
            <th>Quantity of Students</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Subject</th>
            <th>Price</th>
        </tr>
        <% 
            while(rs.next()){ 
        %>
           <td><%=rs.getInt("idbooking") %></td>
           <td><%=rs.getString("date") %></td>
           <td><%=rs.getInt("time") %></td>
           <td><%=rs.getString("type") %></td>
           <td><%=rs.getInt("quantity_students") %></td>
           <td><%=rs.getString("s_name") %></td>
           <td><%=rs.getString("s_surname") %></td>
           <td><%=rs.getString("subject") %></td>
           <td><%=rs.getInt("price") %></td>
        <% } %>
    </table>
        <button type="submit" class="btn btn-primary">Continue</button>
    </form>
    </section>
        

    <!-- Footer -->
    <footer class="py-5 bg-black">
      <div class="container">
        <p class="m-0 text-center text-white small">Copyright &copy; Book a Class 2019 all rights reserved</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    </body>

</html>
