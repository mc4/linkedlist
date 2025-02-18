package com.wakefernfoodcorp;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListTest {

	private LinkedList<Integer> list;

	@BeforeEach
	public void setUp() {
		list = new LinkedList<>();
	}

	@Test
	public void testInsertAtBeginningEmptyList() {
		list.insert(0, 42);
		assertEquals("[42]", list.toString());
	}

	@Test
	public void testInsertAtEnd() {
		list.append(10);
		list.append(20);
		list.insert(2, 30);
		assertEquals("[10 -> 20 -> 30]", list.toString());
	}

	@Test
	public void testInsertInMiddle() {
		list.append(10);
		list.append(30);
		list.insert(1, 20);
		assertEquals("[10 -> 20 -> 30]", list.toString());
	}

	@Test
	public void testInsertIntoSingleElementList() {
		list.append(10);
		list.insert(1, 20);
		assertEquals("[10 -> 20]", list.toString());
	}

	@Test
	public void testInsertNegativeIndexThrowsException() {
		list.append(10);
		assertThrows(IndexOutOfBoundsException.class, () -> list.insert(-1, 20));
	}

	@Test
	public void testInsertOutOfBoundsThrowsException() {
		list.append(10);
		assertThrows(IndexOutOfBoundsException.class, () -> list.insert(3, 20));
	}

	// @formatter:off
	@Test
	public void testRemoveOnlyElement() {
		list.append(42);
		int removed = list.remove(0);
		assertAll("Remove single element", 
				() -> assertEquals(42, removed), 
				() -> assertEquals(0, list.size()),
				() -> assertEquals("[]", list.toString()));
	}

	@Test
	public void testRemoveLastElement() {
		list.append(10);
		list.append(20);
		int removed = list.remove(1);
		assertAll("Remove last element", 
				() -> assertEquals(20, removed), 
				() -> assertEquals(1, list.size()),
				() -> assertEquals("[10]", list.toString()));
	}

	@Test
	public void testRemoveMiddleElement() {
		list.append(10);
		list.append(20);
		list.append(30);
		int removed = list.remove(1);
		assertAll("Remove middle element", 
				() -> assertEquals(20, removed),
				() -> assertEquals("[10 -> 30]", list.toString()));
	}

	// @formatter:on
	@Test
	public void testRemoveFromEmptyListThrowsException() {
		assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
	}

	@Test
	public void testRemoveOutOfBoundsThrowsException() {
		list.append(10);
		list.append(20);
		assertThrows(IndexOutOfBoundsException.class, () -> list.remove(5));
	}

	@Test
	public void testReverseSingleElementList() {
		list.append(42);
		list.reverse();
		assertEquals("[42]", list.toString());
	}

	@Test
	public void testReverseEmptyList() {
		list.reverse();
		assertEquals("[]", list.toString());
	}

	@Test
	public void testCopyEmptyList() {
		LinkedList<Integer> copiedList = list.copy();
		assertEquals("[]", copiedList.toString());
	}

	@Test
	public void testCopySingleElementList() {
		list.append(42);
		LinkedList<Integer> copiedList = list.copy();
		assertEquals("[42]", copiedList.toString());
	}

	@Test
	public void testContainsOnEmptyList() {
		assertFalse(list.contains(10));
	}

	@Test
	public void testContainsNonExistentElement() {
		list.append(10);
		list.append(20);
		assertFalse(list.contains(30));
	}

}
