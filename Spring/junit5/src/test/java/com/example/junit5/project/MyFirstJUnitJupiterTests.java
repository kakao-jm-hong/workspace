package com.example.junit5.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyFirstJUnitJupiterTests {
	
	private final Calculator calculator = new Calculator();
	
	@FastTest
	void test() {
		assertEquals(2, calculator.add(1, 1));
	}

}
