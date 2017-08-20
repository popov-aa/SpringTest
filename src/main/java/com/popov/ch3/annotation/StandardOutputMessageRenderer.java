package com.popov.ch3.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.popov.ch2.MessageProvider;
import com.popov.ch2.MessageRenderer;

@Service("messageRenderer")
public class StandardOutputMessageRenderer implements MessageRenderer {
	private MessageProvider messageProvider;
	
	@Override
	public void render() {
		if (messageProvider == null) {
			throw new RuntimeException(
					"You must set the property messageProvider of class: " +
					StandardOutputMessageRenderer.class.getName());
		}
		System.out.println(messageProvider.getMessage());
	}

	@Override
	@Autowired
	public void setMessageProvider(MessageProvider provider) {
		this.messageProvider = provider;
	}

	@Override
	public MessageProvider getMessageProvider() {
		return this.messageProvider;
	}
}
