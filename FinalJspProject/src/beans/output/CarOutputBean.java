package beans.output;

public class CarOutputBean {
	private int id;
	private String carBrand;
	private String carModal;
	private String registerDate;
	private String registerState;
	private String FuelType;
	private String price;
	private String transmission;
	private double Engine_cc;
	private String car_desc;
	private String carType;
	private String carImg;
	private String isActive;
	private String createdBy;
	private String createdDate;
	private String ModifiedBY;
	private String modifiedDateString;
	
	
	
	
	public CarOutputBean() {
		super();
		
	}
	public CarOutputBean(int id, String carBrand, String carModal,
			String registerDate, String registerState, String fuelType,
			String price, String transmission, double engine_cc,
			String car_desc, String carType, String carImg, String isActive) {
		super();
		this.id = id;
		this.carBrand = carBrand;
		this.carModal = carModal;
		this.registerDate = registerDate;
		this.registerState = registerState;
		FuelType = fuelType;
		this.price = price;
		this.transmission = transmission;
		Engine_cc = engine_cc;
		this.car_desc = car_desc;
		this.carType = carType;
		this.carImg = carImg;
		this.isActive = isActive;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCarBrand() {
		return carBrand;
	}
	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}
	public String getCarModal() {
		return carModal;
	}
	public void setCarModal(String carModal) {
		this.carModal = carModal;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public String getRegisterState() {
		return registerState;
	}
	public void setRegisterState(String registerState) {
		this.registerState = registerState;
	}
	public String getFuelType() {
		return FuelType;
	}
	public void setFuelType(String fuelType) {
		FuelType = fuelType;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	public double getEngine_cc() {
		return Engine_cc;
	}
	public void setEngine_cc(double engine_cc) {
		Engine_cc = engine_cc;
	}
	public String getCar_desc() {
		return car_desc;
	}
	public void setCar_desc(String car_desc) {
		this.car_desc = car_desc;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getCarImg() {
		return carImg;
	}
	public void setCarImg(String carImg) {
		this.carImg = carImg;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifiedBY() {
		return ModifiedBY;
	}
	public void setModifiedBY(String modifiedBY) {
		ModifiedBY = modifiedBY;
	}
	public String getModifiedDateString() {
		return modifiedDateString;
	}
	public void setModifiedDateString(String modifiedDateString) {
		this.modifiedDateString = modifiedDateString;
	}

}
