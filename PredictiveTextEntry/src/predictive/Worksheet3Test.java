package predictive;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Version 1.0
 * @Author:Mingrui Li 2087184 mxl991
 * @Date:2020/2/9
 * @Content:workshop
 */
class Worksheet3Test {

    @org.junit.jupiter.api.Test
    void wordToSignature() {
        String expected = "4663";
        assertEquals(expected, PredictivePrototype.wordToSignature("home"),
                "fail in test");
    }
    @org.junit.jupiter.api.Test
    void wordToSignature2() {
        String word = "";
        String expected = "";
        assertEquals(expected, PredictivePrototype.wordToSignature(word),"fail in test");
    }
    @org.junit.jupiter.api.Test
    void wordToSignature3() {
        String word = " ";
        String expected = " ";
        assertEquals(expected, PredictivePrototype.wordToSignature(word),"fail in test");
    }
    @org.junit.jupiter.api.Test
    void signatureToWords() {
        HashSet<String> expected = new HashSet<>();
        expected.add("edee");
        expected.add("feff");
        expected.add("feed");
        expected.add("dede");
        expected.add("deed");
        expected.add("dedd");
        assertEquals(expected, PredictivePrototype.signatureToWords("3333"),
                "fail in test");
    }
    @org.junit.jupiter.api.Test
    void signatureToWords2() {
        String sig = "";
        HashSet<String> expected = new HashSet<String>();
        Set<String> result = PredictivePrototype.signatureToWords(sig);
        assertEquals(expected, result,"fail in test");
    }

    @org.junit.jupiter.api.Test
    void isValidWord1() {
        boolean expected = false;
        assertEquals(expected, PredictivePrototype.isValidWord("!!!!"),
                "fail in test");
    }

    @org.junit.jupiter.api.Test
    void isValidWord2() {
        boolean expected = true;
        assertEquals(expected, PredictivePrototype.isValidWord("home"),
                "fail in test");
    }

    @org.junit.jupiter.api.Test
    void compareTo1() {
        WordSig test = new WordSig("home", "2222");
        WordSig test2 = new WordSig("home", "1111");
        int result = test.compareTo(test2);
        int expected = 1;
        assertEquals(result, expected, "fail in test");
    }

    @Test
    public void compareTo2() {
        WordSig test = new WordSig("home", "1111");
        WordSig test2 = new WordSig("home", "2222");
        int result = test.compareTo(test2);
        int expected = -1;
        assertEquals(result, expected, "fail in test");
    }

    @Test
    public void compareTo3() {
        WordSig test = new WordSig("home", "111");
        WordSig test2 = new WordSig("home", "111");
        int result = test.compareTo(test2);
        int expected = 0;
        assertEquals(result, expected, "fail in test");
    }

    @org.junit.jupiter.api.Test
    void equals1() {
        boolean expected =true;
        WordSig test = new WordSig("hello", "123");
        WordSig test2 = new WordSig("home", "123");
        assertEquals(expected,test.equals(test2),"fail in test");
    }
    @Test
    public void equals2() {
        boolean expected =true;
        WordSig test = new WordSig("hello", "123");
        WordSig test2 = new WordSig("home", "123");
        assertEquals(expected,test.equals(test2),"fail in test");
    }
    @Test
    public void equals3() {
        boolean expected =false;
        WordSig test = new WordSig("hello", "123");
        WordSig test2 = new WordSig("home", "1233");
        assertEquals(expected,test.equals(test2),"fail in test");
    }
    @Test
    public void Words2SigProto() {
        System.out.println("Test the Words2SigProto Class :");
        Words2SigProto.main(new String[]{"home", "hello"});
    }
    @Test
    public void Sigs2WordsProto() {
        System.out.println("Test the Sigs2WordsProto Class:");
        Sigs2WordsProto.main(new String[]{"4663", "3333"});
    }
    @Test
    public void treetest1() {

        TreeDictionary t = new TreeDictionary("/usr/share/dict/words");

        Set<String> s = new TreeSet<String>();
        s.add("good");
        s.add("gnof");
        s.add("imme");
        s.add("inme");
        s.add("inod");
        s.add("inof");
        s.add("inoe");
        s.add("hooe");
        s.add("gooe");
        s.add("gonf");
        s.add("honf");
        s.add("gone");
        s.add("home");
        s.add("hone");
        s.add("hood");
        s.add("hoof");
        s.add("ioof");
        s.add("ione");
        s.add("inne");
        s.add("gome");
        s.add("gond");
        s.add("hond");
        s.add("goof");

        Set<String> expected1 = s;
        Set<String> actual1 = t.signatureToWords("4663");

        assertEquals(expected1, actual1);

    }

    // Testing wordToSignature method

    @Test
    public void treetest2() {
        TreeDictionary t = new TreeDictionary("/usr/share/dict/words");

        String expected1 = "4663";
        String actual1 = TreeDictionary.wordToSignature("home");

        String expected2 = "4663";
        String actual2 = TreeDictionary.wordToSignature("home");

        String expected3 = "5282";
        String actual3 = TreeDictionary.wordToSignature("java");

        String expected4 = "33278279";
        String actual4 = TreeDictionary.wordToSignature("february");

        String expected5 = "22233344";
        String actual5 = TreeDictionary.wordToSignature("abcdefgh");

        String expected6 = "5268279";
        String actual6 = TreeDictionary.wordToSignature("JANUARY");



        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
        assertEquals(expected5, actual5);
        assertEquals(expected6, actual6);

    }

    // Testing isValidWord() method

    @Test
    public void treetest3() {
        TreeDictionary t = new TreeDictionary("/usr/share/dict/words");

        boolean expected1 = false;
        boolean actual1 = TreeDictionary.isValidWord("home!!!");

        boolean expected2 = true;
        boolean actual2 = TreeDictionary.isValidWord("home");

        boolean expected3 = false;
        boolean actual3 = TreeDictionary.isValidWord("   java");

        boolean expected4 = true;
        boolean actual4 = TreeDictionary.isValidWord("abcdefhijklmnop");

        boolean expected5 = true;
        boolean actual5 = TreeDictionary.isValidWord("JANUARY");

        boolean expected6 = false;
        boolean actual6 = TreeDictionary.isValidWord("/';['");

        boolean expected7 = false;
        boolean actual7 = TreeDictionary.isValidWord("]\'jki[]");

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
        assertEquals(expected5, actual5);
        assertEquals(expected6, actual6);
        assertEquals(expected7, actual7);
    }
    

    @Test
    public void test2() {
        MapDictionary usr = new MapDictionary("/usr/share/dict/words");
        String expected1 = "4663";
        String actual1 = MapDictionary.wordToSignature("home");

        String expected2 = "4663";
        String actual2 = MapDictionary.wordToSignature("home");

        String expected3 = "5282";
        String actual3 = MapDictionary.wordToSignature("java");

        String expected4 = "33278279";
        String actual4 = MapDictionary.wordToSignature("february");

        String expected5 = "22233344";
        String actual5 = MapDictionary.wordToSignature("abcdefgh");

        String expected6 = "5268279";
        String actual6 = MapDictionary.wordToSignature("JANUARY");



        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
        assertEquals(expected5, actual5);
        assertEquals(expected6, actual6);

    }

    // Testing isValidWord() method

    @Test
    public void test3() {
        MapDictionary usr = new MapDictionary("/usr/share/dict/words");
        boolean expected1 = false;
        boolean actual1 = MapDictionary.isValidWord("home!!!");

        boolean expected2 = true;
        boolean actual2 = MapDictionary.isValidWord("home");

        boolean expected3 = false;
        boolean actual3 = MapDictionary.isValidWord("   java");

        boolean expected4 = true;
        boolean actual4 = MapDictionary.isValidWord("abcdefhijklmnop");

        boolean expected5 = true;
        boolean actual5 = MapDictionary.isValidWord("JANUARY");

        boolean expected6 = false;
        boolean actual6 = MapDictionary.isValidWord("/';['");

        boolean expected7 = false;
        boolean actual7 = MapDictionary.isValidWord("]\'jki[]");

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
        assertEquals(expected5, actual5);
        assertEquals(expected6, actual6);
        assertEquals(expected7, actual7);
    }
}