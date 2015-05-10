package data;

import java.io.Serializable;

public class DataUsers implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int user_id;
	private String email;
	private String password;
	private int role;
	
	public DataUsers() {	
	}
	
	public int getUser_Id() {
		return user_id;
	}
	public void setUser_Id(int user_id) {
		this.user_id = user_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + role;
		result = prime * result + user_id;
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
		if (!(obj instanceof DataUsers)) {
			return false;
		}
		DataUsers other = (DataUsers) obj;
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (role != other.role) {
			return false;
		}
		if (user_id != other.user_id) {
			return false;
		}
		return true;
	}
	

}
