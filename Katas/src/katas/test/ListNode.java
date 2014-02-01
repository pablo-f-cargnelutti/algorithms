package katas.test;


public class ListNode<T> {
	
	private ListNode<T> next;
	private final T data;

	public ListNode(final T data) {
		this.data = data;
	}
	
	public void setNext(final ListNode<T> next) {
		this.next = next;
	}
	
	public ListNode<T> addFirst(final ListNode<T> currentHead) {
		this.setNext(currentHead);		
		return this;	
	}
	
	public void addLast(final ListNode<T> currentHead) {
		ListNode<T> aux = currentHead; 
		while ( aux.next != null) {			
			aux = aux.next;
		}
		aux.next = this;	
	}

	public T data() {
		return this.data;
	}

	public void flatten() {
		// Do nothing
	}

	public ListNode<T> next() {
		return this.next;
	}

	protected boolean hasNext() {
		return next() != null;
	}

}
