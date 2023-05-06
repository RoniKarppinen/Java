import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class WordList {
    // Attributes
    private List<String> words = new ArrayList<String>();
    // Constructors
    public WordList(String filename) {
        try {
            Scanner wordreader = new Scanner(new File(filename));
            while(wordreader.hasNextLine()) {
                String scannerstring = wordreader.nextLine().toLowerCase();
                if(scannerstring != null) {
                    words.add(scannerstring);
                }
            }
            wordreader.close();
        } catch (FileNotFoundException exception) {
            System.out.println("File was not found, check the file name and try again.");
        }
    }
    public WordList(List<String> words) {
        this.words = words;
    }
    // Methods
    /* The method returns words of the wordlist. */
    public List<String> giveWords() {
        return words;
    }

    /* Bonus method, The method returns a new WordList object with only the words whose length corresponds to the value of
    the variable given as a parameter.  */
    public WordList theWordsOfLength(int length) {
        List<String> SameLengthWords = new ArrayList<>();
        for(int i = 0; i < words.size(); i++) {
            if(words.get(i).length() == length) {
                SameLengthWords.add(words.get(i));
            }
        }
        return new WordList(SameLengthWords);
    }

    /*The method returns a new WordList object with only the words with the letters in the exact positions
    specified in the given string (and matching the length of that given string).
    For example, the given string is in the format _a_e_ (matching words would be for example camel or panel)
    where the lines represent any letter and other letters must be in the given positions in the word. */
    public WordList theWordsWithCharacters(String someString) {
        List<String> equalCharacterWords = new ArrayList<>();
        int stringLength = someString.length();
        for (String current : words) {
            boolean compatible = true;
            if (stringLength == current.length()) {
                for (int i = 0; i < stringLength; i++) {
                    char c = someString.charAt(i);
                    if (c != '_' && c != current.charAt(i)) {
                        compatible = false;
                        break;
                    }
                }
                if (compatible) {
                    equalCharacterWords.add(current);
                }
            }
        }
        return new WordList(equalCharacterWords);
    }
}
