<%@page import="beans.output.CarOutputBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/style.css">
<style>

#AllCarsParent{
width:1200px;
margin:auto;
}
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #fff9f9;
 
}

th, td {
  text-align: center;
  padding: 12px;
  border: 1px solid #ddd;
  
}
th{
background-image: linear-gradient(-60deg, #ff5858 0%, #f09819 100%);

}

tr:nth-child(even) {
  background-color: #d6dadd;
}
.btn {
  border: 2px solid black;
  background-color: white;
  color: black;
  padding: 10px 16px;
  font-size: 10px;
  cursor: pointer;
}
tr:hover {
  background-color: #cfd8dc; 
}
</style>
</head>
<body>

<div id="AllCarsParent">
<jsp:include page="Navbar.jsp"></jsp:include>
<h1 style="text-align:center;">All car table</h1>
<div id="tableParentDiv"  style="overflow-x:auto;">
   <table border='1' cellpadding='4' width='80%' align="center">
        <tr>
           <th>ID</th>
        <th>Car Brand</th>
        <th>Car Modal</th>
        <th>Car Type</th>
        <th>Fuel Type</th>
        <th>Transmission</th>
        <th>Engine (cc)</th>
        <th>Price</th>
        <th>Register Date</th>
        <th>Register State</th>
        <th>Is Active</th>
        <th>Created By</th>
        <th>Created Date</th>
        <th>Modified By</th>
        <th>Modified Date</th>
        <th>Status</th>
        </tr>
        <%
            ArrayList cars = (ArrayList) session.getAttribute("Car");
            Iterator iterator = cars.iterator();
            while(iterator.hasNext()){
                CarOutputBean car = (CarOutputBean) iterator.next();
        %>
        <tr>
        <td><%= car.getId() %></td>
            <td><%= car.getCarBrand() %></td>
            <td><%= car.getCarModal()%></td>
            <td><%= car.getCarType()%></td>
            <td><%= car.getFuelType()%></td>
            <td><%= car.getTransmission() %></td>            
            <td><%= car.getEngine_cc() %></td>
            <td><%= car.getPrice()%></td>
            <td><%= car.getRegisterDate() %></td>
            <td><%= car.getRegisterState() %></td>
            <td><%= car.getIsActive() %></td>
            <td><%= car.getCreatedBy() %></td>
            <td><%= car.getCreatedDate() %></td>
            <td><%= car.getModifiedBY() %></td>
            <td><%= car.getModifiedDateString() %></td>
            <td>Inactive Car </td>
        </tr>
        <% 
            }
        %>
    </table>
</div>
 <br>
    <div>
      <a href="../index.jsp" style="color:red">&larr; Home</a>
    </div>
</div>
</body>
</html>