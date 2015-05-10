package data;

import java.io.Serializable;

public class DataDrivers implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int driver_id;
	private String name;
	private String surname;
	private int status;
	
	public DataDrivers() {	
	}
	
	public int getDriver_Id() {
		return driver_id;
	}
	public void setDriver_Id(int driver_id) {
		this.driver_id = driver_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + driver_id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + status;
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		if (!(obj instanceof DataDrivers)) {
			return false;
		}
		DataDrivers other = (DataDrivers) obj;
		if (driver_id != other.driver_id) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (status != other.status) {
			return false;
		}
		if (surname == null) {
			if (other.surname != null) {
				return false;
			}
		} else if (!surname.equals(other.surname)) {
			return false;
		}
		return true;
	}

}
