import java.util.*;
import java.io.*;
public class Scrabble {
	String word;
	int wordSize;
	ArrayList<String> wordList;	

	public Scrabble(int wordSize) {
		this.wordSize = wordSize;
		wordList = new ArrayList<String>();
		createWordList(wordSize);
		updateList("vwxyz", 0);
	}
	
	public void createWordList(int size) {
		Scanner reader = null;
		try {
			reader = new Scanner(new File("/home/administrator/GitRepo/GuessWord/sowpods"));
			String word = "";
			while ((word = reader.nextLine()) != null) {
				if (word.length() == wordSize) {
					wordList.add(word);
				}			
			} 
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			reader.close();			
		}
		for (String s : wordList) 
			System.out.println(s);
	}

	public String guessWord() {
		Random r = new Random();
		int index = r.nextInt(wordList.size());
		return wordList.get(index);
	} 

	public int evaluateGuess(String guess) {
		int count = 0;
		guess = removeDuplicate(guess);
		for(int i = 0;i < guess.length(); i++) {
			char c = guess.charAt(i);
			
			if (word.contains(guess.charAt(i) + "" )) {
				count++;
			}
		}
		return count;
	}
	
	public String removeDuplicate(String word){
	    char[] processed = word.toCharArray();
	    for(int i = 0; i < word.length(); i++){
	    	for(int j = i+1 ; j < word.length(); j++) {
	    		if(processed[i] == processed[j]) {
	    			processed[j] = ' ';
	    		}
	    	}
	    } 
	    return new String(processed);
	}

	public void updateList(String guess, int count) {
		guess = removeDuplicate(guess);
		if (count == 0) {
			//remove all words with chars in string guess
			for (char c : guess.toCharArray()) {
				for (int i = 0; i < wordList.size(); i++) {
					String word = wordList.get(i);					
					if (word.contains(c + ""))
						wordList.set(i,"");
				}
				wordList.removeAll(Arrays.asList(""));
			} 
			for (String word : wordList) 
				System.out.println(word);
		} else if (count == wordSize) {
			// remove all words who donot hv even 1 of the above chars
			char[] ascendingGuess = guess.toCharArray();
			Arrays.sort(ascendingGuess);
			for (int i = 0; i < wordList.size(); i++) {
				char[] wordArr = word.toCharArray();
				Arrays.sort(wordArr);			
				if (!Arrays.equals(wordArr, ascendingGuess))
					wordList.set(i,"");
			}
			wordList.removeAll(Arrays.asList(""));
		}
		else {
			//remove all words who donot hv any of these characters
			int[] countMissedLett = new int[wordList.size()];
			for (int i = 0; i < wordList.size(); i++) {
				String word = wordList.get(i);					
				for (char c : guess.toCharArray()){									
					if (!word.contains(c + "")) {
						countMissedLett[i]++;				
					}
				}
				if (countMissedLett[i] == wordSize)						
					wordList.set(i,"");	
			}
			wordList.removeAll(Arrays.asList(""));
		}
	}

	public static void main(String[] args) {
		Scrabble scrab = new Scrabble(4);
		System.out.println(scrab.guessWord());	
	}
}
