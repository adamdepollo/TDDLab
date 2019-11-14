package co.grandcircus;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DoItRightTest {

	@Test
	void test() {
		assertEquals("zero", DoItRightTest.numToWord(0));
		assertEquals("one", DoItRightTest.numToWord(1));
		assertEquals("two", DoItRightTest.numToWord(2));
		assertEquals("three", DoItRightTest.numToWord(3));
		assertEquals("four", DoItRightTest.numToWord(4));
		assertEquals("five", DoItRightTest.numToWord(5));
		assertEquals("six", DoItRightTest.numToWord(6));
		assertEquals("seven", DoItRightTest.numToWord(7));
		assertEquals("eight", DoItRightTest.numToWord(8));
		assertEquals("nine", DoItRightTest.numToWord(9));
		assertEquals("ten", DoItRightTest.numToWord(10));
		assertEquals("eleven", DoItRightTest.numToWord(11));
		assertEquals("twelve", DoItRightTest.numToWord(12));
		assertEquals("thirteen", DoItRightTest.numToWord(13));
		assertEquals("fourteen", DoItRightTest.numToWord(14));
		assertEquals("fifteen", DoItRightTest.numToWord(15));
		assertEquals("sixteen", DoItRightTest.numToWord(16));
		assertEquals("seventeen", DoItRightTest.numToWord(17));
		assertEquals("eighteen", DoItRightTest.numToWord(18));
		assertEquals("nineteen", DoItRightTest.numToWord(19));
		assertEquals("twenty", DoItRightTest.numToWord(20));

	}

	@Test
	void testMoreThan20() {
		assertEquals("twenty-one", DoItRightTest.numToWord(21));
		assertEquals("twenty-two", DoItRightTest.numToWord(22));
		assertEquals("ninety-nine", DoItRightTest.numToWord(99));
	}

	@Test
	void testHundos() {
		assertEquals("one hundred", DoItRightTest.numToWord(100));
		assertEquals("one hundred one", DoItRightTest.numToWord(101));
		assertEquals("one hundred nine", DoItRightTest.numToWord(109));
		assertEquals("one hundred ten", DoItRightTest.numToWord(110));
		assertEquals("one hundred fifteen", DoItRightTest.numToWord(115));
		assertEquals("one hundred twenty-one", DoItRightTest.numToWord(121));
		assertEquals("two hundred", DoItRightTest.numToWord(200));
		assertEquals("two hundred one", DoItRightTest.numToWord(201));
		assertEquals("nine hundred ninety-nine", DoItRightTest.numToWord(999));
	}

	@Test
	void testThous() {
		assertEquals("one thousand", DoItRightTest.numToWord(1000));
		assertEquals("one thousand nine hundred ninety-nine", DoItRightTest.numToWord(1999));
		assertEquals("nine thousand nine hundred ninety-nine", DoItRightTest.numToWord(9999));
		assertEquals("ten thousand nine hundred ninety-nine", DoItRightTest.numToWord(10999));
		assertEquals("nineteen thousand nine hundred ninety-nine", DoItRightTest.numToWord(19999));
		assertEquals("twenty-one thousand nine hundred ninety-nine", DoItRightTest.numToWord(21999));
		assertEquals("ninety-nine thousand nine hundred ninety-nine", DoItRightTest.numToWord(99999));
		assertEquals("one hundred thousand", DoItRightTest.numToWord(100000));
		assertEquals("one hundred thousand nine hundred ninety-nine", DoItRightTest.numToWord(100999));
		assertEquals("nine hundred ninety-nine thousand nine hundred ninety-nine", DoItRightTest.numToWord(999999));
		assertEquals("one million", DoItRightTest.numToWord(1000000));
		assertEquals("nine hundred ninety-nine million nine hundred ninety-nine thousand nine hundred ninety-nine",
				DoItRightTest.numToWord(999999999));
		assertEquals("two billion one hundred forty-seven million four hundred eighty-three thousand six hundred forty-seven",
				DoItRightTest.numToWord(Integer.MAX_VALUE));
	}
	
	@Test
	void testDec() {
		assertEquals("one and 5/100", getDouble(1.05));
		assertEquals("one and 99/100", getDouble(1.99));
		assertEquals("one and 0/100", getDouble(1));
		assertEquals("nine hundred ninety-nine and 47/100", getDouble(999.47));
		assertEquals("nine hundred ninety-nine thousand nine hundred ninety-nine and 47/100", getDouble(999999.47));
		//assertEquals("nine hundred ninety-nine million nine hundred ninety-nine thousand nine hundred ninety-nine and 47/100", getDouble(999999999.47));
	}
	
	public static void main(String[] args) {
		getDouble (1.05);
	}
	public static String getDouble(double n) {
		int dec = (int)(n * 100) % 100;
		return numToWord((int)(n * 100) / 100)+ " and " + dec + "/100" ;
		
	}

	public static String numToWord(int n) {
		if (n == 0) {
			return "zero";
		} else if (n < 100) {
			if (n < 20 || n % 10 == 0) {
				return words(n);
			}
			return words((n - (n % 10))) + "-" + words(n % 10);
		} else if (n < 1000) {
			if (n % 100 == 0) {
				return words(n / 100) + " hundred";
			}
			return words(n / 100) + " hundred " + numToWord(n % 100);
		} else if (n < 1000000) {
			if (n % 1000 == 0) {
				return numToWord(n / 1000) + " thousand";
			}
			return numToWord(n / 1000) + " thousand " + numToWord(n % 1000);
		} else if (n < 1000000000) {
			if (n % 1000000 == 0) {
				return words(n / 1000000) + " million";
			}
			return numToWord(n / 1000000) + " million " + numToWord(n % 1000000);
		}
		if (n % 1000000000 == 0) {
			return words(n / 1000000000) + " billion";
		}
		return numToWord(n / 1000000000) + " billion " + numToWord(n % 1000000000);

	}

	public static String words(int n) {
		switch (n) {
		case 1:
			return "one";
		case 2:
			return "two";
		case 3:
			return "three";
		case 4:
			return "four";
		case 5:
			return "five";
		case 6:
			return "six";
		case 7:
			return "seven";
		case 8:
			return "eight";
		case 9:
			return "nine";
		case 10:
			return "ten";
		case 11:
			return "eleven";
		case 12:
			return "twelve";
		case 13:
			return "thirteen";
		case 14:
			return "fourteen";
		case 15:
			return "fifteen";
		case 16:
			return "sixteen";
		case 17:
			return "seventeen";
		case 18:
			return "eighteen";
		case 19:
			return "nineteen";
		case 20:
			return "twenty";
		case 30:
			return "thirty";
		case 40:
			return "forty";
		case 50:
			return "fifty";
		case 60:
			return "sixty";
		case 70:
			return "seventy";
		case 80:
			return "eighty";
		case 90:
			return "ninety";
		}
		return "";
	}

}
