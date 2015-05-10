package disp.com.del;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoDrivers;
import dao.DaoUsers;
import service.BaseService;

public class DelDriverService extends BaseService {

	@Override
	public void serv(HttpServletRequest request, HttpServletResponse response) {
		String driverId = request.getParameter("driverid");
		
		DaoDrivers dao = DaoDrivers.getDaoDrivers();
		if (dao.delDriver(driverId)>0) {
			DaoUsers userDao = DaoUsers.getDaoUsers();
			if (userDao.delUser(driverId)>0) {
				request.setAttribute("err", "0");
			} else {
				request.setAttribute("err", "1");
			}	
		} else {
			request.setAttribute("err", "1");
		}
	}

}
