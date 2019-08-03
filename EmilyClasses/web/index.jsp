<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="WebUtil.UIConstants" %>
<%@page import="java.util.*" %>

<html>
<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Aldana Louzan</title>

  <!--Script for botton video-->
  <script src="/jquery.min.js"></script>
  <script src="/bootstrap.min.js"></script>
  <script>
    $(function () {
      $(".video").click(function () {
        var theModal = $(this).data("target"),
          videoSRC = $(this).attr("data-video"),
          videoSRCauto = videoSRC + "?modestbranding=1&rel=0&controls=0&showinfo=0&html5=1&autoplay=1";
        $(theModal + ' iframe').attr('src', videoSRCauto);
        $(theModal + ' button.close').click(function () {
          $(theModal + ' iframe').attr('src', videoSRC);
        });
      });
    });
  </script>



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
      <a class="navbar-brand" href="#">Book a class</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
        aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="#" data-toggle="modal" data-target="#myModal">Log In</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="registerForm.jsp">Register</a>
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
          <div class="p-5">
            <img class="img-fluid rounded-circle" src="img/science.jpg" alt="">
          </div>
        </div>
        <div class="col-lg-6 order-lg-1">
          <div class="p-5">
            <h2 class="display-4">Science is the door to creativity and innovation</h2>
            <p>So, even if you have felt frustrated learning Mathematics, Physics or Chemistry, you sholdn´t give up and
              give us a try! Book your class and start having fun while learning</p>
              <button class="btn btn-primary btn-success video" data-video="https://www.youtube.com/embed/BdDD9JX-Tyg"
          data-toggle="modal" data-target="#videoModal">Check more out with this video</button>
          </div>
          
        </div>
      </div>
      <div class="modal fade" id="videoModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
        aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-body">
              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                  aria-hidden="true">&times;</span></button>
              <iframe width="100%" height="350" src="" frameborder="0" allowfullscreen></iframe>
            </div>
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
            <form action="LoginServlet" method="post">
              <div class="form-group">
                <label for="email">User:</label>
                <input type="email" class="form-control" id="email" placeholder="Enter e-mail" name="<%=UIConstants.USUARIO%>" value="">
                </div>
              <div class="form-group">
                <label for="pwd">Password:</label>
                <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="<%=UIConstants.PASSWORD%>" value="">
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
