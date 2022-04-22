package com.mulcam.di1.sample2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Di1Application {

	public static void main(String[] args) {
		MessageBean bean = new MessageBeanKr();
		bean.sayHello("Spring");
	}
}
