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
		return (E) current.data;
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

		ListNode currentCheck = front;
		for (int i = 0; i < size; i++) { //checks entire list for a duplicate
			if (currentCheck.equals(element)) {
				throw new IllegalArgumentException();
			}
			currentCheck = currentCheck.next;
		}
		
		if (index == 0) {
			front = new ListNode(element, front);
		} else {
			ListNode current = front;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			current.next = new ListNode(element, current.next);
		}
		size++;
	}

	@Override
	public E set(int index, E element) {
		if (element == null) {
			throw new NullPointerException();
		} else if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		ListNode current = front;
		ListNode indexToChange = null;
		if (index == 0) {
			for (int i = 0; i < size; i++) {
				if (current.equals(element)) {
					throw new IllegalArgumentException();
				}
				current = current.next;
			}
			if (front.next == null) {
				front = new ListNode(element, null);
			} else {
				front = new ListNode(element, front.next);
			}
		} else if (index == size) {
			for (int i = 0; i < size - 1; i++) {
				if (current.equals(element)) {
					throw new IllegalArgumentException();
				}
				current = current.next;
			}
			current.next = new ListNode(element, null);
		} else {
			for (int i = 0; i < size; i++) {
				if (i == index - 1) {
					indexToChange = current;
				}
				if (current.equals(element)) {
					throw new IllegalArgumentException();
				}
				current = current.next;
			}
			indexToChange.next = new ListNode(element, indexToChange.next.next);
		}
		return element;
	}

	@Override
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		ListNode removedNode = null;
		if (index == 0) {
			removedNode = front;
			front = front.next;
		} else {
			ListNode current = front;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			removedNode = current.next;
			current.next = current.next.next;
		}
		size--;
		return removedNode.data;
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

		@Override
		public boolean equals(Object data) {
			return this.data == data;
		}
	 }
	
}
