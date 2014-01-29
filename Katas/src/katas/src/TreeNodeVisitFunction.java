package katas.src;

public interface TreeNodeVisitFunction<T> {
	void execute(T input);
	void endOfLevel();
}
