package Word_Filter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class PluralWords {

	public static void main(String[] args) throws IOException {
		
		File file = new File(
				"/Users/billytheredneck/eclipse-workspace/Wordler/Words For Wordler.txt");
		HashSet<String> plurals = new HashSet<>();

		BufferedReader br = new BufferedReader(new FileReader(file));

		String curr;
		while ((curr = br.readLine()) != null) {
			if(curr.matches("[a-z]{4}s")) 
			plurals.add(curr);
		}
		br.close();
		System.out.println("--------------TOP-----------------");
		for (String x : plurals) {
			System.out.println(x);
		}

	}

}
