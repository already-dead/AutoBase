package disp.commands.del;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import service.BaseService;

import com.Command;

import disp.com.del.DelDispatcherService;

public class DelDispatcherDisp extends Command {
	private static Logger log = Logger.getLogger(DelDispatcherDisp.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BaseService serv = new DelDispatcherService();
		serv.serv(request, response);
	
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		
		if ((request.getAttribute("err")).equals("0")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/menu/dispatcher/?mode=showdisp");
			try {
				dispatcher.include(request, response);
			} catch (ServletException e) {
				log.error(e);
			} catch (IOException e) {
				log.error(e);
			}
		}
		request.setAttribute("error", "������ ��� ���������� ��������!");
		request.setAttribute("link", "/AutoBase/menu/dispatcher/?mode=showdisp");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login/?mode=error");
		try {
			dispatcher.include(request, response);
		} catch (ServletException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}
	}

}
