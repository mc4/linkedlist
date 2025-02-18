package com.wakefernfoodcorp;

import java.util.Objects;

public class LinkedList<T> {

	private ListNode<T> head;
	private int size;

	private class ListNode<T> {
		T data;
		ListNode<T> next;

		public ListNode(T data) {
			Objects.requireNonNull(data, "Null values are not allowed");
			this.data = data;
			this.next = null;
		}
	}

	public LinkedList() {
		head = null;
		size = 0;
	}

	public void reverse() {
		ListNode<T> prev = null;
		ListNode<T> current = head;
		ListNode<T> next = null;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}

	public void prepend(T data) {
		insert(0, data);
	}

	public void append(T data) {
		insert(size, data);
	}

	public void insert(int index, T data) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}

		ListNode<T> newNode = new ListNode<>(data);

		if (index == 0) {
			newNode.next = head;
			head = newNode;
		} else {
			ListNode<T> prev = head;
			for (int i = 0; i < index - 1; i++) {
				prev = prev.next;
			}
			newNode.next = prev.next;
			prev.next = newNode;
		}
		size++;
	}

	public void insert(T data) {
		append(data);
	}

	public T remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}

		T removedData;

		if (index == 0) {
			removedData = head.data;
			head = head.next;
		} else {
			ListNode<T> prev = head;
			for (int i = 0; i < index - 1; i++) {
				prev = prev.next;
			}

			ListNode<T> nodeToRemove = prev.next;
			removedData = nodeToRemove.data;
			prev.next = nodeToRemove.next;
		}

		size--;
		return removedData;
	}

	public void traverse() {
		ListNode<T> ptr = head;

		while (ptr != null) {
			System.out.print(ptr.data + " -> ");
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

	public boolean contains(T data) {
		ListNode<T> current = head;

		while (current != null) {
			if (current.data.equals(data)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public LinkedList<T> copy() {
		LinkedList<T> newList = new LinkedList<>();

		if (head == null) {
			return newList;
		}

		newList.head = new ListNode<>(head.data);
		ListNode<T> current = head.next;
		ListNode<T> newCurrent = newList.head;

		while (current != null) {
			newCurrent.next = new ListNode<>(current.data);
			newCurrent = newCurrent.next;
			current = current.next;
		}
		newList.size = this.size;
		return newList;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public String toString() {
		if (head == null) {
			return "[]";
		}

		StringBuilder sb = new StringBuilder();
		sb.append("[");
		ListNode<T> current = head;

		while (current != null) {
			sb.append(current.data);
			if (current.next != null) {
				sb.append(" -> ");
			}
			current = current.next;
		}

		sb.append("]");
		return sb.toString();
	}
}
