package driver.com.show;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoCars;
import data.DataCars;
import service.BaseService;

public class RepairService extends BaseService {

	@Override
	public void serv(HttpServletRequest request, HttpServletResponse response) {
    	DaoCars dao = DaoCars.getDaoCars();
		List<DataCars> cars = dao.getCars();
		request.setAttribute("list", cars);
	}

}