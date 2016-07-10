public class Scrabble {
	String word;
	int level;
	Arraylist<String> wordList;	

	public Scrabble(int level) {
		this.level = level;
		wordList = new ArrayList<String>();
	}
	
	public void createWordList(int size) {
		BufferedReader buffReader = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader("/home/administrator/GitRepo/GuessWord/sowpods"));
			String word = "";
			while ((word = reader.readLine()) != null) {
				if (word.length() == level) {
					wordList.add(word);
				}			
			} 
		}
	}
}
