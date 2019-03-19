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
        String attrName = scae.getName(); // Ŀǰ���ڲ�����������
        Object attrValue = scae.getServletContext().getAttribute(attrName);
    	System.out.println("ServletContext�����ӡ�����:��������"+attrName+",����ֵ��"+attrValue);
    }

    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
    	System.out.println("ServletContext��ɾ��������:"+scae.getName());
        
    }

    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
    	String attrName = scae.getName();
    	Object attrValue = scae.getServletContext().getAttribute(attrName);
     	System.out.println("ServletContext���滻������:��������"+attrName+",����ֵ��"+attrValue);
     }
	


    public void attributeAdded(ServletRequestAttributeEvent srea)  {
    	String attrName = srea.getName(); // Ŀǰ���ڲ�����������
        Object attrValue = srea.getServletRequest().getAttribute(attrName);
    	System.out.println("ServletRequest�����ӡ�����:��������"+attrName+",����ֵ��"+attrValue);
    
    }


    public void attributeReplaced(ServletRequestAttributeEvent srea)  { 
    	String attrName = srea.getName();
    	Object attrValue = srea.getServletRequest().getAttribute(attrName);
     	System.out.println("ServletRequest���滻������:��������"+attrName+",����ֵ��"+attrValue);
	}
    
    public void attributeRemoved(ServletRequestAttributeEvent srea)  { 
    	System.out.println("ServletRequest��ɾ��������:"+srea.getName());
    }




    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	String attrName = se.getName(); // Ŀǰ���ڲ�����������
    	Object attrValue = se.getSession().getAttribute(attrName);
     	System.out.println("HttpSession�����ӡ�����:��������"+attrName+",����ֵ��"+attrValue);
    }


    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	String attrName = se.getName();
    	Object attrValue = se.getSession().getAttribute(attrName);
     	System.out.println("HttpSession���滻������:��������"+attrName+",����ֵ��"+attrValue);
	}
    
    
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	System.out.println("HttpSession��ɾ��������:"+se.getName());
    }



}
