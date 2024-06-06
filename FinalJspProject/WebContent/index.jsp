<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.output.CarOutputBean"%>
<%@page import="beans.action.CommonActionBean"%>
<%@page import="controller.CommonController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Dekho</title>
<link rel="stylesheet" href="css/index.css">
<script src="js/jQuery.js"></script>
<script src="js/jqueryScript.js"></script>
</head>
<body>
<%-- <jsp:include page="../jsp/Navbar.jsp"></jsp:include> --%>

<div id="parent">
<jsp:include page="jsp/Navbar.jsp"></jsp:include>
<% if(request.getAttribute("successMessage") != null) { %>
    <p  class="message" style="color: green;"><%= request.getAttribute("successMessage") %></p>
    
<% } %>


<% if(request.getAttribute("errorMessage") != null) { %>
    <p  class="message"  style="color: red;"><%= request.getAttribute("errorMessage") %></p>
<% } %>

<% if(request.getAttribute("EmailError") != null) { %>
    <p  class="message"  style="color: red;"><%= request.getAttribute("EmailError") %></p>
<% } %>

<% CommonActionBean cActionBean= new CommonActionBean(); 
     cActionBean.getAllCar(request, response);
  
%>
        <h1></h1>
    <div id="midBanner">

            <div id="formDiv">
                <h1 style=" margin-top: 10px;">Find Your Right Car</h1>
                <form action="CommonController">
                <input type="hidden" name="action" value="searchCarBy">
                <div id="radioButton">
                    <!-- <input type="radio" name="radio" id="radio" value="price"> -->
                    <label for="radio">By Budget</label>
                    <span id="brandDiv" style="margin-left:25px;">
                    <!-- <input type="radio" name="radio" id="radio" value="brand"> -->
                    <label for="radio">By Car Type</label>
                    </sapn>
                 </div>
                    <br>
                    <select name="Budget" id="budget" class="selectForm" style=" margin-top: 20px;">
                        <option value="12">12 lakh</option>
                        <option value="10">10 Lakh</option>
                        <option value="15">15 Lakh</option>
                        <option value="30">30 Lakh</option>
                    </select>
                    <br>
                    <select name="CarType" id="cartypes" class="selectForm">
                        <option value="1">Car Types</option>
                        <option value="1">Petrol</option>
                        <option value="2">Diesel</option>
                        <option value="3">CNG</option>
                        <option value="4">Hybrid</option>
                    </select>
                    <br>
                    <input type="submit" value="SEARCH" id="submitBtn">

                </form>
            </div>
        </div>

        <!-- --------------------------- Car Card -------------------------------- -->


        <div id="UsedCars">
             <h1>Used cars</h1>
              <div id="cardBodyParent" class="">
              <%
            ArrayList cars = (ArrayList) session.getAttribute("Car");
            Iterator iterator = cars.iterator();
            while(iterator.hasNext()){
                CarOutputBean car = (CarOutputBean) iterator.next();
        %>
                    <div id="cardBody" class="">
    <div id="imgDiv">
        <img id="imgDiv" src="images/Jeep.webp" alt="">
    </div>
    <div id="carCardContent">
         <span id="carCardName"><%= car.getCarBrand() %></span> <br>
       <span id="carCardprice">Rs <%= car.getPrice() %> lakh</span> <br> <br>
        <form action="./jsp/ViewCarDetails.jsp?id=<%= car.getId() %>">
            <input type="hidden" value="<%= car.getId() %>" name="id"/>
            <input type="submit" value="Check car details" id="cardButton"/>
          </form> 
        </div>
    </div>
<%
        }
            
%>          
</div>
          <div id="UsedCars">
             <h1>Searched Cars</h1>
              <div id="cardBodyParent" class="">
              <%if(session.getAttribute("SearchCarBYPrice")!=null) {
            	  System.out.println("Car By Price");
            ArrayList Scars = (ArrayList) session.getAttribute("SearchCarBYPrice");
            Iterator iteratorS = Scars.iterator();
            while(iteratorS.hasNext()){
                CarOutputBean carS = (CarOutputBean) iteratorS.next();
        %>
                    <div id="cardBody" class="">
    <div id="imgDiv">
        <img id="imgDiv" src="images/Thar.webp" alt="">
    </div>
    <div id="carCardContent">
         <span id="carCardName"><%= carS.getCarBrand() %></span> <br>
       <span id="carCardprice">Rs <%= carS.getPrice() %> lakh</span> <br> <br>
        <form action="./jsp/ViewCarDetails.jsp?id=<%= carS.getId() %>">
            <input type="hidden" value="<%= carS.getId() %>" name="id"/>
            <input type="submit" value="Check car details" id="cardButton"/>
          </form> 
        </div>
    </div>
<%
        }
            }
              else {
            	%>
                <p>No Searched cars found .</p>
            <% } %>

                </div>
                <div style="clear: both;"></div>
                </div>
        </div>
        
        
        <div id="UsedCars">
             <h1>Searched car by state</h1>
              <div id="cardBodyParent" class="">
            <% if(session.getAttribute("SerchedCar")!=null) {
                	   System.out.println("SearchEdCars inside index");
                   ArrayList searchCars = (ArrayList)session.getAttribute("SerchedCar");
                   System.out.println("SearchEdCars"+searchCars);
                        Iterator iterator1 = searchCars.iterator();
                        System.out.println("92 before loop");
                        while(iterator1.hasNext()){
                        	 CarOutputBean serchedCar = (CarOutputBean) iterator1.next();
                        	 System.out.println("95 inside loop");
                        %>
                    <div id="cardBody" class="">
    <div id="imgDiv">
        <img id="imgDiv" src="images/Thar.webp" alt="">
    </div>
    <div id="carCardContent">
         <span id="carCardName"><%= serchedCar.getCarBrand() %></span> <br>
       <span id="carCardprice">Rs <%= serchedCar.getPrice() %> lakh</span> <br> <br>
        <form action="./jsp/ViewCarDetails.jsp?id=<%= serchedCar.getId() %>">
            <input type="hidden" value="<%= serchedCar.getId() %>" name="id"/>
            <input type="submit" value="Check car details" id="cardButton"/>
          </form> 
        </div>
    </div>
<%
        }
            }
              else {
            	%>
                <p>No Searched cars found .</p>
            <% } %>

                </div>
                <div style="clear: both;"></div>
                </div>
        </div>
        <!--=====================================================Login form====================================================  -->
         <%-- <jsp:include page="jsp/LoginForm.jsp"></jsp:include> --%>
          <div id="popupDiv">
			<div id="popupChildMain">

				<div id="LoginImg"></div>
				<div id="popup-child">
					<span id="close" onclick="validate.closeLoginPopup()">&times;</span>
					<h1 style="text-align: center;color: black;margin: 30px;">Login Form</h1>
					<Form id="LoginformDiv" >
                         <input type="hidden" value="Login" name="action"/>
                         <label for="userType">Login As:</label><br>
                               <input type="radio" id="userTypeUser" name="userType" value="user" checked/>
                               <label for="userTypeUser">User</label>
                              <input type="radio" id="userTypeAdmin" name="userType" value="admin">
                              <label for="userTypeAdmin">Admin</label><br>
						<!-- <label for="" id="labelUsername">Username :</label> <br> -->
						<input type="text" id="Username"  name="Username" placeholder="Email_id" > <br> 
						<div id="UsernameError" class="errorDiv" style="margin-left:25px">&nbsp;</div>
						<br> 
						<!-- <label for="" id="labelPassword">Password :</label> <br> -->
						<input type="password" id="Password" name="Password" placeholder="Password"  maxlength=15 >
						<br>
						<div id="PasswordError" class="errorDiv" style="margin-left:25px">&nbsp;</div><br>
                              
						<span id="registerLinkDiv"><a href="#" onclick="validate.showRegisterPopup()" id="registerlink">Not
								Register yet ?</a></span>  <span> <a href="#" style="color:red"> Forgot Password</a> </span>
						<input type="submit" id="Loginbtn" onclick="" value="Login">

					</Form>


				</div>
			</div>

			<div class="alert" id="alertBoxLogin">
			 <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
			 <strong id="msglogin"></strong>
			<div id="progressBarLogin" class="">
			
			</div>
		  </div>

		</div>
		
		<!--============================================Registeration form===============================  -->
				<div id="registerPopUp">
			<div id="Formcontainer">
				<div id="formDiv1">
				
					<form action="CommonController" id="formObj" method="post">
					    <input type="hidden" value="register" name="action"/>
						<span id="closeRegister" onclick="validate.closeRegisterPopup()">&times;</span>
						<!-- <div id="nameDiv" class=""> -->
						<label for="fname" class="lableColor">First Name <span class="starColor">*</span>: </label> <br>

						<input type="text" id="fname" name="firstname" placeholder="Your First name.."
							class="inpformat inpValid" onkeydown="validate.inputErrorDisplay(this)" autofocus>
						<div id="firstnameError" class="errorDiv">&nbsp;</div>
						<!-- <br> -->
						<!-- </div> -->

						<!-- <div id="lnameDiv" class=""> -->
						<label for="lname" class="lableColor">Last Name <span class="starColor">*</span> : </label> <br>

						<input type="text" id="lname" name="lastname" placeholder="Your last name.."
							class="inpformat inpValid" onkeydown="validate.inputErrorDisplay(this)">
						<div id="lastnameError" class="errorDiv">&nbsp;</div>
						<!-- </div> -->


						<!-- <label for="gender" class="lableColor">Gender <span class="starColor">*</span>: </label>
						<label class="lableColor"><input type="radio" name="gender" id="gender"
								value="male">Male</label>
						<label class="lableColor"><input type="radio" name="gender" id="gender"
								value="female">Female</label>
						<label class="lableColor"><input type="radio" name="gender" id="gender"
								value="Other">Other</label>
						<div id="errorSpan"></div> -->
						<br>
						<!-- <div id="dobDiv" class="">
							<label for="dob" class="lableColor">Date Of Birth <span class="starColor">*</span>: </label>
							<br>

							<input type="text" id="dob" name="dob" placeholder="DD/MM/YYYY"
							oninput="validate.inputErrorDisplay(this)" class="inpformat">
							<div id="dobError" class="errorDiv">&nbsp;</div>
						</div>

						<div id="ageDiv" class="">
							<label for="age" class="lableColor">Age <span class="starColor">*</span>: </label> <br>

							<input type="text" name="age" id="age" class="inpformat" onchange="validate.inputErrorDisplay(this)" readonly="readonly" placeholder="00">
							<div id="ageError" class="errorDiv">&nbsp;</div>
						</div> -->

						<label for="mobile" class="lableColor">Mobile no <span class="starColor">*</span>: </label> <br>

						<input type="tel" name="mobileNo" id="mobile" minlength=1 maxlength=10 class="inpformat" onkeypress="validate.inputErrorDisplay(this)" placeholder="9112345678">
						<div id="mobileError" class="errorDiv">&nbsp;</div>

						<label for="email" class="lableColor">Email-id <span class="starColor">*</span>: </label> <br>
						<input type="email" name="email" id="email" class="inpformat" onkeydown="validate.inputErrorDisplay(this)" placeholder="example@gmail.com"/>
						<div id="emailError" class="errorDiv">&nbsp;</div>

						<label for="password" class="lableColor">Password <span class="starColor">*</span>: </label> <br>
						<input type="text" name="password" id="password" class="inpformat" oninput="validate.inputErrorDisplay(this)" placeholder="Pass@123"/>
						<div id="passwordError" class="errorDiv">&nbsp;</div>

						<label for="confirmPassword" class="lableColor">Confirm Password <span class="starColor">*</span>: </label> <br>
						<input type="password" name="confirmPassword" id="confirmPassword" class="inpformat" oninput="validate.inputErrorDisplay(this)"  placeholder="Pass@123"/>
						<div id="confirmPasswordError" class="errorDiv">&nbsp;</div>

						

						<label for="address" class="lableColor">Address <span class="starColor">*</span>: </label><br>
						<input type="text"name="addressArea" class="inpformat" id="addressArea" cols="53" rows=""
							style="margin:10px;width:400px;" oninput="validate.inputErrorDisplay(this)">
						<div id="addressAreaError" class="errorDiv"></div>

						<label for="state" class="lableColor">State <span class="starColor">*</span>: </label>
						<select name="state" id="state" onclick="validate.state()">
							<option value="" >Select state</option>
							<option value="Maharashtra">Maharashtra</option>
							<option value="Gujrat">Gujrat</option>
							<option value="Rajastan">Rajastan</option>
							<!-- <option value="Jalgaon">Jalgaon</option>
							<option value="Surat">Surat</option>
							<option value="Nagpur">Nagpur</option> -->

						</select>

						<div id="cityDiv" class="">
							<label for="city" class="lableColor">City <span class="starColor">*</span>: </label>
							<br>
							<select name="city" id="city"  disabled>
								<option value="">Select city</option>
								<option value="Pune">Pune</option>
								<option value="Mumbai">Mumbai</option>
								<option value="Nashik">Nashik</option>
								<option value="Jalgaon">Jalgaon</option>
								<option value="Surat">Surat</option>
								<option value="Nagpur">Nagpur</option>

							</select>

						</div>
						
							<br>
							
						<label for="pincode" class="lableColor">pincode <span class="starColor">*</span>: </label> <br>
						<input type="text" name="pincode" id="pincode" class="inpformat" oninput="validate.inputErrorDisplay(this)" placeholder="411062"/>
						<div id="pincodeError" class="errorDiv">&nbsp;</div>


						<br>
						
						<div id="btn-div" class="">
						<input type="submit" class="btn" id="submitRegister" value="Register">
						<!-- <button onclick="" class="btn" id="resetBtn">Reset</button> -->
										</div>
					</form>
					</div>
					<div class="alert" id="alertBox">
							<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
							<strong id="msg"></strong>
							<div id="progressBar" class="">
				
							</div>
						</div>
					</div>
					</div>
					
					<div class="jsP" id="jspalertBox">
							<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
							<strong id="msg">Login Success Redirecting...</strong>
							<div id="progressBar" class="jspprogressBar">
				              
							</div>
						</div>
    
        <jsp:include page="jsp/Footer.jsp"></jsp:include>
    </div>
    <script src="./js/scriptI.js">
        
        </script>

</body>
</html>