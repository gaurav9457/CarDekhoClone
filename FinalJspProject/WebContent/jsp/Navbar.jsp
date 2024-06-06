<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<script src="../js/jQuery.js"></script>
<script src="../js/jqueryScript.js"></script> 
<body>
<%! public String userName(HttpServletRequest req){
	HttpSession session=req.getSession();
	
	if(session.getAttribute("username")!=null){
		return session.getAttribute("username").toString();
	}
	return "Login/Register";
 } 

 public String AdminName(HttpServletRequest req){
	 HttpSession session=req.getSession();
	 
	 if(session.getAttribute("createdBY")!=null){
		     System.out.println(session.getAttribute("createdBY"));
			return "View All Users";
		}
		return "";
 }
 %>
 <div id="NavContainer" class="">
	<div class="header">
			<header>
				<div class="logo">
					<a href="../index.jsp"><img title="jsp" src="https://stimg.cardekho.com/images/cms/carnewsimages/editorimages/63b3f752b6f86.jpg?impolicy=resize&imwidth=420" width="150" height="100"
							alt="logo"></a>
				</div>
				<div class="srch-con">
					<div class="search-container">
						<div class="search">
							<div>
								<input id="search" title="start typing product name"
									placeholder="Search Car Brand" type="text">
							</div>
							<div id="serch-btn"><button><img src="images/search.png" title="search"
										alt="search" /></button></div>
						</div>
					</div>
					
					<div class="contact">
						<!-- <div id="LikeIconDiv">
							<a href=""><img src="https://iconape.com/wp-content/png_logo_vector/like.png" id="like-icon" alt="" srcset=""></a>
						</div> -->
						<a href="#" id="login-Btn" onclick="validate.showLoginPoup()">
							<img src="https://t4.ftcdn.net/jpg/00/65/77/27/360_F_65772719_A1UV5kLi5nCEWI0BNLLiFaBPEkUbv5Fv.jpg" alt="" srcset="" id="profile-img"> <sup id="loginProfile"><%=userName(request)%></sup>
							</a>
						<div id="clear-both"></div>
					</div>
					<div id="clear-both"></div>

				</div>
				<div id="clear-both"></div>
			</header>


			<hr>


			<nav>
				<div>

					
					<div class="nav-bar">
						<div class="nav-bar-content">
							<ul>
								<div class="dropdown">
									<button class="dropbtn">NEW CARS
									</button>
									<div class="dropdown-content">
									  <a href="#">Explore new cars</a>
									  <a href="#">Electric cars</a>
									  <a href="#">Sell cars</a>
									</div>
								  </div> 
								  <div class="dropdown">
									<button class="dropbtn">SELL CAR
									</button>
									<div class="dropdown-content">
									  <a href="jsp/SellCarForm.jsp">Sell Your Car</a>
									  <a href="#">Buy New Car</a>
									  <a href="#">View Car</a>
									</div>
								  </div> 
								  <div class="dropdown">
									<button class="dropbtn">NEW CARS
									</button>
									<div class="dropdown-content">
									  <a href="#">Explore new cars</a>
									  <a href="#">Electric cars</a>
									  <a href="#">Sell cars</a>
									</div>
								  </div> 
								  <div class="dropdown">
									<button class="dropbtn">NEW CARS
									</button>
									<div class="dropdown-content">
									  <a href="#">Explore new cars</a>
									  <a href="#">Electric cars</a>
									  <a href="#">Sell cars</a>
									</div>
								  </div> 
								   <div class="dropdown">
									<a href="jsp/AdminPage.jsp" id="adminPageBtn" ><button class="dropbtn" ><%=AdminName(request)%>
									</button></a>
									<!-- <div class="dropdown-content">
									  <a href="#">Explore new cars</a>
									  <a href="#">Electric cars</a>
									  <a href="#">Sell cars</a>
									</div> -->
								  </div> 
								  
								  
								<!-- <li><a href="#">Pages</a></li>
								<li><a href="#">Shop</a></li>
								<li><a href="#">Blog</a></li>
								<li><a href="#">Contact</a></li>
								<li><a href="#" onclick="formPopups.openRegister()" title="register"
										id="register-btn">Register</a></li>
								<li><a href="#">GET&nbsp;PRO</a></li> -->
								<div id="clear-both"></div>
							</ul>
						</div>

					</div>
					<!-- <div class="category">
						<div class="cars">
							<select title="state" name="category">
								<option value="Search By State" selected>State</option>
								<option value="Maharashtra">Maharashtra</option>
								<option value="Gujrat">Gujrat</option>
								<option value="Rajastan">Rajastan</option>
							</select>
						</div>
						<div id="clear-both"></div>
					</div> -->
					<div id="clear-both"></div>

				</div>
				<div class="category">
					<div class="cars">
						<select title="state" name="category" id="NavstateSelect">
							<option value="" selected>Select State</option>
							<option value="Maharashtra">Maharashtra</option>
							<option value="Gujrat">Gujrat</option>
							<option value="Goa">Goa</option>
							<option value="Rajastan">Rajastan</option>
						</select>
					</div>
					<div id="clear-both"></div>
				</div>
				<div id="clear-both"></div>
			</nav>
			<div id="clear-both"></div>
 </div>
 
 <script src="../js/scriptI.js"></script>
<script>
/* let button=document.getElementById("adminPageBtn");
if(button.innerHTML==" "){
	button.style.display="none";
} */
$(document).ready(function() {
    $('#NavstateSelect').change(function() {
        var selectedLocation = $(this).val();
        $.ajax({
            type: 'POST',
            url: 'CommonController',
            data: {"action":"selectState", 
            	location: selectedLocation 
            	},
            success: function(data) {
                console.log("Success");
               // $("#midBanner").toggle();
             //  alert(data+" Success");
             console.log("data"+data);
               window.location.href="index.jsp?cars=";
               
            },
            error: function(xhr, status, error) {
                console.error('Error:', status, error);
            }
        });
    });
});

</script>
		
 </body>
</html>