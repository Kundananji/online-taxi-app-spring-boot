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
        
        <!-- custom styles -->
        <link href="css/common.css" rel="stylesheet" />
    </head>
    <body>
 <jsp:include page="menu.jsp"></jsp:include>
        <!-- Page header with logo and tagline-->
        <header class="py-5 bg-light border-bottom mb-4">
            <div class="container">
                <div class="text-center my-5">
                    <h1 class="fw-bolder">Welcome <c:out value="${loggedInUser.name}"/>! </h1>
                     <c:if test="${loggedInUser.userType.name =='Taxi User'}">
                       <p class="lead mb-0">Book Taxis from the comfort of your home</p>
                    </c:if>
                    <c:if test="${loggedInUser.userType.name =='Taxi Owner'}">
                        <p class="lead mb-0">Manage Your Taxis on the Go!</p>
                    </c:if>
                </div>
            </div>
        </header>
        <!-- Page content-->
        <div class="container">
            <div class="row">
                <!-- Blog entries-->
                <div class="col-lg-8">
                   
                    <div class="card mb-4">
                    <c:if test="${loggedInUser.userType.name =='Taxi User'}">
                    	<a href="#!"><img class="card-img-top" src="assets/cover.jpg" alt="..." /></a>
                    </c:if>
                       
                        <div class="card-body">     
                        
                           <!-- taxi user views taxis -->   
                                                  
                             <c:if test="${loggedInUser.userType.name =='Taxi User'}">
                             <h2 class="card-title">View Available Taxis</h2>
                             <c:if test="${search == null || search.size()==0}">
                                <div class="alert alert-warning">No Taxis found. Make your booking to view available taxis</div>
                             </c:if>
                             <c:if test="${search != null && search.size()>0}">
                                <table class="table table-striped">
						            <thead>
						                <tr>
						                    <th>RegNo.</th>
						                    <th>Name</th>
						                    <th>Driver</th>
						                    <th>Distance Away</th>
						                </tr>
						            </thead>
						            <tbody>
						                <c:forEach items="${search}" var="taxi">
						                    <tr>
						                        <td>${taxi.registrationNumber}</td>
						                        <td>${taxi.name}</td>
						                        <td>${taxi.driverName}</td>
						                        <td>${String.format("%.2f",taxi.distance)} Kilometers</td>
						                    </tr>
						                </c:forEach>
						            </tbody>
						        </table> 
                            </c:if> 
                            </c:if> 
                                             
                            
                            <!--  taxi owner views taxis -->
                             <c:if test="${loggedInUser.userType.name =='Taxi Owner'}">
                             <h2 class="card-title">View Your Taxis</h2>
                             <c:if test="${taxis == null || taxis.size()==0}">
                                <div class="alert alert-warning">You have no taxis added. Please add a taxi.</div>
                             </c:if>
                                <table class="table table-striped">
						            <thead>
						                <tr>
						                    <th>RegNo.</th>
						                    <th>Name</th>
						                    <th>Driver</th>
						                    <th>Location</th>
						                </tr>
						            </thead>
						            <tbody>
						                <c:forEach items="${taxis}" var="taxi">
						                    <tr>
						                        <td>${taxi.registrationNumber}</td>
						                        <td>${taxi.name}</td>
						                        <td>${taxi.driverName}</td>
						                        <td>${taxi.location}</td>
						                    </tr>
						                </c:forEach>
						            </tbody>
						        </table> 
                            </c:if>  
                                     
                        </div>
                    </div>       

                </div>
                <!-- Side widgets-->
                <div class="col-lg-4">
                    <!-- Search widget-->
            <div class="card mb-4">
                        <div class="card-header"><h4>Find a Taxi</h4></div>
                        <div class="card-body">
                        
                        <!--  Taxi Owner Enter Taxi Details-->
                        
                        <c:if test="${loggedInUser.userType.name =='Taxi Owner'}">
                        
                            <c:if test="${addTaxiSuccess}">
					            <div class="alert alert-success m-2">Successfully added Taxi with Reg Number: ${addedTaxiReg}</div>
					        </c:if>
                        
                            <form:form action="taxi/add" method="post" modelAttribute="taxi">

                           
                            <div class="form-group">
                                <form:label path="registrationNumber">RegNo: </form:label>
                                <form:input type="text" path="registrationNumber" class="form-control"/>
                            </div>
                            <div class="form-group">
						         <form:label path="name">Taxi Name: </form:label> 
						         <form:input type="text" path="name" class="form-control"/>                              
                            </div>
                            <div class="form-group">
                                <form:label path="driverName">Driver Name: </form:label>
                                 <form:input path="driverName" class="form-control" placeholder="Enter Driver" aria-label="Enter Driver"/>
                            </div>
                     
                            <div class="form-group">
                                <form:label path="location">Location: </form:label> 
                                <form:input path="location"  onfocus="pickLocation(this)" class="form-control" id="location" type="text" readonly="true" placeholder="Click to Pick Location" aria-label="Click to Pick Location"/>                               
                            </div>
                            <input type="submit" name="action" value="Add Taxi" class="btn btn-primary mt-3"/>
                         </form:form>
                        
                        </c:if>
                        
                        <!--  Taxi User book a  Taxi-->
                        <c:if test="${loggedInUser.userType.name =='Taxi User'}">
                        
				         <c:if test="${addBookingSuccess}">
				            <div class="alert alert-success">Your booking has been successfully received!</div>
				        </c:if>
                        <form:form action="booking/add" method="post" modelAttribute="booking">
                            <div class="form-group">
                                <form:label for="name" path="name">Enter Your Name</form:label>
                                <form:input class="form-control" type="text" id="name" path="name" placeholder="Enter Your Name" aria-label="Enter Name" readonly="true"/>
                                
                            </div>
                            <div class="form-group">
                                <form:label for="email" path="email">Enter Your Email</form:label>
                                <form:input class="form-control" type="email" id="email" path="email" placeholder="Enter Email" aria-label="Email" readonly="true"/>                                
                            </div>
                            <div class="form-group">
                                <form:label for="phoneNo" path="phoneNo">Enter Your Phone Number</form:label>
                                <form:input class="form-control" type="text" id="phoneNo" path="phoneNo" placeholder="Enter Phone No." aria-label="Enter Phone No." readonly="true"/>                                
                            </div>
                             <div class="form-group">
                                <form:label for="pickUp" path="pickUp">Specify PickUp</form:label>
                                <form:input class="form-control" type="text" onfocus="pickLocation(this)" id="pickUp" path="pickUp" placeholder="Click to Enter Pickup" aria-label="Click to Pick Pickup" readonly="true"/>                                
                            </div>
                            <div class="form-group">
                                <form:label for="destination" path="destination">Specify Destination</form:label>
                                <form:input class="form-control" type="text" onfocus="pickLocation(this)" id="destination" path="destination" placeholder="Click to Enter Destination" aria-label="Click to Pick Destination" readonly="true"/>                                
                            </div>
                            <input type="submit" name="action" value="Find Taxi" class="btn btn-primary mt-3"/>
                         </form:form>
                         
                         </c:if>
                         
                         <!--  End card body -->
                        </div>
                    </div>
        
     
                </div>
            </div>
        </div>
 <jsp:include page="footer.jsp"></jsp:include>
 
 <!-- Google Map Modal -->
 
  <!-- modal: pick location -->
  <div class="modal fade" id="pickLocationModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Pick Location From Map</h5>
          <button class="close" type="button" data-bs-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">
          <div id="alerting-area"></div>
          <div id="googleMap" style="width:100%;height:400px;">

          </div>


        </div>
        <div class="modal-footer">
          <button class="btn btn-primary" type="button" data-bs-dismiss="modal">Okay</button>

        </div>
      </div>
    </div>
  </div>
 
 
 
        <!-- Bootstrap core JS-->
        <script src="js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <script src="js/jquery-3.6.3.min.js"></script>
        
        
        
        <!--  Google Maps -->
    <script>

    window.lastPickedLocation = null;

    let showLocation = (location) => {
      $('#pickLocationModal').modal('show');
      $('#alerting-area').html('');
      loadMap(null, location);
    }


    let pickLocation = (obj) => {
      $('#pickLocationModal').modal('show');
      $('#alerting-area').html(`<div class="alert alert-info">Click on Map to Pick Locaton</div>`);
      loadMap(obj);
    }

    let loadMap = (obj, mLocation) => {

      //initialize map to lusaka

      let currentPosition = new google.maps.LatLng(-15.416667, 28.283333);
      if(window.lastPickedLocation){ //remember last picked location
        currentPosition = window.lastPickedLocation;

      }
      if (mLocation) {
        let locationParts = mLocation.split(",");
        currentPosition = new google.maps.LatLng(locationParts[0], locationParts[1]);
      }
      else{
    	  //attempt to pick location from device
    	  
    	  if (navigator.geolocation) {
          navigator.geolocation.getCurrentPosition(
		        (position) => {
		 
		         const pos =    new google.maps.LatLng(position.coords.latitude,position.coords.longitude);
		          // Add a marker at the center of the map.
		          addMarker(pos, map);
		          console.log('Setting default location');
		        },
		        () => {
		          console.log('defaulting to default location')
		        }
		      );
		    } else {
		      // Browser doesn't support Geolocation
		        console.log('defaulting to default location');
		    }
      }
      
      


      var map = new google.maps.Map(document.getElementById("googleMap"));

      currentMarker = null;

     if(!mLocation){ //only listen for location chances if mLocation is not defined

	      // This event listener calls addMarker() when the map is clicked.
	      google.maps.event.addListener(map, "click", (event) => {
	        addMarker(event.latLng, map);
	      });
    }

      // Add a marker at the center of the map.
      addMarker(currentPosition, map);


      // Adds a marker to the map.
      function addMarker(location, map) {
        if (currentMarker) {
          currentMarker.setMap(null);
        }
        // Add the marker at the clicked location
        currentMarker = new google.maps.Marker({
          position: location,
          map: map,

        });

        map.setCenter(location); //center map
        map.setZoom(15);

        if (obj) {
          var mLocation = location.toJSON();
          obj.value = mLocation.lat + "," + mLocation.lng;
          //$('#pickLocationModal').modal('hide');

        }
      }




    }
  </script>

  <!-- Google map -->
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyASoSGvmJE4yIFaP4K0ijV-hpemGBevikw"></script>
        
    </body>
</html>
