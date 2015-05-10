package login.commands;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.com.RegService;

import org.apache.log4j.Logger;

import service.BaseService;

import com.Command;

public class RegLogin extends Command {
	private static Logger log = Logger.getLogger(RegLogin.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {	
		BaseService serv = new RegService();
		serv.serv(request, response);
		
		if ((request.getAttribute("err")).equals("1")) {
			request.setAttribute("error", "������������ � ������ ID ��� ����������!");
			request.setAttribute("link", "/AutoBase/login/?mode=regshow");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login/?mode=error");
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
		if ((request.getAttribute("err")).equals("2")) {
			request.setAttribute("error", "������������ ������� ������! ������� � ������� �� ���� ������� � �������");
			request.setAttribute("link", "/AutoBase/menu/driver/");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login/?mode=error");
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
		if ((request.getAttribute("err")).equals("3")) {
			request.setAttribute("error", "ID �� ������! ����������, ���������� � ����������!");
			request.setAttribute("link", "/AutoBase/login/?mode=regshow");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login/?mode=error");
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
		if ((request.getAttribute("err")).equals("4")) {
			request.setAttribute("error", "��������� ������ �� ���������!");
			request.setAttribute("link", "/AutoBase/login/?mode=regshow");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login/?mode=error");
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

	}

}
