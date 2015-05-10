package driver.commands.show;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.Command;

public class ConfirmDesignateDriver extends Command {
	private static Logger log = Logger.getLogger(ConfirmDesignateDriver.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {	
		String flightId = request.getParameter("flightid");
		String driverId = request.getParameter("driverid");
		request.setAttribute("driverid", driverId);
		request.setAttribute("flightid", flightId);
		
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/driver/enterCondition.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}
	}

}