package org.student.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;


public class BeanListener implements HttpSessionBindingListener {


    public BeanListener() {
        // TODO Auto-generated constructor stub
    }


    public void valueBound(HttpSessionBindingEvent arg0)  { 
    	System.out.println("��Bean����(��Bean������ӵ�session��)���󶨵Ķ���"+this+",sessionId:"+arg0.getSession().getId());
    }


    public void valueUnbound(HttpSessionBindingEvent arg0)  { 
    	System.out.println("���Bean����(��Bean�����session�����Ƴ�)�����Ķ���"+this+",sessionId:"+arg0.getSession().getId());
    }
	
}
