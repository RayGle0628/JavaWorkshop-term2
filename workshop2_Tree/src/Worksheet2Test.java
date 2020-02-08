import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

/** @author
 *  <MINGRUI LI>
 * This class contains the test cases for Worksheet2 solutions.
 *  <WRITE YOUR TEST CASES BELOW>
 */

class Worksheet2Test {

    @org.junit.jupiter.api.Test
    void negateAll() {
        Tree expected = new Tree(-10,new Tree(-11),new Tree(-9));
        Tree actual = new Tree(10,new Tree(9),new Tree(11));
        assertEquals(expected,Worksheet2.negateAll(actual),"fail in test");
    }

    @org.junit.jupiter.api.Test
    void allEven() {
        boolean expected = false;
        Tree actual = new Tree(10,new Tree(9),new Tree(11));
        assertEquals(expected,Worksheet2.allEven(actual),"fail in test");
    }

    @org.junit.jupiter.api.Test
    void depth() {
        int expected = 1;
        Tree actual = new Tree(10,new Tree(9),new Tree(11));
        assertEquals(expected,Worksheet2.depth(actual,9),"fail in test");
    }

    @org.junit.jupiter.api.Test
    void preorder() {
        Tree t1 = new Tree(10,new Tree(9),new Tree(11));
        List expected = new List(10,new List(9,new List(11,new List())));
        assertEquals(expected,Worksheet2.preorder(t1),"fail in test");
    }

    @org.junit.jupiter.api.Test
    void isSearchTree() {
        boolean expected = true;
        Tree actual = new Tree(10,new Tree(9),new Tree(11));
        assertEquals(expected,Worksheet2.isSearchTree(actual),"fail in test");
    }

    @org.junit.jupiter.api.Test
    void max() {
        Tree<Integer> t1 = new Tree<>(10,new Tree<>(5,new Tree<>(2),new Tree<>(7)),
                new Tree<>(17, new Tree<>(15),new Tree<>(20)));
        int expected = 20;
        assertEquals(expected,Worksheet2.max(t1),"fail in test");
    }

    @org.junit.jupiter.api.Test
    void delete() {
        Tree<Integer> t1 = new Tree(10,new Tree(9),new Tree(11));
        Tree<Integer> expected = new Tree(10,new Tree(9),new Tree());
        assertEquals(expected,Worksheet2.delete(t1,11),"fail in test");
    }

    @org.junit.jupiter.api.Test
    void isHeightBalanced() {
        Tree<Integer> t1 = new Tree<>(10,new Tree<>(5,new Tree<>(2),new Tree<>(7)),
                new Tree<>(17, new Tree<>(15),new Tree<>(20)));
        boolean expected = true;
        assertEquals(expected,Worksheet2.isHeightBalanced(t1),"fail in test");
    }

    @org.junit.jupiter.api.Test
    void insertHB() {
        Tree<Integer> t1 = new Tree<>(10,new Tree<>(5,new Tree<>(2),new Tree<>(7)),
                new Tree<>(17, new Tree<>(15),new Tree<>()));
        Tree<Integer> expected = new Tree<>(10,new Tree<>(5,new Tree<>(2),
                new Tree<>(7)),
                new Tree<>(17, new Tree<>(15),new Tree<>(20)));
        assertEquals(expected,Worksheet2.insertHB(t1,20),"fail in test");
    }

    @org.junit.jupiter.api.Test
    void deleteHB() {
        Tree<Integer> t1 = new Tree<>(10,new Tree<>(5,new Tree<>(2),
                new Tree<>(7)),
                new Tree<>(17, new Tree<>(15),new Tree<>(20)));
        Tree<Integer> expected = new Tree<>(10,new Tree<>(5,new Tree<>(2),
                new Tree<>(7)),
                new Tree<>(17, new Tree<>(15),new Tree<>()));
        assertEquals(expected,Worksheet2.deleteHB(t1,20),"fail in test");
    }
}