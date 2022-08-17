package Word_Filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class vocabLists {

	public static void main(String[] args) {
		/*
		Scanner myScanner = new Scanner(System.in);
		HashSet<String> wordSet = new HashSet<>();
		System.out.println("Input words from vocab list:");
		do {
			String curr = myScanner.nextLine().toLowerCase();
			if (curr.equalsIgnoreCase("$done$")) {
				break;
			}
			if (curr.matches("^\\s*[a-z]{5}\\s*$")) {
				wordSet.add(curr.replace(',', ' ').trim());
			}
		} while (true);
		Word_Filter.createFile(wordSet, "From Vocab Lists.txt");
		myScanner.close();
		*/

		HashSet<String> wordSet = null;
		try {
			wordSet = Word_Filter.readFile("From Vocab Lists.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		HashSet<String> wordSetWithoutS = new HashSet<>();
		HashSet<String> wordSetEndsInS = new HashSet<>();
		HashSet<String> emptySpace = new HashSet<>();
		emptySpace.add("");
		emptySpace.add("");
		emptySpace.add("");
		emptySpace.add("");
		for (String x: wordSet) {
			if(x.matches("[a-z]{4}s")) {
				wordSetEndsInS.add(x);
			} else {
				wordSetWithoutS.add(x);
			}
		}
		Word_Filter.createFile(wordSetWithoutS, "Vocab Lists Filtered.txt");
		Word_Filter.createFile(emptySpace, "Vocab Lists Filtered.txt");
		Word_Filter.createFile(wordSetEndsInS, "Vocab Lists Filtered.txt");
		
	}

}
