
public class TestCode {
	public static void main(String args[]) {
		Scrabble MindGame = new Scrabble(4);
		String DecidedWord = args[0];
		int result = 0;
		String Guess = " ";
		while (result != 5) {
			Guess = MindGame.guessWord();
			result = MindGame.evaluateGuess(DecidedWord,Guess);
			MindGame.updateList(Guess, result);
			if(MindGame.Won) {
				break;
			}
		}
		System.out.println(result);
		System.out.println(MindGame.guessWord());
		System.out.println("Won the game");
	}
}

