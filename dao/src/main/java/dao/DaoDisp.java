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

import data.DataDisp;

public class DaoDisp{	
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
			InitialContext initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/appname");
			Connection conn = ds.getConnection();
			Statement statement = conn.createStatement();
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
			e.printStackTrace();
		} catch (NamingException e) {
			log.error(e);
			e.printStackTrace();
		}
		return null;
	}
	
	public List<DataDisp> getDisps()
	{
		ArrayList<DataDisp> disps = new ArrayList<DataDisp>();
		try {
			InitialContext initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/appname");
			Connection conn = ds.getConnection();
			Statement statement = conn.createStatement();
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
			e.printStackTrace();
		} catch (NamingException e) {
			log.error(e);
			e.printStackTrace();
		}
		
		return null;
	}
	public int addDisp(DataDisp d)
	{
		try {
			InitialContext initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/appname");
			Connection conn = ds.getConnection();
			Statement statement = conn.createStatement();
			statement.executeUpdate("insert into disp values ('"+d.getDisp_Id()+"','"+d.getName()+"','"+d.getSurname()+"');");
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
	
	public int delDisp(String id)
	{
		try {
			InitialContext initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/appname");
			Connection conn = ds.getConnection();
			Statement statement = conn.createStatement();
			statement.executeUpdate("delete from disp where disp_id='"+id+"';");
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
	
	public int editDisp(int oldId, DataDisp newDisp)
	{
		try {
			InitialContext initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/appname");
			Connection conn = ds.getConnection();
			Statement statement = conn.createStatement();
			statement.executeUpdate("update disp set disp_id='"+newDisp.getDisp_Id()+"', name='"+newDisp.getName()+"', surname='"+
					newDisp.getSurname()+"' where disp_id='"+oldId+"';");
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
