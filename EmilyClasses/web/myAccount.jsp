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
    <link href="https://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/one-page-wonder.min.css" rel="stylesheet">

  </head>

  <body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark navbar-custom fixed-top">
  <div class="container">
    <a class="navbar-brand" href="home.jsp">Book a class</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
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
        <!--
        <li class="nav-item">
          <a class="nav-link" href="./privatepage2.html#contactform">Newsletter</a>
        </li>
        -->  
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="myAccount.jsp" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            My Account
          </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdown">
            <a class="dropdown-item" href="classSetting.jsp">Book a class</a>
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
              <h1 class="masthead-heading mb-0">Hello <%=name%></h1>
            </div>
        </div>
        <div class="bg-circle-1 bg-circle"></div>
        <div class="bg-circle-2 bg-circle"></div>
        <div class="bg-circle-3 bg-circle"></div>
        <div class="bg-circle-4 bg-circle"></div>
    </header>
    
    <section>
      <div class="container">
        <div class="row align-items-center">
          <div class="col-lg-6 order-lg-2">
            <div class="p-5">
                <img class="img-fluid rounded-circle" src="img/private_classes.jpg" alt="">
            </div>
          </div>
          <div class="col-lg-6 order-lg-1">
            <div class="p-5">
              <h2 class="display-4">Private Classes</h2>
              <p>If you find it difficult to get focus on what you are studying and you beleive that you are more efficient in a quiet environment. 
                    We strongly recommend our private classes. This classes will be taylored depending on your individual needs. 
                  <b>Price: €50 per hour</b>
                </p> 
            </div>
          </div>
        </div>
      </div>
    </section>

    <section>
      <div class="container">
        <div class="row align-items-center">
          <div class="col-lg-6">
            <div class="p-5">
              <img class="img-fluid rounded-circle" src="img/mix_students.jpg" alt="">
            </div>
          </div>
          <div class="col-lg-6">
            <div class="p-5">
              <h2 class="display-4">Semi-private classes</h2>
              <p>You can also find the option of a mix-class. In this classes you will find students that even though will study different topics
                    are in your same situation. Basically you will find extra support in this friendly environment.
                    <b>Price: €40 per hour</b> 
            </div>
          </div>
        </div>
      </div>
    </section>

    <section>
      <div class="container">
        <div class="row align-items-center">
          <div class="col-lg-6 order-lg-2">
            <div class="p-5">
              <img class="img-fluid rounded-circle" src="img/teamwork.jpg" alt="">
            </div>
          </div>
          <div class="col-lg-6 order-lg-1">
            <div class="p-5">
              <h2 class="display-4">In Group Classes</h2>
              <p>We give you the possibility to study with your own group of friends (maximun 4 people). We encourage study groups. Not only does it help
                 to avoid procrastination, but also push students to think creatively and learn from their pairs. Come together and become the "Dream Team"!<b>Price: €30 per hour & per person</b> 
            </div>
          </div>
        </div>
      </div>
      <div class="container">
            <div class="row">
                <div class="col-sm-12" id="contactform">
                    <h1>Newsletter</h1>
                    <p>Stay up to date with our latest courses and shows:</p>
                </div>
            <form class="form-inline" action="PDO/newsletter.php" method="post">
              <label for="name" class="mr-sm-2">Name:</label>
              <input type="name" class="form-control mb-2 mr-sm-2" id="name" name="name">
              <label for="email" class="mr-sm-2">E-mail:</label>
              <input type="email" class="form-control mb-2 mr-sm-2" id="email" name="email">
              <button type="submit" class="btn btn-primary mb-2">Submit</button>
            </form>
          </div>
      </div>  
                    
  </section>   
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