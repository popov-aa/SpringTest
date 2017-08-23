package com.popov.ch4.CustomBeanFactory;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext();
        applicationContext.load("ch4/CustomBeanFactory/app-context-xml.xml");
        applicationContext.refresh();

        MessageDigester messageDigester = applicationContext.getBean("digester", MessageDigester.class);
        messageDigester.digest("Hello, custom bean factory!");
    }
}
