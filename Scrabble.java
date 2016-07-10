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

	public void updateList(String guess, int count) {
		if (count == 0) {
			//remove all words with chars in string guess
			for (char c : guess.toCharArray()) {
				ArrayList<String> copyOfList = ()wordList.clone();
				for (String word : copyOfList) {
					if (word.contains(c + ""))
						wordList.remove(word);
				}
			}
			for (String word : wordList) 
				System.out.println(word);
		} else if (count == wordSize) {
			// remove all words who donot hv even 1 of the above chars
		}
		else {
			//remove all words who donot hv any of these characters
		}
	}

	public static void main(String[] args) {
		Scrabble scrab = new Scrabble(4);
		System.out.println(scrab.guessWord());	
	}
}
