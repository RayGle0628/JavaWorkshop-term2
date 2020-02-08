/**
 * @author Uday Reddy
 * @version 2018-01-15 based on Uday's version of 2012 and Alexandros Evangelidis 2015
 * 
 *          List class defines a generic type called List, and provides constructor and getter
 *          methods.
 */

// We do not put nil and cons methods here because they need to be
// generic static methods.

class List<E> {
  protected boolean empty;
  protected E head;
  protected List<E> tail;

  /**
   * The first constructor creates a list consisting of a head, that is, an integer and a tail,
   * which is another list of integers.
   * 
   * @param head
   * @param tail
   */
  public List(E head, List<E> tail) {
    this.empty = false;
    this.head = head;
    this.tail = tail;
  }

  /**
   * The second constructor creates an empty list, i.e., a list with no elements. For this list,
   * head and tail remain undefined, calls to the corresponding getters will have to result in an
   * exception.
   */
  public List() {
    this.empty = true;
  }

  /**
   * returns true if this list is empty
   */
  public boolean isEmpty() {
    return this.empty;
  }

  /**
   * returns the head of this list or throws an exception if the list is empty
   * 
   * @throws IllegalStateException if the list is empty
   */
  public E getHead() {
    if (isEmpty()) {
      throw new IllegalStateException("Trying to access head of an empty list");
    }
    return this.head;
  }

  /**
   * returns the tail of this list or throws an exception if the list is empty
   * 
   * @throws IllegalStateException if the list is empty
   */
  public List<E> getTail() {
    if (isEmpty()) {
      throw new IllegalStateException("Trying to access tail of an empty list");
    }
    return this.tail;
  }

  public String toString() {
    return "[" + toStringAux() + "]";
  }

  public String toStringAux() {
    if (isEmpty()) {
      return "";
    } else if (getTail().isEmpty()) {
      return getHead() + "";
    } else {
      return getHead() + ", " + getTail().toStringAux();
    }
  }

  @Override
  public boolean equals(Object o) {
    List<E> list = (List<E>) o;
    if (this.empty && list.isEmpty())
      return true;
    else if (this.isEmpty() || list.isEmpty()) {
      return false;
    } else if (this.getHead().equals(list.getHead())) {
      return this.getTail().equals(list.getTail());
    } else {
      return false;
    }
  }

}
