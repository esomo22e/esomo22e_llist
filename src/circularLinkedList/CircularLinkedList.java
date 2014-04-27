//Eunice Esomonu
//March 6, 2013

package circularLinkedList;

/**
 * CircularLinkedList is a class that provides some of the capabilities required
 * by using the list interface we created a CircularLinkedList which is similar
 * to a SingleLinkedList but it there is no head pointer. There is only a tail
 * which points to the next node. The following methods in the
 * CircularLinkedNode class is getData, getNext, setData, setNext, and a
 * toString method. The follwing method in the CircularLinkedList class has add,
 * remove, set, and get method.
 * 
 * @author Esomonu
 */
public class CircularLinkedList<E> {
	private static class CircularLinkedNode<E> {
		private E data;

		private CircularLinkedNode<E> next;

		public E getData() {
			return data;

		}

		public void setData(E data) {
			this.data = data;
		}

		public CircularLinkedNode<E> getNext() {
			return next;
		}

		public void setNext(CircularLinkedNode<E> next) {
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

	private CircularLinkedNode<E> tail;

	/**
	 * Get data stored in the tail node.
	 */
	public E getLast() {
		return tail.getData();
	}

	/**
	 * Get the tail node.
	 * 
	 * @return
	 */
	public CircularLinkedNode<E> getLastNode() {
		return tail;
	}

	/**
	 * Check if list is empty.
	 * 
	 * @return true if list contains no items.
	 **/
	public boolean isEmpty() {
		// if there is no tail node
		if (tail == null) {
			// return true
			return true;
		}
		// if there is
		else
			// then it is empty
			return false;
	}

	/**
	 * Find the node at a specific index. From Elodie's SingleLinkedList class
	 * @param index
	 * @return
	 */
	private CircularLinkedNode<E> getNode(int index) {
		CircularLinkedNode<E> node = tail;
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
		CircularLinkedNode<E> node = getNode(index);
		return node.data;
	}

	/**
	 * Insert a new node with data at the head of the list.
	 **/
	public void addFirstNode(CircularLinkedNode<E> node) {

		// the newNode point to the front node
		node.next = tail;

		// put the node in the front
		tail = node;

	}

	/**
	 * add a new node with data at the head of the list.
	 **/
	public void addFirst(E data) {
		// We need to make a new node to add it
		CircularLinkedNode<E> node = new CircularLinkedNode<E>();
		// Add data to the node
		node.setData(data);
		// Invoke addFirstNode to link up the new node
		addFirstNode(node);
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
			CircularLinkedNode<E> node = getNode(index - 1);
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
	 * Insert the node after currentNode
	 **/
	public void addNodeAfter(CircularLinkedNode<E> currentNode,
			CircularLinkedNode<E> newNode) {
		// Have the new node point to the node after currentNode
		newNode.setNext(currentNode.getNext());
		// Have currentNode now point to the new node
		currentNode.setNext(newNode);

	}

	/**
	 * add a new node with data after currentNode
	 **/
	public void addAfter(CircularLinkedNode<E> currentNode, E data) {
		// We need to make a new node to add it
		CircularLinkedNode<E> node = new CircularLinkedNode<E>();
		// Add data to the node
		node.setData(data);
		// Invoke addNodeAfter to link up the new node
		addNodeAfter(currentNode, node);
	}

	/**
	 * Remove head node
	 **/
	public void removeFirst() {
		tail = tail.next;
	}

	/**
	 * Remove node following currentNode
	 * If no node exists (i.e., currentNode is the tail), do nothing
	 **/
	public void removeAfter(CircularLinkedNode<E> currentNode) {
		//if the  currentNode is not the 1st node
		if (currentNode == null) {
			//remove the node
			removeFirst();
		} 
		//if the next node is equal to the tail
		else if (currentNode.next == tail) {
			//the tail is current node
			tail = currentNode;
			//and their won't be a next node
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
		//create a and initialize the node that is going to be removed
		CircularLinkedNode<E> removeNode = getNode(index);
		if (index <= 0 || index > size()) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		//if the index is at 0,remove the first noe
		if (index == 0) {
			removeFirst();
		}

		else {
			//create a temporary node
			CircularLinkedNode<E> node = getNode(index - 1);
			//remove the node after
			removeAfter(node);
		}
		//return the item 's data
		return removeNode.data;
	}
	/**
	 * Remove the first occurrence of the element item
	 * @param item. The item to be removed
 	 * @return true if item is found and removed, other return false
 	 */
	public boolean remove(E item) {
		//if their is no tail
		if (tail == null) {
			//there is no item
			return false;
		}
		//create a node which equal to tail
		CircularLinkedNode<E> currentNode = tail;
		//if the item is equal to the 1st node
		if (item.equals(currentNode.data)) {
			//remove the node
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
		//return false
		return false;
	}

	/**
	 * Compute the size of this list.
	 **/
	public int size() {
		// Start our counter at zero
		int length = 0;
		// We need a temporary node to step through our list
		CircularLinkedNode<E> node = tail;
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
		CircularLinkedNode<E> node = tail;
		// Start off with an empty string
		String representation = "";
		// If there aren't any data
		if (isEmpty())
			// Tell the user that
			representation = "";
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
