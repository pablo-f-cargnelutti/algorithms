package katas.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.Queue;

import katas.src.Tree;
import katas.src.TreeNode;
import katas.src.TreeNodeVisitFunction;

import org.junit.Test;

public class TreeTest {

	protected static final Integer LEVEL_SEPARATOR = 9999;

	@Test
	public void testInsertDataInATree() {

		final Tree<Integer> tree = new Tree<>();

		tree.insert(Integer.valueOf(10));
		tree.insert(Integer.valueOf(100));
		tree.insert(Integer.valueOf(9));
		tree.insert(Integer.valueOf(1));

		assertEquals(Integer.valueOf(10), tree.root().data());
		assertEquals(Integer.valueOf(9), tree.root().left().data());
	}

	@Test
	public void testInLevelOrderVisit() {
		final Tree<Integer> tree = createIntegerBinaryTree();
		final Queue<Integer> inOrderList = new LinkedList<>();
		final TreeNodeVisitFunction<Integer> addInList = new TreeNodeVisitFunction<Integer>(){
			@Override
			public void to(final Integer input) {
				inOrderList.add(input);
			}

			@Override
			public void endOfLevel() {				
				inOrderList.add(LEVEL_SEPARATOR);
			}};

		tree.inLevelOrder(addInList);
		
		assertEquals(Integer.valueOf(10), inOrderList.poll());
		assertEquals(LEVEL_SEPARATOR, inOrderList.poll());
		assertEquals(Integer.valueOf(8), inOrderList.poll());
		assertEquals(Integer.valueOf(100), inOrderList.poll());
		assertEquals(LEVEL_SEPARATOR, inOrderList.poll());
		assertEquals(Integer.valueOf(1), inOrderList.poll());
		assertEquals(Integer.valueOf(9), inOrderList.poll());
		assertEquals(Integer.valueOf(90), inOrderList.poll());
		assertEquals(Integer.valueOf(200), inOrderList.poll());
	}
	
	@Test 
	public void testIfATreeIsABST() {
		final Tree<Integer> tree = createIntegerBinaryTree();
		
		assertTrue(tree.isBST());
	}
	
	@Test 
	public void testIfATreeIsNotABST() {
		final Tree<Integer> tree = createIntegerRegularTree();
		
		assertFalse(tree.isBST());
	}

	private Tree<Integer> createIntegerRegularTree() {
		final Tree<Integer> tree = new Tree<>();

		tree.insert(Integer.valueOf(10));
		tree.insert(Integer.valueOf(100));
		tree.insert(Integer.valueOf(200));
		tree.insert(Integer.valueOf(8));
		tree.insert(Integer.valueOf(1));

		tree.root().right().setLeft(new TreeNode<Integer>(Integer.valueOf(4000)));
		tree.root().left().setRight(new TreeNode<Integer>(Integer.valueOf(9)));
		return tree;
	}

	private Tree<Integer> createIntegerBinaryTree() {
		final Tree<Integer> tree = new Tree<>();

		tree.insert(Integer.valueOf(10));
		tree.insert(Integer.valueOf(100));
		tree.insert(Integer.valueOf(200));
		tree.insert(Integer.valueOf(8));
		tree.insert(Integer.valueOf(1));

		tree.root().right().setLeft(new TreeNode<Integer>(Integer.valueOf(90)));
		tree.root().left().setRight(new TreeNode<Integer>(Integer.valueOf(9)));
		return tree;
	}

}
