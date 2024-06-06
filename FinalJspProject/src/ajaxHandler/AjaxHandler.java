package ajaxHandler;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jboss.axis.handlers.http.HTTPActionHandler;

import beans.input.CarInputBean;
import beans.input.LoginResponse;
import beans.output.CarOutputBean;
import beans.output.OutputBean;
import beans.output.UserOutputBean;

import com.google.gson.Gson;

import dao.AllDao;
import helper.CommonHelper;

public class AjaxHandler {
	
	public static void loginUser(OutputBean op, HttpServletResponse response,HttpServletRequest request) throws IOException {
        String username = op.getUsername();
        String password = op.getPassword();

       
        boolean loginSuccess = AllDao.loginDao(username, password);
        System.out.println("Ajax enter");

        
        if (loginSuccess) {
        	System.out.println("AjaxHandler true");
            boolean isActive = AllDao.isUserActive(username); 
            ResultSet rsSet=AllDao.getUserByEmail(username);
            
            
           
            try {
				if (rsSet.next()) {
				   
					int id= rsSet.getInt("id");
				    String firstName = rsSet.getString("FirstName");
				    String lastName = rsSet.getString("LastName");
				    String mobileNo = rsSet.getString("MobileNo");
				    String email = rsSet.getString("Email_id");
				    String address = rsSet.getString("Address");
				    String state = rsSet.getString("State");
				    String city = rsSet.getString("City");
				    String pincode = rsSet.getString("Pincode");
				    String Upassword=rsSet.getString("C_Password");
				  
				    HttpSession session = request.getSession();
				    session.setAttribute("userId", id);
				    session.setAttribute("username", username);
				    session.setAttribute("firstName", firstName);
				    session.setAttribute("lastName", lastName);
				    session.setAttribute("mobileNo", mobileNo);
				    session.setAttribute("email", email);
				    session.setAttribute("address", address);
				    session.setAttribute("state", state);
				    session.setAttribute("city", city);
				    session.setAttribute("pincode", pincode);
				    session.setAttribute("password", Upassword);
				    
				 
				    rsSet.close();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
            
            
            response.setStatus(200);
           response.getWriter().write("{\"status\": \"success\"}");
           HttpSession session = request.getSession();
           session.setAttribute("username", username); 
            System.out.println("AjaxHandler end");
        } else {
        	System.out.println("AjaxHandler false");
        	response.setStatus(401);
        	
        	    response.getWriter().write("{\"status\": \"error\"}");
        }
    }
	
	public static void loginAdmin(OutputBean op, HttpServletResponse response,HttpServletRequest request) throws IOException {
        String username = op.getUsername();
        String password = op.getPassword();

       
        boolean loginSuccess = AllDao.AdminLogin(username, password);
        System.out.println("Admin Ajax enter");

        
        if (loginSuccess) {
        	System.out.println("Admin AjaxHandler true");
            boolean isActive = AllDao.isUserActive(username); 
            ResultSet rsSet=AllDao.getAdminByEmail(username);
            
            
            
            try {
				if (rsSet.next()) {
				    
				    String firstName = rsSet.getString("FirstName");
				    String lastName = rsSet.getString("LastName");
				    String mobileNo = rsSet.getString("MobileNo");
				    String email = rsSet.getString("Email_id");
				    String createdBy = rsSet.getString("createdBY");
				    /*String state = rsSet.getString("State");
				    String city = rsSet.getString("City");
				    String pincode = rsSet.getString("Pincode");*/
				    
				    
				    HttpSession session = request.getSession();
				    session.setAttribute("username", username);
				    session.setAttribute("firstName", firstName);
				    session.setAttribute("lastName", lastName);
				    session.setAttribute("mobileNo", mobileNo);
				    session.setAttribute("email", email);
				    session.setAttribute("createdBY", createdBy);
				   /* session.setAttribute("address", address);
				    session.setAttribute("state", state);
				    session.setAttribute("city", city);
				    session.setAttribute("pincode", pincode);*/
				    
				   
				    rsSet.close();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
            
         
            response.setStatus(200);
           response.getWriter().write("{\"status\": \"success\"}");
           HttpSession session = request.getSession();
           session.setAttribute("Ausername", username); 
         
            System.out.println("AjaxHandler end");
        } else {
        	System.out.println("AjaxHandler false");
        	response.setStatus(401);
        	 
        	    response.getWriter().write("{\"status\": \"error\"}");
        }
    }

	public static void getCarByLocation(HttpServletResponse response,
			HttpServletRequest request) {
	     String location=request.getParameter("location");
	     System.out.println("Location "+location);
		 List<CarOutputBean> cList= AllDao.getCarByLocation(location);
		if(cList!=null){
			HttpSession session=request.getSession();
			response.setStatus(200);
			session.setAttribute("SerchedCar", cList);
			System.out.println("clist"+cList);
			//System.out.println(request.);
			try {
				response.getWriter().write(cList.toString());
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		else {
        	System.out.println("AjaxHandler false");
        	response.setStatus(401);
        	 //response.setContentType("application/json");
        	    try {
					response.getWriter().write("{\"status\": \"error\"}");
				} catch (IOException e) {
					
					e.printStackTrace();
				}
        }
	}

	public String likedCar(int cId, int uId) {
		String resultString=null;
		try{
			
			resultString=AllDao.likedCar(cId, uId);
			System.out.println("Ajax handler"+resultString);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultString;
	}


   

}
