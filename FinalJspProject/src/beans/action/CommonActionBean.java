package beans.action;

import helper.CommonHelper;
import impl.Implementation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.Cookie;
import org.omg.CosCollection.CommandHelper;

import dao.AllDao;
import sun.misc.UCDecoder;
import ajaxHandler.AjaxHandler;
import beans.input.CarInputBean;
import beans.input.UserInputBean;
import beans.output.CarOutputBean;
import beans.output.OutputBean;

/**
 * Servlet implementation class CommonActionBean
 */
public class CommonActionBean extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CommonActionBean() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
      
	public static HttpServletResponse registeruser(HttpServletRequest request, HttpServletResponse response){
		UserInputBean us= new UserInputBean();
		
		us.setFirstname(request.getParameter("firstname"));
		us.setLastname(request.getParameter("lastname"));
		us.setMobileNo(Long.parseLong(request.getParameter("mobileNo")));
		us.setEmailId(request.getParameter("email"));
		us.setPassword(request.getParameter("password"));
		us.setAddress(request.getParameter("addressArea"));
		us.setState(request.getParameter("state"));
		us.setCity(request.getParameter("city"));
		us.setPincode(Long.parseLong(request.getParameter("pincode")));
		
		CommonHelper helper=new CommonHelper();
		int result=helper.addUser(us);
		if (result==1) {
			response.setStatus(200);
			 request.setAttribute("successMessage", "User successfully registered!");
		} 
		if(result== -1){
			request.setAttribute("EmailError", "Error: Unable to register user. Email id already exists;");
			
		}else {
			response.setStatus(400);
			request.setAttribute("errorMessage", "Error: Unable to register user. Please try again later.");

		}
		try {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return response;
		
		
	}
	
	public static void loginUser(String email,String Password, HttpServletResponse response,HttpServletRequest request) throws ServletException, IOException {
//	    String mobileNo = request.getParameter("Username");
//	    String password = request.getParameter("Password");
		
	    OutputBean op=new OutputBean();
	    op.setUsername(email);
	    op.setPassword(Password);
	    System.out.println("Action Bean "+email+" "+Password);
	   // Implementation.loginUser(op, response);
	    AjaxHandler.loginUser(op, response,request);
  
	}
	
	public static void loginAdmin(String email,String Password, HttpServletResponse response,HttpServletRequest request) throws ServletException, IOException {
//	    String mobileNo = request.getParameter("Username");
//	    String password = request.getParameter("Password");
		
	    OutputBean op=new OutputBean();
	    op.setUsername(email);
	    op.setPassword(Password);
	    System.out.println("Admin Action Bean "+email+" "+Password);
	   // Implementation.loginUser(op, response);
	    AjaxHandler.loginAdmin(op, response,request);
  
	}
	
	public static void getAllUser(HttpServletRequest request, HttpServletResponse response) {
	    List<UserInputBean> users = Implementation.getAllUserImpl();

	    if (users != null) {
	        HttpSession session = request.getSession();
	        session.setAttribute("user", users);

	        try {
	        	System.out.println("User list"+users);
	           // RequestDispatcher rDispatcher = request.getRequestDispatcher("../jsp/GetUserTable.jsp");
	            //rDispatcher.forward(request, response);
	            response.sendRedirect("jsp/GetUserTable.jsp");
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	            
	        }
	    } else {
	        
	       System.out.println("Else block");
	    }
	}
	
	public static void getAllCar(HttpServletRequest request, HttpServletResponse response) {
	    List<CarOutputBean> cars = Implementation.getAllCar();

	    if (cars != null) {
	        HttpSession session = request.getSession();
	        session.setAttribute("Car", cars);

	        try {
	        	System.out.println("Car list"+cars);
	           // RequestDispatcher rDispatcher = request.getRequestDispatcher("../jsp/GetUserTable.jsp");
	            //rDispatcher.forward(request, response);
	          //  response.sendRedirect("index.jsp");
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            
	        }
	    } else {
	        
	       System.out.println("Else block");
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String url=request.getParameter("action");  
		if (url.equals("register")) {
			
			UserInputBean us= new UserInputBean();
			
			us.setFirstname(request.getParameter("firstname"));
			us.setLastname(request.getParameter("lastname"));
			us.setMobileNo(Long.parseLong(request.getParameter("mobileNo")));
			us.setEmailId(request.getParameter("email"));
			us.setPassword(request.getParameter("password"));
			us.setAddress(request.getParameter("addressArea"));
			us.setState(request.getParameter("state"));
			us.setCity(request.getParameter("city"));
			us.setPincode(Long.parseLong(request.getParameter("pincode")));
			
			CommonHelper helper=new CommonHelper();
			if (helper.addUser(us)) {
				response.setStatus(200);
				 request.setAttribute("successMessage", "User successfully registered!");
			} else {
				response.setStatus(400);
				request.setAttribute("errorMessage", "Error: Unable to register user. Please try again later.");

			}
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		} 
		else if(url.equals("Login"))
		{
			String mobileNo=request.getParameter("Username");
			String password=request.getParameter("Password");
			
		
			
		}
		else {
            System.out.println("Null request");
		}
	}
*/
	}


	public static void addCar(HttpServletRequest request,
			HttpServletResponse response) {
		 System.out.println("addCar Action bean start");
		CarInputBean carInputBean=new CarInputBean();
		carInputBean.setCarBrand(request.getParameter("carBrand"));
	    carInputBean.setCarModal(request.getParameter("carModal"));
	    carInputBean.setRegisterDate(request.getParameter("registerDate"));
	    carInputBean.setRegisterState(request.getParameter("RegisterState"));
	    carInputBean.setFuelType(Integer.parseInt(request.getParameter("FuelType")));
	    carInputBean.setPrice(Double.parseDouble(request.getParameter("price")));
	    carInputBean.setTransmission(request.getParameter("transmission"));
	    carInputBean.setEngine_cc(Integer.parseInt(request.getParameter("Engine_cc")));
	    carInputBean.setCar_desc(request.getParameter("car_desc"));
	    carInputBean.setCarType(Integer.parseInt(request.getParameter("carType")));
	   // carInputBean.setCarImg(request.getParameter("carImage"));
	    
		CommonHelper helper=new CommonHelper();
		HttpSession session = request.getSession();
		if (session.getAttribute("username") != null) {
		    if (helper.addCar(carInputBean)) {
		        response.setStatus(200);
		        request.setAttribute("successMessage", "Car successfully sent for verification!");
		    } else {
		        response.setStatus(400);
		        request.setAttribute("errorMessage", "Error: Something went wrong. Please try again later.");
		    }
		} 
		else {
		    request.setAttribute("errorMessage", "Error: Please login first");
		}

		try {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("addCar Action bean end");
		
	}


	public static void logoutuser(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = request.getSession(false); 
		if (session != null) {
		    session.invalidate(); 
		}
		try {
			response.sendRedirect("index.jsp");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	}


	public static void getCarByLocation(HttpServletRequest request,
			HttpServletResponse response) {
		 AjaxHandler.getCarByLocation(response,request);
		
	}


	public static void likedCar(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("Action Start");
		HttpSession session =request.getSession();
		int cId=Integer.parseInt(request.getParameter("CarId"));
		int uId=Integer.parseInt(session.getAttribute("userId").toString());
		String status="";
		try{
			status=CommonHelper.likedCar(cId,uId);
			System.out.println("Action try");
			if(status!=null){
				System.out.println("Action if");
				response.setStatus(200);
				session.setAttribute("likedStatus", status);
				response.getWriter().write(status);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public static void getLikedCars(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session =request.getSession();
		int uId=Integer.parseInt(session.getAttribute("userId").toString());
		List<CarOutputBean> cars = Implementation.getLikedCars(uId);
		 if (cars != null) {
		        
		        session.setAttribute("GetLikedCar", cars);

		        try {
		        	//System.out.println(+cars);
		           // RequestDispatcher rDispatcher = request.getRequestDispatcher("../jsp/GetUserTable.jsp");
		            //rDispatcher.forward(request, response);
		            response.sendRedirect("jsp/ViewLikedCars.jsp");
		            
		        } catch (Exception e) {
		            e.printStackTrace();
		            
		        }
		    } else {
		        
		       System.out.println("Else block");
		    }
		
	}


	public static void searchCarBy(HttpServletRequest request,
			HttpServletResponse response) {
		int price=Integer.parseInt(request.getParameter("Budget"));
		int car_type=Integer.parseInt(request.getParameter("CarType"));
		List<CarOutputBean> cars = Implementation.searchCarBy(price,car_type);
		
		if (cars != null) {
	        HttpSession session = request.getSession();
	        session.setAttribute("SearchCarBYPrice", cars);

	        try {
	        	System.out.println("Price List"+cars);
	            RequestDispatcher rDispatcher = request.getRequestDispatcher("index.jsp");
	            rDispatcher.forward(request, response);
	           // response.sendRedirect("index.jsp");
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            
	        }
	    } else {
	        
	       System.out.println("Else block");
	    }
		
	}


	public static HttpServletResponse updateUser(HttpServletRequest request,
			HttpServletResponse response) {
         UserInputBean us= new UserInputBean();
		us.setId(Integer.parseInt(request.getParameter("userId")));
		us.setFirstname(request.getParameter("firstname"));
		us.setLastname(request.getParameter("lastname"));
		us.setMobileNo(Long.parseLong(request.getParameter("mobileNo")));
		us.setEmailId(request.getParameter("email"));
		us.setPassword(request.getParameter("password"));
		us.setAddress(request.getParameter("addressArea"));
		us.setState(request.getParameter("state"));
		us.setCity(request.getParameter("city"));
		us.setPincode(Long.parseLong(request.getParameter("pincode")));
		
		
		CommonHelper helper=new CommonHelper();
		if (helper.updateUser(us)) {
			response.setStatus(200);
			 request.setAttribute("UpdatesuccessMessage", "Request Send for updation ");
			 
		} else {
			response.setStatus(400);
			request.setAttribute("UpdateerrorMessage", "Error: Unable to update user. Please try again later.");

		}
		RequestDispatcher rDispatcher = request.getRequestDispatcher("jsp/ViewUser.jsp");
        try {
			rDispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			
			e.printStackTrace();
		}
		return response;
	}


	public static void userInactive(HttpServletRequest request,
			HttpServletResponse response) {
		int userId=Integer.parseInt(request.getParameter("userId"));
		CommonHelper helper=new CommonHelper();
		int status=helper.userInactive(userId);
		if(status == 1){
			RequestDispatcher rDispatcher = request.getRequestDispatcher("index.jsp");
			try {
				rDispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				
				e.printStackTrace();
			}
		}
		
	}
}
