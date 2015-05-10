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
import data.DataFlights;

public class DaoFlights{	
	private static Logger log = Logger.getLogger(DaoFlights.class);
	private static DaoFlights thisDao; 

	public DaoFlights() {
		super();
	}
	
	public static  DaoFlights getDaoFlights()
	{
		if(thisDao == null)
			thisDao = new DaoFlights();
		return thisDao;
	}
	
	public DataFlights getFlight(int id)
	{
		DataFlights data = null;

		try {
			InitialContext initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/appname");
			Connection conn = ds.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from flights where flight_id='"+id+"'");
			if(rs.next())
			{
				data = new DataFlights();
				data.setFlight_Id(rs.getInt("flight_id"));
				data.setDate(rs.getString("date"));
				data.setAdress(rs.getString("adress"));
				data.setCar(rs.getInt("car"));
				data.setDriver(rs.getInt("driver"));
				data.setStatus(rs.getInt("status"));
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
	
	public List<DataFlights> getFlights()
	{
		ArrayList<DataFlights> flights = new ArrayList<DataFlights>();
		try {
			InitialContext initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/appname");
			Connection conn = ds.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from flights");
			while(rs.next())
			{
				DataFlights data = new DataFlights();
			
				data = new DataFlights();
				data.setFlight_Id(rs.getInt("flight_id"));
				data.setDate(rs.getString("date"));
				data.setAdress(rs.getString("adress"));
				data.setCar(rs.getInt("car"));
				data.setDriver(rs.getInt("driver"));
				data.setStatus(rs.getInt("status"));
				data.setCondition(rs.getInt("condition"));
				flights.add(data);
				
			}
			conn.close();
			return flights;
		} catch (SQLException e) {
			log.error(e);
		} catch (NamingException e) {
			log.error(e);
		}
		
		return null;
	}
	public int addFlight(DataFlights f)
	{
		try {
			InitialContext initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/appname");
			Connection conn = ds.getConnection();
			Statement statement = conn.createStatement();
			statement.executeUpdate("insert into flights values ('"+f.getFlight_Id()+"','"+f.getDate()+"','"+f.getAdress()+"','"+f.getDriver()
					+"','"+f.getCar()+"','"+f.getStatus()+"','"+f.getCondition()+"');");
			conn.close();
			return 1;
		} catch (SQLException e) {
			log.error(e);
		} catch (NamingException e) {
			log.error(e);
		}
		return -1;
	}
	
	public int delFlight(String id)
	{
		try {
			InitialContext initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/appname");
			Connection conn = ds.getConnection();
			Statement statement = conn.createStatement();
			statement.executeUpdate("delete from flights where flight_id='"+id+"';");
			conn.close();
			return 1;
		} catch (SQLException e) {
			log.error(e);
		} catch (NamingException e) {
			log.error(e);
		}
		return -1;
	}
	
	public int editFlight(int oldId, DataFlights newFlight)
	{
		try {
			InitialContext initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/appname");
			Connection conn = ds.getConnection();
			Statement statement = conn.createStatement();
			statement.executeUpdate("update flights set flight_id='"+newFlight.getFlight_Id()+"', date='"+newFlight.getDate()+"', adress='"+
			newFlight.getAdress()+"', driver='"+newFlight.getDriver()+"', car='"+newFlight.getCar()+"', status='"+newFlight.getStatus()+
			"', flights.condition='"+newFlight.getCondition()+"' where flight_id='"+oldId+"';");
			
			if (newFlight.getCondition()>0) {
				DaoCars dao = DaoCars.getDaoCars();
				DataCars data = dao.getCar(newFlight.getCar());
				data.setCondition(newFlight.getCondition());
				dao.editCar(data.getCar_Id(), data);
			}
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

