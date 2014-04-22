package katas.src;

import java.util.*;

public class IntegerArray {

    public static IntegerArray integerArrayFrom(final Integer[] initialValues) {
        return new IntegerArray(initialValues);
    }

    final private List<Integer> elements;

    private IntegerArray(final Integer[] initialValues) {
        this.elements = Arrays.asList(initialValues);
    }

    public boolean hasTwoNumbersThatSum(int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        fillMap(map);

        for (Integer current : elements) {
            int diff = sum - current;
            if(diff == current && map.get(current) == 1)
                continue;
            if(map.containsKey(diff))
                return true;
        }
        return false;
    }

    private void fillMap(Map<Integer, Integer> map) {
        for (Integer key : elements) {
            int count = map.containsKey(key) ? map.get(key) : 0;
            count ++;
            map.put(key, count);
        }
    }

    public Pair<Integer, Integer> getPairWithMinimalSum() {
        validateSizeIsAtLeast(2);
        Collections.sort(this.elements);
        return Pair.of(elements.get(0), elements.get(1));
    }

    private void validateSizeIsAtLeast(int expectedSize) {
        if(size() < expectedSize)
            throw new IllegalStateException("Size too short.");
    }

    private int size() {
        return this.elements.size();
    }

    public Triplet<Integer, Integer, Integer> getTripletWithMinimalSum() {
        validateSizeIsAtLeast(3);
        Collections.sort(this.elements);
        return Triplet.of(elements.get(0), elements.get(1), elements.get(2));
    }

    public static void sortedMerge(int[] baseArray, int[] toMergeArray, int baseSize, int toMergeSize) {
        int totalSize = baseSize + toMergeSize - 1;
        baseSize --;
        toMergeSize --;
        for(int i = totalSize; i>=0; i--) {
            if(baseSize >= 0 && toMergeSize >= 0) {
                if (baseArray[baseSize] > toMergeArray[toMergeSize]) {
                    baseArray[i] = baseArray[baseSize--];
                } else {
                    baseArray[i] = toMergeArray[toMergeSize--];
                }
            }
            else if(toMergeSize >= 0)
                baseArray[i] = toMergeArray[toMergeSize--];
        }
    }

    public int maxAscendingSequence() {
        int maxSeqCount = 0;
        int seqCount = 0;
        int maxSeqIndex = -1;
        int seqIndex = 0;
        int previous = elements.get(0);

        for (int i = 1; i < size(); i++) {
            int current = elements.get(i);
            if(previous < current) {
                seqCount ++;
            }
            else {
                if(seqCount > maxSeqCount) {
                    maxSeqCount = seqCount;
                    maxSeqIndex = seqIndex;
                }
                seqCount = 0;
                seqIndex = i;
            }
            previous = current;
        }
        if(seqCount > maxSeqCount) {
            maxSeqIndex = seqIndex;
        }
        return maxSeqIndex;
    }
}