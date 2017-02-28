/**
 * 
 */
package edu.ncsu.csc216.pack_scheduler.util;

/**
 * Creates a generic ArrayList constructor
 * 
 * @author Sam
 * @author Claire
 * @author Caitlyn
 *
 * @param <E>
 *            a generic object
 */
public class ArrayList<E> {
	/** The initial size of the arraylist */
	private static final int INIT_SIZE = 10;
	/** The arraylist that will be used */
	private E[] list;
	/** The size of the arraylist */
	private int size;
	
	/**
	 * Contructs a generic arraylist
	 */
	@SuppressWarnings("unchecked")
	public ArrayList() {
		E item = (E)(new Object());
		list = (E[])(new Object[INIT_SIZE]);
		size = 0;
	}
	
	/**
	 * Returns the object in the list at the specified index
	 * 
	 * @param index
	 *            the index to return an object from
	 * @return the object at the specified index
	 */
	public Object get(int index) {
		if (size != 0) {
			return list[index];
		} else {
			return null;
		}
	}

	/**
	 * Returns the number of elements in the list
	 * 
	 * @return the size of the list
	 */
	public int size() {
		return size;
	}

}
