package com.popov.ch4.FactoryBean;

import com.popov.ch4.CustomBeanFactory.MessageDigester;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestFactoryExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext();
        applicationContext.load("ch4/FactoryBean/app-context-xml.xml");
        applicationContext.refresh();

        MessageDigester digester = (MessageDigester)applicationContext.getBean("digester");
        digester.digest("Hello, factory bean!");
    }
}
