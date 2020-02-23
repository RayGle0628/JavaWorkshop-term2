package predictive;

import predictive.MapDictionary;

import java.util.Set;
/**
 *
 * Class 'Sigs2WordsTree' is a command line program calling the signatureToWords
 * method. It accepts a list of Strings from the command line and calls the
 * signatureToWords method to do the conversion of signature to words.
 *
 * See 'Timings.html' for more detail on timings of programs.
 *
 * @author Mingrui li
 * @version 1.0
 */

public class Sigs2WordsTree {

    public static void main(String[] args) {

        MapDictionary t = new MapDictionary("/usr/share/dict/words");

        for (String s : args) {
            System.out.print(s + " : ");

            Set<String> matching = (Set<String>) t.signatureToWords(s);

            for (String word : matching) {
                System.out.print(word + " ");
            }
            System.out.println();

        }
    }
}

