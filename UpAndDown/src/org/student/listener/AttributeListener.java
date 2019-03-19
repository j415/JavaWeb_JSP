package org.student.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;


public class AttributeListener implements ServletRequestAttributeListener, HttpSessionAttributeListener, ServletContextAttributeListener {
	// application.setAttribute("name","aspire");
    public AttributeListener() {
        // TODO Auto-generated constructor stub
    }

    public void attributeAdded(ServletContextAttributeEvent scae)  { 
        String attrName = scae.getName(); // 目前正在操作的属性名
        Object attrValue = scae.getServletContext().getAttribute(attrName);
    	System.out.println("ServletContext【增加】属性:属性名："+attrName+",属性值："+attrValue);
    }

    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
    	System.out.println("ServletContext【删除】属性:"+scae.getName());
        
    }

    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
    	String attrName = scae.getName();
    	Object attrValue = scae.getServletContext().getAttribute(attrName);
     	System.out.println("ServletContext【替换】属性:属性名："+attrName+",属性值："+attrValue);
     }
	


    public void attributeAdded(ServletRequestAttributeEvent srea)  {
    	String attrName = srea.getName(); // 目前正在操作的属性名
        Object attrValue = srea.getServletRequest().getAttribute(attrName);
    	System.out.println("ServletRequest【增加】属性:属性名："+attrName+",属性值："+attrValue);
    
    }


    public void attributeReplaced(ServletRequestAttributeEvent srea)  { 
    	String attrName = srea.getName();
    	Object attrValue = srea.getServletRequest().getAttribute(attrName);
     	System.out.println("ServletRequest【替换】属性:属性名："+attrName+",属性值："+attrValue);
	}
    
    public void attributeRemoved(ServletRequestAttributeEvent srea)  { 
    	System.out.println("ServletRequest【删除】属性:"+srea.getName());
    }




    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	String attrName = se.getName(); // 目前正在操作的属性名
    	Object attrValue = se.getSession().getAttribute(attrName);
     	System.out.println("HttpSession【增加】属性:属性名："+attrName+",属性值："+attrValue);
    }


    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	String attrName = se.getName();
    	Object attrValue = se.getSession().getAttribute(attrName);
     	System.out.println("HttpSession【替换】属性:属性名："+attrName+",属性值："+attrValue);
	}
    
    
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	System.out.println("HttpSession【删除】属性:"+se.getName());
    }



}
