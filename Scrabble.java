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
			try {
				reader.close();			
			} catch (Exception e) {}
		}
		for (String s : wordList) 
			System.out.println(s);
	}

	public String guessWord() {
		Random r = new Random();
		int index = r.nextInt(wordList.size());
		return wordList.get(index);
	}

	public static void main(String[] args) {
		Scrabble scrab = new Scrabble(4);
		System.out.println(scrab.guessWord());	
	}
}
