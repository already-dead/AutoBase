package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import baseDao.BaseDao;
import data.DataDisp;

public class DaoDisp extends BaseDao{	
	private static Logger log = Logger.getLogger(DaoDisp.class);
	private static DaoDisp thisDao; 

	public DaoDisp() {
		super();
	}
	
	public static  DaoDisp getDaoDisp()
	{
		if(thisDao == null)
			thisDao = new DaoDisp();
		return thisDao;
	}
	
	public DataDisp getDisp(int id)
	{
		DataDisp data = null;

		try {
			ResultSet rs = statement.executeQuery("select * from disp where disp_id='"+id+"'");
			if(rs.next())
			{
				data = new DataDisp();
				data.setDisp_Id(rs.getInt("disp_id"));
				data.setName(rs.getString("name"));
				data.setSurname(rs.getString("surname"));
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
	
	public List<DataDisp> getDisps()
	{
		ArrayList<DataDisp> disps = new ArrayList<DataDisp>();
		try {
			ResultSet rs = statement.executeQuery("select * from disp");
			while(rs.next())
			{
				DataDisp data = new DataDisp();
			
				data = new DataDisp();
				data.setDisp_Id(rs.getInt("disp_id"));
				data.setName(rs.getString("name"));
				data.setSurname(rs.getString("surname"));
				disps.add(data);
				
			}
			conn.close();
			return disps;
		} catch (SQLException e) {
			log.error(e);
		}
		
		return null;
	}
	public int addDisp(DataDisp d)
	{
		try {
			statement.executeUpdate("insert into disp values ('"+d.getDisp_Id()+"','"+d.getName()+"','"+d.getSurname()+"');");
			conn.close();
			return 1;
		} catch (SQLException e) {
			log.error(e);
		}
		return -1;
	}
	
	public int delDisp(String id)
	{
		try {
			statement.executeUpdate("delete from disp where disp_id='"+id+"';");
			conn.close();
			return 1;
		} catch (SQLException e) {
			log.error(e);
		}
		return -1;
	}
	
	public int editDisp(int oldId, DataDisp newDisp)
	{
		try {
			statement.executeUpdate("update disp set disp_id='"+newDisp.getDisp_Id()+"', name='"+newDisp.getName()+"', surname='"+
					newDisp.getSurname()+"' where disp_id='"+oldId+"';");
			conn.close();
			return 1;
		} catch (SQLException e) {
			log.error(e);
		}
		return -1;
	}

}
