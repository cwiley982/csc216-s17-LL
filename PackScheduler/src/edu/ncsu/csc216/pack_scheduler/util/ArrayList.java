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
	public E get(int index) {
		if (size != 0) {
			return (E) list[index];
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

	/**
	 * Adds and element to a specific index and shifts all other elements to
	 * make room
	 * 
	 * @param index
	 *            the index to add the element to
	 * @param element
	 *            the element to be added to the list
	 */
	public void add(int index, E element) {
		if (element == null) {
			throw new NullPointerException();
		} else if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}

		for (int i = 0; i < size; i++) {
			if (element.equals(list[i])) {
				throw new IllegalArgumentException();
			}
		}

		ensureCapacity(size + 1);
		for (int i = size; i > index; i--) {
			list[i] = list[i - 1];
		}
		list[index] = element;
		size++;
	}

	/**
	 * Removes the element at the specified index
	 * 
	 * @param index
	 *            where to remove the element from
	 */
	public void remove(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		for (int i = index; i < size; i++) {
			list[i] = list[i + 1];
		}
		list[size - 1] = null;
		size--;
	}

	/**
	 * Sets the element at the specified index to the new element passed into
	 * the method
	 * 
	 * @param index
	 *            the index to set the element to
	 * @param element
	 *            the element to set
	 */
	public void set(int index, E element) {
		if (element == null) {
			throw new NullPointerException();
		} else if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		for (int i = 0; i < size; i++) {
			if (element.equals(list[i])) {
				throw new IllegalArgumentException();
			}
		}
		list[index] = element;
	}
	/**
	 * Ensures that the list has enough room to add the element, if not a new,
	 * longer list is made
	 * 
	 * @param capacity
	 *            the new size of the list once the element is added
	 */
	@SuppressWarnings("unchecked")
	private void ensureCapacity(int capacity) {
		if (capacity > list.length) {
			int newCapacity = capacity * 2;
			if (capacity > newCapacity) {
				newCapacity = capacity;
			}
			E[] newList = (E[]) (new Object[newCapacity]);
			for (int i = 0; i < size; i++) {
				newList[i] = list[i];
			}
			list = newList;
		}

	}

}
