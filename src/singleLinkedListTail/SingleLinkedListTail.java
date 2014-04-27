package singleLinkedListTail;

//import SingleLinkedList.Node;
/**
 * SingleLinkedList is a class that provide some capabilities required by the list and this
 * LinkedList contains a tail method reference. The methods is isEmpty,size, get, set, add, remove,
 * toString. 
 * @author Esomonu
 *
 * @param <E>
 */
public class SingleLinkedListTail<E> {
	 /** A Node is the building block for the SingleLinkedList 
	  */
	private static class SingleLinkedNode<E> {
		private E data;

		private SingleLinkedNode<E> next;

		public E getData() {
			return data;

		}

		public void setData(E data) {
			this.data = data;
		}

		public SingleLinkedNode<E> getNext() {
			return next;
		}

		public void setNext(SingleLinkedNode<E> next) {
			this.next = next;
		}

		/**
		 * Returns a String representation of this node.
		 **/
		public String toString() {
			// Return a string representation of the data in the node
			return data.toString();
		}

	}



	private SingleLinkedNode<E> head;

	private SingleLinkedNode<E> tail;

	/*
	 * Get Data Stored in the first node.
	 */
	public E getFirst() {
		return head.getData();
	}

	/**
	 * Get the head node from the list.
	 */
	public SingleLinkedNode<E> getFirstNode() {
		return head;
	}

	/**
	 * Get data stored in the tail node.
	 */
	public E getLast() {
		return tail.getData();
	}
	
	public SingleLinkedNode<E> getLastNode() {
		return tail;
	}
	/**
	 * Check if list is empty.
	 * 
	 * @return true if list contains no items.
	 **/
	public boolean isEmpty() {
		//if their is no head node
		if (head == null) {
			//is isEmpty
			return true;
		} else
			return false;

	}

	/**
	 * Find the node at a specific index. From Elodie's SingleLinkedList class
	 * @param index
	 * @return
	 */
	private SingleLinkedNode<E> getNode(int index) {
		SingleLinkedNode<E> node = head;
		for (int i = 0; i < index && node != null; i++) {
			node = node.getNext();
		}
		return node;
	}

	/**
	 * Get Data value from the index Elodie's SingleLinkedList class
	 */
	public E get(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		SingleLinkedNode<E> node = getNode(index);
		return node.data;
	}
	/**
	 * Insert a new node with data at the head of the list.
	 **/

	public void addFirstNode(SingleLinkedNode<E> node) {
		// the newNode point to the head node
			node.next = head;
		//	put the head in the front
			head = node;
		

	}

	/**
	 * add a new node with data at the head of the list.
	 **/
	public void addFirst(E data) {
		// We need to make a new node to add it
		SingleLinkedNode<E> node = new SingleLinkedNode<E>();
		// Add data to the node
		node.setData(data);
		// Invoke addFirstNode to link up the new node
		addFirstNode(node);
	}
	/**
	 * Insert the node after currentNode
	 **/
	public void addNodeAfter(SingleLinkedNode<E> currentNode,
			SingleLinkedNode<E> newNode) {
		// Have the new node point to the node after currentNode
		newNode.setNext(currentNode.getNext());
		// Have currentNode now point to the new node
		currentNode.setNext(newNode);

	}


	/**
	 * add a new node with data after currentNode
	 **/
	public void addAfter(SingleLinkedNode<E> currentNode, E data) {
		// We need to make a new node to add it
		SingleLinkedNode<E> node = new SingleLinkedNode<E>();
		// Add data to the node
		node.setData(data);
		// Invoke addNodeAfter to link up the new node
		addNodeAfter(currentNode, node);
	}
	/**
	 * Insert the specified item at the specified position in the list.
	 * Shifts the element currently at that position (if any) and any 
	 * subs
	 * @param index
	 * @param item
	 */
	public void add(int index, E item) {

		if (index == 0) {
			addFirst(item);
		} else {
			SingleLinkedNode<E> node = getNode(index - 1);
			addAfter(node, item);
		}
	}
	/**
	 * Append the specified item to the end of the list. 
	 *Similar to Elodie's SingleLinkedList 
	 * @param item
	 * @return
	 */
	public boolean add(E item) {
		add(size(), item);
		return true;
	}
	/**
	 * Remove head node
	 **/
	public void removeFirst() {
		
			head = head.next;
	}
	/**
	 * Remove node following currentNode
	 * If no node exists (i.e., currentNode is the tail), do nothing
	 **/
	public void removeAfter(SingleLinkedNode<E> currentNode) {
		//if the  currentNode is not the 1st node
		if (currentNode == null) {
			//remove the node
			removeFirst();
		} 
		//if the next node is equal to the tail
		else if (currentNode.next == tail) {
			tail = currentNode;
			tail.next = null;
		} 
		
		 else {
			// Set the currentNode to point to the one after the next node.  This will drop the one in the middle from the list
			currentNode.next = currentNode.next.next;
		}
		
	}
	/**
	 * Remove the item at the specified position in the list. Shifts any subsequent
	 * items to the left (subtracts one fromt he indices). Returns the item that was removed. 
	 * @param index The index of the item to be removed. 
	 * @return The item that was at the specified position
	 * 
	 */
	public E remove(int index) {
		SingleLinkedNode<E> removeNode = getNode(index);
		if (index <= 0 || index > size()) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}

		if (index == 0) {
			removeFirst();
		}

		else {

			SingleLinkedNode<E> node = getNode(index - 1);
			removeAfter(node);
		}

		return removeNode.data;
	}
	/**
	 * Remove the first occurrence of the element item
	 * @param item. The item to be removed
 	 * @return true if item is found and removed, other return false
 	 */
	public boolean remove(E item) {
		//no head
		if (head == null) {
			//remove false
			return false;
		}
		//create a node which equal to head
		SingleLinkedNode<E> currentNode = head;
		if (item.equals(currentNode.data)) {
			removeFirst();
			return true;
		}
		//while loop which goes through the linked list
		while (currentNode.next != null) {
			//if item is the next node
			if (item.equals(currentNode.next.data)) {
				//remove the node
				removeAfter(currentNode);
				return true;
			}
			//go the currentNode
			currentNode = currentNode.next;
		}

		return false;
	}

	/**
	 * Compute the size of this list.
	 **/
	public int size() {
		// Start our counter at zero
		int length = 0;
		// We need a temporary node to step through our list
		SingleLinkedNode<E> node = head;
		// While we aren't at the node after the tail (a null node)
		while (node != null) {
			// Tick up our counter
			length++;
			// Get the next node
			node = node.getNext();
		}
		// Return the length of our list
		return length;
	}

	/**
	 * Return a String representation of the list.
	 **/
	public String toString() {
		// We need a temporary node to step through our list
		SingleLinkedNode<E> node = head;
		// Start off with an empty string
		String representation = "";
		// If there aren't any data
		if (isEmpty())
			// Tell the user that
			representation = "";
		// Otherwise
		else {
			// While we aren't at the tail
			while (node.getNext() != null) {
				// Add the node representation plus an arrow
				representation += (node.toString() + " ==> ");
				// Get the next node
				node = node.getNext();
			}
			// When we're at the tail, we don't want the arrow, so we just add
			// the toString() output directly
			representation += node.toString();
		}
		// Return our string representing the whole list
		return representation;
	}
}
