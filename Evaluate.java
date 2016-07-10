public class Evaluate {
	String DecidedWord;
	public Evaluate(String DecidedWord) {
		this.DecidedWord = DecidedWord;
	}
	public int evaluateGuess(String GuessedWord) {
		int count = 0;
		String GuessWord = removeDuplicate(GuessedWord);
		for(int i = 0;i < 5;i++) {
			if(this.DecidedWord.contains(Character.toString(GuessWord.charAt(i)))) {
				count++;
			}
		}
		return count;
	}
	public String removeDuplicate(String GuessedWord){
	    char[] process = GuessedWord.toCharArray();
	    for(int i= 0;i < 5;i++){
	    	for(int j = i+1 ; j < 5;j++) {
	    		if(process[i] == process[j]) {
	    			process[j] = ' ';
	    		}
	    	}
	    }
	    String newGuess = new String(process);
	    return newGuess;

	}
	public static void main(String args[]) {
		Evaluate MindGame = new Evaluate("divya");
		int result = MindGame.evaluateGuess("ddddd");
		System.out.println(result);
		
	}
}

