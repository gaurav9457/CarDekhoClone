<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
<link rel="stylesheet" href="../css/style.css">
<style>
#ViewRegisterUserBtn{
 padding:15px 10px ;
 background-color: #f75d34;
 border:none;
 Cursor:pointer;
 color:white; 
 box-shadow:7px 3px 3px 3px #cfd9df;
 margin-left:100px;
}
#ViewRegisterUserBtn:hover{
background-color: white;
 border:1px solid black;
 color: #f75d34; 
}
</style>
</head>
<body>
<div id="parent">
  <jsp:include page="Navbar.jsp"></jsp:include>
  <h1 style="color:#f75d34;">Welcome Admin</h1>
  <br>
  <a href="../CommonController?action=getAllUsers" > <button id="ViewRegisterUserBtn">View Register users</button> </a>
  <a href="AllCarTable.jsp"><button id="ViewRegisterUserBtn">View All Cars</button></a>
</div>
</body>
</html>