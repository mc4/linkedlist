package com.wakefernfoodcorp;

public class LinkedList<T> {

	private ListNode<T> head;
	private int size;

	private static class ListNode<T> {
		T data;
		ListNode<T> next;

		public ListNode(T data) {
			this.data = data;
			this.next = null;
		}
	}

	public LinkedList() {
		head = null;
		size = 0;
	}

	public ListNode<T> reverseList() {
		return null;
	}

	// Add element at the beginning
	public void insertFirst(T data) {
		insert(0, data);
	}

	// Add element at the beginning
	public void insertLast(T data) {
		insert(size - 1, data);
	}

	// Add element at a specific index
	public void insert(int index, T data) {

	}

	// Remove element at a specific index
	public boolean remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		return false;
	}

	public void traverse() {
		ListNode<T> ptr = head;

		while (ptr != null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}

	public ListNode<T> search(T data) {
		ListNode<T> ptr = head;

		while (ptr != null) {
			if (data.equals(ptr.data)) {
				return ptr;
			}
			ptr = ptr.next;
		}
		return null;
	}

	// Get the size of the list
	public int size() {
		return size;
	}
}
