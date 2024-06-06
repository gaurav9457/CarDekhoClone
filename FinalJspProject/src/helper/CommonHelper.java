package helper;

import javax.mail.Flags.Flag;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import impl.Implementation;
import ajaxHandler.AjaxHandler;
import beans.input.CarInputBean;
import beans.input.UserInputBean;

public class CommonHelper {
	 boolean status;
	 Implementation implementation = new Implementation();
	 
	public  int addUser(UserInputBean uc) {
		
		if (uc.getFirstname().equals("")) {
						
			return 0;
		}
		 if (!isValidMobileNumber(uc.getMobileNo())) {
	            return 0;
	        }
		 if (!isValidPassword(uc.getPassword())) {
	            return 0;
	        }
		return implementation.saveUser(uc);
		
	}
	
	public boolean addCar(CarInputBean cBean){
		System.out.println("Add car");
	
		if (cBean.getCarBrand().equals("")) {
			return false;
		}
		if (cBean.getFuelType()==0) {
			return false;
		}
		
		System.out.println("Add car end");
		return implementation.saveCar(cBean);
		}
	
//	public boolean login(String Username,String Password){
//		return implementation.login(Username,Password);
//		
//	}
	
	
	
	 private boolean isValidMobileNumber(long mobileNo) {
	       
	        return mobileNo > 0;
	    }
	 private boolean isValidPassword(String password) {
	       
	        return password != null && !password.isEmpty();
	    }

	public static String likedCar(int cId, int uId) {
		AjaxHandler handler=new AjaxHandler();
		if (cId<=0) {
			System.out.println("Inside helper If");
			return null;
		} else {
			System.out.println("Inside helper else");
           return handler.likedCar(cId,uId);
		}
		
	}

	public boolean updateUser(UserInputBean us) {
		
		if (us.getFirstname().equals("")) {
			
			return false;
		}
		 if (!isValidMobileNumber(us.getMobileNo())) {
	            return false;
	        }
		 if (!isValidPassword(us.getPassword())) {
	            return false;
	        }
		return implementation.UpadteUser(us);
	}

	public int userInactive(int userId) {
		return implementation.userInactive(userId);
		
	}
	 
	 
	 
	 
	 
	 

}
