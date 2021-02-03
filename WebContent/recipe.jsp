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
    <title>Recipe</title>
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
 
<body class="main-layout Recipes_page">
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
                    <li>
                        <a href="MenuController?action=nologinindex">Home</a>
                    </li>
                    <li>
                        <a href="about.jsp">About</a>
                    </li>
                    <li class="active">
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
                        <a class="logo" href="#"><img src="images/logo.png" alt="#" /></a>
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
    
    <div class="pink_bg">
   <div class="container">
            <div class="row">
               <div class="col-md-12">
                  <div class="title">
                     <h2>Our Recipes</h2>
                    
                  </div>
               </div>
            </div>
          </div>
    </div>
    
    <!-- section tukar bg -->
    <section class="resip_section">
        <!-- blog -->
    <div class="blog">
      <div class="container">
      
        <div class="title">
          <h2>Food</h2>
        </div>
        <div class="row">
         <c:forEach items="${semuafood}" var="food">
	          <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 mar_bottom">
	            <div class="blog_box"> 
	              <div class="blog_img_box">
	                <figure>
	                <h3><c:out value="${food.menuname}" /></h3>
	                </figure>
	              </div>
	              <h3>RM <c:out value="${pf.format(food.menuprice)}" /></h3>
	              <p><c:out value="${food.fooddesc}" /></p>
				</div>
	        </div>
	        </c:forEach>   
	     </div>
	     
	     <div class="title">
          <h2>Drink</h2>
        </div>     
	     <div class="row">
	        <c:forEach items="${semuadrink}" var="drink">
	          <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 mar_bottom">
	            <div class="blog_box"> 
	              <div class="blog_img_box">
	                <figure>
	              	<h3><c:out value="${drink.menuname}" /></h3>
	                </figure>
	              </div>
	              <h3>RM <c:out value="${pf.format(drink.menuprice)}" /></h3>
	              <p><c:out value="${drink.drinktype}" /></p>
				</div>
	        </div>
	        </c:forEach>
        </div>
    </div>
    </div>
    </section>


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