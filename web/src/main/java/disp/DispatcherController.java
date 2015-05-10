package disp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Command;

import disp.commands.add.AddCarDisp;
import disp.commands.add.AddDesignateDisp;
import disp.commands.add.AddDispatcherDisp;
import disp.commands.add.AddDriverDisp;
import disp.commands.del.DelCarDisp;
import disp.commands.del.DelDesignateDisp;
import disp.commands.del.DelDispatcherDisp;
import disp.commands.del.DelDriverDisp;
import disp.commands.show.ShowDesignateDriversDisp;
import disp.commands.show.ShowDispatchersDisp;
import disp.commands.show.ShowRemoveDriversDisp;
import disp.commands.show.ShowCarsDisp;
import disp.commands.show.ShowDriversDisp;
import disp.commands.show.ShowMenuDisp;
import disp.commands.write.AddWriteCarDisp;
import disp.commands.write.AddWriteDesignateDisp;
import disp.commands.write.AddWriteDispatcherDisp;
import disp.commands.write.AddWriteDriverDisp;
import disp.commands.write.WriteRemoveDriverDisp;


/**
 * Servlet implementation class DispatcherController
 */

public class DispatcherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherController() {
        super();
    }
    
    public void init() throws ServletException {
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
			com = new ShowMenuDisp();
		}
		else if(mode.equals("remove"))
		{
			com = new ShowRemoveDriversDisp();
		}
		else if(mode.equals("removewrite"))
		{
			com = new WriteRemoveDriverDisp();
		}
		else if(mode.equals("designate"))
		{
			com = new ShowDesignateDriversDisp();
		}
		else if(mode.equals("adddesignate"))
		{
			com = new AddDesignateDisp();
		}
		else if(mode.equals("addwritedesignate"))
		{
			com = new AddWriteDesignateDisp();
		}
		else if(mode.equals("deldesignate"))
		{
			com = new DelDesignateDisp();
		}
		else if(mode.equals("showcars"))
		{
			com = new ShowCarsDisp();
		}
		else if(mode.equals("addcar"))
		{
			com = new AddCarDisp();
		}
		else if(mode.equals("addwritecar"))
		{
			com = new AddWriteCarDisp();
		}
		else if(mode.equals("delcar"))
		{
			com = new DelCarDisp();
		}
		else if(mode.equals("showdrivers"))
		{
			com = new ShowDriversDisp();
		}
		else if(mode.equals("adddriver"))
		{
			com = new AddDriverDisp();
		}
		else if(mode.equals("addwritedriver"))
		{
			com = new AddWriteDriverDisp();
		}
		else if(mode.equals("deldriver"))
		{
			com = new DelDriverDisp();
		}
		else if(mode.equals("showdisp"))
		{
			com = new ShowDispatchersDisp();
		}
		else if(mode.equals("adddisp"))
		{
			com = new AddDispatcherDisp();
		}
		else if(mode.equals("addwritedisp"))
		{
			com = new AddWriteDispatcherDisp();
		}
		else if(mode.equals("deldisp"))
		{
			com = new DelDispatcherDisp();
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
