package predictive;

/**
 * @Version 1.0
 * @Author:Mingrui Li 2087184 mxl991
 * @Date:2020/2/11
 * @Content:workshop
 */
import java.util.ArrayList;
import java.util.Collection;

public interface Dictionary {
    /**
     * The signatureToWords method must return all the words that correspond with a given signature.
     * All words are then returned in an ArrayList of Strings.
     * @param sig A String of numbers representing a numerical signature of a word.
     * @return An arrayList of type String containing all the words that correspond to the given sig.
     */
    public Collection<String> signatureToWords(String sig);
    /**
     wordToSigniture () takes a word and returns a digital signature
     If the word has any non-alphabetic characters, replace it with
     A " " (space) in the resulting string.
     This method uses bufferedString because it is more efficient
     More than just appending to a string. A string is an immutable object,
     Therefore, every time you append it, a new String object will be created
     and the old String object is left to the GC for use.
     It takes more time to create new objects than to change existing ones.
     bufferedString method creates only one object instead of creating new
     objects.
     *
     * @param word A String containing a single word.
     * @return A string representing the numeric signature of word.
     */
    public static String wordToSignature(String word) {
        word = word.toLowerCase();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            if (w == 'a' || w == 'b' || w == 'c') {
                sb.append('2');
            } else if (w == 'd' || w == 'e' || w == 'f') {
                sb.append('3');
            } else if (w == 'g' || w == 'h' || w == 'i') {
                sb.append('4');
            } else if (w == 'j' || w == 'k' || w == 'l') {
                sb.append('5');
            } else if (w == 'm' || w == 'n' || w == 'o') {
                sb.append('6');
            } else if (w == 'p' || w == 'q' || w == 'r' || w == 's') {
                sb.append('7');
            } else if (w == 't' || w == 'u' || w == 'v') {
                sb.append('8');
            } else if (w == 'w' || w == 'x' || w == 'y' || w == 'z') {
                sb.append('9');
            } else {
                return " ";
            }
        }
        return sb.toString();
    }
    /**
     * This method returns a boolean indicating that the given string is a valid word and
     * does not contain non-alphabetical characters.
     * I used  unicode to check 26 English letters, the range of English letters is 97-122.
     * @param word A string containing a single word.
     * @return A boolean indicating whether the word given is valid.
     */
     static boolean isValidWord(String word){
        word = word.toLowerCase();
        char check;
        for(int i=0; i<word.length(); i++){
            check = word.charAt(i);
            if((check<97 || check>122)){
                return false;
            }
        }
        return true;
    }

}

