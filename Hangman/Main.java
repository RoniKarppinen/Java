import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* Creating a scanner object, getting the words from the "words.txt -file with the WordList object and creating Hangman -object." */
        Scanner input = new Scanner(System.in);
        WordList words = new WordList("words.txt");
        Hangman hangman = new Hangman(words, 5);
        // Main
        while(!hangman.theEnd() && hangman.guessesLeft() > 0) {
            System.out.println("The hidden word... \n");
            for(int i = 0; i < hangman.word().length(); i++) {
                if (hangman.correctguesses().contains(hangman.word().charAt(i))) {
                    System.out.print(hangman.word().charAt(i));
                } else {
                    System.out.print("*");
                }
            }
            System.out.println("\n");
            System.out.print("Guesses left: ");
            System.out.print(hangman.guessesLeft() + "\n");
            System.out.print("Guessed letters: ");
            System.out.print(hangman.guesses() + "\n");
            System.out.println("Guess a letter: ");
            String guess = input.next().toLowerCase();
            if(guess.length() == 1) {
                char c = guess.charAt(0);
                hangman.guess(c);
            } else {
                System.out.println("Please type just a one letter.");
            }
        // After the necessary things are printed, the actual game starts and gameResult -method will print the outcome of the game.
        System.out.println(hangman.gameResult());
        input.close();
        }
    }
}