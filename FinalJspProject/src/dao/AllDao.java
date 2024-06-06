package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;





import org.jacorb.trading.test.ExampleSetup;
import org.omg.CORBA.PRIVATE_MEMBER;

import utility.DBconnection;
import beans.input.CarInputBean;
import beans.input.UserInputBean;
import beans.output.CarOutputBean;

public class AllDao {
	private static String query;
	private static PreparedStatement pStatement;
	private static int resultSet;
	
	public static int addUser(UserInputBean us) {
		 Connection connection =null;
		try {
			 connection = DBconnection.getConnection();
	        
	        
	        String checkQuery = "SELECT COUNT(*) FROM Register_User WHERE Email_id = ?";
	        PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
	        checkStatement.setString(1, us.getEmailId());
	        ResultSet checkResultSet = checkStatement.executeQuery();
	        checkResultSet.next();
	        int count = checkResultSet.getInt(1);
	        
	        if (count > 0) {
	            return -1; 
	        }
		
			query="Insert into Register_User (FirstName,LastName,MobileNo,Email_id,C_Password,Address,State,City,Pincode,isActive,createdBY,ModifiedBy,createdDate,ModifiedDate) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,CURRENT_DATE,NULL)";
			
			pStatement=connection.prepareStatement(query);
			pStatement.setString(1, us.getFirstname());
			pStatement.setString(2, us.getLastname());
			pStatement.setLong(3, us.getMobileNo());
			pStatement.setString(4, us.getEmailId());
			pStatement.setString(5, us.getPassword());
			pStatement.setString(6, us.getAddress());
			pStatement.setString(7, us.getState());
			pStatement.setString(8, us.getCity());
			pStatement.setLong(9, us.getPincode());
			pStatement.setString(10, "Y");
			pStatement.setInt(11, 0);
			pStatement.setString(12, null);
			
			
            resultSet=pStatement.executeUpdate();
			
			System.out.println("Query ok"+resultSet);
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		 finally {
		       
		        try {
		            if (pStatement != null) pStatement.close();
		            if (connection != null) connection.close();
		            
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		return resultSet;
				
	}

	public static boolean loginDao(String mobileNo, String password) {
		Connection connection=null;
		 try  {
			 
			 System.out.println("From Dao"+mobileNo+" "+password);
			  connection=DBconnection.getConnection();
	             query = "SELECT * FROM Register_User WHERE Email_id = ? AND C_password = ?";
	             pStatement=connection.prepareStatement(query);
	             pStatement.setString(1, mobileNo);
	 			pStatement.setString(2, password );
	 			try (ResultSet resultSet = pStatement.executeQuery()) {
                   
                    return resultSet.next();
                }
	           
	        } catch (Exception e) {
	            e.printStackTrace(); 
	             
	        }
		 finally {
		       
		        try {
		            
		            if (connection != null) connection.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		 return false;
	}
	
	public static boolean AdminLogin(String mobileNo, String password) {
		Connection connection=null;
		 try  {
			 System.out.println("AdminFrom Dao"+mobileNo+" "+password);
			  connection=DBconnection.getConnection();
	             query = "SELECT * FROM Admin WHERE Email_id = ? AND C_Password = ?";
	             pStatement=connection.prepareStatement(query);
	             pStatement.setString(1, mobileNo);
	 			pStatement.setString(2, password );
	 			try (ResultSet resultSet = pStatement.executeQuery()) {
	 				System.out.println("ResultSet "+resultSet);
                   return resultSet.next();
               }
	           
	        } catch (Exception e) {
	            e.printStackTrace(); 
	             
	        }
		 finally {
		       
		        try {
		            if (connection != null) connection.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		 return false;
	}
	
	public static ResultSet getUserByEmail(String UserName){
		ResultSet rs=null;
		try  {
			 Connection connection=DBconnection.getConnection();
	             query = "SELECT * FROM Register_User WHERE Email_id = ?";
	             pStatement=connection.prepareStatement(query);
	             pStatement.setString(1, UserName);
	             rs=pStatement.executeQuery();
		}
		catch (Exception e){
			 e.printStackTrace();
		}
		
			return (rs != null) ? rs : null;
		
	}
	

	public static ResultSet getAdminByEmail(String UserName){
		ResultSet rs=null;
		try  {
			System.out.println("Admin Dao");
			 Connection connection=DBconnection.getConnection();
	             query = "SELECT * FROM Admin WHERE Email_id = ?";
	             pStatement=connection.prepareStatement(query);
	             pStatement.setString(1, UserName);
	             rs=pStatement.executeQuery();
		}
		catch (Exception e){
			 e.printStackTrace();
		}
		
	
			return (rs != null) ? rs : null;
		
	}
	
	public static List<UserInputBean> getAllUsers() {
	    List<UserInputBean> allUsers = new ArrayList<>();
	    Connection connection = null;
	    PreparedStatement pStatement = null;
	    ResultSet rSet = null;
	    
	    try {
	        connection = DBconnection.getConnection();
	        String query = "SELECT id, FirstName,LastName,MobileNo,Email_id,C_Password,Address,State,City,Pincode FROM Register_User";
	        pStatement = connection.prepareStatement(query);
	        rSet = pStatement.executeQuery();
	        
	       
	        while (rSet.next()) {
	            UserInputBean user = new UserInputBean();
	            user.setId(rSet.getInt("id"));
	            user.setFirstname(rSet.getString("FirstName"));
	            user.setLastname(rSet.getString("LastName"));
	            user.setMobileNo(rSet.getLong("MobileNo"));
	            user.setEmailId(rSet.getString("Email_id"));
	            user.setPassword(rSet.getString("C_Password")); 
	            user.setAddress(rSet.getString("Address"));
	            user.setState(rSet.getString("State"));
	            user.setCity(rSet.getString("City"));
	            user.setPincode(rSet.getLong("Pincode"));
	            
	            allUsers.add(user);
	        }
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    } 
	    finally {
	       
	        try {
	            if (rSet != null) rSet.close();
	            if (pStatement != null) pStatement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    return allUsers;
	}


	public static boolean isUserActive(String username) {
        String query = "SELECT isActive FROM Register_User WHERE Email_id = ?";
        try (Connection connection = DBconnection.getConnection();
             PreparedStatement pStatement = connection.prepareStatement(query)) {
            pStatement.setString(1, username);
            try (ResultSet rs = pStatement.executeQuery()) {
                if (rs.next()) {
                    String isActive = rs.getString("isActive");
                    return isActive.equals("Y");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
	
	
	
	

	public static List<CarOutputBean> getAllCars() {
	    List<CarOutputBean> allCars = new ArrayList<>();
	    Connection connection = null;
	    PreparedStatement pStatement = null;
	    ResultSet rSet = null;
	    
	    try {
	        connection = DBconnection.getConnection();
	        String query = "SELECT c.*, ft.type_name, ct.type_name As CAR_TYPE"+
                            " FROM Cars c"+
                            " INNER JOIN FuelTypes ft ON c.Fuel_type = ft.id"+
                            " INNER JOIN CarTypes ct ON c.carType = ct.id;";
	        pStatement = connection.prepareStatement(query);
	        rSet = pStatement.executeQuery();
	        
	       
	        while (rSet.next()) {
	            CarOutputBean car = new CarOutputBean();
	           car.setId(rSet.getInt("id"));
	            car.setCarBrand(rSet.getString("carBrand"));
	            car.setCarModal(rSet.getString("carModal"));
	            car.setRegisterDate(rSet.getString("Register_Date"));
	            car.setRegisterState(rSet.getString("Register_State"));
	            car.setFuelType(rSet.getString("type_name")); 
	            car.setPrice(rSet.getString("Price"));
	            car.setTransmission(rSet.getString("Transmission"));
	            car.setEngine_cc(rSet.getDouble("ENGINE_cc"));
	            car.setCar_desc(rSet.getString("car_Description"));
	            car.setCarType(rSet.getString("CAR_TYPE"));
	            car.setIsActive(rSet.getString("isActive"));
	            car.setCreatedBy(rSet.getString("createdBy"));
	            car.setCreatedDate(rSet.getString("createdDate"));
	            car.setModifiedBY(rSet.getString("ModifiedBy"));
	            car.setModifiedDateString(rSet.getString("ModifiedDate"));
	            
	            allCars.add(car);
	        }
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    } 
	    finally {
	       
	        try {
	            if (rSet != null) rSet.close();
	            if (pStatement != null) pStatement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    return allCars;
	}
	public static int  addCar(CarInputBean cBean) {
		 System.out.println("Car Dao");
		try {
			 System.out.println("Inside try");
			Connection connection=DBconnection.getConnection();
			query="INSERT INTO Cars (carBrand, carModal, Register_Date, Register_State, Fuel_type, Price, Transmission, ENGINE_cc, car_Description, car_image, carType, isActive, createdBY, ModifiedBy, createdDate, ModifiedDate) values (?,?,?,?,?,?,?,?,?,?,?,'Y','User',null,CURRENT_DATE,null)";
			
			pStatement=connection.prepareStatement(query);
			pStatement.setString(1, cBean.getCarBrand());
			pStatement.setString(2, cBean.getCarModal());
			pStatement.setString(3, cBean.getRegisterDate());
			pStatement.setString(4, cBean.getRegisterState());
			pStatement.setInt(5, cBean.getFuelType());
			pStatement.setDouble(6, cBean.getPrice());
			pStatement.setString(7, cBean.getTransmission());
			pStatement.setDouble(8, cBean.getEngine_cc());
			pStatement.setString(9, cBean.getCar_desc());
			pStatement.setString(10, "Tata.jpg");
			pStatement.setInt(11, cBean.getCarType());
			 resultSet=pStatement.executeUpdate();
				
				System.out.println("Query ok"+resultSet);
		} catch (Exception e) {
			e.getStackTrace();
		}
		 System.out.println("Dao End");
		
		return resultSet;
	}

	public static  List<CarOutputBean> getCarByLocation(String location) {
		 List<CarOutputBean> cList= new ArrayList<>();
		 Connection connection=null;
		 ResultSet rSet=null;
		 try{
		
		 connection = DBconnection.getConnection();
	        String query = "SELECT c.*, ft.type_name AS fuel_type, ct.type_name AS car_type"+
	        		" FROM Cars c"+
	        		" INNER JOIN FuelTypes ft ON c.Fuel_type = ft.id"+
	        		" INNER JOIN CarTypes ct ON c.carType = ct.id"+
	        		" WHERE c.Register_State = ?";
	        pStatement = connection.prepareStatement(query);
	        pStatement.setString(1,location);
	       rSet = pStatement.executeQuery();
	       
	       while (rSet.next()) {
	       CarOutputBean car = new CarOutputBean();
           car.setId(rSet.getInt("id"));
            car.setCarBrand(rSet.getString("carBrand"));
            car.setCarModal(rSet.getString("carModal"));
            car.setRegisterDate(rSet.getString("Register_Date"));
            car.setRegisterState(rSet.getString("Register_State"));
            car.setFuelType(rSet.getString("fuel_type")); 
            car.setPrice(rSet.getString("Price"));
            car.setTransmission(rSet.getString("Transmission"));
            car.setEngine_cc(rSet.getDouble("ENGINE_cc"));
            car.setCar_desc(rSet.getString("car_Description"));
            car.setCarType(rSet.getString("car_type"));
            
            cList.add(car);
		 } 
		 }
		 catch(Exception e){
			    e.printStackTrace();
		 }
		 finally {
		       
		        try {
		            if (rSet != null) rSet.close();
		           
		            if (connection != null) connection.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		return cList;
	}
	
	public static String likedCar(int carId,int userId) {
		String setStatus="";
		int status=0;
		
		try{
			Connection connection=DBconnection.getConnection();
			Statement statement=connection.createStatement();
			int favId=0;
			ResultSet rsSet=statement.executeQuery("select * from Liked_Cars where Carid="+carId+" and Userid="+userId);
			if (rsSet.next()) {
				favId=rsSet.getInt(1);
			} 
			if(favId==0){
				status=statement.executeUpdate("insert into Liked_Cars(Userid,Carid,isActive) values("+userId+","+carId+",'Y')");
				setStatus="liked";
			}
			
			else {
               status=statement.executeUpdate("Update Liked_Cars set isActive='N' where id="+favId+" and isActive='Y'");
               setStatus="unliked";
               if(status==0){
            	   status=statement.executeUpdate("Update Liked_Cars set isActive='Y' where id="+favId+" and isActive='N'");
            	   setStatus="liked";
               }
              // setStatus="updated";
			}
			if(status==0){
				setStatus=null;
			}
			
		}
		catch(Exception e){
			status=0;
			System.out.println(e);
		}
		return setStatus;
	}

	public static List<CarOutputBean> getLikedCars(int uId) {
		List<CarOutputBean> allLikedCars = new ArrayList<>();
		try{
			Connection connection=DBconnection.getConnection();
			Statement statement=connection.createStatement();
			ResultSet rSet=statement.executeQuery("SELECT c.* FROM Cars c INNER JOIN Liked_Cars lc ON c.id = lc.Carid WHERE lc.Userid ="+uId+" and lc.isActive ='Y'");

			 while (rSet.next()) {
			       CarOutputBean car = new CarOutputBean();
		           car.setId(rSet.getInt("id"));
		            car.setCarBrand(rSet.getString("carBrand"));
		            car.setCarModal(rSet.getString("carModal"));
		            car.setRegisterDate(rSet.getString("Register_Date"));
		            car.setRegisterState(rSet.getString("Register_State"));
		           // car.setFuelType(rSet.getString("fuel_type")); 
		            car.setPrice(rSet.getString("Price"));
		            car.setTransmission(rSet.getString("Transmission"));
		            car.setEngine_cc(rSet.getDouble("ENGINE_cc"));
		            car.setCar_desc(rSet.getString("car_Description"));
		            //car.setCarType(rSet.getString("car_type"));
		            
		            allLikedCars.add(car);
				 } 

					
			}
		catch(Exception e){
			e.printStackTrace();
		}
		return allLikedCars;
	}

	public static List<CarOutputBean> searchCarBy(int price, int car_type) {
		List<CarOutputBean> searchCarBy = new ArrayList<>();
		 ResultSet rSet=null;
		try{
			Connection connection=DBconnection.getConnection();
			
			//Statement statement=connection.createStatement();
			//if(price != 0 && car_type !=0){
				
		        String query = "SELECT c.*, ft.type_name AS fuel_type, ct.type_name AS car_type"+
		        		" FROM Cars c"+
		        		" INNER JOIN FuelTypes ft ON c.Fuel_type = ft.id"+
		        		" INNER JOIN CarTypes ct ON c.carType = ct.id"+
		        		" WHERE c.Price = ? and ft.id=?";
		        pStatement = connection.prepareStatement(query);
		        pStatement.setInt(1,price);
		        pStatement.setInt(2, car_type);
		        
		       rSet = pStatement.executeQuery();
		       while (rSet.next()) {
			       CarOutputBean car = new CarOutputBean();
		           car.setId(rSet.getInt("id"));
		            car.setCarBrand(rSet.getString("carBrand"));
		            car.setCarModal(rSet.getString("carModal"));
		            car.setRegisterDate(rSet.getString("Register_Date"));
		            car.setRegisterState(rSet.getString("Register_State"));
		            car.setFuelType(rSet.getString("fuel_type")); 
		            car.setPrice(rSet.getString("Price"));
		            car.setTransmission(rSet.getString("Transmission"));
		            car.setEngine_cc(rSet.getDouble("ENGINE_cc"));
		            car.setCar_desc(rSet.getString("car_Description"));
		            car.setCarType(rSet.getString("car_type"));
		            
		            searchCarBy.add(car);
				 } 
		       
			//}
			
			
			}
		catch(Exception e){
			e.printStackTrace();
		}
		return searchCarBy;
	}

	
	public static int UpdateUser(UserInputBean us) {
		try {
			Connection connection=DBconnection.getConnection();
			query="UPDATE Register_User SET FirstName = ?, LastName = ?,MobileNo = ?,Email_id = ?,C_Password = ?,Address = ?,State = ?, City = ?,Pincode = ?,isActive = ?,createdBY = ?,ModifiedBy = ?,ModifiedDate = CURRENT_DATE WHERE  id= ?";
			
			pStatement=connection.prepareStatement(query);
			pStatement.setString(1, us.getFirstname());
			pStatement.setString(2, us.getLastname());
			pStatement.setLong(3, us.getMobileNo());
			pStatement.setString(4, us.getEmailId());
			pStatement.setString(5, us.getPassword());
			pStatement.setString(6, us.getAddress());
			pStatement.setString(7, us.getState());
			pStatement.setString(8, us.getCity());
			pStatement.setLong(9, us.getPincode());
			pStatement.setString(10, "Y");
			pStatement.setInt(11, us.getId());
			pStatement.setString(12,"user" );
			pStatement.setInt(13, us.getId());
			
			
			
            resultSet=pStatement.executeUpdate();
			
			System.out.println("Query ok"+resultSet);
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return resultSet;
		}

	public static int userInactive(int userId) {
		Connection connection=null;
		try{
			connection=DBconnection.getConnection();
			query="Update Register_User SET isActive = ?,ModifiedBy = ?,ModifiedDate = CURRENT_DATE WHERE  id= ? ";
			
			pStatement=connection.prepareStatement(query);
			pStatement.setString(1,"N");
			pStatement.setString(2, "Admin");
			pStatement.setInt(3, userId);
			resultSet=pStatement.executeUpdate();
			System.out.println("Updated success "+resultSet);
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultSet;
		
	} 
		
	

	
	

}
