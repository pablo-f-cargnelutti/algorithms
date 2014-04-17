package katas.test;

import static org.junit.Assert.assertEquals;
import katas.src.Queue;

import org.junit.Test;

public class QueueTest {

	@Test
	public void testOffer() {
		Queue<Integer> queue = new Queue<>();
		queue.offer(10);
		queue.offer(106);
		queue.offer(150);
		
		assertEquals(3, queue.size());
	}
	
	@Test
	public void testPeek() {
		Queue<Integer> queue = new Queue<>();
		queue.offer(10);
		queue.offer(73);
		queue.offer(77);
		queue.offer(79);
		assertEquals(Integer.valueOf(10), queue.peek());		
	}
	
	@Test
	public void testPeekAfterPush() {
		Queue<Integer> queue = new Queue<>();
		queue.offer(10);
		queue.offer(73);
		queue.offer(77);
		queue.offer(79);
		assertEquals(Integer.valueOf(10), queue.peek());
		queue.offer(80);
		assertEquals(Integer.valueOf(10), queue.peek());
	}
	
	@Test
	public void testPoll() {
		Queue<Integer> queue = new Queue<>();
		queue.offer(10);
		queue.offer(73);
		queue.offer(77);
		queue.offer(79);
		assertEquals(Integer.valueOf(10), queue.poll());
		assertEquals(3, queue.size());
		assertEquals(Integer.valueOf(73), queue.poll());
	}
	
	@Test
	public void testPollAfterPush() {
		Queue<Integer> queue = new Queue<>();
		queue.offer(10);
		queue.offer(73);
		queue.offer(77);
		queue.offer(79);
		assertEquals(Integer.valueOf(10), queue.poll());
		assertEquals(3, queue.size());
		queue.offer(90);
		assertEquals(Integer.valueOf(73), queue.poll());
		assertEquals(3, queue.size());
		queue.poll();
		queue.poll();
		assertEquals(Integer.valueOf(90), queue.poll());
		
	}
}
