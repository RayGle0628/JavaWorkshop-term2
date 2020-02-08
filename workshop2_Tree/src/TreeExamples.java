/**
 * @Version 1.0
 * @Author:Mingrui Li 2087184 mxl991
 * @Date:2020/1/31
 * @Content:workshop
 */
/**
 * This class contains some code examples done in the lecture. Also it contains
 * some other examples. This class requires the List, ListOps and Tree classes to compile.
 * These can be downloaded from Canvas.
 *
 * @author Alexandros Evangelidis, minor edits by Miriam Backens
 * @version 2020-01-23
 */
public class TreeExamples {

    /**
     * Checks whether the value is present in a tree.
     *检查树中是否存在该值
     * @param x
     *            the integer value we search for.
     * @param a,
     *            a tree of integers
     * @return true or false, accordingly.
     */
    public static boolean isPresent(int x, Tree<Integer> a) {

        if (a.isEmpty())
            return false;

        else if (x == a.getValue())
            return true;

        else if (x < a.getValue())
            return isPresent(x, a.getLeft());

        else
            return isPresent(x, a.getRight());
    }

    /**
     * Prints the values in ascending order 按升序打印值
     */
    public static void inorder(Tree<Integer> a) {

        if (a.isEmpty())
            return;

        else {
            inorder(a.getLeft());
            System.out.print(a.getValue() + " ");
            inorder(a.getRight());
        }
    }

    /**
     * Inserts an integer x in the tree
     *
     * @param x
     *            an integer to be inserted in the tree
     * @param a,
     *            a tree of integers
     * @return a new tree
     */
    public static Tree<Integer> insert(int x, Tree<Integer> a) {

        if (a.isEmpty())
            return new Tree(x);

        else if (x == a.getValue())
            return a; // if the value already exists, we change nothing

        else if (x < a.getValue())
            return new Tree(a.getValue(), insert(x, a.getLeft()), a.getRight());

        else
            return new Tree(a.getValue(), a.getLeft(), insert(x, a.getRight()));

    }

    /**
     * Search for n in a tree t, and return the subtree whose root is n. If n does
     * not occur in the tree, throw an exception.
     */
    public static Tree<Integer> find(int n, Tree<Integer> a) {
        if (a.isEmpty())
            throw new IllegalArgumentException("Value not present in search tree");
        else if (n == a.getValue())
            return a;
        else if (n < a.getValue())
            return find(n, a.getLeft());
        else
            return find(n, a.getRight());
    }

    /**
     * Returns an ordered Tree from a given List of int.
     */

    public static Tree<Integer> listToTree(List<Integer> l) {
        if (l.isEmpty()) {
            return new Tree();
        } else {
            return insert(l.getHead(), listToTree(l.getTail()));
        }
    }

    /**
     * Returns a List of values obtained by visiting the Tree in in-order, i.e. left
     * branch, then current root, then right branch.
     */
    public static List<Integer> inorderList(Tree<Integer> t) {
        if (t.isEmpty())
            return new List<Integer>();
        else {
            return (List<Integer>) ListOps.append(inorderList(t.getLeft()), new List(t.getValue(), inorderList(t.getRight())));
        }
    }

    /**
     * sort a list by creating a sorted tree and traversing it in inorder.
     */
    public static List<Integer> treeSort(List<Integer> l) {
        return inorderList(listToTree(l));
    }

    /**
     *
     * Main method for simple testing.
     */
    public static void main(String[] args) {

        Tree<Integer> t1 = new Tree(84, new Tree(48, new Tree(30), new Tree(50)),
                new Tree(96, new Tree(90), new Tree()));

        System.out.println(isPresent(150, t1));

        inorder(t1);
        System.out.println();
        Tree<Integer> t2 = insert(51, t1);

        System.out.println(t2);

        inorder(t2);
    }
}
