package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.commands.AuthLogin;
import login.commands.ErrorLogin;
import login.commands.RegLogin;
import login.commands.RegShowLogin;

import com.Command;

/**
 * Servlet implementation class LoginController
 */

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mode = request.getParameter("mode");
		
		Command com = null;
		
		if(mode == null)
		{
			com = new AuthLogin();
		}
		else if(mode.equals("reg"))
		{
			com = new RegLogin();
		}
		else if(mode.equals("regshow"))
		{
			com = new RegShowLogin();
		}
		else if(mode.equals("error"))
		{
			com = new ErrorLogin();
		}
		com.execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
