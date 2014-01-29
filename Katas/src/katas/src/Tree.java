package katas.src;

import java.util.LinkedList;
import java.util.Queue;

public class Tree<T extends Comparable<T>> {
	private TreeNode<T> root;

	public void bfs() {
		bfs(root);
	}

	private void bfs(final TreeNode<T> root) {
		if (root == null) {
			return;
		}
		bfs(root.left());
		bfs(root.right());
		System.out.println(root.data());
	}

	public void inLevelOrder(final TreeNodeVisitFunction<T> visit) {
		final Queue<TreeNode<T>> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			inLevelOrder(queue, visit);
			int count = queue.size();
			for (; count > 0; count--) {
				final TreeNode<T> head = queue.poll();
				if (head.left() != null)
					queue.offer(head.left());
				if (head.right() != null)
					queue.offer(head.right());
			}
		}
	}

	private void inLevelOrder(final Queue<TreeNode<T>> queue, final TreeNodeVisitFunction<T> visit) {
		for (final TreeNode<T> node : queue) {
			visit.execute(node.data());
		}
		visit.endOfLevel();
	}

	public void insert(final T data) {
		if (root == null)
			root = new TreeNode<T>(data);
		else
			insert(root, data);
	}

	private TreeNode<T> insert(TreeNode<T> root, final T data) {
		if (root == null) {
			root = new TreeNode<T>(data);			
		} 
		else if (root.isGreatherThan(data)) {
			root.setLeft(insert(root.left(), data));
		}
		else {
			root.setRight(insert(root.right(), data));
		}

		return root;
	}

	public TreeNode<T> root() {
		return root;
	}


}
