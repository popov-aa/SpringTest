package com.popov.ch3.InheritBean;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBean {
    private String name;
    private int age;

    public static void main(String[] args) {
        GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext();
        applicationContext.load("com/popov/ch3/InheritBean/app-context-xml.xml");
        applicationContext.refresh();

        SimpleBean parent = applicationContext.getBean("inheritParent", SimpleBean.class);
        SimpleBean child = applicationContext.getBean("inheritChild", SimpleBean.class);

        System.out.println("Parent: " + parent);
        System.out.println("Child: " + child);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return getClass().getName() + "(Name: " + name + ", age: " + age + ")";
    }
}
