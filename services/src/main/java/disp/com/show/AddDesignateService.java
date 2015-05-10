package disp.com.show;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoCars;
import dao.DaoDrivers;
import data.DataCars;
import data.DataDrivers;
import service.BaseService;

public class AddDesignateService extends BaseService {

	@Override
	public void serv(HttpServletRequest request, HttpServletResponse response) {
    	DaoDrivers dao = DaoDrivers.getDaoDrivers();
		List<DataDrivers> drivers = dao.getDrivers();
		request.setAttribute("drivers", drivers);
		
    	DaoCars daoC = DaoCars.getDaoCars();
		List<DataCars> cars = daoC.getCars();
		request.setAttribute("cars", cars);		
	}

}
