package com.popov.ch3.MethodReplacement;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class MethodReplacementExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext();
        applicationContext.load("com/popov/ch3/MethodReplacement/app-context-xml.xml");
        applicationContext.refresh();

        ReplacementTarget replacementTarget = applicationContext.getBean("replacementTarget", ReplacementTarget.class);
        ReplacementTarget standardTarget = applicationContext.getBean("standardTarget", ReplacementTarget.class);

        displayInfo(replacementTarget);
        displayInfo(standardTarget);
    }

    private static void displayInfo(ReplacementTarget target) {
        System.out.println(target.formatMessage("Hello, World, " + target.getClass().getName()));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("perfTest");
        for (int x = 0; x < 1000000; x++) {
            String out = target.formatMessage("foo");
        }
        stopWatch.stop();
        System.out.println("1000000 invocations took: " + stopWatch.getTotalTimeMillis() + " ms");
    }
}
