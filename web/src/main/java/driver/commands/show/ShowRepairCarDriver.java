package driver.commands.show;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import service.BaseService;

import com.Command;

import driver.com.show.RepairService;

public class ShowRepairCarDriver extends Command {
	private static Logger log = Logger.getLogger(ShowRepairCarDriver.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {	
		BaseService serv = new RepairService();
		serv.serv(request, response);
		
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/driver/repairCar.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}
	}

}