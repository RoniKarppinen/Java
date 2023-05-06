import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hangman {
    // Attributes
    private String word;
    private int remainingGuesses;
    private List<Character> guessedCharacters = new ArrayList<>();
    private List<Character> correctCharacters = new ArrayList<>();
    // Constructors
    public Hangman(WordList list, int attempts) {
        this.remainingGuesses = attempts;
        Random random = new Random();
        List<String> words = list.giveWords();
        if (words.size() > 0) {
            this.word = words.get(random.nextInt(words.size()));
        }
    }
    // Methods
    /* The method compares the character entered as a parameter to the word being guessed and adds the guess
    to the list of guesses. If the character is found in the word being guessed, the method will return true. If
    character is not found from the word being guessed, the number of guesses is reduced by one and the
    method will return false. */
    public boolean guess(Character c) {
        boolean result = false;
        if(!guessedCharacters.contains(Character.toLowerCase(c))) {
            guessedCharacters.add(Character.toLowerCase(c));
        }
        if(word.contains(Character.toString(Character.toLowerCase(c)))) {
            correctCharacters.add(Character.toLowerCase(c));
            result = true;
        } else {
            remainingGuesses--;
        }
        return result;
    }

    /*The method returns the guesses made (as a List of Character objects). Each character should be in the list
    only once (even if the user has guessed the same character several times). */
    public List<Character> guesses() {
        return guessedCharacters;
    }

    /*The method returns the number of remaining guesses. Note, must not be negative. */
    public int guessesLeft() {
        if(remainingGuesses >= 0) {
            return remainingGuesses;
        }
        return 0;
    }

    /*The method returns the list of correct guesses, it will be used in Main class. Own method. */
    public List<Character> correctguesses() {
        return correctCharacters;
    }

    /*The method returns the selected word (unmasked, i.e., as read from the file). */
    public String word() {
        return word;
    }

    /* The method indicates whether the game is over or not. The game ends if all the letters in the word are
    guessed correctly */
    public boolean theEnd() {
        boolean result = false;
        for(int i = 0; i < word.length(); i++) {
            if(!correctCharacters.contains(word.charAt(i))) {
                result = false;
                break;
            }
            result = true;
        }
        if(guessesLeft() == 0) {
            result = true;
        }
        return result;
    }

    /* The method prints the winning or losing message according to the game result.
    The game result is determined by checking if the correctCharacter -list contains all the correct letters.
    Own method.*/
    public String gameResult() {
        char[] characters = word.toCharArray();
        for(int i = 0; i < characters.length; i++) {
            char c = characters[i];
            if(!correctCharacters.contains(c)) {
                StringBuilder sb = new StringBuilder();
                sb.append("You lost the game, correct word was ").append(word());
                return sb.toString();
            }
        }
    StringBuilder sb = new StringBuilder();
    sb.append("Congratulations, you won the game and guessed the word correctly, the word was ").append(word());
    return sb.toString();
    }
}
