package com.jdc.chat;

public class ChatBot {

	private Dictionary dictionary;
	private String lastQuestion;

	public ChatBot() {
		dictionary = new Dictionary();
	}

	public String talk(String message) {
		
		String result = null;
		
		if(null == lastQuestion) {
			
			result = dictionary.get(message);
			
			if(null == result) {
				lastQuestion = message;
				result = "I've no idea. Please teach me.";
			}
			
		} else {
			dictionary.put(lastQuestion, message);
			lastQuestion = null;
			result = "Thank you for your kindness.";
		}
		
		return result;
	}

}