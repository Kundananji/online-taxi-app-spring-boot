<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <p class="lead mb-0">Book Taxis fromt eh comfort of your home</p>
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
                        <div class="card-header"><h4>Find a Taxi</h4></div>
                        <div class="card-body">
                        
				         <c:if test="${savedBooking}">
				            <div class="alert alert-success">Your booking has been successfully received!</div>
				        </c:if>
                        <form:form action="booking/add" method="post" modelAttribute="booking">
                            <div class="form-group">
                                <form:label for="name" path="name">Enter Your Name</form:label>
                                <form:input class="form-control" type="text" id="name" path="name" placeholder="Enter Your Name" aria-label="Enter Name"/>
                                
                            </div>
                            <div class="form-group">
                                <form:label for="email" path="email">Enter Your Email</form:label>
                                <form:input class="form-control" type="email" id="email" path="email" placeholder="Enter Email" aria-label="Email"/>                                
                            </div>
                            <div class="form-group">
                                <form:label for="phoneNo" path="phoneNo">Enter Your Phone Number</form:label>
                                <form:input class="form-control" type="text" id="phoneNo" path="phoneNo" placeholder="Enter Phone No." aria-label="Enter Phone No."/>                                
                            </div>
                             <div class="form-group">
                                <form:label for="pickUp" path="pickUp">Specify PickUp</form:label>
                                <form:input class="form-control" type="text" id="pickUp" path="pickUp" placeholder="Enter Pickup" aria-label="Enter Pickup"/>                                
                            </div>
                            <div class="form-group">
                                <form:label for="destination" path="destination">Specify Destination</form:label>
                                <form:input class="form-control" type="text" id="destination" path="destination" placeholder="Enter Destination" aria-label="Enter Destination"/>                                
                            </div>
                            <input type="submit" name="action" value="Find Taxi" class="btn btn-primary mt-3"/>
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
