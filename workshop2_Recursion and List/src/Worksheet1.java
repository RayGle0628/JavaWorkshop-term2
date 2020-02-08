import javax.lang.model.util.ElementScanner6;
import java.lang.annotation.ElementType;

/**
 * @author <RayGle> This class contains the solution for Worksheet1
 */

 public class Worksheet1 {

	// Exercise 1


	/**
	 * This is a static method for finding exponential values
	 * @param m Base number
	 * @param n exponent number
	 * @return m to the power of n
	 */
		 static int power(int m, int n) {
			 if (m<0||n<0) {
				 throw new IllegalStateException("m and n should not be less " +
						 "than zero");
			 }else if (m == 0){
				 return 1;
			 }else if (m % 2 == 0){
				 return power(m/2, n) * power(m/2, n);
			 }else {
				 return n * power(m/2, n) * power(m/2, n);
			 }
		 }

	/**
	 * this is a fast static method for finding exponential values
	 * @param m Base number
	 * @param n exponent number
	 * @return m to the power of n
	 */
	 static int fastPower(int m, int n) {
		 if (m<0||n<0) {
			 throw new IllegalStateException("m and n should not be less than zero");
		 }else if (m == 0) {
			 return 1;
		 }else if (m % 2 == 0) {
			 return fastPower(m/2, n)*fastPower(m/2, n);
		 }else {
			 return fastPower(m-1, n)*n;
		 }
	}

	// Exercise 2

	/**This is a static method for returning the opposite element of a list
	 * @param a A LIST with integers and unlimited positive and negative
	 * @return A LIST containing the opposite elements of LIST A
	 */
	 static List<Integer> negateAll(List<Integer> a) {
		 if (a.isEmpty()) {
			 throw new IllegalArgumentException(
					 "This is an empty list ,so wo can not use the list");
		 }else if(a.getHead() == 0) {
			 return new List<Integer>(a.getHead(),new List<Integer>());
		 }else {
			 return new List<Integer>((a.getHead()*(-1)),
					 negateAll(a.getTail()));
		 }

	}

	// Exercise 3

	/** this is a static method for finding the index of x that you want to find
	 * @param x the number of you want to find in the list
	 * @param a the list you are access to
	 * @return the index of x
	 */
	 static int find(int x, List<Integer> a) {
		if (a.isEmpty()) {
			throw  new  IllegalArgumentException("x is not in the list " +
					"of a or Trying to access of an empty " +
					"list ");
		}
		else if (a.getHead()!=x){
			return 1+find(x,a.getTail());
		}
		else return 0;
	}

	// Exercise 4

	/** this is a static method for determine if the list is even
	 * @param a the list you access
	 * @return a boolean number of the list if is even
	 */
	 static boolean allEven(List<Integer> a) {
		 if(a.isEmpty()) {
			 return true;
		 }else if(a.getHead() % 2 == 1) {
			 return false;
		 } else{
			 return true && allEven(a.getTail());
		 }
	}

	// Exercise 5

	/** this is a static method for finding all of even numbers of the list
	 * @param a the list you access
	 * @return  all of even numbers of the list
	 */
	 static List<Integer> evenNumbers(List<Integer> a) {
		if(a.isEmpty()) return new List<Integer>();
		else if (a.getHead()%2==0){
			return new List<Integer>(a.getHead(),evenNumbers(a.getTail()));
		}
		else return evenNumbers(a.getTail());
	}

	// Exercise 6

	/**this is a static method for determine if the list is sorted
	 * @param a the list you access
	 * @return a boolean number of the list if is sorted
	 */
	 static boolean sorted(List<Integer> a) {
		if (a.isEmpty()) return true;
		else if (a.getHead()>=a.getTail().getHead()){
			return true && sorted(a.getTail());
		}else return false;
	}

	// Exercise 7

	/**
	 * Given two sorted lists a and b, your method must return a new sorted list that contains all the elements
	 * of a and all the elements of b. Any duplicate copies of elements in a or b or their combination are retained.
	 * @param a list a
	 * @param b lis b
	 * @return Merged and sorted LIST
	 */
	 static List<Integer> merge(List<Integer> a, List<Integer> b) {
		 	if (a.isEmpty()&&b.isEmpty()) {
		 		throw new IllegalArgumentException("List a and b are empty, " +
						"we can not merge two lists");
			}
		 if (a.isEmpty()&&!b.isEmpty() ) {
			 return b;
		 }else if(b.isEmpty()&&!a.isEmpty()){
			 return a;
		 }else if(a.getHead() <= b.getHead()){
			 return new List<Integer>(b.getHead(),merge(a,b.getTail()));
		 }else {
			 return new List<Integer>(a.getHead(),merge(a.getTail(),b));
		 }
	}

	// Exercise 8

	/**
	 * Given a sorted list a, this method must return a copy of the list a with all duplicate copies removed.
	 * @param a the list you access
	 * @return  return a copy of the list a with all duplicate copies removed.
	 */
	static List<Integer> removeDuplicates(List<Integer> a) {
		if (a.isEmpty()) {
			return a;
		} else if (a.getTail().isEmpty()) {
			return new List(a.getHead(), new List<>());

		} else if (a.getHead() == a.getTail().getHead()) {
			return removeDuplicates(a.getTail());
		} else {
			return new List<Integer>(a.getHead(), removeDuplicates(a.getTail()));
		}
	}
}
