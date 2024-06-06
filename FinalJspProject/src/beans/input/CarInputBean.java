package beans.input;

import java.io.InputStream;

public class CarInputBean {

	private int id;
	private String carBrand;
	private String carModal;
	private String registerDate;
	private String registerState;
	private int FuelType;
	private double price;
	private String transmission;
	private double Engine_cc;
	private String car_desc;
	private int carType;
	private String carImg;
	//private InputStream carImgInp;
	
	public CarInputBean() {
		super();
		
	}
	


	public CarInputBean(int id, String carBrand, String carModal,
			String registerDate, String registerState, int fuelType,
			double price, String transmission, double engine_cc,
			String car_desc, int carType, String carImg) {
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
	public int getFuelType() {
		return FuelType;
	}
	public void setFuelType(int fuelType) {
		FuelType = fuelType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
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
	public int getCarType() {
		return carType;
	}
	public void setCarType(int carType) {
		this.carType = carType;
	}
	
	
	public String getRegisterState() {
		return registerState;
	}

	public void setRegisterState(String registerState) {
		this.registerState = registerState;
	}

	public String getCarImg() {
		return carImg;
	}



	public void setCarImg(String carImg) {
		this.carImg = carImg;
	}
//	public InputStream getCarImgInp() {
//		return carImgInp;
//	}
//	public void setCarImgInp(InputStream carImgInp) {
//		this.carImgInp = carImgInp;
//	}
//	
	
	
}
