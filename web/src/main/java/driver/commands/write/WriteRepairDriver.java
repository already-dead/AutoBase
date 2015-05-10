package driver.commands.write;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import service.BaseService;

import com.Command;

import driver.com.write.WriteRepairService;


public class WriteRepairDriver extends Command {
	private static Logger log = Logger.getLogger(WriteRepairDriver.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BaseService serv = new WriteRepairService();
		serv.serv(request, response);
		
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		
		if ((request.getAttribute("err")).equals("0")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/driver/repairCar.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				log.error(e);
			} catch (IOException e) {
				log.error(e);
			}
		}
		if ((request.getAttribute("err")).equals("1")) {
			request.setAttribute("error", "������ ��� ���������� ��������!");
		} else {
			if ((request.getAttribute("err")).equals("2")) {
				request.setAttribute("error", "������ �� ��������� � �������!");
			}
		}
		request.setAttribute("link", "/AutoBase/menu/driver/?mode=repair");
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
