package Wordler;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

/** This class contains the logic of what happens when submit is pressed
 * It ensures that 5 letters are typed, then ensures it is a valid word, then
 * will change the color of the boxes.
 */

/*
 * GOAT website:
 * https://www.browserling.com/tools/spaces-to-newlines
 */

public class Wordler_Logic {

	private static HashSet<String> wordList;
	private static ArrayList<String> wordListAsArrayList;
	private static String correctWord;
	private String word;
	private StringBuffer progress;
	private final static int NUM_WORDS_IN_FILE = 2396;

	private final int MAX_WORD_LENGTH = 5;
	//Set the wordList and correctWord
	static { 
		File file = new File(Controller.DIRECTORY + "Vocab Lists Filtered.txt");


		BufferedReader br;
		wordList = new HashSet<>();
		wordListAsArrayList = new ArrayList<>(NUM_WORDS_IN_FILE);
		int count = 0;
		try {
			//Load words into wordList
			br = new BufferedReader(new FileReader(file));
			String curr;
			while ((curr = br.readLine()) != null) {
				wordList.add(curr);
				if (count < NUM_WORDS_IN_FILE) {
					wordListAsArrayList.add(curr);
				}
				count++;
			}
			Collections.shuffle(wordListAsArrayList);
			setCorrectWord();
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}



	}

	//Take in the words list as well as the guess number to decide which buttons
	//to modify.
	public Wordler_Logic(String word, String progress) {
		this.word = word.toLowerCase().replace(" ", "");
		this.progress = new StringBuffer(progress);
	}
	
	//Set the correctWord
	public static void setCorrectWord() {
		correctWord = wordListAsArrayList.remove(0);
	}

	//Check word
	public Color[] wordCheck() {
		numLetters();
		validWord();
		return changeBoxColor();

	}

	//Check amount of letters
	private void numLetters() {
		if (word.length() == MAX_WORD_LENGTH) {
			return; 
		}
		throw new IllegalArgumentException("Not enough letters");
	}

	//Check if valid word
	private void validWord() {
		//System.out.println("word is: " + word);
		if (wordList.contains(word)) {
			return; 
		}
		throw new TypeNotPresentException("Not enough letters", null);
	}

	//Determine box colors
	private Color[] changeBoxColor() {
		int numCorrect = 0;
		Color[] buttonChange = new Color[6];
		StringBuffer temp = new StringBuffer(correctWord);
		//Check which letters are completely correct
		for (int index = 0; index < MAX_WORD_LENGTH; index++) {
			if (temp.charAt(index) == word.charAt(index)) {
				buttonChange[index+1] = Color.GREEN; //Add one because 1-indexed
				numCorrect++;
				temp.setCharAt(index, '?'); 
				progress.setCharAt(index*2, word.charAt(index));
			}
		}
		Wordler_GUI.Progress.setText(progress.toString().toUpperCase());
		//Check which letters are not present or out of place
		for (int index = 1; index <= MAX_WORD_LENGTH; index++) {
			//Is the letter in the correctWord?
			//System.out.println("temp is " + temp);
			int indexInTemp = temp.indexOf(Character.toString(word.charAt(index-1)));
			if (buttonChange[index] == null) { //Letter hasn't been checked
				if (indexInTemp != -1) { //Yes it is
					buttonChange[index] = Color.ORANGE;
					//Set the char to ? so it won't be checked again
					temp.setCharAt(indexInTemp, '?'); 
				} else { //Letter is not in correctWord
					buttonChange[index] = new Color(109,109,109);
				}
			}

		}
		if (numCorrect == 5) {
			buttonChange[0] = Color.GREEN;
		}

		return buttonChange;
	}
	
	public void displayCorrectWord() {
		for (int index = 0; index < MAX_WORD_LENGTH; index++) {
			progress.setCharAt(index*2, correctWord.charAt(index));
		}
		Wordler_GUI.Progress.setText(progress.toString().toUpperCase());
	}

}
