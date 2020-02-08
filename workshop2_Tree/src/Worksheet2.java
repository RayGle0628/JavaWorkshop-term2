import javax.print.DocFlavor;
import java.lang.annotation.ElementType;

/**
<<<<<<< HEAD
 * @author <>
=======
 * @author <RayGle>
>>>>>>> 9ec21a99c7f4725034966f036f862cef1c5609d3
 * This class contains the solution for Worksheet2
 */

public class Worksheet2 implements Worksheet2Interface {

	// Exercise 1

	/**
	 * @param a the tree we want to access
	 * @return a new tree containing all the elements of
	 * a with their sign negated
	 */
	static Tree<Integer> negateAll(Tree<Integer> a) {
		if (a.isEmpty())
		return new Tree<Integer>();
		else if(a.getValue() == 0) {
			return new Tree<Integer>(a.getValue(),negateAll(a.getLeft()),
					negateAll(a.getRight()));
		}
		else return new Tree<>(a.getValue()*(-1),negateAll(a.getRight()),
				negateAll(a.getLeft()));
	}

	// Exercise 2

	/**
	 * @param a the tree we want to access
	 * @return  a boolean value indicating whether all the values in its nodes
	 * are even, i.e., divisible by 2.
	 */
	static boolean allEven(Tree<Integer> a) {
	if (a.isEmpty())	return true;
	else if (a.getValue()%2==1) return false;
	else return true&& allEven(a.getLeft())&&allEven(a.getRight());
	}

	// Exercise 3

	/**
	 * @param a  the tree we want to access
	 * @param x the node we want to access
	 * @return the depth of the given node value
	 */
	static int depth(Tree<Integer> a, int x) {

		if (a.isEmpty()) return -1;
		else if (a.getValue()==x) return 0;
		else if (Math.max(depth(a.getLeft(), x), depth(a.getRight(),x)) == -1){
			return -1;}
		else return 1+Math.max(depth(a.getLeft(),x),depth(a.getRight(),x));
	}

	// Exercise 4

	/**
	 * @param a the first list we want to access
	 * @param b the 2nd list we want to access
	 * @param <E> Generic
	 * @return a new  list =a+b
	 */
	static <E> List<E> append(List<E> a, List<E> b){
		if (a.isEmpty() && b.isEmpty()) {
			return new List<E>();
		}
		if (!a.isEmpty()) {
			return new List<E>(a.getHead(), append(a.getTail(),b));
		}else {
			return new List<E>(b.getHead(), append(a,b.getTail()));
		}
	}

	/**
	 * @param a the tree we want to access
	 * @param <E> Generic
	 * @return a list containing the values in a by traversing the nodes in
	 * preorder
	 */
	static <E> List<E> preorder(Tree<E> a) {
		if (a.isEmpty()) {
			return new List<E>();
		}else {
			return new List<E>(a.getValue(),append(preorder(a.getLeft()),(preorder(a.getRight()))));
		}

	}


	// Exercise 5

	/**
	 * @param a the tree we want to access
	 * @return a boolean value indicating whether a is
	 * a binary search tree.
	 */
	static boolean isSearchTree(Tree<Integer> a) {
		if (a.isEmpty()) throw  new IllegalArgumentException("Trying to " +
				"access root of an empty tree");
		else if (a.getLeft().isEmpty()) return isSearchTree(a.getRight());
		else if (a.getRight().isEmpty()) return  true;
		else if (a.getValue()<a.getLeft().getValue()||a.getValue()>a.getRight().getValue())
return false;
		else return true;
		}


	// Exercise 6

	/**
	 * @param a the tree we want to access
	 */
	static void printDescending(Tree<Integer> a) {
		if (a.isEmpty()) return;
		else if (a.height==1) System.out.println(a.getValue());
		else {
			printDescending(a.getRight());
			System.out.println(a.getValue());
			printDescending(a.getLeft());
		}
	}

	// Exercise 7

	/**
	 * @param a the tree we want to access
	 * @return the
	 * maximum value stored in the tree
	 */
	static int max(Tree<Integer> a) {
		if (a.isEmpty()) return 0;
		else if (a.height==1) return a.getValue();
		else if(a.right==null) return a.getValue();
		else return max(a.getRight());
	}

	// Exercise 8

	/**
	 * @param a the tree we want to access
	 * @param x the node we wang to access
	 * @return the resulting tree after deleting the value
	 * x
	 */
	static Tree<Integer> delete(Tree<Integer> a, int x) {
		if (a.isEmpty()) return a;
		if (a.getValue()==x) {
			if (!a.getLeft().isEmpty() && !a.getRight().isEmpty()) {
				return delete(new Tree<Integer>(max(a.getLeft()), delete(a.getLeft(), max(a.getLeft())), delete(a.getRight(), x)), x);
			}
			if (!a.getLeft().isEmpty()) {
				return delete(new Tree<Integer>(a.getLeft().getValue(), delete(a.getLeft().getLeft(), x), delete(a.getLeft().getRight(), x)), x);
			}
			if (!a.getRight().isEmpty()) {
				return delete(new Tree<Integer>(a.getRight().getValue(), delete(a.getRight().getLeft(), x), delete(a.getRight().getRight(), x)), x);
			}
			return new Tree<Integer>();
		}
		return new Tree<Integer>(a.getValue(), delete(a.getLeft(), x), delete(a.getRight(), x));
	}

	/**
	 * @param a the tree we want to access
	 * @param <E> Generic
	 * @return a boolean value to check to see if it is height-balanced
	 */
	// Exercise 9
	static <E> boolean isHeightBalanced(Tree<E> a) {
		if(a.isEmpty()) {
			return true;
		}else if(Math.abs(a.getLeft().getHeight() - a.getRight().getHeight()) <=1 ) {
			return isHeightBalanced(a.getLeft());
		}else if(Math.abs(a.getRight().getHeight() - a.getLeft().getHeight()) <=1 ) {
			return isHeightBalanced(a.getRight());
		}else {
			return false;
		}
	}

	// Exercise 10

	/**
	 * @param x the tree we want to access
	 * @return a new lLTree
	 */
	public static Tree<Integer> lLTree(Tree<Integer> x) {
		return new Tree<Integer>(x.getLeft().getValue(), x.getLeft().getLeft(), new Tree<>(x.getValue(), x.getLeft().getRight(), x.getRight()));
	}

	/**
	 * @param w the tree we want to access
	 * @return a new rRTree
	 */
	public static Tree<Integer> rRTree(Tree<Integer> w) {
		return new Tree<Integer>(w.getRight().getValue(), new Tree<Integer>(w.getValue(), w.getLeft(), w.getRight().getLeft()), w.getRight().getRight());
	}

	/**
	 * @param t the tree we want to access
	 * @return a new lRTree
	 */
	public static Tree<Integer> lRTree(Tree<Integer> t) {
		return lLTree(new Tree<>(t.getValue(), rRTree(t.getLeft()), t.getRight()));
	}

	/**
	 * @param t the tree we want to access
	 * @return a new  rLTree
	 */
	public static Tree<Integer> rLTree(Tree<Integer> t) {
		return rRTree(new Tree<>(t.getValue(), t.getLeft(), lLTree(t.getRight())));

	}

	/**
	 * @param a the tree we want to access
	 * @param x the node we wang to access
	 * @return a new tree that is  height-balancing after inserting x
	 */
	static Tree<Integer> insertHB(Tree<Integer> a, int x) {
		if (a.isEmpty()) {
			return new Tree<Integer>(x);
		}
		if (a.getValue().equals(x)) {
			return a;
		}
		if (x > a.getValue()) {
			if (factor(new Tree<Integer>(a.getValue(), a.getLeft(), insertHB(a.getRight(), x))) == 2) {
				if (factor(new Tree<Integer>(a.getValue(), a.getLeft(), insertHB(a.getRight(), x)).getRight()) == -1)
					return rRTree(new Tree<Integer>(a.getValue(), a.getLeft(), lLTree(insertHB(a.getRight(), x))));
				else
					return rRTree(new Tree<Integer>(a.getValue(), a.getLeft(), insertHB(a.getRight(), x)));
			} else
				return new Tree<Integer>(a.getValue(), a.getLeft(), insertHB(a.getRight(), x));
		}
		if (x < a.getValue()) {
			if (factor(new Tree<Integer>(a.getValue(), insertHB(a.getLeft(), x), a.getRight())) == -2) {
				if (factor(new Tree<Integer>(a.getValue(), insertHB(a.getLeft(), x), a.getRight()).getLeft()) == 1) {
					return lLTree(new Tree<Integer>(a.getValue(), rRTree(insertHB(a.getLeft(), x)), a.getRight()));

				} else {
					return lLTree(new Tree<Integer>(a.getValue(), insertHB(a.getLeft(), x), a.getRight()));
				}

			}
			return new Tree<Integer>(a.getValue(), insertHB(a.getLeft(), x), a.getRight());
		}

		return a;
	}

	/**
	 * @param t the tree we want to access
	 * @param <E>Generic
	 * @return the factor of the tree
	 */
	static <E> int factor(Tree<E> t) {
		if (t.isEmpty()) return 0;
		if (t.getLeft().isEmpty()) return t.getHeight() - 1;
		if (t.getRight().isEmpty()) return 0 - t.getHeight() + 1;
		return t.getRight().getHeight() - t.getLeft().getHeight();
	}

	/**
	 * @param a the tree we want to access
	 * @param x the node we wang to access
	 * @return a new tree that is  height-balancing after deleting x
	 */
	static Tree<Integer> deleteHB(Tree<Integer> a, int x) {
		if (a.isEmpty()) return a;

		if (factor(delete(a, x)) == 2) {
			if (factor(delete(a, x).getRight()) == 1)
				return rRTree(delete(a, x));
			else {
				return rLTree(delete(a, x));
			}
		}
		if (factor(delete(a, x)) == -2) {
			if (factor(delete(a, x).getLeft()) == 1)
				return lLTree(delete(a, x));
			else {
				return lRTree(delete(a, x));
			}
		}
		if (x > a.getValue()) {

			return new Tree<Integer>(a.getValue(), a.getLeft(), deleteHB(a.getRight(), x));

		}
		if (x < a.getValue()) {
			return new Tree<Integer>(a.getValue(), deleteHB(a.getLeft(), x), a.getRight());

		}
		return delete(a, x);

	}



	public static void main(String[] args) {
		Tree t1 = new Tree(10,new Tree(9),new Tree(11));

		System.out.println(preorder(t1));
	}
}



