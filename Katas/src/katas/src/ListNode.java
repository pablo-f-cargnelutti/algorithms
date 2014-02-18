package katas.src;


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
	
	public void remove(final ListNode<T> previousNode) {
		previousNode.setNext(this.next());
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

	@Override
	public boolean equals(final Object obj) {
		if( obj instanceof ListNode ) {
			return ListNode.class.cast(obj).data.equals(this.data);
		}
		return false;
	}
	
	protected boolean hasNext() {
		return next() != null;
	}

}
