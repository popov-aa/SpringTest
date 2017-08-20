package com.popov.ch3.Autowire;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Target {
    private Foo foo;
    private Foo foo2;
    private Bar bar;

    public Target() {
        System.out.println("Target()");
    }

    public Target(Foo foo) {
        System.out.println("Target(Foo foo)");
    }

    public Target(Foo foo, Bar bar) {
        System.out.println("Target(Foo foo, Bar bar)");
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
        System.out.println("setFoo(Foo foo)");
    }

    public void setFoo2(Foo foo) {
        this.foo2 = foo;
        System.out.println("setFoo2(Foo foo)");
    }

    public void setBar(Bar bar) {
        this.bar = bar;
        System.out.println("setBar(Bar bar)");
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext();
        applicationContext.load("com/popov/ch3/Autowire/app-context-xml.xml");
        applicationContext.refresh();

        Target target = null;

        System.out.println("Using byName:\n");
        target = applicationContext.getBean("targetByName", Target.class);

        System.out.println("Using byType:\n");
        target = applicationContext.getBean("targetByType", Target.class);

        System.out.println("Using constructor:\n");
        target = applicationContext.getBean("targetConstructor", Target.class);
    }
}
