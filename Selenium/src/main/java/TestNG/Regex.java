package TestNG;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	public static void main (String args[]){

		// Define the pattern
		String pattern = "[A-Za-z0-9._-]+@[A-Za-z0-9-]{3,}+.[A-Za-z]{2,6}";

		// Compile the pattern
		Pattern p = Pattern.compile(pattern);

		// Get the matcher
		Matcher match = p.matcher("test@tester.com");

		// Confirm the matches
		System.out.println(match.matches());






	}
}