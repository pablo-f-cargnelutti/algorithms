package katas.src;

import katas.test.ListNode;

public class NestedListNode<T> extends ListNode<T> {

	private ListNode<T> otherNext;
	public NestedListNode(final T data) {
		super(data);		
	}
	
	public void setOtherNext(final ListNode<T> otherNext) {
		this.otherNext = otherNext;
	}	
	
	@Override
	public void flatten() {
		if(otherNext == null)
			return;
		
		final ListNode<T> continued = next();
		setNext(otherNext);
		ListNode<T> current = otherNext;
		while ( current.next() != null) {
			current = current.next();				
		}
		current.setNext(continued);											
	}
}
