package predictive;

/**
 * This class is mainly used to enter statements with parameters on the command
 * line and return the correct signature
 *  The program must accept a list of strings and call the appropriate method to
 *  do the conversion.
 * @Version 1.0
 * @Author:Mingrui Li 2087184 mxl991
 * @Date:2020/2/8
 * @Content:workshop
 */
public class Words2SigProto {
    /**
     * @param args The parameters you want to enter
     */
    public static void main(String[] args) {
        for (String a: args) {
            System.out.println(a + " : " + PredictivePrototype.wordToSignature(a));

        }
    }
}
