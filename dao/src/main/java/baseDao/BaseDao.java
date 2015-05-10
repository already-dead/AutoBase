package baseDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class BaseDao {
	public Statement statement;
	public Connection conn;
	private static Logger log = Logger.getLogger(BaseDao.class);
	
	public BaseDao() {
		InitialContext initContext;
		try {
			initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/appname");
			conn = ds.getConnection();
			statement = conn.createStatement();
		} catch (NamingException e) {
			log.error(e);
		} catch (SQLException e) {
			log.error(e);
		}

	}

}
