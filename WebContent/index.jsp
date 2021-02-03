<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <title>Home</title>
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
    
    <style>
    #owl-demo .item{
        margin: 3px;
    }
    #owl-demo .item img{
        display: block;
        width: 100%;
        height: auto;
    }
    </style>
</head>
<!-- body -->

<body class="main-layout">
    <!-- loader  -->
    <div class="loader_bg">
        <div class="loader"><img src="images/loading.gif" alt="" /></div>
    </div>

    <div class="wrapper">
    <!-- end loader -->

     <div class="sidebar">
            <!-- Sidebar  -->
            <nav id="sidebar">

                <div id="dismiss">
                    <i class="fa fa-arrow-left"></i>
                </div>

                <ul class="list-unstyled components">
                    <li class="active">
                        <a href="MenuController?action=nologinindex">Home</a>
                    </li>
                    <li>
                        <a href="about.jsp">About</a>
                    </li>
                    <li>
                        <a href="MenuController?action=nologinlistMenu">Recipe</a>
                    </li>
                </ul>
            </nav>
        </div>

    <div id="content">
    <!-- header -->
    <header>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-3">
                    <div class="full">
                        <a class="logo" href="MenuController?action=nologinindex"><img src="images/logo.png" alt="#" /></a>
                    </div>
                </div>
                <div class="col-md-9">
                    <div class="full">
                        <div class="right_header_info">
                            <ul>
                                <li class="button_user"><a class="button active" href="login.jsp">Login</a>
                                  <a class="button" href="register.jsp">Register</a></li>
                                <li>
                                    <button type="button" id="sidebarCollapse">
                                        <img src="images/menu_icon.png" alt="#">
                                    </button>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <!-- end header -->

    <!-- start slider section -->
    <div class="slider_section">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="full">
                        <div id="main_slider" class="carousel vert slide" data-ride="carousel" data-interval="5000">
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <div class="row">
                                        <div class="col-md-5">
                                            <div class="slider_cont">
                                                <h3>Neo Cafe Club<br>is ready to delivery right in front of your doorstep</h3>
                                                <p>We provide Malay breakfast that is perfect your starting day with a reasonable price. Don't wait, order now! Just click this button &darr;</p>
                                                <a class="main_bt_border" href="login.jsp">Order Now</a>
                                            </div>
                                        </div>
                                        <div class="col-md-7">
                                            <div class="slider_image full text_align_center">
                                                <img class="img-responsive" src="images/intronasilemak.jpg" alt="#" />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- end slider section -->

    <!-- section -->
    <section class="resip_section">
        <div class="container">
            <div class="row">
         <div class="col-md-12">
       <div class="ourheading">
        <h2>Our Recipes</h2>
      </div>
    </div>    
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="owl-carousel owl-theme">
                <c:forEach items="${semuafood}" var="food">
                    <div class="item">
                        <div class="product_blog_cont">
                            <h3><c:out value="${food.menuname}" /></h3>
                            <h4><span class="theme_color">RM</span><c:out value="${pf.format(food.menuprice)}" /></h4>
                        </div>
                    </div>
				</c:forEach>                   
                <c:forEach items="${semuadrink}" var="drink">
                    <div class="item">
                        <div class="product_blog_cont">
                            <h3><c:out value="${drink.menuname}" /></h3>
                            <h4><span class="theme_color">RM</span><c:out value="${pf.format(drink.menuprice)}" /></h4>
                        </div>
                    </div>
                </c:forEach>
                </div>
            </div>
        </div>
    </div>
    </div>
    </div>
    </section>

    <div class="bg_bg">
    <!-- about -->
    <div class="about">
        <div class="container">
          <div class="row">
             <div class="col-md-12">
                 <div class="title">
                    <i><img src="images/title.png" alt="#"/></i>
                    <h2>About Our Food &amp; Restaurant</h2>
                    <span>Neo Cafe Club is a club where we share our hapiness through food include a high quality food delivery. It is only been a year we run our business yet we are grateful for the high review.
                       <br> Thank you for supporting us
                    </span>
                 </div>
              </div>
           </div>
           <div class="row">
             <div class="col-xl-6 col-lg-6 col-md-12 col-sm-12">
                 <div class="about_box">
                     <h3>Best Food</h3>
                     <p>Nasi Lemak is made by one of our founder, Nabil Naim, recipe from his hometown. Our ingredients is from local market #supportLocal. It is a must to grab one for your breakfast day.<br>You can enjoy it with Ayam Paprik.</p>
                     <a href="about.jsp">Read More <i class="fa fa-long-arrow-right" aria-hidden="true"></i></a>
                 </div>
             </div>
              <div class="col-xl-5 col-lg-5 col-md-10 col-sm-12 about_img_boxpdnt">
                 <div class="about_img">
                     <figure><img src="images/about-img.jpg" alt="#/"></figure>
                 </div>
             </div>      
           </div> 
        </div>
    </div>
    <!-- end about -->
    <br><br>
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

    </div>
    </div>
    </div>
    <div class="overlay"></div>
    <!-- Javascript files-->
    <script src="js/jquery.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/custom.js"></script>
     <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
    
     <script src="js/jquery-3.0.0.min.js"></script>
   <script type="text/javascript">
        $(document).ready(function() {
            $("#sidebar").mCustomScrollbar({
                theme: "minimal"
            });

            $('#dismiss, .overlay').on('click', function() {
                $('#sidebar').removeClass('active');
                $('.overlay').removeClass('active');
            });

            $('#sidebarCollapse').on('click', function() {
                $('#sidebar').addClass('active');
                $('.overlay').addClass('active');
                $('.collapse.in').toggleClass('in');
                $('a[aria-expanded=true]').attr('aria-expanded', 'false');
            });
        });
    </script>

     
      <script>
         $(document).ready(function() {
           var owl = $('.owl-carousel');
           owl.owlCarousel({
             margin: 10,
             nav: true,
             loop: true,
             responsive: {
               0: {
                 items: 1
               },
               600: {
                 items: 2
               },
               1000: {
                 items: 5
               }
             }
           })
         })
      </script>

</body>

</html>