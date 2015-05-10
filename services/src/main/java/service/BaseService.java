package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseService {
	abstract public void serv(HttpServletRequest request,HttpServletResponse response);
}