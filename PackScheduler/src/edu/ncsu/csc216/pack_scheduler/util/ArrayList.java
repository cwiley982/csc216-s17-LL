/**
 * 
 */
package edu.ncsu.csc216.pack_scheduler.util;

import java.util.AbstractList;

/**
 * @author Sam
 *
 */
public class ArrayList<E> {
	private int INIT_SIZE = 10;
	private E[] list;
	private int size;
	
	@SuppressWarnings("unchecked")
	public ArrayList() {
		E item = (E)(new Object());
		list = (E[])(new Object[INIT_SIZE]);
		size = 0;
	}
	
	public Object get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
