package driver.com.show;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFlights;
import data.DataFlights;
import service.BaseService;

public class EditDesignateService extends BaseService {

	@Override
	public void serv(HttpServletRequest request, HttpServletResponse response) {
		String driverId = request.getParameter("id");
    	DaoFlights dao = DaoFlights.getDaoFlights();
		List<DataFlights> flights = dao.getFlights();
		request.setAttribute("list", flights);
		request.setAttribute("driverid", driverId);
	}

}
