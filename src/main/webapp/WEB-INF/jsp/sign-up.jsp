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
        <title>Register Account</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <!-- Page content-->
        <div class="container">
            <div class="row">
                <!-- Blog entries-->
                <div class="col-lg-6">
                    <!-- Featured blog post-->
                    <div class="card m-4">
                       
                        <div class="card-body">
                            
                        <c:if test="${savedRegistration}">
				            <div class="alert alert-success m-3"><i class="bi bi-check"></i> Your account has been successfully created! You can now login. <a href="login">Click Here To Login</a></div>
				        </c:if>
				        <c:if test="${savedRegistration==false}">
				            <div class="alert alert-warning m-3"><c:out value = "${response.message}"/></div>
				        </c:if>
                        <form:form action="users/register" method="post" modelAttribute="userRegistration">
                            <div class="form-group">
                                <form:label for="name" path="name">Enter Your Name</form:label>
                                <form:input class="form-control" type="text" id="name" path="name" placeholder="Enter Your Name" aria-label="Enter Name"/>
                                
                            </div>
                            <div class="form-group">
                                <form:label for="emailAddress" path="emailAddress">Enter Your Email</form:label>
                                <form:input class="form-control" type="emailAddress" id="emailAddress" path="emailAddress" placeholder="Enter Email" aria-label="Email"/>                                
                            </div>
                            <div class="form-group">
                                <form:label for="phoneNumber" path="phoneNumber">Enter Your Phone Number</form:label>
                                <form:input class="form-control" type="text" id="phoneNumber" path="phoneNumber" placeholder="Enter Phone No." aria-label="Enter Phone No."/>                                
                            </div>
                             <div class="form-group">
                                <form:label for="password" path="Password">Password</form:label>
                                <form:input class="form-control" type="password" id="password" path="password" placeholder="Enter Password" aria-label="Enter Password"/>                                
                            </div>
                           <div class="form-group">
                                <form:label for="confirmPassword" path="confirmPassword">Confirm Password</form:label>
                                <form:input class="form-control" type="password" id="confirmPassword" path="confirmPassword" placeholder="Confirm Password" aria-label="Confirm Password"/>                                
                            </div>
                            <div class="form-group">
                             <form:label for="selectedUserType" path="selectedUserType">Select User Type</form:label>
                             <form:select  path="selectedUserType" id="selectedUserType" class="form-control">
							    <form:option value=""> --Select User Type--</form:option>
							  
							         <c:forEach items="${userRegistration.userTypes}" var="userType">
								          <form:option value="${userType.userTypeId}">  <c:out value = "${userType.name}"/></form:option>
								      </c:forEach>
							  </form:select>
							  </div>

                            <input type="submit" name="action" value="Register" class="btn btn-primary mt-3"/>
                         </form:form>
                        </div>
                    </div>       

                </div>
                <div class="col-lg-6">
                 <div class="card m-4">
                 
                   <div class="card-body">
                   <a href="#!"><img class="img-fluid rounded" src="assets/cover.jpg" alt="Online Taxi Application" /></a>
                   <h2>Sign Up for an Account</h2>
                   <p>Sign up for an account and experience convenience at your finger tips</p>
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
