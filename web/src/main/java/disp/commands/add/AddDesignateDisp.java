package disp.commands.add;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import org.apache.log4j.Logger;

import service.BaseService;

import com.Command;

import disp.com.show.AddDesignateService;

public class AddDesignateDisp extends Command {
	private static Logger log = Logger.getLogger(AddDesignateDisp.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BaseService serv = new AddDesignateService();
		serv.serv(request, response);

		String id = request.getParameter("id");
		request.setAttribute("id", id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/disp/addDesignate.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}
	}

}
