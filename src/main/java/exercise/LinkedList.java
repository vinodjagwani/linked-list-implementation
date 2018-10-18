package exercise;

import org.springframework.util.Assert;
import java.math.BigDecimal;
import java.util.Iterator;

/**
 * @author Vinod
 *        
 */
public class LinkedList<T extends Comparable<T>> implements SimpleList<T> {

	private static final String ENTRY_NULL_MSG = "entry must not be null!";
	private static final String NEXT_ELEMENT_MSG = "Next element is not available!";

	/**
	 * Link point field represent the node where element will be added
	 */
	private Node<T> linkPoint;
	/**
	 * size field represent the total Linklist size
	 */
	private int size = BigDecimal.ZERO.intValue();

	/**
	 * add method will Insert an element in sorted order.
	 *
	 * @param entry
	 *            parameter entry is an element which will be inserted into link
	 *            list
	 */

	@Override
	public void add(T entry) {
		Assert.notNull(entry, ENTRY_NULL_MSG);
		Node<T> tNode = new Node<>(entry, linkPoint);
		if (linkPoint == null) {
			linkPoint = tNode;
			size++;
			return;
		} else if (compareTo(entry, linkPoint.getElement())) {
			tNode.setNext(linkPoint);
			linkPoint = tNode;
			size++;
		} else {
			swapElements(tNode, entry);

		}
	}

	/**
	 * set method will overwrite the value on given index.
	 *
	 * @param index
	 *            parameter index is the already present index of linked list.
	 * @param entry
	 *            parameter entry is the value which will be overwrite against
	 *            provided index.
	 */

	@Override
	public void set(int index, T entry) {
		Assert.notNull(entry, ENTRY_NULL_MSG);
		verifyIndex(index);
		Node<T> node = getNode(index);
		node.setElement(entry);
	}

	/**
	 * remove method will remove the value from linked list.
	 *
	 * @param entry
	 *            parameter entry is the value which will be removed from the
	 *            linked list.
	 */

	@Override
	public void remove(T entry) {
		Assert.notNull(entry, ENTRY_NULL_MSG);
		Node<T> currentNode = linkPoint;
		while (linkPoint != null && linkPoint.getElement() == entry) {
			linkPoint = linkPoint.getNext();
			size--;
		}
		deleteIfExistNodes(currentNode, entry);
	}

	/**
	 * get method will give the value of provided index.
	 *
	 * @param index
	 *            parameter index is the number value where desire value store
	 *            in linked list.
	 */

	@Override
	public T get(int index) {
		verifyIndex(index);
		Node<T> node = getNode(index);
		return node.getElement();
	}

	/**
	 * size method will give the total size of linked list.
	 */

	@Override
	public int size() {
		return size;
	}

	/**
	 * iterator method will iterate the values in the linked list.
	 */

	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}

	/**
	 * verifyIndex is method which will validate the index of linked list.
	 *
	 * @param index
	 *            parameter index is the number value where desire value store
	 *            in linked list.
	 */

	private void verifyIndex(int index) {
		if (index < 0 || size <= index) {
			throw new IndexOutOfBoundsException(String.valueOf(index));
		}
	}

	/**
	 * getNode is method which will return current node on given index in the
	 * linked list.
	 *
	 * @param index
	 *            parameter index is the number value where desire value store
	 *            in linked list.
	 */

	private Node<T> getNode(int index) {
		Node<T> node = linkPoint;
		for (int i = 0; i < index && node != null; i++) {
			node = node.getNext();
		}
		return node;
	}

	/**
	 * deleteIfExistNodes checks previous values in the Linkedlist and if found
	 * it will set most previous value in the previous entry.
	 *
	 * @param currentNode
	 *            parameter is the current node which hold the values .
	 * @param entry
	 *            parameter is the value itself in the list.
	 */

	private void deleteIfExistNodes(Node<T> currentNode, T entry) {
		while (linkPoint != null && currentNode.getNext() != null) {
			if (currentNode.getNext().getElement() == entry) {
				currentNode.setNext(currentNode.getNext().getNext());
				size--;
			} else {
				currentNode = currentNode.getNext();
			}
		}
	}

	/**
	 * swapElements is the method for swaping the elements after comparing the
	 * object.
	 *
	 * @param tNode
	 *            parameter is the current node which hold the values .
	 * @param entry
	 *            parameter is the value itself in the list.
	 */

	private void swapElements(Node<T> tNode, T entry) {
		Node<T> nextNode = linkPoint.getNext();
		Node<T> previousNode = linkPoint;
		while (nextNode != null) {
			if (compareTo(entry, nextNode.getElement())) {
				break;
			}
			previousNode = nextNode;
			nextNode = nextNode.getNext();
		}
		tNode.setNext(previousNode.getNext());
		previousNode.setNext(tNode);
		size++;
	}

	/**
	 * compareTo is the method for comparing elements for sorted order.
	 * 
	 * @param entry1
	 *            parameter is the previous value in the list.
	 *
	 * @param entry2
	 *            parameter is the next value in the list.
	 */

	private boolean compareTo(T entry1, T entry2) {
		boolean checkCompare = Boolean.FALSE;
		int intValue = entry1.compareTo(entry2);
		if (intValue < 0) {
			return true;
		}
		return checkCompare;
	}

	/**
	 * LinkedListIterator is the class for iterator implementation.
	 */

	private class LinkedListIterator implements Iterator<T> {
		Node<T> node = linkPoint;

		@Override
		public boolean hasNext() {
			return node != null ? Boolean.TRUE : Boolean.FALSE;
		}

		@Override
		public T next() {
			Assert.notNull(node, NEXT_ELEMENT_MSG);
			T element = null;
			while (node != null) {
				element = node.getElement();
				node = node.getNext();
				return element;
			}
			return element;
		}
	}

}
