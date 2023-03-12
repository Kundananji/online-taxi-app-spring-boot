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
        <title>Add Taxi</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <!-- Responsive navbar-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="#!">Online Taxi</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                        <li class="nav-item"><a class="nav-link" href="/">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="#!">View Taxis</a></li>
                        <li class="nav-item"><a class="nav-link" href="add-taxi">Add Taxis</a></li>

                    </ul>
                </div>
            </div>
        </nav>
        <!-- Page header with logo and tagline-->
        <header class="py-5 bg-light border-bottom mb-4">
            <div class="container">
                <div class="text-center my-5">
                    <h1 class="fw-bolder">Welcome to Online Tax Booking!</h1>
                    <p class="lead mb-0">Add a new Taxi</p>
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
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Online Taxi Application 2023</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>
