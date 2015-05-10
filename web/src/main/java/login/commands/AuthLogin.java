package login.commands;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.com.AuthService;

import org.apache.log4j.Logger;

import service.BaseService;

import com.Command;


public class AuthLogin extends Command {
	private static Logger log = Logger.getLogger(AuthLogin.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {	
		BaseService serv = new AuthService();
		serv.serv(request, response);

		
		if ((request.getAttribute("role")).equals("1")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/menu/dispatcher/");
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
		if ((request.getAttribute("role")).equals("2")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/menu/driver/");
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
		request.setAttribute("error", "Неверно введен логин или пароль!");
		request.setAttribute("link", "/AutoBase/menu/driver/?id=0");
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
