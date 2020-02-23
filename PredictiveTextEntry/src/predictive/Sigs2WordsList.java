package predictive;

/**
 * @Version 1.0
 * @Author:Mingrui Li 2087184 mxl991
 * @Date:2020/2/11
 * @Content:workshop
 */


import java.util.ArrayList;


public class Sigs2WordsList {
    public static void main(String[] args) {
        ListDictionary listdictionary = new ListDictionary();
        for (String s : args) {
            System.out.print(s + " : ");
            ArrayList<String> arrayList =
                    (ArrayList<String>) listdictionary.signatureToWords(s);
            for (String word : arrayList) {
                System.out.print(word + " ");
            }
            System.out.println();
        }
    }

}

