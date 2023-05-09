package com.jdc.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.demo.BalanceChecker;

public class BalanceCheckerTest {

	@ParameterizedTest
	@ValueSource(strings = {
			"[]",
			"[()<>{}]",
			"{([<>])}",
			"{()([<>])}"
	})
	void test_is_balance_result_true(String input) {
		assertTrue(BalanceChecker.isBalance(input));
	}

	@ParameterizedTest
	@ValueSource(strings = {
			"[](",
			"[(<>{}]",
			"{([>])}",
			"{()(>])}",
			"",
			">"
	})
	void test_is_balance_result_false(String input) {
		assertFalse(BalanceChecker.isBalance(input));
	}
	
	@ParameterizedTest
	@CsvSource(value = {
			"[],true",
			"[()<>{}],true",
			"{([<>])},true",
			"{()([<>])},true",
			"[](,false",
			"[(<>{}],false",
			"{([>])},false",
			"{()(>])},false",
			",false",
			">,false"
	})
	void test_is_balance(String input, boolean expected) {
		var result = BalanceChecker.isBalance(input);
		assertEquals(expected, result);
	}
}
