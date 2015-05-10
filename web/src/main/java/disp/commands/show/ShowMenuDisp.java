package disp.commands.show;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.Command;

public class ShowMenuDisp extends Command {
		private static Logger log = Logger.getLogger(ShowMenuDisp.class);
		private boolean ex = false;

		@Override
		public void execute(HttpServletRequest request, HttpServletResponse response) {	
			
			for (Enumeration<String> names = request.getAttributeNames(); names.hasMoreElements() ;) {
		         if(names.nextElement().equals("id")) {
		        	 ex = true;
		        	 break;
		         }
		     }	
			if (ex==false) { 
				String id = request.getParameter("id");
				request.setAttribute("id", id);
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/disp/dispMenu.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				log.error(e);
			} catch (IOException e) {
				log.error(e);
			}
		}

	}