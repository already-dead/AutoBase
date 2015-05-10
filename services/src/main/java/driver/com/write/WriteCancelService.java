package driver.com.write;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BaseService;


import dao.DaoFlights;
import data.DataFlights;

public class WriteCancelService extends BaseService {

	@Override
	public void serv(HttpServletRequest request, HttpServletResponse response) {	
		String flightId = request.getParameter("flightid");
		String driverId = request.getParameter("driverid");
		
    	DaoFlights dao = DaoFlights.getDaoFlights();
		DataFlights flight = dao.getFlight(Integer.parseInt(flightId));
		flight.setStatus(-1);

		if (dao.editFlight(Integer.parseInt(flightId), flight)>0) {
			List<DataFlights> flights = dao.getFlights();
			request.setAttribute("list", flights);
			request.setAttribute("driverid", driverId);
			request.setAttribute("err", "0");
		} else {
			request.setAttribute("err", "1");
		}
	}
}
