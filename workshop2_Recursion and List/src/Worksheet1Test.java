import jdk.nashorn.internal.ir.LiteralNode;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/**
  @author
 *  <>
 * This class contains the test cases for Worksheet1 solutions.
 *  <WRITE YOUR TEST CASES BELOW>
 */

class Worksheet1Test {

    @Test
    void power() {
        int expected =4 ;
        assertEquals(expected,Worksheet1.power(2,2),"fail in test");
    }

    @Test
    void fastPower() {
        int expected =16 ;
        assertEquals(expected,Worksheet1.power(2,4),"fail in fastpower test");
    }

    @Test
    void negateAll() {
        List<Integer> expected = new List<Integer>(-2,new List<Integer>(5,
                new List<Integer>(-8,new List<>(0,new List<>()))));
        List a = new List(2,new List<Integer>(-5,
                new List<Integer>(8,new List<>(0,new List<>()))));
        assertEquals(expected,Worksheet1.negateAll(a),"fail in test");
    }

    @Test
    void find() {
        int expected =2 ;
        List a = new List(2,new List<Integer>(-5,
                new List<Integer>(8,new List<>(0,new List<>()))));
        assertEquals(expected,Worksheet1.find(8,a),"fail in test");
    }

    @Test
    void allEven() {
        boolean expected = false;
        List<Integer> a = new List<Integer>(-2,new List<Integer>(5,
                new List<Integer>(-8,new List<>(0,new List<>()))));
        assertEquals(expected,Worksheet1.allEven(a),"fail in test");
    }

    @Test
    void evenNumbers() {
        List<Integer> expected = new List<Integer>(-2,new List<Integer>(10,
                new List<Integer>(-8,new List<>(0,new List<>()))));
        List a = new List(-2,new List<Integer>(10,
                new List<Integer>(-8,new List<>(0,new List<>()))));
        assertEquals(expected,Worksheet1.evenNumbers(a),"fail in test");
    }

    @Test
    void sorted() {
      boolean expected = false;
        List a = new List(-2,new List<Integer>(10,
                new List<Integer>(-8,new List<>(0,new List<>()))));
        assertEquals(expected,Worksheet1.sorted(a),"fail in test");
    }

    @Test
    void merge() {
        List<Integer> expected = new List<Integer>(9,new List<Integer>(7,
                new List<Integer>(7,new List<>(4,new List<>(3,new List<>())))));
        List a = new List(7,new List<Integer>(7,
                new List<Integer>(4,new List<>(3,new List<>()))));
        List b = new List(9,new List());
        assertEquals(expected,Worksheet1.merge(a,b),"fail in test");
    }

    @Test
    void removeDuplicates() {
        List<Integer> expected = new List<Integer>(-2,new List<Integer>(10,
                new List<Integer>(-8,new List<>(0,new List<>()))));
        List<Integer> a = new List<Integer>(-2,new List<Integer>(10,
                new List<Integer>(10,
                        new List<>(-8,new List<>(0,new List<>())))));
        assertEquals(expected,Worksheet1.removeDuplicates(a),"fail in test");
    }
}