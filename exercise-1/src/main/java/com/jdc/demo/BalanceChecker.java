package com.jdc.demo;

public interface BalanceChecker {

	public static boolean isBalance(String input) {
		
		if(null != input && !input.isBlank()) {
			var array = input.toCharArray();
			
			Stack stack = new StackChar();
			
			for(var c : array) {
				
				if(isOpenChar(c)) {
					stack.push(c);
				} else {
					var open = stack.pop();
					
					if(!match(open, c)) {
						return false;
					}
				}
			}
			
			return stack.isEmpty();
		}
		
		return false;
	}

	private static boolean match(Character open, char close) {
		if(null != open) {
			return (open == '[' && close == ']') 
					|| (open == '(' && close == ')')
					|| (open == '{' && close == '}')
					|| (open == '<' && close == '>');
		}
		return false;
	}

	private static boolean isOpenChar(char c) {
		return c == '(' || c == '{' || c == '[' || c == '<';
	}
}
