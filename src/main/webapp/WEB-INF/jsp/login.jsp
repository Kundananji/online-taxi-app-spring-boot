<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Online Taxi Application</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <!-- Page header with logo and tagline-->
        <header class="py-5 bg-light border-bottom mb-4">
            <div class="container">
                <div class="text-center my-5">
                    <h1 class="fw-bolder">Welcome to Online Tax Booking!</h1>
                    <p class="lead mb-0">Book Taxis from  the comfort of your home</p>
                </div>
            </div>
        </header>
        <!-- Page content-->
        <div class="container">
            <div class="row">
                <!-- Blog entries-->
                <div class="col-lg-8">
                    <!-- Featured blog post-->
                    <div class="card mb-4">
                        <a href="#!"><img class="card-img-top" src="assets/cover.jpg" alt="..." /></a>
                        <div class="card-body">
                            
                            <h2 class="card-title">Book Online</h2>
                            <p class="card-text">Book a taxi to anywhere from the comfort of your home!</p>
                        
                        </div>
                    </div>       

                </div>
                <!-- Side widgets-->
                <div class="col-lg-4">
                    <!-- Search widget-->
                    <div class="card mb-4">
                        <div class="card-header"><h4>Login</h4></div>
                        <div class="card-body">
                        
				         <c:if test="${status!=null && status == 'success'}">
				            <div class="alert alert-success">Login Successful!</div>
				        </c:if>
				        <c:if test="${status !=null && status != 'success'}">
				            <div class="alert alert-warning">${message}</div>
				        </c:if>
                        <form:form action="users/login" method="post" modelAttribute="userLogin">
                            <div class="form-group">
                                <form:label for="username" path="username">Enter Your Email or Phone Number</form:label>
                                <form:input class="form-control" type="text" id="username" path="username" placeholder="Enter Email or phone Number" aria-label="Enter Email or Phone Number"/>
                                
                            </div>
                    
                            <div class="form-group">
                                <form:label for="password" path="password">Enter Password</form:label>
                                <form:input class="form-control" type="password" id="password" path="password" placeholder="Enter Password" aria-label="Enter Password"/>                                
                            </div>
                            <input type="submit" name="action" value="Login" class="btn btn-primary mt-3"/>
                         </form:form>
                        </div>
                    </div>
        
     
                </div>
            </div>
        </div>
 <jsp:include page="footer.jsp"></jsp:include>
        <!-- Bootstrap core JS-->
        <script src="js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>
