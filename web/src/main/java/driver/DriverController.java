package driver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Command;

import driver.commands.show.ConfirmDesignateDriver;
import driver.commands.show.ShowEditDesignateDriver;
import driver.commands.show.ShowMenuDriver;
import driver.commands.show.ShowRepairCarDriver;
import driver.commands.write.WriteCancelDesignateDriver;
import driver.commands.write.WriteConfirmDesignateDriver;
import driver.commands.write.WriteRepairDriver;

/**
 * Servlet implementation class DriverController
 */

public class DriverController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DriverController() {
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
  //ODBCP
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mode = request.getParameter("mode");
		
		Command com = null;

		if(mode == null)
		{
			com = new ShowMenuDriver();
		}
		else if(mode.equals("repair"))
		{
			com = new ShowRepairCarDriver();
		}
		else if(mode.equals("writerepair"))
		{
			com = new WriteRepairDriver();
		}
		else if(mode.equals("editdesignate"))
		{
			com = new ShowEditDesignateDriver();
		}
		else if(mode.equals("cancel"))
		{
			com = new WriteCancelDesignateDriver();
		}
		else if(mode.equals("confirm"))
		{
			com = new ConfirmDesignateDriver();
		}
		else if(mode.equals("writeconfirm"))
		{
			com = new WriteConfirmDesignateDriver();
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
