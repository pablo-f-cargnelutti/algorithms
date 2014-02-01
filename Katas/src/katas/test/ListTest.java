package katas.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import katas.src.LinkedList;
import katas.src.ListNode;
import katas.src.NestedListNode;

import org.junit.Test;

public class ListTest {

	@Test
	public void testAddElementToList() {
		final LinkedList<Integer> list = new LinkedList<>();		
		list.addFirst(Integer.valueOf(10));
		assertEquals(1, list.size());
		assertEquals(Integer.valueOf(10), list.getFirst());
	}
	
	@Test
	public void testAddSeveralElementsToList() {
		final LinkedList<Integer> list = new LinkedList<>();		
		list.addFirst(Integer.valueOf(10));
		list.addFirst(Integer.valueOf(100));
		list.addFirst(Integer.valueOf(1546));
		list.addFirst(Integer.valueOf(12340));
		list.addFirst(Integer.valueOf(610));
		assertEquals(5, list.size());
		assertEquals(Integer.valueOf(610), list.getFirst());
	}
	
	@Test
	public void testFlattenListInTheMiddle() {
		final NestedListNode<Integer> nestedList = new NestedListNode<Integer>(Integer.valueOf(50));
		final ListNode<Integer> otherNext = new ListNode<Integer>(Integer.valueOf(40));
		otherNext.setNext(new ListNode<Integer>(Integer.valueOf(98)));
		nestedList.setOtherNext(otherNext);		
		
		final LinkedList<Integer> list = new LinkedList<>();
		list.addFirst(Integer.valueOf(10));
		list.addFirst(Integer.valueOf(100));
		
		list.addNodeFirst(nestedList);
		
		list.addFirst(Integer.valueOf(670));
		list.addFirst(Integer.valueOf(45));
		
		list.flatten();
		
		assertArrayEquals(new Integer[]{45,670,50,40,98,100,10}, list.asArray());			
	}
	
	@Test
	public void testFlattenListAtTheBeginning() {
		final NestedListNode<Integer> nestedList = new NestedListNode<Integer>(Integer.valueOf(50));
		final ListNode<Integer> otherNext = new ListNode<Integer>(Integer.valueOf(40));
		otherNext.setNext(new ListNode<Integer>(Integer.valueOf(98)));
		nestedList.setOtherNext(otherNext);		
		
		final LinkedList<Integer> list = new LinkedList<>();
		list.addFirst(Integer.valueOf(10));
		list.addFirst(Integer.valueOf(100));
		
		list.addNodeFirst(nestedList);
				
		list.flatten();
		
		assertArrayEquals(new Integer[]{50,40,98,100,10}, list.asArray());			
	}
	
	@Test
	public void testFlattenListAtTheEnd() {
		final NestedListNode<Integer> nestedList = new NestedListNode<Integer>(Integer.valueOf(50));
		final ListNode<Integer> otherNext = new ListNode<Integer>(Integer.valueOf(40));
		otherNext.setNext(new ListNode<Integer>(Integer.valueOf(98)));
		nestedList.setOtherNext(otherNext);		
		
		final LinkedList<Integer> list = new LinkedList<>();
		
		list.addNodeFirst(nestedList);
		list.addFirst(Integer.valueOf(10));
		list.addFirst(Integer.valueOf(100));
				
		list.flatten();
		
		assertArrayEquals(new Integer[]{100, 10, 50,40,98}, list.asArray());			
	}
	
	@Test
	public void testFlattenListWithTwoNestedLists() {
		final NestedListNode<Integer> nestedList = new NestedListNode<Integer>(Integer.valueOf(50));
		final ListNode<Integer> otherNext = new ListNode<Integer>(Integer.valueOf(40));
		otherNext.setNext(new ListNode<Integer>(Integer.valueOf(98)));
		nestedList.setOtherNext(otherNext);		
		
		final NestedListNode<Integer> nestedList2 = new NestedListNode<Integer>(Integer.valueOf(500));
		final ListNode<Integer> otherNext2 = new ListNode<Integer>(Integer.valueOf(400));
		otherNext2.setNext(new ListNode<Integer>(Integer.valueOf(980)));
		nestedList2.setOtherNext(otherNext2);
		
		final LinkedList<Integer> list = new LinkedList<>();
		
		list.addNodeFirst(nestedList);
		list.addFirst(Integer.valueOf(10));
		list.addFirst(Integer.valueOf(100));
		list.addNodeFirst(nestedList2);
		
		list.flatten();
		
		assertArrayEquals(new Integer[]{500, 400, 980, 100, 10, 50,40,98}, list.asArray());			
	}
		
	@Test
	public void testReverseList(){
		final LinkedList<Integer> list = new LinkedList<>();		
		list.addFirst(Integer.valueOf(10));
		list.addFirst(Integer.valueOf(100));
		list.addFirst(Integer.valueOf(1546));
		list.addFirst(Integer.valueOf(12340));
		list.addFirst(Integer.valueOf(610));
		
		list.reverse();
		
		assertArrayEquals(new Integer[]{10, 100, 1546, 12340, 610}, list.asArray());
		
		// Back to original state
		list.reverse();
		
		assertArrayEquals(new Integer[]{610, 12340, 1546, 100, 10}, list.asArray());
	}
}
