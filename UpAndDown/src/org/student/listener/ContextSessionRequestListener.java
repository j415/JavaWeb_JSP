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
		System.out.println("监听ServletContext,销毁ServletContext对象..."+sce);
		
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("监听ServletContext,创建ServletContext对象..."+sce);
		
	}
	// session
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("监听HttpSession,创建HttpSession对象..."+se);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("监听HttpSession,销毁HttpSession对象..."+se);
		
	}
	// request
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("监听ServletRequest,销毁ServletRequest对象..."+sre);
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("监听ServletRequest,创建ServletRequest对象..."+sre);
		
	}

}
