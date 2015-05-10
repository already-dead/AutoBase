package disp.com.show;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoDrivers;
import data.DataDrivers;
import service.BaseService;

public class ShowRemoveDriversService extends BaseService {

	@Override
	public void serv(HttpServletRequest request, HttpServletResponse response) {
    	DaoDrivers dao = DaoDrivers.getDaoDrivers();
		List<DataDrivers> drivers = dao.getDrivers();
		request.setAttribute("list", drivers);
	}

}