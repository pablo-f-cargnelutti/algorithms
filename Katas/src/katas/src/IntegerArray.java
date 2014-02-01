package katas.src;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntegerArray {

	public static IntegerArray integerArrayFrom(final Integer[] initialValues) {
		return new IntegerArray(initialValues);
	}

	final private List<Integer> elements;

	private IntegerArray(final Integer[] initialValues) {
		this.elements = Arrays.asList(initialValues);
	}

	public boolean hasTwoNumbersThatSum(final int aNumber) {
		final Set<Integer> uniqueElements = new HashSet<>(elements);

		for (final Integer number : elements) {
			if (uniqueElements.contains(aNumber - number))
				return true;
		}
		return false;
	}

	public Pair<Integer, Integer> getPairWithMinimalSum()
			throws IllegalStateException {
		if (this.size() < 2)
			throw new IllegalStateException();

		this.sort();
		return Pair.of(elements.get(0), elements.get(1));
	}

	public void sort() {
		Collections.sort(elements);
	}

	public Integer size() {
		return this.elements.size();
	}
	
	public int maxAscendingSequence(){
		int max = 1;
		int count = 1;
		for(int i = 1; i< this.size(); i++) {
			if(elements.get(i) - elements.get(i-1) == 1) {
				count ++;
			} 
			else {
				max = (count > max) ? count : max;	
				count = 1;
			}	
		}
		max = (count > max) ? count : max;
		return max;
	}

	/**
	 * You are given two sorted arrays, A and B, and A has a 
	 * large enough buffer at the end to hold B. Write a method 
	 * to merge B into A in sorted order.
	 * @param baseArray
	 * @param toMerge
	 * @param baseSize
	 * @param toMergeSize
	 */
	public static void sortedMerge(final int[] baseArray, final int[] toMerge, int baseSize, int toMergeSize) {
		final int totalSize = baseSize + toMergeSize;
		baseSize--;
		toMergeSize--;
		for (int i = totalSize-1; i >= 0; i--) {
			if(baseSize >= 0 && toMergeSize >= 0) {
				if(baseArray[baseSize] >= toMerge[toMergeSize]) {
					baseArray[i] = baseArray[baseSize--];										
				}
				else if(baseArray[baseSize] < toMerge[toMergeSize]){
					baseArray[i] = toMerge[toMergeSize--];
				} 				
			} else if(toMergeSize >= 0)
				baseArray[i] = toMerge[toMergeSize];
		}
	}
}
