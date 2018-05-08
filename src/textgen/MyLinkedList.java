package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode<E>();
		tail = new LLNode<E>();
		head.next = tail;
		tail.prev = head;
		
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException();
		}
		LLNode<E> currentNode = this.head;
		while (true) {
			if (currentNode.next.data == null) {
				LLNode<E> newNode = new LLNode<E>(element, currentNode);
				this.size += 1;	
				return true;
			}
			currentNode = currentNode.next;
		}
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> currentNode = this.head.next;
		int currentIndex = 0;
		while (true) {
			if (currentIndex == index) {
				return currentNode.data;
			}
			currentNode = currentNode.next;
			currentIndex += 1;
		}
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		if (index > this.size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (element == null) {
			throw new NullPointerException();
		}
		
		LLNode<E> prevNode = this.head;
		int currentIndex = 0;
		
		while (true) {
			if (currentIndex == index) {
				LLNode<E> newNode = new LLNode<E>(element, prevNode);
				this.size += 1;
				return;
			}
			currentIndex += 1;
			prevNode = prevNode.next;
		}
	}


	/** Return the size of the list */
	public int size() 
	{
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> currentNode = this.head.next;
		int currentIndex = 0;
		
		while (true) {
			if (index == currentIndex) {
				currentNode.prev.next = currentNode.next;
				currentNode.next.prev = currentNode.prev;
				this.size -= 1;
				return currentNode.data;
			}
			currentNode = currentNode.next;
			currentIndex += 1;
		}
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		if (index >= this.size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (element == null) {
			throw new NullPointerException();
		}
		LLNode<E> currentNode = this.head.next;
		int currentIndex = 0;
		
		while (true) {
			if (index == currentIndex) {
				E out = currentNode.data;
				currentNode.data = element;
				return out;
			}
			currentIndex += 1;
			currentNode = currentNode.next;
		}
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode() {
		this.next = null;
		this.prev = null;
	}
	
	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E e, LLNode<E> prevNode) {
		this(e);
		this.next = prevNode.next;
		this.prev = prevNode;
		prevNode.next = this;
		this.next.prev = this;
	}

}
