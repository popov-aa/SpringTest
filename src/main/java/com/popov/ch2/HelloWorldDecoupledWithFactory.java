package com.popov.ch2;

public class HelloWorldDecoupledWithFactory {
	public static void main(String[] args) {
		MessageRenderer messageRenderer = MessageSupportFactory.getInstance().getMessageRenderer();
		MessageProvider messageProvider = MessageSupportFactory.getInstance().getMessageProvider();
		messageRenderer.setMessageProvider(messageProvider);
		messageRenderer.render();
	}
}
