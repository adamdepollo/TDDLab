package co.grandcircus;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumToWordTest {
	@Test
	void test1() {
		assertEquals("one dollar and 0/100", NumToWord.numToWord(1));
	}
	
	@Test
	void test2() {
		assertEquals("two dollars and 0/100", NumToWord.numToWord(2));
	}
	
	@Test
	void test9() {
		assertEquals("nine dollars and 0/100", NumToWord.numToWord(9));
	}
	
	@Test
	void test10() {
		assertEquals("ten dollars and 0/100", NumToWord.numToWord(10));
	}
	
	@Test
	void test15() {
		assertEquals("fifteen dollars and 0/100", NumToWord.numToWord(15));
	}
	
	@Test
	void test21() {
		assertEquals("twenty-one dollars and 0/100", NumToWord.numToWord(21));
	}
	
	@Test
	void test99() {
		assertEquals("ninety-nine dollars and 0/100", NumToWord.numToWord(99));
	}
	
	@Test
	void test100() {
		assertEquals("one hundred dollars and 0/100", NumToWord.numToWord(100));
	}
	
	@Test
	void test110() {
		assertEquals("one hundred ten dollars and 0/100", NumToWord.numToWord(110));
	}
	
	@Test
	void test177() {
		assertEquals("one hundred seventy-seven dollars and 0/100", NumToWord.numToWord(177));
	}
	
	@Test
	void test869() {
		assertEquals("eight hundred sixty-nine dollars and 0/100", NumToWord.numToWord(869));
	}
	
	@Test
	void test999() {
		assertEquals("nine hundred ninety-nine dollars and 0/100", NumToWord.numToWord(999));
	}
	
	@Test
	void test1000() {
		assertEquals("one thousand dollars and 0/100", NumToWord.numToWord(1000));
	}
	
	@Test
	void test1500() {
		assertEquals("one thousand five hundred dollars and 0/100", NumToWord.numToWord(1500));
	}
	
	@Test
	void test9999() {
		assertEquals("nine thousand nine hundred ninety-nine dollars and 0/100", NumToWord.numToWord(9999));
	}
	
	@Test
	void test999999() {
		assertEquals("nine hundred ninety-nine thousand nine hundred ninety-nine dollars and 0/100", NumToWord.numToWord(999999));
	}
	
	@Test
	void test1000000() {
		assertEquals("one million dollars and 0/100", NumToWord.numToWord(1000000));
	}
	
	@Test
	void test1000001() {
		assertEquals("one million one dollars and 0/100", NumToWord.numToWord(1000001));
	}
	
	@Test
	void test999999999() {
		assertEquals("nine hundred ninety-nine million nine hundred ninety-nine thousand nine hundred ninety-nine dollars and 0/100", NumToWord.numToWord(999999999));
	}
	@Test
	void test1999999999() {
		assertEquals("one billion nine hundred ninety-nine million nine hundred ninety-nine thousand nine hundred ninety-nine dollars and 0/100", NumToWord.numToWord(1999999999));
	}
	
}
