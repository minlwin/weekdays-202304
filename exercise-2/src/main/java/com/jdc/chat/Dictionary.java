package com.jdc.chat;

import java.util.*;

public class Dictionary {

	private Map<String, String> words;
	
	public Dictionary() {
		words = new HashMap<>();
	}


	public String get(String keyword) {
		return words.get(keyword);
	}

	public void put(String keyword, String definition) {
		words.put(keyword, definition);
	}

}