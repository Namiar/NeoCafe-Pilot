<%@ page language="java" contentType="text/html; charset=windows-1256"
  pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- basic -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- mobile metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <!-- site metas -->
    <title>Register</title>
    <!-- bootstrap css -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- owl css -->
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <!-- style css -->
    <link rel="stylesheet" href="css/style.css">
    <!-- responsive-->
    <link rel="stylesheet" href="css/responsive.css">
    <!-- awesome fontfamily -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
<!-- body -->

<body class="main-layout">
    <div id="content">
    <!-- header -->
    <header>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-3">
                    <div class="full">
                        <a class="logo" href="#"><img src="images/logo.png" alt="#" /></a>
                    </div>
                </div>
                <div class="col-md-9">
                    <div class="full">
                        <div class="right_header_info">
                            <ul>
                              <li class="dinone"><a href="MenuController?action=nologinindex">Home</a></li>
                              <li class="button_user"><a class="button" href="login.jsp">Login</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <!-- end header -->
    <!-- Our Client -->
    <div class="Client">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="title">
              <br><br>
              <h2>Register</h2>
            </div>
          </div>
        </div>
        <div class="row">
                      <div class="col-md-6 offset-md-3">
             <div class="Client_box">
                        <form name="register" action="CustomerController?action=register" method="post">
                            <div class="row">
                             
                                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
                                    <p>Name</p>
                                    <input class="form-control" placeholder="Name" type="text" name="Name">
                                </div>
                                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
                                    <p>Username</p>
                                    <input class="form-control" placeholder="Username" type="text" name="Username">
                                </div>
                                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
                                    <p>Email</p>
                                    <input class="form-control" placeholder="Email" type="email" name="Email">
                                </div>
                                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
                                  <p>Password</p>
                                    <input class="form-control" placeholder="Password" type="password" name="Password">
                                </div>
                                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
                                    <button type="submit" class="send">Submit</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
        </div>
      </div>
    </div>  
    <!-- end Our Client -->
    </div>

    <!-- footer -->
    <footer>
        <div class="footer">
            <div class="col-md-12">
                <div class="footer_logo">
                  <a href="#"><img src="images/logo.png" alt="logo" /></a>
                </div>
            </div>
            <div class="col-md-12">
                <p class="lik">2020 &copy; Neo Club Cafe</p>
            </div>
        </div>
    </footer>
    <!-- end footer -->

    <div class="overlay"></div>
    <!-- Javascript files-->
    <script src="js/jquery.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/custom.js"></script>
     <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
    
     <script src="js/jquery-3.0.0.min.js"></script>

</body>

</html>