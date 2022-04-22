package com.mulcam.di1.sample1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Di1Application {

	public static void main(String[] args) {
		MessageBean bean = new MessageBean();
		bean.sayHello("Spring");
	}
}
