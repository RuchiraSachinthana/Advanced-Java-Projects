import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author Keenal
 * COP 4027 Advanced Computer Programming
 * Project 3
 * 
 * This is action class for Spell Menu. it opens the file, reads through each word, hashes it onto a table and uses that map to find 
 * corrections to the words from the input file. 
 */

public class SpellCheck{

	String line;
	int lineNum = 0;
	String[] word;
	StringBuilder compareWord;
	char[] letter = {'a', 'b','c','d','e','f','g','h',
			'i','j','k','l','m','n','o', 'p','q','r',
			's','t','u','v','w','x','y','z'};
	String checkWord;
	
	HashMap<String, Integer> hmap = new HashMap<String, Integer>();
	
	//read Words.txt and store it into a HashMap
	public void openFile(String wordfilename){
		String[] word;
		try{	
			BufferedReader read = new BufferedReader(new FileReader(wordfilename));
			
			while((line = read.readLine()) != null){
				hmap.put(line, lineNum);
				lineNum++;
			}
			read.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
			
	}
	
	
	//split string
	public void splitString(String testLine){

		word = testLine.split("\\ |\\, |\\.");
		
		for(int i = 0; i < word.length; i++){
			checkWord = word[i].toLowerCase();
	
		if(!hmap.containsKey(checkWord)){
			//add one more letter to check if the word is missing a letter
			for(int j =0; j<letter.length; j++){
				compareWord = new StringBuilder(checkWord + letter[j]);
				
			//	System.out.println(compareWord);
				
				if(hmap.containsKey(compareWord.toString())){
			//		System.out.println("BETWEEEEN");
					
					if(compareWord.toString().length() >= 2){
						System.out.println(checkWord + " is misspelled.");
						System.out.println("Change it to: " + compareWord.toString() + "\n");
				//		System.out.println("between read");
					}
				}
			}
			
			// cut one letter at a time
			for(int i11 = 0; i11 < checkWord.length(); i11++){
				compareWord = new StringBuilder(checkWord);
				compareWord = compareWord.deleteCharAt(i11);
				
				if(hmap.containsKey(compareWord.toString())){
					if(compareWord.toString().length() >= 2){
						System.out.println(checkWord + " is misspelled.");
						System.out.println("Change it to: " + compareWord.toString() + "\n");
					}
				}
			}
			
			
			//swap letters to check in hashmap to see if the word exist
			for(int k = 0; k < checkWord.length()-1; k++){
				char[] check = checkWord.toCharArray();
				
				char temp = check[k];
				check[k] = check[k+1];
				check[k+1] = temp;
				
				String newcompareWord = new String(check);
				// System.out.println("WOKRING YET?");
				if(hmap.containsKey(newcompareWord)){
					if(newcompareWord.toString().length() >= 2){
						System.out.println(checkWord + " is misspelled.");
						System.out.println("Change it to: " + newcompareWord.toString() + "\n");
						}
					}
				}
			}	
		}
	}
}
	
	

