package katas.src;


public class LinkedList<T> {

	private ListNode<T> head;
	private int size;

	public void addFirst(final T value) {
		final ListNode<T> node = new ListNode<>(value);
		addNodeFirst(node);
	}
	
	public void addNodeLast(final ListNode<T> node) {
		node.addLast(this.head);
		this.size++;		
	}

	public int size() {
		return this.size;
	}

	public T getFirst() {
		return this.head.data();
	}

	/**
	 * Method only for testing reasons.
	 * @param node
	 */
	public void addNodeFirst(final ListNode<T> node) {
		this.head = node.addFirst(this.head);
		this.size++;		
	}

	public void flatten() {
		transverse(new NodeAction<T>() {
			@Override
			public void apply(final ListNode<T> node) {
				node.flatten();				
			}
		});
		updateListSize();
	}
	
	@SuppressWarnings("unchecked")
	// TODO check generic types
	public T[] asArray() {
		final Object[] array = new Object[this.size];
		
		transverse(new NodeAction<T>() {
			int index=0;
			@Override
			public void apply(final ListNode<T> node) {
				array[index++] = node.data();
				
			}
		});
		return (T[])array;
	}
	
	private void updateListSize() {
		this.size = 0;
		transverse(new NodeAction<T>() {
			@Override
			public void apply(final ListNode<T> node) {
				LinkedList.this.size ++;
			}
		});
	}
	
	private void transverse(final NodeAction<T> nodeAction) {
		transverse(head, nodeAction);		
	}

	private void transverse(final ListNode<T> originNode, final NodeAction<T> action) {
		ListNode<T> aux = originNode;
		while(aux != null) {
			action.apply(aux);
			aux = aux.next();
		}
	}

	public void reverse() {
		ListNode<T> current = this.head;
		ListNode<T> next = null;
		ListNode<T> previous = null;
		
		while(current != null) {
			next = current.next();
			current.setNext(previous);
			previous = current;
			current = next;
		}
		this.head = previous;
	}

	public void printReverse() {
		printReverse(this.head);		
	}

	private void printReverse(final ListNode<T> node) {
		if(node ==  null)
			return;
		printReverse(node.next());
		System.out.println(node.data());		
	}

	public void removeDuplicates() {
		ListNode<T> current = head;		
		while( current != null ) {
			ListNode<T> runer = current.next();
			ListNode<T> previous = current;
			while( runer != null ) {
				if( current.equals(runer) ) {
					remove(runer, previous);
				}
				else {
					previous = runer;
				}
				runer = runer.next();
			}
			current = current.next();
		}		
	}

	private void remove(final ListNode<T> runer, final ListNode<T> previous) {
		runer.remove(previous);	
		this.size --;
	}

	public ListNode<T> getNodeAt(final int index) {
		validateSizeGreaterThan(index);		
		ListNode<T> current = head;
		int indexCount = 0;
		while ( current != null ) {
			if( index == indexCount ) {
				return current;
			}			
			indexCount ++;
			current = current.next();
		}
		return ListNode.getNullNode(); // should never reach this point.
	}

	private void validateSizeGreaterThan(final int index) {
		if( this.size < index ) {
			throw new IllegalArgumentException();
		}		
	}

	/**
	 * This approach is assuming that you only have access to the node
	 * to delete. It does no work if the node to remove is the last node.
	 * @param toDelete
	 */
	public void remove(final ListNode<T> toDelete) {
		if ( toDelete == null  || !toDelete.hasNext() ) {
			throw new IllegalArgumentException();
		}
			
		ListNode<T> next = toDelete.next();
		toDelete.setData(next.data());
		toDelete.setNext(next.next());
		this.size --;
	}
}
