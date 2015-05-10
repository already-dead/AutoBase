
package login.com;

import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BaseService;
import dao.DaoUsers;
import data.DataUsers;


public class AuthService extends BaseService {

	@Override
	public void serv(HttpServletRequest request, HttpServletResponse response) {	
		DataUsers user = new DataUsers();
		DataUsers dataUsers = new DataUsers();
		DaoUsers dao = DaoUsers.getDaoUsers();
		List<DataUsers> users = dao.getUsers();
		dataUsers.setEmail(request.getParameter("email"));
		dataUsers.setPassword(request.getParameter("password"));
		ListIterator<DataUsers> iterator = users.listIterator();
		while (iterator.hasNext()) {
			DataUsers data = iterator.next();
			if (data.getEmail().equals(dataUsers.getEmail()) && data.getPassword().equals(dataUsers.getPassword())) {
				user.setUser_Id(data.getUser_Id());
				user.setEmail(data.getEmail());
				user.setPassword(data.getPassword());
				user.setRole(data.getRole());
				break;
			}
		}
		request.setAttribute("role", "0");
		if ((user.getRole()==1) || (user.getRole()==2)) {
			request.setAttribute("role", String.valueOf(user.getRole()));
			request.setAttribute("id", user.getUser_Id());
		}

	}
}

