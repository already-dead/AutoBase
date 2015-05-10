package data;

import java.io.Serializable;

public class DataCars implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int car_id;
	private String brand;
	private String model;
	private String regNumber;
	private int condition;
	
	public DataCars() {	
	}
	
	public int getCar_Id() {
		return car_id;
	}
	public void setCar_Id(int car_id) {
		this.car_id = car_id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getRegNumber() {
		return regNumber;
	}
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	public int getCondition() {
		return condition;
	}
	public void setCondition(int condition) {
		this.condition = condition;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + car_id;
		result = prime * result + condition;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result
				+ ((regNumber == null) ? 0 : regNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof DataCars)) {
			return false;
		}
		DataCars other = (DataCars) obj;
		if (brand == null) {
			if (other.brand != null) {
				return false;
			}
		} else if (!brand.equals(other.brand)) {
			return false;
		}
		if (car_id != other.car_id) {
			return false;
		}
		if (condition != other.condition) {
			return false;
		}
		if (model == null) {
			if (other.model != null) {
				return false;
			}
		} else if (!model.equals(other.model)) {
			return false;
		}
		if (regNumber == null) {
			if (other.regNumber != null) {
				return false;
			}
		} else if (!regNumber.equals(other.regNumber)) {
			return false;
		}
		return true;
	}
	

}
