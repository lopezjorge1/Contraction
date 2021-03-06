import java.util.Scanner;
import java.util.Arrays;

public class MakeContract {
	private static String[] not = {"should","could","would","do","is","are","does","have"};
	private static String[] have = {"should","could","would"};

	public static void main(String[] args) {
		System.out.println(makeContraction("should have not"));
	}
	
	public static String makeContraction(String s) {
		String[] splitS = s.split(" "); //given sentence split into an array
		String sentence = ""; //sentence being created
		String temp = ""; //holds value of last word

		for (int x = 0; x < splitS.length; x++) {
			if (splitS[x].equals("not")) { //checks if the word is not 
				if (Arrays.asList(not).contains(temp)) { //if it is, then check if temp is contract. worthy
					if (sentence.substring(sentence.length()-3,sentence.length()).equals("'ve")) { //makes sure there isn't contract. already
						sentence += " ";
						sentence += splitS[x];
					} else if (sentence.substring(sentence.length()-3,sentence.length()).equals("n't")) {
						sentence += " ";
						sentence += splitS[x];
					} else {
						sentence += "n't"; 
					}
				} else {  //if not just concantenate not to string
					if (x != 0) {//just to make sure there's no space in the beginning of sentence
						sentence += " ";
					}
					
					sentence += splitS[x];
				}
			} else if (splitS[x].equals("have")) {
				if (Arrays.asList(have).contains(temp)) { 
					if (sentence.substring(sentence.length()-3,sentence.length()).equals("'ve")) {
						sentence += " ";
						sentence += splitS[x];
					} else if (sentence.substring(sentence.length()-3,sentence.length()).equals("n't")) {
						sentence += " ";
						sentence += splitS[x];
					} else {
						sentence += "'ve";
					}
				} else {
					if (x != 0) { 
						sentence += " ";
					}
		
					sentence += splitS[x];
				}
			} else { //if current word doesn't equal not or have just concantenate to string
				if (x != 0) {
					sentence += " ";
				}

				sentence += splitS[x];
			}
			temp = splitS[x]; //temp now equals the current word, regardless of what happens
		}
		return sentence;
	}
}