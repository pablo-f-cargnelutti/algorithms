package katas.src;

import java.util.*;
import java.util.function.BinaryOperator;

public class IntegerArray_old {

    public static IntegerArray_old integerArrayFrom(final Integer[] initialValues) {
        return new IntegerArray_old(initialValues);
    }

    final private List<Integer> elements;

    private IntegerArray_old(final Integer[] initialValues) {
        this.elements = Arrays.asList(initialValues);
    }

    public boolean hasTwoNumbersThatSum(Integer aNumber) {
        final Set<Integer> uniqueElements = new HashSet<>(elements);
        elements.stream().mapToInt(Integer::intValue).max();
        return elements.stream().anyMatch(p->uniqueElements.contains(aNumber-p));


//        for (final Integer number : elements) {
//            if (uniqueElements.contains(aNumber - number))
//                return true;
//        }
//        return false;
    }

    public Pair<Integer, Integer> getPairWithMinimalSum() {
        validateSizeGreaterThan(1);
        this.sort();
        return Pair.of(elements.get(0), elements.get(1));
    }

    public void sort() {
        Collections.sort(elements);
    }

    public Integer size() {
        return this.elements.size();
    }

    public int maxAscendingSequence() {
        int max = 1;
        int count = 1;
        for (int i = 1; i < this.size(); i++) {
            if (elements.get(i) - elements.get(i - 1) == 1) {
                count++;
            } else {
                max = (count > max) ? count : max;
                count = 1;
            }
        }
        max = (count > max) ? count : max;
        return max;
    }

    public Triplet<Integer, Integer, Integer> getTripletWithMinimalSum() {
        validateSizeGreaterThan(2);
        Integer first = elements.get(0);
        Integer second = elements.get(1);
        Integer third = elements.get(2);
        Integer minSum = first + second + third;

        for (int i = 1; i + 2 < this.size(); i++) {
            final Integer sum = elements.get(i) + elements.get(i + 1) + elements.get(i + 2);
            if (sum < minSum) {
                minSum = sum;
                first = elements.get(i);
                second = elements.get(i + 1);
                third = elements.get(i + 2);
            }
        }
        return Triplet.of(first, second, third);
    }

    private void validateSizeGreaterThan(final int expectedSize) {
        if (this.size() <= expectedSize)
            throw new IllegalStateException("Size should be greater that " + expectedSize);
    }


    /**
     * You are given two sorted arrays, A and B, and A has a
     * large enough buffer at the end to hold B. Write a method
     * to merge B into A in sorted order.
     *
     * @param baseArray
     * @param toMerge
     * @param baseSize
     * @param toMergeSize
     */
    public static void sortedMerge(final int[] baseArray, final int[] toMerge, int baseSize, int toMergeSize) {
        final int totalSize = baseSize + toMergeSize;
        baseSize--;
        toMergeSize--;
        for (int i = totalSize - 1; i >= 0; i--) {
            if (baseSize >= 0 && toMergeSize >= 0) {
                if (baseArray[baseSize] >= toMerge[toMergeSize]) {
                    baseArray[i] = baseArray[baseSize--];
                } else if (baseArray[baseSize] < toMerge[toMergeSize]) {
                    baseArray[i] = toMerge[toMergeSize--];
                }
            } else if (toMergeSize >= 0)
                baseArray[i] = toMerge[toMergeSize];
        }
    }

    public int findTheMostOccurrences() {
        if(size() == 1)
            return elements.get(0);
        Collections.sort(elements);
        int maxOccurrences = 0;
        int maxOccurrencesNumber = 0;
        int previous = elements.get(0);
        int count = 0;
        for (Integer number : elements) {
            if (number == previous)
                count++;
            else if (count > maxOccurrences) {
                maxOccurrences = count;
                maxOccurrencesNumber = previous;
                count = 1;
                previous = number;
            }
        }
        return maxOccurrencesNumber;
    }
}