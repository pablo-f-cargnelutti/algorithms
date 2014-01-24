package katas.test;

import static org.junit.Assert.*;
import katas.src.Stack;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StackTest {

	@Test
	public void testStackShouldPush() {
		Integer value = Integer.valueOf(10);
		final Stack<Integer> stack = Stack.emptyStack();
		stack.push(value);

		assertEquals(stack.size(), Integer.valueOf(1));
	}

	@Test
	public void testStackShouldPush2Elements() {
		final Stack<Integer> stack = Stack.emptyStack();
		stack.push(Integer.valueOf(10));
		stack.push(Integer.valueOf(40));

		assertEquals(stack.size(), Integer.valueOf(2));
	}

	@Test
	public void testStackShouldPopLastInsertedElement() {
		final Stack<Integer> stack = Stack.emptyStack();
		stack.push(Integer.valueOf(10));
		Integer lastElementInserted = Integer.valueOf(40);
		stack.push(lastElementInserted);

		assertEquals(stack.pop(), lastElementInserted);
		assertEquals(stack.size(), Integer.valueOf(1));
	}

	@Test
	public void testStackShouldReturnMinElement() {
		final Stack<Integer> stack = Stack.emptyStack();

		stack.push(Integer.valueOf(10));
		Integer min = Integer.valueOf(5);
		stack.push(min);
		stack.push(Integer.valueOf(9));
		stack.push(Integer.valueOf(140));
		stack.push(Integer.valueOf(1033));

		assertEquals(stack.min(), min);
		assertEquals(stack.size(), Integer.valueOf(5));
	}

	@Test
	public void testStackShouldReturnMinElementWhenTheStackIsPoped() {
		final Stack<Integer> stack = Stack.emptyStack();

		stack.push(Integer.valueOf(10));
		Integer min = Integer.valueOf(5);
		stack.push(Integer.valueOf(9));
		stack.push(Integer.valueOf(140));
		stack.push(min);

		assertEquals(stack.min(), min);
		assertEquals(stack.size(), Integer.valueOf(4));

		stack.pop();

		assertEquals(stack.min(), Integer.valueOf(9));
		assertEquals(stack.size(), Integer.valueOf(3));
	}

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void testStackShouldThrowExceptionWhenMinAndTheStackIsEmpty() {
		expectedException.expect(IllegalStateException.class);
		final Stack<Integer> stack = Stack.emptyStack();
		stack.min();
	}

	@Test
	public void testStackShouldThrowExceptionWhenPopAndTheStackIsEmpty() {
		expectedException.expect(IllegalStateException.class);
		final Stack<Integer> stack = Stack.emptyStack();
		stack.pop();
	}

}
