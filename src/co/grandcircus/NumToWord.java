package co.grandcircus;

import java.util.Arrays;

public class NumToWord {

	public static void main(String[] args) {
		System.out.println(numToWord(1199999999.99));
	}

	public static String numToWord(double number) {
		String numString = "";
		int num = 0;
		int dec = 0;
		if (number > 2147483647) {
			return "Error: Number larger than maximum int value, and I'm too tired to write another version of all this code \nso that you can figure out how to write out a check for 2.15 billion dollars. Who are you, Jeff Bezos?\nIf you need to write a check that big maybe you should just hire someone to do it, you rich bastard.\n";
		} else if (number > 9999999 && number < 2147483647) {
			numString = "" + number;
			num = (int) (Double
					.parseDouble(numString.substring(0,
							numString.indexOf('.') + 1
									+ Integer.parseInt(
											Character.toString(numString.charAt(numString.indexOf('E') + 1)))))
					* Math.pow(10.0, (double) Integer
							.parseInt(numString.substring(numString.indexOf('E') + 1, numString.length()))));
			if (number == 999999999) {
//				 Very strange, but the line of code above this loop sets num to 999,999,998 if the number
//				 entered was 999,999,999. As far as I can tell, this isn't true for any other
//				 number.
				num += 1;
			}
			try {
				dec = Integer
						.parseInt(
								numString
										.substring(
												numString.indexOf('.') + 1
														+ Integer.parseInt(Character.toString(
																numString.charAt(numString.indexOf('E') + 1))),
												numString.indexOf('E')));
			} catch (NumberFormatException e) {

			}
		} else {
			numString = Double.toString(number);
			num = Integer.parseInt(numString.substring(0, numString.indexOf('.')));
			if (numString.substring(numString.indexOf('.') + 1, numString.length()).length() == 1) {
				dec = Integer.parseInt(numString.substring(numString.indexOf('.') + 1, numString.length())) * 10;
			} else {
				if (Integer.parseInt(numString.substring(numString.indexOf('.') + 1, numString.length())) > 99) {
					dec = Integer.parseInt(numString.substring(numString.indexOf('.') + 1, numString.indexOf('.') + 3));
				} else {
					dec = Integer.parseInt(numString.substring(numString.indexOf('.') + 1, numString.length()));
				}
			}
		}
		String result = "";
		if (num < 1000) {
			if (num == 0) {
				result += "zero";
			} else {
				result += threeDigWord(num);
			}
		} else if (num >= 1000 && num < 1000000) {
			result += thouString(num);
		} else if (num >= 1000000 && num < 1000000000) {
			result += milString(num);
		} else {
			result += bilString(num);
		}
		if (!Character.toString(result.charAt(result.length() - 1)).equals(" ")) {
			result += " ";
		}
		if (result.equals("one ")) {
			result += "dollar and ";
		}

		else {
			result += "dollars and ";
		}
		if (dec < 10) {
			return result + dec + "/100";
		} else {
			return result + String.format("%-2d", dec).replace(' ', '0') + "/100";
		}

	}

	public static String thouString(int num) {
		String result = "";
		int huns = Integer.parseInt(
				Integer.toString(num).substring(Integer.toString(num).length() - 3, Integer.toString(num).length()));
		int thous = Integer.parseInt(Integer.toString(num).substring(0, Integer.toString(num).length() - 3));
		result = threeDigWord(thous) + " thousand " + threeDigWord(huns);
		return result;
	}

	public static String milString(int num) {
		String result = "";
		int huns = Integer.parseInt(
				Integer.toString(num).substring(Integer.toString(num).length() - 3, Integer.toString(num).length()));
		int thous = Integer.parseInt(Integer.toString(num).substring(Integer.toString(num).length() - 6,
				Integer.toString(num).length() - 3));
		int mils = Integer.parseInt(Integer.toString(num).substring(0, Integer.toString(num).length() - 6));
		result += threeDigWord(mils) + " million ";
		if (!threeDigWord(thous).equals("")) {
			result += threeDigWord(thous) + " thousand ";
		}
		result += threeDigWord(huns);
		return result;
	}

	public static String bilString(int num) {
		String result = "";
		int huns = Integer.parseInt(
				Integer.toString(num).substring(Integer.toString(num).length() - 3, Integer.toString(num).length()));
		int thous = Integer.parseInt(Integer.toString(num).substring(Integer.toString(num).length() - 6,
				Integer.toString(num).length() - 3));
		int mils = Integer.parseInt(Integer.toString(num).substring(Integer.toString(num).length() - 9,
				Integer.toString(num).length() - 6));
		int bils = Integer.parseInt(Integer.toString(num).substring(0, Integer.toString(num).length() - 9));

		result += threeDigWord(bils) + " billion ";
		if (!threeDigWord(mils).equals("")) {
			result += threeDigWord(mils) + " million ";
		}
		if (!threeDigWord(thous).equals("")) {
			result += threeDigWord(thous) + " thousand ";
		}
		result += threeDigWord(huns);
		return result;
	}

	public static String threeDigWord(int num) {
		if (num < 20) {
			if (num == 0) {
			}
			return ones(num);
		} else if (num >= 20 && num < 100) {
			String numString = Integer.toString(num);
			if (!Character.toString(numString.charAt(1)).equals("0")) {
				return tens(Integer.parseInt(Character.toString(numString.charAt(0)))) + "-"
						+ ones(Integer.parseInt(Character.toString(numString.charAt(1))));
			} else {
				return tens(Integer.parseInt(Character.toString(numString.charAt(0))));
			}
		} else {
			String numString = Integer.toString(num);
			String result = ones(Integer.parseInt(Character.toString(numString.charAt(0)))) + " hundred";
			if (Integer.parseInt(numString.substring(1, 3)) < 20) {
				if (Integer.parseInt(numString.substring(1, 3)) == 0) {
					return result;
				} else {
					result += " " + ones(Integer.parseInt(numString.substring(1, 3)));
					return result;
				}
			} else {
				if (!Character.toString(numString.charAt(2)).equals("0")) {
					result += " " + tens(Integer.parseInt(Character.toString(numString.charAt(1)))) + "-"
							+ ones(Integer.parseInt(Character.toString(numString.charAt(2))));
					return result;
				} else {
					result += " " + tens(Integer.parseInt(Character.toString(numString.charAt(1))));
					return result;
				}
			}
		}
	}

	public static String tens(int num) {
		switch (num) {
		case 1:
			return "ten";
		case 2:
			return "twenty";
		case 3:
			return "thirty";
		case 4:
			return "forty";
		case 5:
			return "fifty";
		case 6:
			return "sixty";
		case 7:
			return "seventy";
		case 8:
			return "eighty";
		case 9:
			return "ninety";
		}
		return "";
	}

	public static String ones(int num) {
		switch (num) {
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
		}
		return "";
	}

}
