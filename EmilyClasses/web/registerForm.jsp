<%@page import="WebUtil.UIConstants"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    
 <title>Aldana Louzan</title> 
 <!--Script for datepicker-->
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
 <!-- Isolated Version of Bootstrap, not needed if your site already uses Bootstrap -->
<link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />

 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
 <script>
$.fn.datepicker.defaults.format = "mm/dd/yyyy";
$('.datepicker').datepicker();
 </script>
 

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
        <a class="navbar-brand" href="index.jsp">Book a class</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="#" data-toggle="modal" data-target="#myModal">Log In</a>
            </li>

            <li class="nav-item">
              <a class="nav-link" href="#" data-toggle="modal" data-target="#registerForm">Register</a>
            </li>
          </ul>
        </div>    
         
    </nav>

    <header class="masthead text-center text-white">
        <div class="masthead-content">
            <div class="container">
              <h1 class="masthead-heading mb-0">Science classes</h1>              
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
          <form action="RegisterServlet" method="post">
            <div class="form-group">
              <label for="name">Name(*):</label>
              <input type="text" class="form-control" id="name" name="<%=UIConstants.STNAME%>" value="">
            </div>
            <div class="form-group">
              <label for="surname">Last Name(*):</label>
              <input type="text" class="form-control" id="surname"name="<%=UIConstants.STSURNAME%>" value="">
            </div>
            <div class="form-group">
              <label for="phone">Phone(*):</label>
              <input type="tel" class="form-control" id="phone" name="<%=UIConstants.STPHONE%>" value="">
            </div>
            <div class="form-group">
              <label for="birth">Birth(*):</label>
              <input type="text" class="form-control" id="parentName"  placeholder="YYYY-MM-DD" name="<%=UIConstants.STBIRTH%>" value="">
            </div>
            <div class="form-group" style="display:none">
              <label for="parentName">Name(*):</label>
              <input type="text" class="form-control" id="parentName" name="<%=UIConstants.PNAME%>" value="">
            </div>
            <div class="form-group" style="display:none">
              <label for="parentLastName">Last Name(*):</label>
              <input type="text" class="form-control" id="parentLastName" name="<%=UIConstants.PSURNAME%>" value="">
            </div>
            <div class="form-group" style="display:none">
              <label for="parentPhone">Phone(*):</label>
              <input type="tel" class="form-control" id="parentPhone" name="<%=UIConstants.PPHONE%>" value="">
            </div>
            <div class="form-group">
              <label for="email">E-mail(*):</label>
              <input type="email" class="form-control" id="email" name="<%=UIConstants.USUARIO%>" value="">
            </div>
            <div class="form-group">
              <label for="psw">Password(*):</label>
              <input type="password" class="form-control" id="psw" name="<%=UIConstants.PASSWORD%>" value="">
            </div>
            <div class="form-group">
              <label for="college">College/School:</label>
              <input type="text" class="form-control" id="college" name="<%=UIConstants.STCOLLEGE%>" value="">
            </div>
            <div class="form-group">
              <label for="level">Level:</label>
              <input type="text" class="form-control" id="level" name="<%=UIConstants.STLEVEL%>" value="">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
          </form>
        </div>
          <div class="col-lg-6 order-lg-1">
            <div class="p-5">
              <h2 class="display-4">Science is the door to creativity and innovation</h2>
              <p>So, even if you have felt frustrated learning Mathematics, Physics or Chemistry, you sholdn´t give up and give us a try! Book your class and start having fun while learning</p>
            </div>
          </div>
        </div>            
      </div>
    </section>   
        
    
  <!-- Footer -->
  <footer class="py-5 bg-black">
    <div class="container">
      <p class="m-0 text-center text-white small">Copyright &copy; Book a Class 2019 all rights reserved</p>
    </div>
    <!-- /.container -->
  </footer>

    <!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog">
      <div class="modal-dialog">
  
        <!-- Modal content-->
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title">Welcome back!</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
          </div>
          <div class="modal-body">
            <div class="container">
              <form action="PDO/signin_connection.php" method="post">
                <div class="form-group">
                  <label for="email">User:</label>
                  <input type="email" class="form-control" id="email" placeholder="Enter user name" name="email">
                </div>
                <div class="form-group">
                  <label for="pwd">Password:</label>
                  <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
                </div>
                <button type="submit" class="btn btn-default">Log in</button>
              </form>
            </div>
          </div>
  
        </div>
  
      </div>
    </div>
      


    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>

</html>
