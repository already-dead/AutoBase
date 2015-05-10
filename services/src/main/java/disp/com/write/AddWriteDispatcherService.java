package disp.com.write;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoDisp;
import data.DataDisp;
import service.BaseService;

public class AddWriteDispatcherService extends BaseService {

	@Override
	public void serv(HttpServletRequest request, HttpServletResponse response) {
		DataDisp disp = new DataDisp();
		DaoDisp dao = DaoDisp.getDaoDisp();
		ArrayList<DataDisp> list = (ArrayList<DataDisp>)dao.getDisps();
		
		DataDisp lastDisp = list.get(list.size()-1);
		disp.setDisp_Id(lastDisp.getDisp_Id()+1);
		
		disp.setName(request.getParameter("name"));
		disp.setSurname(request.getParameter("surname"));
		
		if (dao.addDisp(disp)>0) {
			request.setAttribute("err", "0");
		} else {
			request.setAttribute("err", "1");
		}

	}

}
