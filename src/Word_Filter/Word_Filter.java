package Word_Filter;


/**
 * This class creates the word file for Wordler. This class can either create
 * the file from a text file, or from words typed in the input.
 * 
 * This class uses the typed into input and pulls the words from:
 * https://wordfind.com/length/5-letter-words/
 * 
 * THIS CLASS DOES NOT NEED TO BE CALLED AGAIN
 */

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class Word_Filter {

	public static HashSet<String> swear = new HashSet<>();
	public static HashSet<String> actual = new HashSet<>();
	public static HashSet<String> fromInput = new HashSet<>();

	//Formely the main method, now its just a method
	public static void run() { 

		System.out.println("Input words: ");
		wordsFromInput();
		int count = 0;
		for (@SuppressWarnings("unused") String x : fromInput) {
			count++;
		}
		System.out.println(count);

	}

	//Copy paste words into input and create set from that (Not Used)
	public static void wordsFromInput() {

		Scanner myScanner = new Scanner(System.in);

		do {
			String x = myScanner.nextLine();
			if (x.equalsIgnoreCase("done")) {
				break;
			}
			String[] arr = x.split("[0-9]+");
			for(String curr : arr) {
				fromInput.add(curr);
			}
		} while (true);

		myScanner.close();

		createFile(fromInput, "Words For Wordler.txt");
	}

	//Read the words files and doesn't add swear words to word set
	public static void readPremadeList() throws IOException {
		File file = new File(
				"/Users/billytheredneck/eclipse-workspace/Wordler/output-onlinejsontools-2.txt");


		BufferedReader br = new BufferedReader(new FileReader(file));

		String curr;
		while ((curr = br.readLine()) != null) {
			swear.add(curr);
		}
		br.close();
		file = new File(
				"/Users/billytheredneck/eclipse-workspace/Wordler/output-onlinejsontools.txt");

		br = new BufferedReader(new FileReader(file));

		while ((curr = br.readLine()) != null) {
			if (curr.length() == 5 && !swear.contains(curr)) {
				actual.add(curr);
			}
		}

		br.close();

		createFile(actual, "");

	}
	
	public static HashSet<String> readFile(String fileName) throws IOException {
		File file = new File(
				"/Users/billytheredneck/eclipse-workspace/Wordler/" + fileName);
		HashSet<String> wordSet = new HashSet<>();


		BufferedReader br = new BufferedReader(new FileReader(file));

		String curr;
		while ((curr = br.readLine()) != null) {
			wordSet.add(curr);
		}
		br.close();
		

		return wordSet;

	}

	//Create Words file and write words to it if the file is new
	//Do nothing if file is already created
	public static void createFile(HashSet<String> set, String fileName) {
		//try to create words file
		try {
			File myObj = new File("/Users/billytheredneck/eclipse-workspace/Wordler/" + fileName);
			if (myObj.createNewFile()) {
				//File Created
				System.out.println("File created: " + myObj.getName());
				
				
				
			} else {
				System.out.println("File already exists.");
				
			}
			//try to write to File
			try {
				FileWriter myWriter = new FileWriter("/Users/billytheredneck/eclipse-workspace/Wordler/" + fileName, true);
				for (String word : set) {
					myWriter.write(word + "\n");
				}
				myWriter.close();
				System.out.println("Successfully wrote to the file.");
			//Writing Error
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		//Creation Error
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		
	}

}

