<%@page import="java.util.Iterator"%>
<%@page import="beans.input.UserInputBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#parent{



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
background-color:#b8daff;
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


.success {
padding:10px 8px;
border:none;
  border-color: #ff9800;
  color: white;
   background: #ff9800;
   cursor:pointer;
}

.success:hover {
   background: white;
  color: #ff9800;
}
.danger {
  border-color: #f44336;
  
   background: #f44336;
}

.danger:hover {
background: white;
  color: red;
}
a{
text-decoration: none;
color:black;
padding: 0px;
}
</style>
<link rel="stylesheet" href="../css/style.css">
</head>
<script src="../js/jQuery.js"></script>
<script src="../js/jqueryScript.js"></script> 
<body>
<jsp:include page="Navbar.jsp"></jsp:include>

<div id="getUserParent">
    <table border='1' cellpadding='4' width='80%' align="center">
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Mobile No</th>
            <th>Email</th>
            <th>Address</th>
            <th>State</th>
            <th>City</th>
            <!-- <th>Edit</th> -->
           <!--  <th>Delete</th> -->
            <th>In Active User</th>
        </tr>
        <% 
            ArrayList users = (ArrayList) session.getAttribute("user");
            Iterator iterator = users.iterator();
            while(iterator.hasNext()){
                UserInputBean user = (UserInputBean) iterator.next();
        %>
        <tr>
            <td><%= user.getFirstname() %></td>
            <td><%= user.getLastname() %></td>
            <td><%= user.getMobileNo() %></td>
            <td><%= user.getEmailId() %></td>
            <td><%= user.getAddress() %></td>
            <td><%= user.getState() %></td>
            <td><%= user.getCity() %></td>
           <!--  <td>Edit</td>
            <td>Delete Link</td> -->
            <td><a href="../CommonController?action=userInactive&userId=<%=user.getId() %>"><button class="success" >Inactive</button></a></td>
        </tr>
        <% 
            }
        %>
    </table>
    <br>
    <div>
      <a href="../index.jsp" style="color:red">&larr; Home</a>
    </div>
</div>
<script src="../js/scriptI.js"></script>
</body>
</html>
