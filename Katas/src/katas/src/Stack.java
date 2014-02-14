package katas.src;

import java.util.Deque;
import java.util.LinkedList;

public class Stack<T extends Comparable<T>> {

	private final Deque<T> elements;
	private T min;
	private T lastMin;

	public static <T extends Comparable<T>> Stack<T> emptyStack() {
		return new Stack<T>();
	}

	public void push(final T value) {
		if(this.isEmpty()) {
			lastMin = min = value;
		}
		else if(value.compareTo(min) < 0) {
			lastMin = min;
			min = value;
		}
		
		this.elements.addFirst(value);		
	}
	
	public T pop() {
		validateIsNotEmpty();
		
		final T pop = this.elements.pop();
		
		if(pop.equals(min))
			min = lastMin;	
		
		return pop;
	}

	private void validateIsNotEmpty() {
		if(this.isEmpty())
			throw new IllegalStateException();
	}
	
	public T min() {		
		validateIsNotEmpty();		
		return min;
	}
	
	public T peek() {
		return this.elements.peek();
	}
	
	public Integer size() {
		return this.elements.size();
	}	
	
	private Stack() {
		this.elements = new LinkedList<T>();
	}
	
	private boolean isEmpty() {
		return this.size().equals(0);
	}	
}
