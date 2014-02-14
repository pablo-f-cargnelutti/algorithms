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
	
	private void transverse(final NodeAction<T> action) {
		ListNode<T> aux = this.head;
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
}
