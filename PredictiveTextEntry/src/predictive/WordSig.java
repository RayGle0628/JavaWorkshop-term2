package predictive;

/**
 * Create a class which pairs the numeric signatures with words,
 * When we read the dictionary you will need to create new WordSig objects.
 *
 * @Version 1.0
 * @Author:Mingrui Li 2087184 mxl991
 * @Date:2020/2/9
 * @Content:workshop
 */
public class WordSig implements Comparable<WordSig> {
    private String signature;
    private String word;

    /**
     * Constructor
     * Construct a WordSig object containing a single string of word.
     *
     * @param word A string containing a single word.
     */
    public WordSig(String word) {
        this.word = word;
        this.signature = PredictivePrototype.wordToSignature(word);
    }

    /**
     * Constructor
     * Construct a WordSig object containing a pair of strings:
     * Word and corresponding signature.
     *
     * @param word      A string containing a single word.
     * @param signature the signature correspond to the word.
     */
    public WordSig(String word, String signature) {
        this.word = word;
        this.signature = signature;
    }

    /**
     * getters
     * Returns a String of the word contained in WordSig Object
     *
     * @return A String word
     */
    public String getWord() {
        return word;
    }

    /**
     * Returns a String of the signature contained in the WordSig Object
     *
     * @return A String of signature
     */
    public String getSignature() {
        return signature;
    }

    /**
     * Compare this WordSig signature with the specified WordSig signature.
     * Returns 1, 0, -1, because the signature of this WordSig is greater than, equal to or equal to
     * less than Specified WordSig signature.
     *
     * @Param wordSig A WordSig object we need to compare.
     * @Return A -1, 0, 1, because the signature of this WordSig is less than, equal to or greater than
     * Specified WordSig signature.
     **/

    public int compareTo(WordSig ws) {

        if (this.signature.length() > ws.signature.length()) {
            return 1;
        } else if (this.signature.length() < ws.signature.length()) {
            return -1;
        } else {
            return this.signature.compareTo(ws.signature);
        }

    }

    /**
     * This method returns  string pair includes the word and signature of the
     * WordSig Object.
     * EXAMPLE: "aaa : 222"
     */
    @Override
    public String toString() {
        return word + " : " + signature;
    }

    /**
     * Compares this WordSig's signature with given WordSig's signature.
     * Returns true if the two signatures are the same.
     *
     * @param given A WordSig Object we want to compare
     * @return If signatures of this equals the given, returns true, else false.
     */
    public boolean equals(WordSig given) {
        if ((this.signature.equals(given.signature))) {
            return true;
        }
        return false;
    }
}
