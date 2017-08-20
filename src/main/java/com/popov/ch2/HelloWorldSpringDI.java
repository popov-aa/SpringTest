package com.popov.ch2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldSpringDI {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app-context-annotation-02.xml");
		MessageRenderer messageRenderer = applicationContext.getBean("messageRenderer", MessageRenderer.class);
		messageRenderer.render();
	}
}
