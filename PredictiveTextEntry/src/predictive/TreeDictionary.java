package predictive;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


/**
 * Class TreeDictionary is another improved implementation of the Dictionary
 * interface, using a tree structure instead of Map and List structures as we
 * have done previously. This implementation allows words or parts of words that
 * match partial signatures (prefixes), so users will be able to see the parts
 * of the words they are typing as they type. TreeDictionary stores the
 * dictionary as a TreeDictionary implementation of 8 branches (corresponding to
 * numbers/buttons 2-9 on a phone keypad).
 * <p>
 * At each node of the tree a collection of all words that can match the partial
 * signature are stored. Every word that has a prefix corresponding to the
 * partial signature appears in the collection.
 * <p>
 * Private variables TreeDictionary 'nodes', Set of type String 'dictionary',
 * and Set of type String 'charMatching' are declared.
 *
 * @author Mingrui Li
 * @version 1.0
 */

public class TreeDictionary implements Dictionary {

    private TreeDictionary[] nodes = new TreeDictionary[8];
    private Set<String> dictionary = new HashSet<>();
    private Set<String> charMatching = new HashSet<>();

    /**
     * Constructor for TreeDictionary which populates the nodes of the tree and
     * initializes them to 'null'.
     */

    public TreeDictionary() {
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = null;
        }
    }

    /**
     * Constructor for TreeDictionary takes a path of type String for the dictionary
     * file to be read. Buffered Reader is used to read the file. While there are
     * still valid words in the dictionary, the method converts them into signatures
     * and extracts the individual numbers to locate the position in the array (we
     * use the actual value (which could be between 2-9) minus 2 as the array
     * indices are (0-7).
     *
     * @param path of type String which is the path to the dictionary file
     */
    public TreeDictionary(String path) {

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new TreeDictionary();
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String word = br.readLine();

            while (word != null) {

                if (isValidWord(word)) {
                    String signature = wordToSignature(word);

                    // characterVal = converting the first character from the signature to an int
                    int characterVal = Integer.parseInt(signature.substring(0, 1));
                    // adding the corresponding characterVal to the tree
                    nodes[characterVal - 2].addToNode(word.toLowerCase(), 1);

                }
                word = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file to open.");
        } catch (IOException ex) {
            System.out.println("IOException");
        }
    }

    /**
     * wordToSigniture () takes a word and returns a digital signature
     * If the word has any non-alphabetic characters, replace it with
     * A " " (space) in the resulting string.
     * This method uses bufferedString because it is more efficient
     * More than just appending to a string. A string is an immutable object,
     * Therefore, every time you append it, a new String object will be created
     * and the old String object is left to the GC for use.
     * It takes more time to create new objects than to change existing ones.
     * bufferedString method creates only one object instead of creating new
     * objects.
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
     * Recursive method 'addToNode' extracts each individual signature value/number and
     * creates respective nodes to hold the prefixes. If the node is empty, a new
     * node is created. Words are added to the dictionary Set of type String for
     * matching prefixes to be returned through the signatureToWords method.
     *
     * @param word of type String is the word to be added to the node
     * @param val  the respective signature value to be added to the node
     */

    public void addToNode(String word, int val) {
        String signature = wordToSignature(word);
        dictionary.add(word); // add word to my dictionary

        // base case - terminate when the value exceeds the length of the word
        if (val < word.length()) {

            int characterVal = Integer.parseInt(signature.substring(val, val + 1)); // retrieve signature value
            val++;

            // if the node is empty populate it with a new TreeDictionary
            if (nodes[characterVal - 2] == null) {
                nodes[characterVal - 2] = new TreeDictionary();
            }

            nodes[characterVal - 2].addToNode(word, val);
        }

    }

    /**
     * Recursive method signatureToWordsHelper returns a Set of type String
     * 'charMatching' which contains all of the words with the correct prefixes
     * (matching characters). The method on its own will return all potential words
     * that match the prefix (regardless of size).
     *
     * @param signature of type String which is the signature to find all potential
     *                  matching words
     * @return returns 'charMatching' a Set of type String which contains all
     * potential words.
     */

    public Set<String> signatureToWordsHelper(String signature) {

        if (signature.isEmpty()) {
            return dictionary;
        } else {
            int characterVal = Integer.parseInt(signature.substring(0, 1));
            charMatching = nodes[characterVal - 2].signatureToWordsHelper(signature.substring(1));
            return charMatching;

        }
    }

    /**
     * Method signatureToWords is overridden from the Dictionary interface
     * implementation. It trims all the potential words down to size and returns the
     * matching prefixes of correct length.
     *
     * @param signature of type String which is the signature to find all potential
     *                  matching words
     * @return returns 'trimMatching' a Set of type String which contains all
     * matching prefixes.
     */

    @Override
    public Set<String> signatureToWords(String signature) {
        Set<String> trimMatching = new HashSet<>();
        int max = signature.length();

        signatureToWordsHelper(signature).forEach(el -> trimMatching.add(el.substring(0, max)));
        return trimMatching;

    }

    /**
     * This method returns a boolean indicating that the given string is a valid word and
     * does not contain non-alphabetical characters.
     * I used  unicode to check 26 English letters, the range of English letters is 97-122.
     *
     * @param word A string containing a single word.
     * @return A boolean indicating whether the word given is valid.
     */
    protected static boolean isValidWord(String word) {
        word = word.toLowerCase();
        char check;
        for (int i = 0; i < word.length(); i++) {
            check = word.charAt(i);
            if ((check < 97 || check > 122)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeDictionary tr = new TreeDictionary("/usr/share/dict/words");
        System.out.println(tr.signatureToWords("4"));
        System.out.println(tr.signatureToWords("40"));
        System.out.println(tr.signatureToWords("406"));
        System.out.println(tr.signatureToWords("4063"));
    }
}

