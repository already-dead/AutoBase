package driver.com.write;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoCars;
import data.DataCars;
import service.BaseService;

public class WriteRepairService extends BaseService {

	@Override
	public void serv(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("err", "1");
		String carid = request.getParameter("carid");		
    	DaoCars dao = DaoCars.getDaoCars();
		DataCars car = dao.getCar(Integer.parseInt(carid));
		if (car.getCondition()<10) {
			car.setCondition(10);
			if (dao.editCar(Integer.parseInt(carid),car)>0) {
				List<DataCars> cars = dao.getCars();
				request.setAttribute("list", cars);
				request.setAttribute("err", "0");
			} else {
				request.setAttribute("err", "1");
			}
		} else {
			request.setAttribute("err", "2");
		}
	}

}
