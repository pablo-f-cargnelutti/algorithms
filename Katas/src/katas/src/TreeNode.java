package katas.src;

public class TreeNode<T extends Comparable<T>> {
	private TreeNode<T> left;
	private TreeNode<T> right;
	private T data;

	public TreeNode(final T data) {
		this.data =  data;
	}

	public T data() {
		return data;
	}

	public void setData(final T data) {
		this.data = data;
	}

	public TreeNode<T> right() {
		return right;
	}

	public void setRight(final TreeNode<T> right) {
		this.right = right;
	}

	public TreeNode<T> left() {
		return left;
	}

	public void setLeft(final TreeNode<T> left) {
		this.left = left;
	}

	public boolean isGreatherThan(final T data) {
		return this.data.compareTo(data) > 0;
	}

	public boolean isLessThan(final T data) {
		return this.data.compareTo(data) < 0;
	}	

	@Override
	public String toString() {
		return data.toString();
	}

}
