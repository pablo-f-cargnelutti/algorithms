package katas.src;

public interface TreeNodeVisitFunction<T> {
	void to(T input);
	void endOfLevel();
}
