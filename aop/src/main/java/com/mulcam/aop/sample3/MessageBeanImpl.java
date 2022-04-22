package com.mulcam.aop.sample3;

public class MessageBeanImpl implements MessageBean {
	String name;
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void sayHello() {
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {}
		System.out.println("Hello, "+name+"!");
	}
}
