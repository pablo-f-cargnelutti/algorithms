package katas.src;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntegerArray {

	final private List<Integer> elements;

	public IntegerArray(Integer[] initialValues) {
		this.elements = Arrays.asList(initialValues);
	}

	public boolean hasTwoNumbersThatSum(int aNumber) {
		final Set<Integer> uniqueElements = new HashSet<>(elements);
		
		for (final Integer number : elements) {
			if (uniqueElements.contains(aNumber - number))
				return true;
		}
		return false;
	}

	public Pair<Integer, Integer> getPairWithMinimalSum()
			throws IllegalStateException {
		if (elements.size() < 2)
			throw new IllegalStateException();
		
		Collections.sort(elements);
		return Pair.of(elements.get(0), elements.get(1));
	}
}
