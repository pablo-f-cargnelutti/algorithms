package katas.src;

import katas.test.ListNode;

public interface NodeAction<T> {
	void apply(final ListNode<T> node);
}
