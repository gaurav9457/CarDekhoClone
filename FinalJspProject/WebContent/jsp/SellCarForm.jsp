<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/SellCarForm.css">
 <link rel="stylesheet" href="../css/style.css"> 
 <link rel="stylesheet" href="../css/index.css">
</head>
<style>
 .invalid {
        background-color: #ffb3b3;
    }
</style>
<body>
<jsp:include page="Navbar.jsp"></jsp:include>
<div class="container">

<div id="carFormDiv">
    <h2 style="text-align:center">Add Car Details Form</h2>
    <br>
    <form id="carForm" action="../CommonController" method="post">
    <input type="hidden" name="action" value="addCar">
        <div class="form-group">
            <label for="carBrand" class="label">Car Brand:</label>
            <input type="text" id="carBrand" class="input-text" name="carBrand" >
        </div>
        <div class="form-group">
            <label for="carModal" class="label">Car Model:</label>
            <input type="text" id="carModal" class="input-text" name="carModal" >
        </div>
       <div class="form-group">
       <label for="registerDate" class="label">Register Date:</label>
       <input type="date" id="registerDate" class="input-text" name="registerDate" min="1000-01-01" max="9999-12-31" >
      </div>
        <div class="form-group">
            <label for="RegisterState" class="label">Register State:</label>
            <select id="RegisterState" class="select" name="RegisterState" >
                <option value="Maharashtra">Maharashtra</option>
			    <option value="Gujrat">Gujrat</option>
				<option value="Goa">Goa</option>
				<option value="Rajastan">Rajastan</option>
            </select>
        </div>
        <div class="form-group">
            <label for="FuelType" class="label">Fuel Type:</label>
            <select id="FuelType" class="select" name="FuelType" >
                <option value="1">Petrol</option>
                <option value="2">Diesel</option>
                <option value="3">Electric</option>
            </select>
        </div>
        <div class="form-group">
            <label for="price" class="label">Price:</label>
           <input type="text" id="price" class="input-number" placeholder="Price in Lakh"name="price" maxlength="2" oninput="this.value = this.value.replace(/[^0-9]/g, '').slice(0, 2);">

        </div>
        <div class="form-group">
            <label for="transmission" class="label">Transmission:</label>
            <select id="transmission" class="select" name="transmission" >
                <option value="Manual">Manual</option>
                <option value="Automatic">Automatic</option>
            </select>
        </div>
        <div class="form-group">
            <label for="Engine_cc" class="label">Engine CC:</label>
            <input type="number" id="Engine_cc" class="input-number" name="Engine_cc" >
        </div>
        <div class="form-group">
            <label for="car_desc" class="label">Car Description:</label>
            <textarea id="car_desc" class="input-text" name="car_desc" rows="4" placeholder="upto 100 characters"></textarea>
        </div>
        <div class="form-group">
            <label for="carType" class="label">Car Type:</label>
            <select id="carType" class="select" name="carType" >
                <option value="1">SUV</option>
                <option value="2">Sedan</option>
                <option value="3">Hatchback</option>
                <option value="4">Luxury</option>
                <option value="5">XUV</option>
            </select>
        </div>
         <div class="form-group">
                <label for="carImage" class="label">Upload Car Image:</label>
                <input type="file" id="carImage" class="input-file" name="carImage" accept="image/*" >
            </div> 
        <input type="submit" id="submit-button" value="Submit Details">
    </form>
</div>
         <%-- <jsp:include page="jsp/LoginForm.jsp"></jsp:include> --%>
          
</div>

<script src="../js/scriptI.js"></script>
<script type="text/javascript">
document.getElementById('carForm').addEventListener('submit', function(event) {
    var form = event.target;
    var carBrand = form.elements['carBrand'].value.trim();
    var carModal = form.elements['carModal'].value.trim();
    var registerDate = form.elements['registerDate'].value;
    var registerState = form.elements['RegisterState'].value;
    var fuelType = form.elements['FuelType'].value;
    var price = form.elements['price'].value.trim();
    var transmission = form.elements['transmission'].value;
    var engineCC = form.elements['Engine_cc'].value.trim();
    var carDesc = form.elements['car_desc'].value.trim();
    var carType = form.elements['carType'].value;
    var carImage = form.elements['carImage'].value;
   
    console.log("Brand "+carBrand," ",carModal, registerDate);
    if (!carBrand || !carModal || !registerDate || !registerState || !fuelType || !price || !transmission || !engineCC || !carDesc || !carType || !carImage) {
        event.preventDefault(); 
        document.getElementById('carForm').querySelectorAll('input, select, textarea').forEach(function(element) {
            if (!element.value.trim()) {
                element.classList.add('invalid'); 
            } else {
                element.classList.remove('invalid'); 
            }
        });
    }
});
</script>
</body>
</html>