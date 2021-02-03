<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <title>Add Menu</title>
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

<body class="main-layout Contact_page">
	<%
		int id =(int) session.getAttribute("staffid");
		String uname = (String) session.getAttribute("staffusername");
	%>
	<div class="sidebar">
            <!-- Sidebar  -->
            <nav id="sidebar">

                <div id="dismiss">
                    <i class="fa fa-arrow-left"></i>
                </div>

                <ul class="list-unstyled components">
                    <li  class="active">
                        <a href="admin_menu.jsp">Menu</a>
                    </li>
                    <li>
                        <a href="admin_ordercust.jsp">Order</a>
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
                                <li class="button_user"><a class="button" href="LoginController?action=logout">Log Out</a></li>
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
                   <h2>Edit Menu</h2>
                   <p><a href="MenuController?action=listmenu"> Back </a></p>
                </div>
             </div>
          </div>
        </div>
    </div>

    <div class="about">
        <div class="container-fluid">
            <form action="MenuController?action=editmenu" name="editmenu" method="post">
            <input type="hidden" name="id" value="<c:out value="${men.menuid}" />"/>
            <table>
                <thead>
                    <tr><th colspan="2"><a href="#"> Back </a> </th></tr>
                </thead>
                <tbody>
                <tr>
                    <td>Name</td>
                    <td><c:out value="${men.menuname}" /></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input class="form-control" placeholder="Price" type="number" name="p" value="<c:out value="${pf.format(men.menuprice)}" />"></td>
                </tr>
                <tr>
                    <td colspan="2"><button class="send" type="submit">Submit</button></td>
                </tr>
                </tbody>
            </table>
            </form>
        </div>
    </div>


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
    <div class="overlay"></div>
    <!-- Javascript files-->
    <script src="js/jquery.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/custom.js"></script>
     <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
    
</body>

</html>