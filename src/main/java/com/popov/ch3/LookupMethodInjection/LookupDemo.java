package com.popov.ch3.LookupMethodInjection;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class LookupDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext genericXmlApplicationContext = new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("com/popov/ch3/LookupMethodInjection/app-context-xml.xml");
        genericXmlApplicationContext.refresh();

        DemoBean abstractBean = genericXmlApplicationContext.getBean("abstractLookupBean", DemoBean.class);
        DemoBean standardBean = genericXmlApplicationContext.getBean("standardLookupBean", DemoBean.class);

        displayInfo(abstractBean);
        displayInfo(standardBean);
    }

    public static void displayInfo(DemoBean bean) {
        System.out.println(bean.getClass().getName());
        MyHelper helper1 = bean.getMyHelper();
        MyHelper helper2 = bean.getMyHelper();

        System.out.println("Helper instances the same: " + (helper1 == helper2));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");
        for (int x = 0; x < 100000; ++x) {
            MyHelper helper = bean.getMyHelper();
            helper.doSomethingHelpful();
        }
        stopWatch.stop();
        System.out.println("100000 gets took " + stopWatch.getTotalTimeMillis() + " ms");
    }
}
