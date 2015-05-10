package login.commands;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.Command;


public class RegShowLogin extends Command {
	private static Logger log = Logger.getLogger(RegShowLogin.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/html/registration.html");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}

	}

}
