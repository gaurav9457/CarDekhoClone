<%@page import="java.util.Iterator"%>
<%@page import="beans.output.CarOutputBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../css/Footer.css">
<link rel="stylesheet" href="../css/ViewCarDetails.css">
<link rel="stylesheet" href="../css/index.css">
<script src="../js/jQuery.js"></script>
<script src="../js/jqueryScript.js"></script>
</head>
 
<body>
<div id="viewParent">
 <jsp:include page="Navbar.jsp"></jsp:include>
 <%int id=Integer.parseInt(request.getParameter("id")); 
  HttpSession session2 = request.getSession();
  ArrayList cars = (ArrayList) session.getAttribute("Car");
  CarOutputBean selectedCar = null;
  
  Iterator iterator = cars.iterator();
  while(iterator.hasNext()){
      CarOutputBean car = (CarOutputBean) iterator.next();
      if(car.getId()==id){
    	  selectedCar = car; 
    	  break;
      }
  }
  %>
   
  <div id="viewCarDiv">
        <sapn id="carImage">
         <img src="../images/Thar.webp" width="450px" height="300px" alt="image not found" id="carImageSrc"/>
        </sapn>
        <span id="deatailsDiv">
     <h1 id="brandName">Car Brand : <%= selectedCar != null ? selectedCar.getCarBrand() : "No car selected" %></h1> 
    <br>
    <h3 id="price">Rs : <%= selectedCar != null ? selectedCar.getPrice() : "N/A" %> lakh*</h3>
    <br>
    <h3 id="ViewCarModal">Modal : <%= selectedCar != null ? selectedCar.getCarModal() : "N/A" %></h3>
    <br>
    <h5>Register year : <%= selectedCar != null ? selectedCar.getRegisterDate() : "N/A" %></h5> 
    <br>
    <span id="ViewCarTransmission">Trnsamission Type : <%= selectedCar != null ? selectedCar.getTransmission() : "N/A" %></span>
    <br>
    <h5 id="ViewEngineCC">Engine-cc : <%= selectedCar.getEngine_cc() %></h5>
    <br>
    <h5 id="ViewCarType">Car Type : <%= selectedCar.getCarType() %></h5>
    <br>
    <h5 id="ViewCarFuelType">Fuel Type : <%= selectedCar.getFuelType() %></h5>
    <br>
    <h4 id="viewDesc">Description: <%= selectedCar != null ? selectedCar.getCar_desc() : "N/A" %></h4>
    <br>
    <h4 id="ViewState">Register State: <%= selectedCar.getRegisterState() %></h4>
</span>
     
       
        <img src="../images/unliked.png" alt="img not found" srcset="" id="LikedIconImg" onclick="likedCar(<%=selectedCar.getId()%>)">
        <jsp:include page="LoginForm.jsp"></jsp:include>
  </div>
  
  
  
  <jsp:include page="Footer.jsp"></jsp:include>
</div>
<script src="../js/scriptI.js"></script>
</body>
</html>