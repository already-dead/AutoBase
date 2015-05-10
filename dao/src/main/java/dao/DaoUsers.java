package dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import data.DataUsers;

public class DaoUsers{	

	private static Logger log = Logger.getLogger(DaoUsers.class);
	private static DaoUsers thisDao; 

	public DaoUsers() {
		super();
	}
	
	public static  DaoUsers getDaoUsers()
	{
		if(thisDao == null)
			thisDao = new DaoUsers();
		return thisDao;
	}
	
	public DataUsers getUser(int id)
	{
		DataUsers data = null;

		try {
			InitialContext initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/appname");
			Connection conn = ds.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from users where user_id='"+id+"'");
			if(rs.next()) {
				data = new DataUsers();
				data.setUser_Id(rs.getInt("user_id"));
				data.setEmail(rs.getString("email"));
				data.setPassword(rs.getString("password"));
				data.setRole(rs.getInt("role"));
				conn.close();
				return data;
			}
			else {
				conn.close();
				return null;
			}		
		} catch (SQLException e) {
			log.error(e);
			e.printStackTrace();
		} catch (NamingException e) {
			log.error(e);
			e.printStackTrace();
		}
		return null;
	}
	
	public List<DataUsers> getUsers()
	{
		ArrayList<DataUsers> users = new ArrayList<DataUsers>();
		try {
			InitialContext initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/appname");
			Connection conn = ds.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from users");
			while(rs.next())
			{
				DataUsers data = new DataUsers();
			
				data = new DataUsers();
				data.setUser_Id(rs.getInt("user_id"));
				data.setEmail(rs.getString("email"));
				data.setPassword(rs.getString("password"));
				data.setRole(rs.getInt("role"));
				users.add(data);
				
			}
			conn.close();
			return users;
		} catch (SQLException e) {
			log.error(e);
			e.printStackTrace();
		} catch (NamingException e) {
			log.error(e);
			e.printStackTrace();
		}	
		return null;
	}
	public int addUser(DataUsers u)
	{
		try {
			InitialContext initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/appname");
			Connection conn = ds.getConnection();
			Statement statement = conn.createStatement();
			statement.executeUpdate("insert into users values ('"+u.getUser_Id()+"','"+u.getEmail()+"','"+u.getPassword()+"','"+u.getRole()+"');");
			conn.close();
			return 1;
		} catch (SQLException e) {
			log.error(e);
			e.printStackTrace();
		} catch (NamingException e) {
			log.error(e);
			e.printStackTrace();
		}
		return -1;
	}
	
	public int delUser(String id)
	{
		try {
			InitialContext initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/appname");
			Connection conn = ds.getConnection();
			Statement statement = conn.createStatement();
			statement.executeUpdate("delete from users where user_id='"+id+"';");
			conn.close();
			return 1;
		} catch (SQLException e) {
			log.error(e);
			e.printStackTrace();
		} catch (NamingException e) {
			log.error(e);
			e.printStackTrace();
		}
		return -1;
	}
	
	public int editUser(int oldId, DataUsers newUser)
	{
		try {
			InitialContext initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/appname");
			Connection conn = ds.getConnection();
			Statement statement = conn.createStatement();
			statement.executeUpdate("update users set email='"+newUser.getEmail()+"', password='"+
			newUser.getPassword()+"', role='"+newUser.getRole()+"' where user_id='"+oldId+"';");
			conn.close();
			return 1;
		} catch (SQLException e) {
			log.error(e);
			e.printStackTrace();
		} catch (NamingException e) {
			log.error(e);
			e.printStackTrace();
		}
		return -1;
	}

}
