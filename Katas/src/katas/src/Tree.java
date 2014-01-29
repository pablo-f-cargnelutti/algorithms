package katas.src;

import java.util.LinkedList;
import java.util.Queue;

public class Tree<T extends Comparable<T>> {
	private TreeNode<T> root;

	public void bfs(final TreeNodeVisitFunction<T> visit) {
		bfs(root, visit);
	}

	private void bfs(final TreeNode<T> root, final TreeNodeVisitFunction<T> visit) {
		if (root == null) {
			return;
		}
		bfs(root.left(), visit);
		bfs(root.right(), visit);
		visit.to(root.data());
	}

	public void inLevelOrder(final TreeNodeVisitFunction<T> visit) {
		final Queue<TreeNode<T>> level = new LinkedList<>();
		level.offer(root);

		while (!level.isEmpty()) {
			applyTo(level, visit);
			int count = level.size();
			for (; count > 0; count--) {
				final TreeNode<T> head = level.poll();
				addIfNotNull(level, head.left());
				addIfNotNull(level, head.right());
			}
		}
	}

	private void addIfNotNull(final Queue<TreeNode<T>> queue,
			final TreeNode<T> node) {
		if (node != null)
			queue.offer(node);
	}	

	private void applyTo(final Queue<TreeNode<T>> queue, final TreeNodeVisitFunction<T> visit) {
		for (final TreeNode<T> node : queue) {
			visit.to(node.data());
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
