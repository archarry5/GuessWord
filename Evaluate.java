public class Evaluate {
	String word;
	public Evaluate(String word) {
		this.word = word;
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

	public static void main(String args[]) {
		Evaluate MindGame = new Evaluate("divya");
		int result = MindGame.evaluateGuess("ddddd");
		System.out.println(result);
		
	}

}

