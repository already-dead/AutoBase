package disp.com.write;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFlights;
import data.DataFlights;
import service.BaseService;

public class AddWriteDesignateService extends BaseService {

	@Override
	public void serv(HttpServletRequest request, HttpServletResponse response) {
		
		DataFlights flight = new DataFlights();
		DaoFlights dao = DaoFlights.getDaoFlights();
		ArrayList<DataFlights> list = (ArrayList<DataFlights>)dao.getFlights();
		
		DataFlights lastFlight = list.get(list.size()-1);
		flight.setFlight_Id(lastFlight.getFlight_Id()+1);
		flight.setDate(request.getParameter("date"));
		flight.setAdress(request.getParameter("adress"));
		flight.setDriver(Integer.valueOf(request.getParameter("driver")));
		flight.setCar(Integer.valueOf(request.getParameter("car")));
		flight.setStatus(0);

		if (dao.addFlight(flight)>0) {
			request.setAttribute("err", "0");
		} else {
			request.setAttribute("err", "1");
		}
	}

}
