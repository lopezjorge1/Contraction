import java.util.Scanner;
import java.util.Arrays;

public class MakeContract {
	public static void main(String[] args) {

		System.out.println(makeContraction("have i told you"));
	}

	private static String[] not = {"should","could","would","do","is","are","does","have"};
	private static String[] have = {"should","could","would"};
	
	public static String makeContraction(String s) {
		String[] splitS = s.split(" "); //given sentence split into an array
		String sentence = ""; //sentence being created
		String temp = ""; //holds value of last word

		for (int x = 0; x < splitS.length; x++) {
			if (splitS[x].equals("not")) { //checks if the word is not 
				if (Arrays.asList(not).contains(temp)) { //if it is, then check if it's contract. worthy
					sentence += "n't";
				} else { 
					sentence += " ";
					sentence += splitS[x];
				}
			} else if (splitS[x].equals("have")) {
				if (Arrays.asList(have).contains(temp)) {
					sentence += "'ve";
				} else {
					sentence += " ";
					sentence += splitS[x];
				}
			} else { //if temp word is not contract. worthy and not empty add a space after word
				if (Arrays.asList(not).contains(temp) == false && temp.equals("") == false) {
					sentence += " ";
				} else if ((splitS[x].equals("not") == false || splitS[x].equals("have") == false) && x != 0) {
					sentence += " "; //little problem somewhere here
				}

				sentence += splitS[x];
			}
			temp = splitS[x];
			System.out.println(temp);
		}
		return sentence;
	}
}


/*
(2) 
Multiple contractions can be chained in some cases: 
there's a famous Southern "y'all'd've" (you all would have) which
y'all'd'ven't (you all would have not) heard of if y'all'evn't 
(you all have not (I may be making this one up)) been to the 
South. Additionally, Scottish slang allows for "am not" to be written as "amn't," 
which ain't different from "ain't." 
Design an app to let users input sentences and get shortened (or even expanded) ones back.
How would you allow them to conveniently configure your tool to handle all sorts of contractions 
(even their own, or their own odd chains)?

Frontend (UI/UX):

"Search engine" that will allow to construct contractions or decontruct contractions
There can be user profiles that will save the unique contractions 
Each profile will allow the user to input their own contractions that will be saved in a database
There will also be suggested contractions after receving input sentence or phrase





*/