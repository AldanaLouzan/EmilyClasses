<%@page import="bookingclass.entity.Slot"%>
<%@page import="bookingclass.entity.Classes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Aldana Louzan</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Catamaran:100,200,300,400,500,600,700,800,900" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/one-page-wonder.min.css" rel="stylesheet">
    
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
        <form action="${pageContext.request.contextPath}/ConfirmBookingServlet" method="post">
        <%
            Classes c = (Classes)session.getAttribute("classSet");
            Slot s = (Slot)session.getAttribute("slotSet");            
            String date = (String)session.getAttribute("classDate");
            int time = c.getTime();
            String type = c.getType();
            String comment = s.getComment();
            String subject = s.getSubject();
            int price = s.getPrice();
            /*int time = (Integer) session.getAttribute("classTime");
            //String time = (String)session.getAttribute("classTime");
            String type = (String)session.getAttribute("classType");
            String comment = (String)session.getAttribute("slotComment");
            String subject = (String)session.getAttribute("slotSubject");
            //String price = (String)session.getAttribute("slotPrice");
            int price = (Integer) session.getAttribute("slotPrice");*/
        %>
    <table class="table table-bordered table-hover">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Date</th>
            <th scope="col">Time</th>
            <th scope="col">Class Type</th>
            <th scope="col">Subject</th>
            <th scope="col">Comment</th>
            <th scope="col">Price</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th scope="row">1</th>
            <td><%=date%></td>
            <td><%=time%>hs - <%=time+1%>hs</td>
            <td><%=type%></td>
            <td><%=subject%></td>
            <td><%=comment%></td>
            <td>€<%=price%></td>
        </tr>
        </tbody>
      </table>
        <button type="submit" class="btn btn-primary">Confirm</button>
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
