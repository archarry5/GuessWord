import java.util.*;
public class TestCode {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter word size u want to play..");
		int wordSize = sc.nextInt(); 
		Scrabble scrabble = new Scrabble(wordSize);
		scrabble.chooseWord();
		while (!scrabble.gameWon) {
			String compGuess = scrabble.guessWord();			
			System.out.println(compGuess + "\n Enter no. of char matched -1 if word is guessed correct");
			int compResult = sc.nextInt();
			if (compResult == -1) {
				System.out.println("Computer Won");
				break;
			}
			scrabble.updateList(compGuess, compResult);
			System.out.println("Your turn to guess..");
			String userGuess = sc.next();
			int userResult = scrabble.evaluateGuess(userGuess);
			if (userResult == -1)
				System.out.println("You Won");
			else
				System.out.println(userResult+ " character matched");
			
		}
/*
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
		System.out.println("Won the game"); */
	}
}
