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

import data.DataCars;

public class DaoCars {	

	private static Logger log = Logger.getLogger(DaoCars.class);
	private static DaoCars thisDao; 

	public DaoCars() {
		super();
	}
	
	public static  DaoCars getDaoCars()
	{
		if(thisDao == null)
			thisDao = new DaoCars();
		return thisDao;
	}
	
	public DataCars getCar(int id)
	{
		DataCars data = null;

		try {
			InitialContext initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/appname");
			Connection conn = ds.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from cars where car_id='"+id+"'");
			if(rs.next())
			{
				data = new DataCars();
				data.setCar_Id(rs.getInt("car_id"));
				data.setBrand(rs.getString("brand"));
				data.setModel(rs.getString("model"));
				data.setRegNumber(rs.getString("regNumber"));
				data.setCondition(rs.getInt("condition"));
				conn.close();
				return data;
			}
			else {
				conn.close();
				return null;
			}			
		} catch (SQLException e) {
			log.error(e);
		} catch (NamingException e) {
			log.error(e);
		}
		return null;
	}
	
	public List<DataCars> getCars()
	{
		ArrayList<DataCars> cars = new ArrayList<DataCars>();
		try {
			InitialContext initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/appname");
			Connection conn = ds.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from cars");
			while(rs.next())
			{
				DataCars data = new DataCars();
			
				data = new DataCars();
				data.setCar_Id(rs.getInt("car_id"));
				data.setBrand(rs.getString("brand"));
				data.setModel(rs.getString("model"));
				data.setRegNumber(rs.getString("regNumber"));
				data.setCondition(rs.getInt("condition"));
				cars.add(data);		
			}
			conn.close();
			return cars;
		} catch (SQLException e) {
			log.error(e);
		} catch (NamingException e) {
			log.error(e);
		}
		return null;
	}
	public int addCar(DataCars c)
	{
		try {
			InitialContext initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/appname");
			Connection conn = ds.getConnection();
			Statement statement = conn.createStatement();
			statement.executeUpdate("insert into cars values ('"+c.getCar_Id()+"','"+c.getBrand()+"','"+c.getModel()+"','"+c.getRegNumber()
					+"','"+c.getCondition()+"');");
			conn.close();
			return 1;
		} catch (SQLException e) {
			log.error(e);
		} catch (NamingException e) {
			log.error(e);
		}
		return -1;
	}
	
	public int delCar(String id)
	{
		try {
			InitialContext initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/appname");
			Connection conn = ds.getConnection();
			Statement statement = conn.createStatement();
			statement.executeUpdate("delete from cars where car_id='"+id+"';");
			conn.close();
			return 1;
		} catch (SQLException e) {
			log.error(e);
		} catch (NamingException e) {
			log.error(e);
		}
		return -1;
	}
	
	public int editCar(int oldId, DataCars newCar)
	{
		try {
			InitialContext initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/appname");
			Connection conn = ds.getConnection();
			Statement statement = conn.createStatement();
			statement.executeUpdate("update cars set brand='"+newCar.getBrand()+"', model='"+
			newCar.getModel()+"', regNumber='"+newCar.getRegNumber()+"', cars.condition='"+newCar.getCondition()+"' where car_id='"+oldId+"';");
			conn.close();
			return 1;
		} catch (SQLException e) {
			log.error(e);
		} catch (NamingException e) {
			log.error(e);
		}
		return -1;
	}

}
