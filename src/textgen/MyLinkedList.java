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
		//added in local varialbes below..
		this.size = 0;
		this.head = new LLNode<E>();
		this.tail = new LLNode<E>();
		this.head.next = this.tail;
		this.tail.prev = this.head;
	}
	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		//welp heere goes nothing, this should add to end of the list btw
		if (element == null) {
			throw new NullPointerException("Invalid element input!!");
		}
		LLNode<E> nodeToAdd = new LLNode<E>(element);
		LLNode<E> prev = tail.prev;
		prev.next = nodeToAdd;
		nodeToAdd.prev = prev;
		nodeToAdd.next = tail;
		tail.prev = nodeToAdd;
		size++;
		return true;
		
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		//here goes my try...
/*		if(index < 0 || index > size-1)
		{
			throw new IndexOutOfBoundsException("In get() method, index cannot be less than 0, or more than the size of the list!");
		}
		
		LLNode<E> currNode = head;
		int i = 0;
		while( i <= index)
		{
			currNode = head.next;
		}
		E indexData = currNode.data;
		
		return indexData;*/
		// TODO: Implement this method.
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Invalid index input!!");
		}
		LLNode<E> target = head;
		for (int i = 0; i <= index; i++) {
			target = target.next;
		}
		E value = target.data;
		return value;
		
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		if (element == null)
		{
			throw new NullPointerException("In add() method, MyLinkedList object cannot throw null pointers");
		}
		if ((index < 0 || index > size - 1) && (index != 0 || size != 0)) {
			throw new IndexOutOfBoundsException("In add(int, E) method, index cannot be less than 0, or more than the size of the list!");
		}
		LLNode<E> newNode = new LLNode<E>(element);
		LLNode<E> currNode = head;
		for (int i = 0; i <= index; i++) {
			currNode = currNode.next;
		}
		LLNode<E> previous = currNode.prev;
		previous.next = newNode;
		newNode.prev = previous;
		newNode.next = currNode;
		currNode.prev = newNode;
		size++;
		
		
	}


	/** Return the size of the list */
	public int size() 
	{
/*		LLNode<E> currNode = head;
		int theSize = 0;
		while(currNode != null)
		{
			currNode = head.next;
			theSize ++;
		}
		
		//reducing theSize by 2 because of head and tail nodes...
		return theSize-2;
		//think this would also work
*/		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		//here goes a try...
		if(index < 0 || index > size - 1)
		{
			throw new IndexOutOfBoundsException("In remove() method, index cannot be less than 0, or greater than size -1");
		}
		LLNode<E> removedNode = head;
		for (int i = 0; i <= index; i++) 
		{
			removedNode = removedNode.next;
		}

		LLNode<E> prev = removedNode.prev;
		LLNode<E> next = removedNode.next;
		prev.next = next;
		next.prev = prev;
		size--;
		E value = removedNode.data;
		return value;
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
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("In set(), index is too small or too large!");
		}
		if (element == null) {
			throw new NullPointerException("In set(), element cannot be null!");
		}
		LLNode<E> setNode = head;
		for (int i = 0; i <= index; i++) {
			setNode = setNode.next;
		}
		setNode.data = element;
		return element;

	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode()
	{
		this.data = null;
		this.prev = null;
		this.next = null;
	}
	
	
	//Made a helper method to get next node in the list, this was not part of the assignment btw
	public LLNode<E> getNext()
	{
		return next;
	}
	
	//Made a helper method to set next node in the list, this was not part of the assignment btw
	public void setNext(LLNode<E> _next)
	{
		next = _next;
	}

}
