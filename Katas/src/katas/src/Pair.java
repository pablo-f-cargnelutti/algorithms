package katas.src;

public final class Pair<L, R> {
	final L left;
	final R right;

	public static <L, R> Pair<L, R> of(final L left, final R right) {
		return new Pair<L, R>(left, right);
	}

	private Pair(final L left, final R right) {
		this.left = left;
		this.right = right;
	}

	public L left() {
		return left;
	}

	public R right() {
		return right;
	}
}
