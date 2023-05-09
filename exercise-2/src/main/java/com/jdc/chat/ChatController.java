package com.jdc.chat;

import java.util.*;

public class ChatController {

	private Scanner scanner;
	private ChatBot bot;

	public ChatController() {
		scanner = new Scanner(System.in);
		bot = new ChatBot();
	}


	public void start() {
		
		showWelcomeMessage();
		
		while(true) {
			
			var userInput = getUserInput();
			
			if("exit".equalsIgnoreCase(userInput)) {
				break;
			}
			
			var message = bot.talk(userInput);
			System.out.println("Bot > %s".formatted(message));
			
		}
		
		showEndMessage();
	}

	private void showWelcomeMessage() {
		System.out.println("""
				===================================
				Welcome to Chat Bot Program
				You can ask and teach to Mr Boot
				Then you can communicate with him.
				===================================
				""");
	}

	private String getUserInput() {
		System.out.print("You > ");
		return scanner.nextLine();
	}

	private void showEndMessage() {
		System.out.println("""
				===================================
				Thank you so much!
				See you next time.
				===================================
				""");
	}

}