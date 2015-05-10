package data;

import java.io.Serializable;

public class DataDisp implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int disp_id;
	private String name;
	private String surname;
	
	public DataDisp() {	
	}
	
	public int getDisp_Id() {
		return disp_id;
	}
	public void setDisp_Id(int disp_id) {
		this.disp_id = disp_id;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + disp_id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (!(obj instanceof DataDisp)) {
			return false;
		}
		DataDisp other = (DataDisp) obj;
		if (disp_id != other.disp_id) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
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

