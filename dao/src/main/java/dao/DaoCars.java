package dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import baseDao.BaseDao;
import data.DataCars;

public class DaoCars extends BaseDao{	

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
		}
		return null;
	}
	
	public List<DataCars> getCars()
	{
		ArrayList<DataCars> cars = new ArrayList<DataCars>();
		try {
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
		}
		return null;
	}
	public int addCar(DataCars c)
	{
		try {
			statement.executeUpdate("insert into cars values ('"+c.getCar_Id()+"','"+c.getBrand()+"','"+c.getModel()+"','"+c.getRegNumber()
					+"','"+c.getCondition()+"');");
			conn.close();
			return 1;
		} catch (SQLException e) {
			log.error(e);
		}
		return -1;
	}
	
	public int delCar(String id)
	{
		try {
			statement.executeUpdate("delete from cars where car_id='"+id+"';");
			conn.close();
			return 1;
		} catch (SQLException e) {
			log.error(e);
		}
		return -1;
	}
	
	public int editCar(int oldId, DataCars newCar)
	{
		try {
			statement.executeUpdate("update cars set brand='"+newCar.getBrand()+"', model='"+
			newCar.getModel()+"', regNumber='"+newCar.getRegNumber()+"', cars.condition='"+newCar.getCondition()+"' where car_id='"+oldId+"';");
			conn.close();
			return 1;
		} catch (SQLException e) {
			log.error(e);
		}
		return -1;
	}

}
