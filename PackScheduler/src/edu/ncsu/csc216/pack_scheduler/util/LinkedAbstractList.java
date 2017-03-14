package edu.ncsu.csc216.pack_scheduler.util;

import java.util.AbstractList;

public class LinkedAbstractList<E> extends AbstractList<E> {

	private int size;
	private int capacity;
	private ListNode front;

	public void LinkedAbstractList(int capacity) {
		size = 0;
		if (capacity > 0) {
			this.capacity = capacity;
		} else {
			throw new IllegalArgumentException();
		}
		front = null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		ListNode current = front;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return (E) current.next.data;
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public void add(int index, E element) {
		if (element == null) {
			throw new NullPointerException();
		} else if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}

		if (index == 0) {
			if (!element.equals(front)) {
				front = new ListNode(element);
			}
		} else if (index == size) {
			ListNode current = front;
			for (int i = 0; i < size - 1; i++) {
				current = current.next;
				if (current.equals(element)) {
					throw new IllegalArgumentException();
				}
			}
			current.next = new ListNode(element, null);
		} else {
			ListNode current = front;
			ListNode indexToAddAt = null;
			for (int i = 0; i < size; i++) {
				current = current.next;
				if (i == index - 1) {
					indexToAddAt = current;
				}
				if (current.equals(element)) {
					throw new IllegalArgumentException();
				}
			}
			indexToAddAt = new ListNode(element, indexToAddAt.next);
		}
		size++;
	}

	private class ListNode {
		private E data;
		private ListNode next;
		
		public ListNode(E data){
			this.data = data;
		}

		public ListNode(E data, ListNode next){
			this.data = data;
			this.next = next;
		}
	 }
	
}
