package disp.com.del;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFlights;
import service.BaseService;

public class DelDesignateService extends BaseService {

	@Override
	public void serv(HttpServletRequest request, HttpServletResponse response) {
		String flightId = request.getParameter("designateid");
		
		DaoFlights dao = DaoFlights.getDaoFlights();
		if (dao.delFlight(flightId)>0) {
			request.setAttribute("err", "0");
		} else {
			request.setAttribute("err", "1");
		}
	}

}