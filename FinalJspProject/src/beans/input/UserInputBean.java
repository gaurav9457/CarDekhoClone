package beans.input;

public class UserInputBean {
	
	 private int id;
	 private String firstname;
	 private String lastname;	
	 private long mobileNo;
	 private String emailId;
	 private String password;	 
	 private String address;
	 private String state;
	 private String city;
	 private long pincode;
	 
	 
	public UserInputBean(String firstname, String lastname, long mobileNo,
			String emailId, String password, String address, String state,
			String city, long pincode) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.password = password;
		this.address = address;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
	}
	
	public UserInputBean() {
		super();
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 

}
