package com.zdy.cn.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class Listener implements HttpSessionAttributeListener{

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("�������ػ������µ�����:"+event.getName()+"��ֵ��"+event.getValue());
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		System.out.println("�������ػ�ɾ������:"+event.getName()+"��ֵ��"+event.getValue());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		System.out.println("�������ػ��޸����ԣ�"+event.getName()+"��ֵ��"+event.getValue());
	}

}
