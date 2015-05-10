package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import baseDao.BaseDao;
import data.DataDrivers;

public class DaoDrivers extends BaseDao{	
	private static Logger log = Logger.getLogger(DaoDrivers.class);
	private static DaoDrivers thisDao; 

	public DaoDrivers() {
		super();
	}
	
	public static  DaoDrivers getDaoDrivers()
	{
		if(thisDao == null)
			thisDao = new DaoDrivers();
		return thisDao;
	}
	
	public DataDrivers getDriver(int id)
	{
		DataDrivers data = null;

		try {
			ResultSet rs = statement.executeQuery("select * from drivers where driver_id='"+id+"'");
			if(rs.next())
			{
				data = new DataDrivers();
				data.setDriver_Id(rs.getInt("driver_id"));
				data.setName(rs.getString("name"));
				data.setSurname(rs.getString("surname"));
				data.setStatus(rs.getInt("status"));
				conn.close();
				return data;
			}
			else { 
				conn.close();
				return null;
			}	
		} catch (SQLException e) {
			log.error(e);
		}
		return null;
	}
	
	public List<DataDrivers> getDrivers()
	{
		ArrayList<DataDrivers> drivers = new ArrayList<DataDrivers>();
		try {
			ResultSet rs = statement.executeQuery("select * from drivers");
			while(rs.next())
			{
				DataDrivers data = new DataDrivers();
			
				data = new DataDrivers();
				data.setDriver_Id(rs.getInt("driver_id"));
				data.setName(rs.getString("name"));
				data.setSurname(rs.getString("surname"));
				data.setStatus(rs.getInt("status"));
				drivers.add(data);
				
			}
			conn.close();
			return drivers;
		} catch (SQLException e) {
			log.error(e);
		}
		
		return null;
	}
	public int addDriver(DataDrivers d)
	{
		try {
			statement.executeUpdate("insert into drivers values ('"+d.getDriver_Id()+"','"+d.getName()+"','"+d.getSurname()+"','"+d.getStatus()+"');");
			conn.close();
			return 1;
		} catch (SQLException e) {
			log.error(e);
		}
		return -1;
	}
	
	public int delDriver(String id)
	{
		try {
			statement.executeUpdate("delete from drivers where driver_id='"+id+"';");
			conn.close();
			return 1;
		} catch (SQLException e) {
			log.error(e);
		}
		return -1;
	}
	
	public int editDriver(int oldId, DataDrivers newDriver)
	{
		try {
			statement.executeUpdate("update drivers set driver_id='"+newDriver.getDriver_Id()+"', name='"+newDriver.getName()+"', surname='"+
					newDriver.getSurname()+"', status='"+newDriver.getStatus()+"' where driver_id='"+oldId+"';");
			conn.close();
			return 1;
		} catch (SQLException e) {
			log.error(e);
		}
		return -1;
	}

}
