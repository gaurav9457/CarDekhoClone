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

<style>
#cardBody {
    display: inline-block;
    width:250px;
    height: 330px;
    border: 1px solid grey;
    margin: 14px;
    /* background-color: #fff;  */
    /* padding: 20px; */
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
    color: black;
    vertical-align: top; 
    font-size: 16px; 
    /* float: left; */
}
#carCardContent{
    padding:0px 3px 3px 15px;
}
#carCardprice{
    font-size: 20px;
    font-weight: bold;
}
#carCardName{
    line-height: 40px;
    font-size: 20px;
    font-weight: bold;
}
#cardButton{
    padding: 10px 50px;
    background-color: white;
    border-color: #f75d34;
    color: #f75d34;
    border-radius: 5px;
    cursor:pointer;
    
}
#cardButton:hover{
	background-color: #f75d34;
    border-color: white;
     color:white;
}
#imgDiv{
    height: 200px;
    width: 250px;
    border-radius:1px;
}

</style>
</head>
<body>
<div >

<div>
<% 
ArrayList searchCars = (ArrayList)session.getAttribute("GetLikedCar");
//System.out.println("SearchEdCars"+searchCars);
if (searchCars != null ) {
    Iterator iterator1 = searchCars.iterator();
    while(iterator1.hasNext()) {
        CarOutputBean cars = (CarOutputBean) iterator1.next();
%>
    <div id="cardBody" class="">
        <div id="imgDiv">
            <img id="imgDiv" src="../images/Thar.webp" alt="image not found">
        </div>  
        <div id="carCardContent">
            <span id="carCardName"><%= cars !=null ? cars.getCarBrand() : "No Car Searched" %></sapn> <br>
            <span id="carCardprice">Rs <%= cars.getPrice() %> lakh</span> <br>
            <form action="./ViewCarDetails.jsp?id=<%= cars.getId() %>">
                <input type="hidden" value="<%= cars.getId() %>" name="id"/>
                <input type="submit" value="Check car details" id="cardButton" >
            </form>
        </div>
    </div>
<% 
    }
} else {
%>
    <p>No liked cars found yet.</p>
<% } %>
       <div>
         <a href="../index.jsp" style="color:red">&larr; Home</a> 
         </div>     
</body>
</html>