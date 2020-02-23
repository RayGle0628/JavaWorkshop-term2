package predictive;

import java.util.Set;

/**
 * @Version 1.0
 * @Author:Mingrui Li 2087184 mxl991
 * @Date:2020/2/18
 * @Content:workshop
 */
public class Sigs2WordsMap {
    public static void main(String[] args) {
        MapDictionary mapDictionary = new MapDictionary("/usr/share/dict/words");
        for (String s : args) {
            System.out.print(s + " : ");
            Set<String> set = mapDictionary.signatureToWords(s);
            for (String word : set) {
                System.out.print(word + " ");
            }
            System.out.println();
        }
    }
}
