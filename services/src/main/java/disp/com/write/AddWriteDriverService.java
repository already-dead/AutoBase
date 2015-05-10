package disp.com.write;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoDrivers;
import data.DataDrivers;
import service.BaseService;

public class AddWriteDriverService extends BaseService {

	@Override
	public void serv(HttpServletRequest request, HttpServletResponse response) {
		DataDrivers driver = new DataDrivers();
		DaoDrivers dao = DaoDrivers.getDaoDrivers();
		ArrayList<DataDrivers> list = (ArrayList<DataDrivers>)dao.getDrivers();
		
		DataDrivers lastDriver = list.get(list.size()-1);
		driver.setDriver_Id(lastDriver.getDriver_Id()+1);
		
		driver.setName(request.getParameter("name"));
		driver.setSurname(request.getParameter("surname"));
		driver.setStatus(1);
		
		if (dao.addDriver(driver)>0) {
			request.setAttribute("err", "0");
		} else {
			request.setAttribute("err", "1");
		}
	}

}
