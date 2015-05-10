package disp.com.write;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoDrivers;
import data.DataDrivers;
import service.BaseService;

public class RemoveWriteService extends BaseService {

	@Override
	public void serv(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("driverid");	
    	DaoDrivers dao = DaoDrivers.getDaoDrivers();
		DataDrivers driver = dao.getDriver(Integer.parseInt(id));
		if (driver.getStatus()==0) {
			driver.setStatus(1);
		} else {
			driver.setStatus(0);
		}
		
		if (dao.editDriver(Integer.parseInt(id),driver)>0) {
			request.setAttribute("err", "0");
		} else {
			request.setAttribute("err", "1");
		}
	}

}
