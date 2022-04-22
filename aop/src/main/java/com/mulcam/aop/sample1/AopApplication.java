package com.mulcam.aop.sample1;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.mulcam.aop.sample2.MessageBean;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("beans1.xml");
		MessageBean bean = (MessageBean)context.getBean("proxy");
		bean.sayHello();
	}

}
