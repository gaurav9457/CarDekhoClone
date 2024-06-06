<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/index.css">
<style>
   body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f0f0;
        } 
        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .user-detail {
            margin-bottom: 10px;
        }

        .user-detail strong {
            display: inline-block;
            width: 150px;
            font-weight: bold;
        }
        #logoutButton ,#likedCarBtn{
        padding: 10px 15px;
    background-color: #2e7ec4;
    border: 1px solid;
    margin: 50px 10px 10px 120px;
    color: white;
    font-size:large;
    cursor: pointer;
    border-radius: 5px;
    box-shadow: 5px 3px 5px rgba(0, 0, 0, 0.5);
        }
        #editButton{
         padding: 10px 15px;
    background-color:  #66ff33;
    border: 1px solid;
    margin: 50px 10px 10px 120px;
    color: white;
    font-size:large;
    cursor: pointer;
    border-radius: 5px;
    box-shadow: 5px 3px 5px rgba(0, 0, 0, 0.5);
        }
       #editButton:hover{
       background-color: white;
    color:#2e7ec4 ;
    box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.5);
       }
        #logoutButton:hover{       
    background-color: white;
    color:#2e7ec4 ;
    box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.5);
        }
        #likedCarBtn:hover{
         background-color: white;
    color:#2e7ec4 ;
    box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.5);
        }
        #userDetailsForm{
         width:420px;
    height:500px;
	max-height:70%;
	 background-color: white; 
    padding:20px;
    border-radius:10px;
	overflow-y:scroll;
	overflow-x:none;
    border:1px solid black;    
        }
</style>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
<div id="parent">

<jsp:include page="Navbar.jsp"></jsp:include>

<% if (request.getAttribute("UpdatesuccessMessage") != null) { %>
                <div class="success-message">
                    <%= request.getAttribute("UpdatesuccessMessage") %>
                </div>
            <% } %>
<% if (request.getAttribute("UpdateerrorMessage") != null) { %>
                <div class="error-message">
                    <%= request.getAttribute("UpdateerrorMessage") %>
                </div>
            <% } %>
            
<div class="container">
    <form action="">
        
        <div class="user-detail">
            <strong>First Name:</strong> <span id="firstName"><%= session.getAttribute("firstName") %></span>
        </div>
        <div class="user-detail">
            <strong>Last Name:</strong> <span id="lastName"><%= session.getAttribute("lastName") %></span>
        </div>
        <div class="user-detail">
            <strong>Mobile No:</strong> <span id="mobileNo"><%= session.getAttribute("mobileNo") %></span>
        </div>
        <div class="user-detail">
            <strong>Email:</strong> <span id="email"><%= session.getAttribute("email") %></span>
        </div>
        <div class="user-detail">
            <strong>Address:</strong> <span id="address"><%= session.getAttribute("address") %></span>
        </div>
        <div class="user-detail">
            <strong>State:</strong> <span id="state"><%= session.getAttribute("state") %></span> 
        </div>
        <div class="user-detail">
           <%--  <strong>City:</strong> <span id="city"><%= session.getAttribute("city") %></span> --%>
        </div>
        <a href="../CommonController?action=logOut"><button type="button" id="logoutButton">Logout</button></a> 
        <%if(session.getAttribute("Ausername")!=null) {%>
        <span>Admin</span>
        <%} %>
        <% else { %>
        <a href="../CommonController?action=getLikedCars"><button type="button" id="likedCarBtn">Liked Cars</button></a>
        <%} %>
         <button  id="editButton" >Edit Info</button>
    </form>
   
     <%! public String citySelect(String state,String selected){
    	 //System.out.println(selected);
    	 if(state.equals(selected)){
    			return "selected";
    		}
    		else{
    			return "";
    		}
    	} %>
     <br>
    <form id="userDetailsForm" action="../CommonController" style="display: none;" >
       
					    <input type="hidden" value="updateUser" name="action"/>
					 <input type="hidden" value="<%= session.getAttribute("userId").toString() %>" name="userId">  
						<!-- <span id="closeRegister" onclick="validate.closeRegisterPopup()">&times;</span> -->
						<!-- <div id="nameDiv" class=""> -->
						<label for="fname" class="lableColor">First Name <span class="starColor">*</span>: </label> <br>

						<input type="text" id="fname" name="firstname" placeholder="Your First name.."
							class="inpformat inpValid" onkeydown="validate.inputErrorDisplay(this)" autofocus value="<%= session.getAttribute("firstName") %>">
						<div id="firstnameError" class="errorDiv">&nbsp;</div>
						<!-- <br> -->
						<!-- </div> -->

						<!-- <div id="lnameDiv" class=""> -->
						<label for="lname" class="lableColor">Last Name <span class="starColor">*</span> : </label> <br>

						<input type="text" id="lname" name="lastname" placeholder="Your last name.."
							class="inpformat inpValid" onkeydown="validate.inputErrorDisplay(this)" value="<%= session.getAttribute("lastName") %>">
						<div id="lastnameError" class="errorDiv">&nbsp;</div>
						<!-- </div> -->


						<label for="mobile" class="lableColor">Mobile no <span class="starColor">*</span>: </label> <br>

						<input type="tel" name="mobileNo" id="mobile" minlength=1 maxlength=10 class="inpformat" onkeypress="validate.inputErrorDisplay(this)"value="<%= session.getAttribute("mobileNo") %>" placeholder="9112345678">
						<div id="mobileError" class="errorDiv">&nbsp;</div>

						<label for="email" class="lableColor">Email-id <span class="starColor">*</span>: </label> <br>
					 <input type="email" name="email" id="email" class="inpformat" onkeydown="validate.inputErrorDisplay(this)" value="<%= session.getAttribute("email") %>"placeholder="example@gmail.com"/>
						<div id="emailError" class="errorDiv">&nbsp;</div> 

						<label for="password" class="lableColor">Password <span class="starColor">*</span>: </label> <br>
						<input type="text" name="password" id="password" class="inpformat" oninput="validate.inputErrorDisplay(this)" value="<%=session.getAttribute("password") %>" placeholder="Pass@123"/>
						<div id="passwordError" class="errorDiv">&nbsp;</div>

						 <label for="confirmPassword" class="lableColor">Confirm Password <span class="starColor">*</span>: </label> <br>
						<input type="password" name="confirmPassword" id="confirmPassword" class="inpformat" oninput="validate.inputErrorDisplay(this)" value="<%=session.getAttribute("password")%>  placeholder="Pass@123"/>
						<div id="confirmPasswordError" class="errorDiv">&nbsp;</div> 

						<label for="address" class="lableColor">Address <span class="starColor">*</span>: </label><br>
						 <input type="text"name="addressArea" class="inpformat" id="addressArea" cols="53" rows=""
							style="margin:10px;width:400px;" oninput="validate.inputErrorDisplay(this)" value="<%= session.getAttribute("address") %>">
						<div id="addressAreaError" class="errorDiv"></div> 

						<label for="state" class="lableColor">State <span class="starColor">*</span>: </label>
						<select name="state" id="state" onclick="validate.state()">
							<option value="" >Select state</option>
							<option value="Maharashtra" <%=citySelect("Maharashtra",session.getAttribute("state").toString())%>>Maharashtra</option>
							<option value="Gujrat" <%=citySelect("Gujrat",session.getAttribute("state").toString())%>>Gujrat</option>
							<option value="Rajastan" <%=citySelect("Rajastan",session.getAttribute("state").toString())%>>Rajastan</option>
							
						</select>  
						<div id="cityDiv" class="">
							<label for="city" class="lableColor">City <span class="starColor">*</span>: </label>
							<br>
							<%-- <select name="city" id="city" >
								<option value="">Select city</option>
								<option value="Pune" <%=citySelect("Pune",session.getAttribute("city").toString())%>>Pune</option>
								<option value="Mumbai" <%=citySelect("Mumbai",session.getAttribute("city").toString())%>>Mumbai</option>
								<option value="Nashik" <%=citySelect("Nashik",session.getAttribute("city").toString())%>>Nashik</option>
								<option value="Jalgaon" <%=citySelect("Jalgaon",session.getAttribute("city").toString())%>>Jalgaon</option>
								<option value="Surat" <%=citySelect("Surat",session.getAttribute("city").toString())%>>Surat</option>
								<option value="Nagpur" <%=citySelect("Nagpur",session.getAttribute("city").toString())%>>Nagpur</option>

							</select> --%>

						</div>
						
							<br>
							
						<label for="pincode" class="lableColor">pincode <span class="starColor">*</span>: </label> <br>
						<input type="text" name="pincode" id="pincode" class="inpformat" oninput="validate.inputErrorDisplay(this)" value="<%= session.getAttribute("pincode") %>"placeholder="411062"/>
						<div id="pincodeError" class="errorDiv">&nbsp;</div>


						<br>
						
						<div id="btn-div" class="">
						<input type="submit" class="btn" id="submitUpdate" value="Update">
						<!-- <button onclick="" class="btn" id="resetBtn">Reset</button> -->
										</div>
					
    </form>
    
</div>
<script src="../js/scriptI.js"></script>
<script>
    
    var editButton = document.getElementById('editButton');
    var userDetailsForm = document.getElementById('userDetailsForm');

  
    editButton.addEventListener('click', function() {
       
        if (userDetailsForm.style.display === 'none') {
            userDetailsForm.style.display = 'block';
        } else {
            userDetailsForm.style.display = 'none';
        }
    });
</script>
</body>
</html>