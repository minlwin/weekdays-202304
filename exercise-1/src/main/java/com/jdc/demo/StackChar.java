package com.jdc.demo;

import java.util.Arrays;

public class StackChar implements Stack {
	
	private char[] array = {};

	@Override
	public boolean isEmpty() {
		return array.length == 0;
	}

	@Override
	public void push(char c) {
		array = Arrays.copyOf(array, array.length + 1);
		array[array.length - 1] = c;
	}

	@Override
	public Character pop() {
		
		if(array.length > 0) {
			var c = array[array.length - 1];
			array = Arrays.copyOf(array, array.length - 1);
			return c;
		}
		
		return null;
	}

}
