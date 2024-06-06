$(function () {
    $("#Email").on("input", function (event) {
        loginValidation(event.target);
    });

    $(".message").each(function () {
        var message = $(this);
        setTimeout(function () {
            message.hide();
        }, 2000);
    });

    function loginValidation(e) {
        let err = $("#" + e.name + "Error");
        let pattern = /^[a-zA-Z0-9_@.]{8,20}$/;

        if (e.id == "Password") {
            if (e.value.length > 14) {
                err.html("Please enter up to 15 characters ");
            } else if (e.value == "") {
                err.html("Please enter password");
            } else {
                err.html("&nbsp;");
            }
        }
    }
    
    $("#Username").on("input",function (event){
   	 loginValidation(event.target);
   	 });

   	 function loginValidation(e){
   		let err = $("#"+e.name + "Error");
            let pattern=/^[a-zA-Z0-9_@.]{8,20}$/;
            
   		  if(e.id=="Username"){  
               if (/[#$%&*()!^]/.test(e.value)) {
                   e.value = e.value.replace(/[#$%&*()!^]/g, ''); 
                   err.html("Error: Username contain underscores, '@', or periods only. ");
                   return;
               }
               if (!/^[a-zA-Z0-9_@.]{8,20}$/.test(e.value)) {
                   err.html("Please enter alphanumeric characters, underscores, '@', or periods only.");
                  
                  // e.preventDefault(); 
                 //  return false; 
               } else {
                   err.html("&nbsp;");
               }
   		  }
   		  else if(e.id=="Password"){

   		   if (e.value.length > 14) {
                 err.html("Please enter upto 15 characters ");
   		  }
   		  else if(e.value==""){
   		  err.html("Please enter password");
   		  }
   		 
   		  else{
   		  err.html("&nbsp;");
   		  }

   		 }
   	
   	}
    
    
   /* $("#login-Btn").click(function (event){
    	let loginProfile = $("#loginProfile").html();

        if (loginProfile == "Login/Register") {
            $("#LoginpopupDiv").css("display", "block");
        } else {
            fetchUserInfo();
            window.location.href = "jsp/ViewUser.jsp";
        }
    });*/

    $("#Loginbtn").click(function (event) {
        event.preventDefault();
        var email = $("#Username").val(); 
        var userType = $('input[name="userType"]:checked').val();
        console.log("User"+userType);
        var password = $("#Password").val();
        var action=$('input[name="action"]').val();
       
        if (email === "" || password === "" || !userType) { 
        	alertDisplayLogin("Please fill all the fields","red");
        } else {
            $.ajax({
            	url: "CommonController",
                method: "POST",                 
                data:{
            		"action":"Login",
            		"email":email,
            		"password":password,
            		"userType":userType
            } ,
            success: function (response) {
                //console.log(response);
              
                	// console.log("Success response:", response);
                   // alert("Successful login");
            	//$('#jspalertBox').css("display", "block");
            	alertDisplayLogin("Logging in ...","green");
            	setTimeout(function() {
            	    window.location.href = "index.jsp";
            	}, 2000);

                    
                 
            },
                error: function (error) {
                	console.error("AJAX Error:", error);
                   // alert("User not found error");
                	alertDisplayLogin("User Not Found check email id, password","red");
                   
                }
            });
        }
        console.log(email,password,action);
    });
    
   /* $('#LikedIconImg').on('click', function() {
       
        likedCar(selectedCar.getId());
    });*/
    
    function alertDisplayLogin(msg,color) {
        $("#alertBoxLogin").fadeIn();
        $("#alertBoxLogin").css("background", color);
        $("#msglogin").text(msg);
         $("#progressBarLogin").css("animation", 'progress 3s 1 ease-in-out');
        $(".closebtn").click(function () { $("#alertBoxLogin").fadeOut(); })
 			setTimeout(function () {
 				$("#alertBoxLogin").fadeOut();
 			}, 2000);
     }
    

   
    
  
});
function likedCar(carId){
	console.log(carId+" jdj");
	 $.ajax({
	      	url: "../CommonController",
	          method: "POST",                 
	          data:{
	      		"action":"likedCar",
	      		"CarId":carId,
	      } ,
	      success: function (data) {
	          //console.log(response);
	         if(data=="liked"){
	        	 
	        	 $("#LikedIconImg").attr('src','../images/liked.jpg');
	         }
	         else if(data=="unliked"){
	        	 $("#LikedIconImg").attr('src','../images/unliked.png');
	         }else{
	        	 
	         }
	          	// console.log("Success response:", response);
	             // alert(data);
	             // window.location.href = "index.jsp";
	           
	      },
	          error: function (error) {
	          	console.error("AJAX Error:", error);
	              alert("Please Login First");
	              window.location.href = "../index.jsp";
	              
	             
	          }
	      });
		
}
