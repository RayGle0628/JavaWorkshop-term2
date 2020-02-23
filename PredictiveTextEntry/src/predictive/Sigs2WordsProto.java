package predictive;

import java.util.Collection;

/**This class is mainly used to enter statements with parameters on the command
 * Line and return possibly related words
 * The program must accept a list of parameters and call the appropriate
 * method to do the conversion
 *
 * @Version 1.0
 * @Author:Mingrui Li 2087184 mxl991
 * @Date:2020/2/8
 * @Content:workshop
 */
public class Sigs2WordsProto {
    /**
     * @param args The parameters you want to enter
     */
    public static void main(String[] args) {
        for (String s: args) {
            System.out.print(s + " : " );
            Collection<String> list = PredictivePrototype.signatureToWords(s);
            for(String word:list){
                System.out.print(word + " ");
            }
            System.out.println("");
        }
    }
}
