package org.student.listener;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

// ����BeanListener2����Ķۻ��ͻ
public class BeanListener2 implements HttpSessionActivationListener,Serializable {

	// ׼�����ۻ����������
	private int num;
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	private String user;
	
    public BeanListener2() {
    	
    }

    // ����ʱ�̣������ۻ�֮ǰ
    public void sessionWillPassivate(HttpSessionEvent arg0)  { 
    	System.out.println("�����ۻ�֮ǰ��BeanListener2���󽫻�����session�Ķۻ����ۻ�");
    }
    // ����ʱ�̣��ոջ֮��
    public void sessionDidActivate(HttpSessionEvent arg0)  { 
    	System.out.println("�ոջ֮��BeanListener2���󽫻�����session�Ļ���");
         // TODO Auto-generated method stub
    }


}
