<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Responsive navbar-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="#!">Online Taxi</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="/">Home</a></li>          

                
                <c:if test="${loggedInUser==null}">
                <li class="nav-item"><a class="nav-link" href="login">Login</a></li>
                <li class="nav-item"><a class="nav-link" href="sign-up">Sign Up</a></li>
                </c:if>
                <c:if test="${loggedInUser!=null}">
                   <li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>