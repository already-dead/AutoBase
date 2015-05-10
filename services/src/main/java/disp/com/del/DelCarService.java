package disp.com.del;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoCars;
import service.BaseService;

public class DelCarService extends BaseService {

	@Override
	public void serv(HttpServletRequest request, HttpServletResponse response) {
		String carId = request.getParameter("carid");
		
		DaoCars dao = DaoCars.getDaoCars();
		if (dao.delCar(carId)>0) {
			request.setAttribute("err", "0");
		} else {
			request.setAttribute("err", "1");
		}
		
	}

}
