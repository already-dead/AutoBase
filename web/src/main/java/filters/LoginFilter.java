package filters;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


/**
 * Servlet Filter implementation class LoginFilter
 */

public class LoginFilter implements Filter {
	static private String user;

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		for (Enumeration<String> names = request.getParameterNames(); names.hasMoreElements() ;) {
	         if(names.nextElement().equals("id")) {
	        	 user = request.getParameter("id");
	        	 if (!(user.equals("0"))) {
		        	 chain.doFilter(request, response);
	        	 }
	         }
	     }
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/html/login.html");
		 dispatcher.include(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) {
		
	}

}
