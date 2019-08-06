<%@page import="bookingclass.entity.Classes"%>
<%@page import="java.sql.ResultSet"%>
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
                <h1 class="masthead-heading mb-0">Hello ....</h1>
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
              <form action="SettingClassServlet" method="post">
                <div class="form-group ">
                    <label class="control-label requiredField">
                     Select your subject (*)
                    </span>
                </label>
                <div class="">
                 <div class="radio">
                  <label class="radio">
                   <input type="radio" name="<%=UIConstants.CTYPE%>" value="private"/>
                   Private
                </label>
               </div>
               <div class="">
                <div class="radio">
                 <label class="radio">
                  <input type="radio" name="<%=UIConstants.CTYPE%>" value="semiprivate"/>
                  Semi-private
               </label>
              </div>
              <div class="">
                <div class="radio">
                 <label class="radio">
                  <input type="radio" name="<%=UIConstants.CTYPE%>" value="ingroup"/>
                  In-group
               </label>
              </div>
              <div class="form-group" style="display:none">
                <label class="control-label " for="select1">
                    Group size
                </label>
                   <select class="select form-control" id="select1" name="select1">
                    <option value="2">
                     2
                    </option>
                    <option value="3">
                     3
                    </option>
                    <option value="4">
                     4
                    </option>
                   </select>
              </div>
              <div class="form-group" style="display:none">
                <label class="control-label requiredField" for="email1">
                    Email
                </label>
                <input class="form-control" id="email" name="email" type="text"/>
            </div>
            <div class="form-group" style="display:none">
                <label class="control-label requiredField" for="email1">
                    Email
                </label>
                <input class="form-control" id="email" name="email2" type="text"/>
            </div>
            <div class="form-group" style="display:none">
                <label class="control-label requiredField" for="email1">
                    Email
                </label>
                <input class="form-control" id="email" name="email3" type="text"/>
            </div>
             <div class="form-group">
                <label class="control-label requiredField" for="date"> Pick a date</label>
                </label>
                <!--<input class="form-control" id="date" placeholder="YYYY-MM-DD" type="text" name="<%=UIConstants.CDATE%>" value=""/>-->
                <input type="date" id="date" class="form-control" name="<%=UIConstants.CDATE%>" value="">
             </div>
                              <div class="form-group ">
                <label class="control-label requiredField">
                 Select your subject
                </label>
                <div class="">
                 <div class="radio">
                  <label class="radio">
                   <input name="<%=UIConstants.CSUBJECT%>" type="radio" value="Mathematics"/>
                   Mathematics
                  </label>
                 </div>
                 <div class="radio">
                  <label class="radio">
                   <input name="<%=UIConstants.CSUBJECT%>" type="radio" value="Physics"/>
                   Physics
                  </label>
                 </div>
                 <div class="radio">
                  <label class="radio">
                   <input name="<%=UIConstants.CSUBJECT%>" type="radio" value="Chemistry"/>
                   Chemistry
                  </label>
                 </div>
                </div>
               </div>
               <div class="form-group ">
                <label class="control-label " for="message">
                 Add extra information (topic to study)
                </label>
                <textarea class="form-control" cols="40" id="message" name="message" rows="10"></textarea>
               </div>
                <button type="submit" class="btn btn-primary">Submit</button>
              </form>
            </div>

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
