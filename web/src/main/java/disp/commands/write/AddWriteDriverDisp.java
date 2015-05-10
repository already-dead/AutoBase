package disp.commands.write;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import service.BaseService;

import com.Command;

import disp.com.write.AddWriteDriverService;



public class AddWriteDriverDisp extends Command {
	private static Logger log = Logger.getLogger(AddWriteDriverDisp.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {	
		BaseService serv = new AddWriteDriverService();
		serv.serv(request, response);
	
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		
		if ((request.getAttribute("err")).equals("0")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/menu/dispatcher/?mode=showdrivers");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				log.error(e);
				e.printStackTrace();
			} catch (IOException e) {
				log.error(e);
				e.printStackTrace();
			}
		}
		request.setAttribute("error", "Ошибка при выполнении операции!");
		request.setAttribute("link", "/AutoBase/menu/dispatcher/?mode=showdrivers");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login/?mode=error");
		try {
			dispatcher.include(request, response);
		} catch (ServletException e) {
			log.error(e);
			e.printStackTrace();
		} catch (IOException e) {
			log.error(e);
			e.printStackTrace();
		}
	}

}
