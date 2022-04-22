package com.mulcam.aop.sample3;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.mulcam.aop.sample3.MessageBean;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("beans3.xml");
		MessageBean bean = (MessageBean)context.getBean("targetBean");
		bean.sayHello();
	}

}
