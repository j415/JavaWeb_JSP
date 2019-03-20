package org.student.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;


public class BeanListener implements HttpSessionBindingListener {


    public BeanListener() {
        // TODO Auto-generated constructor stub
    }


    public void valueBound(HttpSessionBindingEvent arg0)  { 
    	System.out.println("绑定Bean对象(将Bean对象添加到session域)，绑定的对象："+this+",sessionId:"+arg0.getSession().getId());
    }


    public void valueUnbound(HttpSessionBindingEvent arg0)  { 
    	System.out.println("解绑Bean对象(将Bean对象从session域中移除)，解绑的对象："+this+",sessionId:"+arg0.getSession().getId());
    }
	
}
