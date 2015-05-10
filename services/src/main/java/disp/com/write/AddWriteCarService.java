package disp.com.write;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoCars;
import data.DataCars;
import service.BaseService;

public class AddWriteCarService extends BaseService {

	@Override
	public void serv(HttpServletRequest request, HttpServletResponse response) {
		DataCars car = new DataCars();
		DaoCars dao = DaoCars.getDaoCars();
		ArrayList<DataCars> list = (ArrayList<DataCars>)dao.getCars();
		
		DataCars lastCar = list.get(list.size()-1);
		car.setCar_Id(lastCar.getCar_Id()+1);
		car.setBrand(request.getParameter("brand"));
		car.setModel(request.getParameter("model"));
		car.setRegNumber(request.getParameter("regNumber"));
		car.setCondition(Integer.valueOf(request.getParameter("condition")));
		
		if (dao.addCar(car)>0) {
			request.setAttribute("err", "0");
		} else {
			request.setAttribute("err", "1");
		}
	}

}
