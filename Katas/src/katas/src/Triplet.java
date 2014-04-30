package katas.src;

public class Triplet<S, T, U> {

	private final S first;
	private final T second;
	private final U third;

	private Triplet(final S first, final T second, final U third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}

	public S first() {
		return first;
	}

	public T second() {
		return second;
	}

	public U third() {
		return third;
	}

	public static <S, T, U > Triplet<S, T, U> of(final S first, final T second, final U third) {
		return new Triplet<S, T, U>(first, second, third);
	}
}
