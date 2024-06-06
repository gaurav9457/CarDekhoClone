package controller;

import impl.Implementation;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log.output.io.rotate.RevolvingFileStrategy;

import com.google.gson.JsonObject;

//import org.json.JSONObject;
import beans.action.CommonActionBean;

/**
 * Servlet implementation class CommonController
 */
public class CommonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CommonController() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	/*	RequestDispatcher rDispatcher=request.getRequestDispatcher("CommonActionBean");
		rDispatcher.forward(request,response);*/
//		 StringBuilder sb = new StringBuilder();
//		    BufferedReader reader = request.getReader();
//		    String line;
//		    while ((line = reader.readLine()) != null) {
//		        sb.append(line);
//		    }
//		    
//		    JsonObject jsonObject = new JsonObject(sb.toString());
//		    if (jsonObject.has("action")) {
//		        url = jsonObject.getString("action");
//		    }
//		    
//		
//		
		String url=request.getParameter("action");  
		System.out.println("Url "+url);
		//System.out.println("Admin/user "+request.getParameter("userType"));
		
		if (url.equals("register")) {
			
			CommonActionBean.registeruser(request, response);
		} 
		 if(url.equals("Login")) {
			 
			 if(request.getParameter("userType").equals("admin")){
				 System.out.println("Admin start");
				 String emailString=request.getParameter("email");
				 String passwordString=request.getParameter("password");
				 CommonActionBean.loginAdmin(emailString,passwordString, response,request);
				 System.out.println("Admin end");
			 }else{
			 System.out.println("Conn "+request.getParameter("email")+" "+request.getParameter("password"));
			 String emailString=request.getParameter("email");
			 String passwordString=request.getParameter("password");
             CommonActionBean.loginUser(emailString,passwordString, response,request);
			 }
		}
		 if(url.equals("addCar")){
			 System.out.println("addCar Controller");
			CommonActionBean.addCar(request,response);
		}
		 if(url.equals("getAllUsers")){
			 System.out.println("common controller");
			 CommonActionBean.getAllUser(request,response);
		 }
		 if(url.equals("getAllCars")){
			 System.out.println("Get All Cars");
		 }
		 if(url.equals("selectState")){
			 System.out.println("State=="+request.getParameter("location"));
			 CommonActionBean.getCarByLocation(request,response);
		 }
		 if(url.equals("logOut")){
			 CommonActionBean.logoutuser(request,response);
		 }
		 if(url.equals("likedCar")){
			 System.out.println("Controller");
			 CommonActionBean.likedCar(request,response);
		 }
		 if(url.equals("getLikedCars")){
			 CommonActionBean.getLikedCars(request,response);
		 }
		 if(url.equals("searchCarBy")){
			// System.out.println("SearchCarBy");
			 CommonActionBean.searchCarBy(request,response);
		 }
		 if(url.equals("updateUser")){
			 System.out.println("updateUser");
			 System.out.println(request.getParameter("firstname"));
			 CommonActionBean.updateUser(request,response);
		 }
		 if(url.equals("userInactive")){
			 System.out.println("userInactive");
			 System.out.println(request.getParameter("userId")+"user ID");
			 CommonActionBean.userInactive(request,response);
		 }
		 
		else {
            System.out.println("Null request");
		}
		
	}

}
