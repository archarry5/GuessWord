public class Scrabble {
	String word;
	int level;
	Arraylist<String> wordList;	

	public Scrabble(int level) {
		this.level = level;
		wordList = new ArrayList<String>();
	}
	
	public void createWordList(int size) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("/home/administrator/GitRepo/GuessWord/sowpods"));
			String word = "";
			while ((word = reader.readLine()) != null) {
				if (word.length() == level) {
					wordList.add(word);
				}			
			} 
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				reader.close();			
			}
		}
	}
}
