package login.com;

import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import service.BaseService;
import dao.DaoDisp;
import dao.DaoDrivers;
import dao.DaoUsers;
import data.DataDisp;
import data.DataDrivers;
import data.DataUsers;

public class RegService extends BaseService {

	@Override
	public void serv(HttpServletRequest request, HttpServletResponse response) {	
		request.setAttribute("err", "0");
		
		DataUsers dataUsers = new DataUsers();
		DaoUsers dao = DaoUsers.getDaoUsers();
		List<DataUsers> users = dao.getUsers();

		boolean f = true;
		if (Integer.parseInt(request.getParameter("password1"))==Integer.parseInt(request.getParameter("password2"))) {
			dataUsers.setEmail(request.getParameter("email"));
			dataUsers.setPassword(request.getParameter("password1"));
			dataUsers.setUser_Id(Integer.parseInt(request.getParameter("id")));

			

			ListIterator<DataUsers> iterator = users.listIterator();
			while (iterator.hasNext()) {
				DataUsers data = iterator.next();
				if (data.getUser_Id()==dataUsers.getUser_Id()) {
					request.setAttribute("err", "1");
					f = false;
					break;
				}
			}
			
			if ((f)) {
				DaoDrivers daoD = DaoDrivers.getDaoDrivers();
				List<DataDrivers> drivers = daoD.getDrivers();
				ListIterator<DataDrivers> iteratorD = drivers.listIterator();
				while (iteratorD.hasNext()) {
					DataDrivers data = iteratorD.next();
					if (data.getDriver_Id()==dataUsers.getUser_Id()) {
						dataUsers.setRole(2);
						dao.addUser(dataUsers);
						request.setAttribute("err", "2");
						f = false;
						break;
					}
				}
				if (f) {
					request.setAttribute("err", "3");
				}
			}
			
			if ((f)) {
				DaoDisp daoDisp = DaoDisp.getDaoDisp();
				List<DataDisp> disp = daoDisp.getDisps();
				ListIterator<DataDisp> iteratorD = disp.listIterator();
				while (iteratorD.hasNext()) {
					DataDisp data = iteratorD.next();
					if (data.getDisp_Id()==dataUsers.getUser_Id()) {
						dataUsers.setRole(1);
						dao.addUser(dataUsers);
						request.setAttribute("err", "2");
						f = false;
						break;
					}
				}
				if (f) {
					request.setAttribute("err", "3");
				}
			}
			
		} else {
			request.setAttribute("err", "4");
		}
	}
}

