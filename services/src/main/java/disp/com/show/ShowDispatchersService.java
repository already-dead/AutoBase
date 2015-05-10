package disp.com.show;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoDisp;
import data.DataDisp;
import service.BaseService;

public class ShowDispatchersService extends BaseService {

	@Override
	public void serv(HttpServletRequest request, HttpServletResponse response) {
    	DaoDisp dao = DaoDisp.getDaoDisp();
		List<DataDisp> disps = dao.getDisps();
		request.setAttribute("list", disps);
	}

}
