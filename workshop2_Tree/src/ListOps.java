/**
 * @Version 1.0
 * @Author:RayGle
 * @Date:2020/1/31
 * @Content:workshop
 */



/**
 * The class ListOps defines a number of static methods to work with
 * lists using the List class.
 */
public class ListOps {

    /**
     * Select and return the nth element of a list a.  Assume that the
     * nth element exists.
     */

    public static int select(int n, List a) {
        if (a.isEmpty())
            throw new IllegalArgumentException(
                    "select - list does not have enough elements.");
        else if (n == 0)
            return (int) a.getHead();
        else
            return select(n-1, a.getTail());
    }

    /**
     * Return the last element of list a.  Assume that theres is an element.
     */

    public static int last(List<Integer> a) {
        if (a.isEmpty())
            throw new IllegalArgumentException(
                    "list does not have any elements.");
        else if (a.getTail().isEmpty())
            return a.getHead();
        else
            return last(a.getTail());
    }

    /**
     * Add an element x to the end of a list a.
     * Return the extended list.
     */

    public static List<Integer> addToEnd(List<Integer> a, int x) {
        if (a.isEmpty()) {
            return new List(x, new List());
        } else {
            return new List(a.getHead(), addToEnd(a.getTail(), x));
        }
    }

    /**
     * Creates a List which is the result of List b appended to the
     * end of List a
     */
    public static List<Integer> append(List<Integer> a, List<Integer> b) {
        if (a.isEmpty()) {
            return b;
        } else {
            return new List(a.getHead(), append(a.getTail(), b));
        }
    }

    /**
     * addToEnd can also be defined using append without any further recursion.

     public static List<Integer> addToEnd(List<Integer> a, int x) {
     return append(a, new List(x, new List()));
     }

     */

    /**
     * A naive implementation of reversing a List. Can take quite long
     * on large lists
     */
    public static List<Integer> naiveReverse(List<Integer> a) {
        if (a.isEmpty()) {
            return new List();
        } else {
            return addToEnd(naiveReverse(a.getTail()), a.getHead());
        }
    }

    /**
     * An efficient (tail recursive) implementation to reverse a List
     * that uses a helper method and an accumulator
     * / **
     *       *一种有效的（尾递归）实现来反转列表
     *       *使用辅助方法和累加器
     *       * /
     */
    public static List<Integer> reverse(List<Integer> list) {
        return reverseAccumulate(list, new List());
    }

    /* reverseAccumulate reverses the elements of the list 'original' and adds
     * them at the front of the list 'reversed', returning the resulting list.
     */

    private static List<Integer> reverseAccumulate(List<Integer> original, List<Integer> reversed) {
        if (original.isEmpty()) {
            return reversed;
        } else {
            return reverseAccumulate(original.getTail(),
                    new List(original.getHead(), reversed));
        }
    }

    public static int max(List<Integer> list) {
        if (list.isEmpty())
            throw new IllegalArgumentException(
                    "list does not have any elements.");
        else if (list.getTail().isEmpty()) {
            return list.getHead();
        } else {
            return Math.max(list.getHead(), max(list.getTail()));
        }
    }

    // Sorted lists

    public static List<Integer> insert(int x, List<Integer> list) {
        if (list.isEmpty())
            return new List(x, new List());
        else if (x <= list.getHead())
            return new List(x, list);
        else // x > list.getHead()
            return new List(list.getHead(), insert(x, list.getTail()));
    }

    public static List<Integer> delete(int x, List<Integer> list) {
        if (list.isEmpty())
            return list;
        else if (x < list.getHead())
            return list;
        else if (x == list.getHead())
            return delete (x, list.getTail());
        else // x > list.getHead()
            return new List(list.getHead(), delete(x, list.getTail()));
    }
}
