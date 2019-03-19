package org.student.listener;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ContextSessionRequestListener implements ServletRequestListener,HttpSessionListener,ServletContextListener {

	
	
	// application (ServletContext)
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("����ServletContext,����ServletContext����..."+sce);
		
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("����ServletContext,����ServletContext����..."+sce);
		
	}
	// session
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("����HttpSession,����HttpSession����..."+se);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("����HttpSession,����HttpSession����..."+se);
		
	}
	// request
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("����ServletRequest,����ServletRequest����..."+sre);
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("����ServletRequest,����ServletRequest����..."+sre);
		
	}

}
