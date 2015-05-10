package data;

import java.io.Serializable;

public class DataFlights implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int flight_id;
	private String date;
	private String adress;
	private int driver;
	private int car;
	private int status;
	private int condition;
	
	public DataFlights() {	
	}
	
	public int getFlight_Id() {
		return flight_id;
	}
	public void setFlight_Id(int flight_id) {
		this.flight_id = flight_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getDriver() {
		return driver;
	}
	public void setDriver(int driver) {
		this.driver = driver;
	}
	public int getCar() {
		return car;
	}
	public void setCar(int car) {
		this.car = car;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + car;
		result = prime * result + condition;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + driver;
		result = prime * result + flight_id;
		result = prime * result + status;
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
		if (!(obj instanceof DataFlights)) {
			return false;
		}
		DataFlights other = (DataFlights) obj;
		if (adress == null) {
			if (other.adress != null) {
				return false;
			}
		} else if (!adress.equals(other.adress)) {
			return false;
		}
		if (car != other.car) {
			return false;
		}
		if (condition != other.condition) {
			return false;
		}
		if (date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (!date.equals(other.date)) {
			return false;
		}
		if (driver != other.driver) {
			return false;
		}
		if (flight_id != other.flight_id) {
			return false;
		}
		if (status != other.status) {
			return false;
		}
		return true;
	}
	
}
