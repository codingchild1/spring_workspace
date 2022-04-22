package com.mulcam.di1.sample4;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.GenericXmlApplicationContext;

@SpringBootApplication
public class Di1Application {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("beans2.xml");
		MessageBean bean = context.getBean("messageBean", MessageBean.class);
		bean.sayHello();
	}
}

