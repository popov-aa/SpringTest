package com.popov.ch3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HierarchicalAppContextUsage {
    public static void main(String[] args) {
        GenericXmlApplicationContext parent = new GenericXmlApplicationContext();
        parent.load("app-context-xml-hierarchical-parent.xml");
        parent.refresh();

        GenericXmlApplicationContext child = new GenericXmlApplicationContext();
        child.load("app-context-xml-hierarchical-child.xml");
        child.setParent(parent);
        child.refresh();

        SimpleTarget target1 = child.getBean("target1", SimpleTarget.class);
        SimpleTarget target2 = child.getBean("target2", SimpleTarget.class);
        SimpleTarget target3 = child.getBean("target3", SimpleTarget.class);

        System.out.println(target1.getVal());
        System.out.println(target2.getVal());
        System.out.println(target3.getVal());
    }
}
