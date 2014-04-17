package katas.src;

public class Queue<T> {

	private final java.util.LinkedList<T> stack;
	private final java.util.LinkedList<T> reversedStack;
	
	public Queue() {
		stack = new java.util.LinkedList<>();
		reversedStack = new java.util.LinkedList<>();
	}
	
	public void offer(final T element) {		
		populateStack();
		stack.push(element);
		reverseStack();
	}
	
	public int size() {
		return reversedStack.size();
	}

	public T peek() {
		return reversedStack.peek();
	}
	
	public T poll() {
		return reversedStack.poll();
	}	

	private void populateStack() {
		fillStack(reversedStack, stack);			
	}
	
	private void reverseStack() {	
		fillStack(stack, reversedStack);
	}	

	private void fillStack(java.util.LinkedList<T> stackFrom, java.util.LinkedList<T> stackTo) {
		while( !stackFrom.isEmpty() ) {
			stackTo.push(stackFrom.poll());
		}
	}
}
