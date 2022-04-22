package com.mulcam.aop.sample2;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.mulcam.aop.sample2.MessageBean;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("beans2.xml");
		MessageBean bean = (MessageBean)context.getBean("targetBean");
		bean.sayHello();
	}

}
