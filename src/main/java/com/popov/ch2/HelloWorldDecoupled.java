package com.popov.ch2;

public class HelloWorldDecoupled {
	public static void main(String[] args) {
		MessageRenderer messageRenderer = new StandardOutputMessageRenderer();
		MessageProvider messageProvider = new HelloWorldMessageProvider();
		messageRenderer.setMessageProvider(messageProvider);
		messageRenderer.render();
	}
}
