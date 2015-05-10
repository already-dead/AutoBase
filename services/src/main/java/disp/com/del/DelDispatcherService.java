package disp.com.del;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoDisp;
import dao.DaoUsers;
import service.BaseService;

public class DelDispatcherService extends BaseService {

	@Override
	public void serv(HttpServletRequest request, HttpServletResponse response) {
		String dispId = request.getParameter("dispid");
		
		DaoDisp dao = DaoDisp.getDaoDisp();
		if (dao.delDisp(dispId)>0) {
			DaoUsers userDao = DaoUsers.getDaoUsers();
			if (userDao.delUser(dispId)>0) {
				request.setAttribute("err", "0");
			} else {
				request.setAttribute("err", "1");
			}	
		} else {
			request.setAttribute("err", "1");
		}

	}

}
