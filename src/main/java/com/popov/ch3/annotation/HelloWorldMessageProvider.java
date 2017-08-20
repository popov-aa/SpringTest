package com.popov.ch3.annotation;

import org.springframework.stereotype.Service;
import com.popov.ch2.MessageProvider;

@Service("messageProvider")
public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World, annotations.";
    }
}
