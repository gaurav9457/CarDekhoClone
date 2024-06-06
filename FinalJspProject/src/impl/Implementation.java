package impl;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import dao.AllDao;
import beans.input.CarInputBean;
import beans.input.UserInputBean;
import beans.output.CarOutputBean;
import beans.output.OutputBean;
import beans.output.UserOutputBean;

public class Implementation {
	
	private static int status;
	boolean result;
	public  int saveUser(UserInputBean bean) {
		
		status=AllDao.addUser(bean);
		if (status==1) {
			return 1;
		} 
		if (status== -1) {
			
			return -1;
		}else {
			return 0;
		}
		
	}
//	public boolean login(String username, String password) {
//		result=AllDao.loginDao(username,password);
//		return false;
//	}
	public boolean saveCar(CarInputBean cBean) {
		System.out.println("Impl car ");
		if (AllDao.addCar(cBean)==1) {
			return true;
		}
		return false;
	}
	
	public static void loginUser(OutputBean op, HttpServletResponse response) throws IOException {
        String username = op.getUsername();
        String password = op.getPassword();

       
        boolean loginSuccess = AllDao.loginDao(username, password);
        System.out.println("Ajax enter");
        if(loginSuccess){
        	ResultSet rs=AllDao.getUserByEmail(username);
        	UserOutputBean uOutputBean = new UserOutputBean();
              System.out.println("Ajax Success");
            try {
                if (rs != null && rs.next()) {
                    uOutputBean.setId(rs.getInt("id"));
                    uOutputBean.setFirstname(rs.getString("FirstName"));
                    uOutputBean.setLastname(rs.getString("LastName"));
                    uOutputBean.setMobileNo(rs.getLong("MobileNo"));
                    uOutputBean.setEmailId(rs.getString("Email_id"));
                    uOutputBean.setPassword(rs.getString("C_Password"));
                    uOutputBean.setAddress(rs.getString("Address"));
                    uOutputBean.setState(rs.getString("State"));
                    response.sendRedirect("ViewCarDetails.jsp");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                
            }
        	
        }
	}
	
	public static List<UserInputBean> getAllUserImpl(){
		List<UserInputBean> userInputBean=AllDao.getAllUsers();
		System.out.println("Impl"+userInputBean);
		return userInputBean;
	}
	public static List<CarOutputBean> getAllCar() {
		List<CarOutputBean> carInputBean=AllDao.getAllCars();
		System.out.println("Impl"+carInputBean);
		return carInputBean;
	}
	/*public static String likedcar(int carId,int userId){
		
	}*/
	public static List<CarOutputBean> getLikedCars(int uId) {
		List<CarOutputBean> carOutputBeans=AllDao.getLikedCars(uId);
		return carOutputBeans;
	}
	
	public static List<CarOutputBean> searchCarBy(int price, int car_type) {
		List<CarOutputBean> carOutputBeans=AllDao.searchCarBy(price,car_type);
		return carOutputBeans;
	}
	public boolean UpadteUser(UserInputBean us) {
		
		status=AllDao.UpdateUser(us);
		if (status==1) {
			return true;
		} else {
			return false;
		}
	}
	public int userInactive(int userId) {
		status=AllDao.userInactive(userId);
		return status;
	}
	

}
