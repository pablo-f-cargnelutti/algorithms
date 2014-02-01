package katas.src;


public interface NodeAction<T> {
	void apply(final ListNode<T> node);
}
