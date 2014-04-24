package katas.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import katas.src.*;
import katas.src.IntegerArray_old;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IntegerArrayTest {
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void testGetTwoNumbersThanSumTen() {
		final Integer[] initialValues = { 1, 54, 1, 5, 41, 5, 7, 5, 16, 7, 9 };
		final IntegerArray array = IntegerArray.integerArrayFrom(initialValues);
		assertTrue(array.hasTwoNumbersThatSum(10));
	}

    @Test
    public void testGetTwoNumbersThanSumEight() {
        final Integer[] initialValues = { 4,5,3 };
        final IntegerArray array = IntegerArray.integerArrayFrom(initialValues);
        assertTrue(array.hasTwoNumbersThatSum(8));
    }

    @Test
    public void testGetTwoNumbersThanSumEightWithRepeatedNumbers() {
        final Integer[] initialValues = { 4,5,4 };
        final IntegerArray array = IntegerArray.integerArrayFrom(initialValues);
        assertTrue(array.hasTwoNumbersThatSum(8));
    }

    @Test
    public void testGetTwoNumbersThanSumMinusEight() {
        final Integer[] initialValues = { -4,5,12,-3,-41,-5 };
        final IntegerArray array = IntegerArray.integerArrayFrom(initialValues);
        assertTrue(array.hasTwoNumbersThatSum(-8));
    }

	@Test
	public void testWhichIsThePairThatRepresentTheMinimalSum() {
		final Integer[] initialValues = { 8, 10, 12, 1, 2 };
		final IntegerArray_old array = IntegerArray_old.integerArrayFrom(initialValues);
		final Pair<Integer, Integer> pair = array.getPairWithMinimalSum();

		assertEquals(pair.left(), Integer.valueOf(1));
		assertEquals(pair.right(), Integer.valueOf(2));
	}

	@Test
	public void testWhichIsThePairThatRepresentTheMinimalSumWithNotEnoughData() {
		expectedException.expect(IllegalStateException.class);

		final Integer[] initialValues = { 8 };
		final IntegerArray array = IntegerArray.integerArrayFrom(initialValues);
		array.getPairWithMinimalSum();
	}

	@Test
	public void testWhichIsThePairThatRepresentTheMinimalSumWithComplexData() {
		final Integer[] initialValues = { 1, 54, 1, 5, 41, 5, 7, 5, 16, 7, 9 };
		final IntegerArray array = IntegerArray.integerArrayFrom(initialValues);
		
		final Pair<Integer, Integer> pair = array.getPairWithMinimalSum();

		assertEquals(pair.left(), Integer.valueOf(1));
		assertEquals(pair.right(), Integer.valueOf(1));
	}
	
	@Test
	public void testWhichIsTheTripletThatRepresentTheMinimalSum() {
		final Integer[] initialValues = { 3,2,43,4,-5,3,2,12};
		final IntegerArray array = IntegerArray.integerArrayFrom(initialValues);
		
		final Triplet<Integer, Integer, Integer> triplet = array.getTripletWithMinimalSum();

		assertEquals(triplet.first(), Integer.valueOf(-5));
		assertEquals(triplet.second(), Integer.valueOf(2));
		assertEquals(triplet.third(), Integer.valueOf(2));
	}
	
	@Test
	public void testWhichIsTheTripletThatRepresentTheMinimalSumWith3Elements() {
		final Integer[] initialValues = { 3,2,43};
		final IntegerArray array = IntegerArray.integerArrayFrom(initialValues);
		
		final Triplet<Integer, Integer, Integer> triplet = array.getTripletWithMinimalSum();

		assertEquals(triplet.first(), Integer.valueOf(2));
		assertEquals(triplet.second(), Integer.valueOf(3));
		assertEquals(triplet.third(), Integer.valueOf(43));		
	}
	
	@Test
	public void testWhichIsTheTripletThatRepresentTheMinimalSumAtTheEnd() {
		final Integer[] initialValues = { 3,2,43,5,4,123,55,3,2,1};
		final IntegerArray array = IntegerArray.integerArrayFrom(initialValues);
		
		final Triplet<Integer, Integer, Integer> triplet = array.getTripletWithMinimalSum();

		assertEquals(triplet.first(), Integer.valueOf(1));
		assertEquals(triplet.second(), Integer.valueOf(2));
		assertEquals(triplet.third(), Integer.valueOf(2));
	}
	
	@Test
	public void testWhichIsTheTripletThatRepresentTheMinimalSumWithNotEnoughElements() {
		expectedException.expect(IllegalStateException.class);
		
		final Integer[] initialValues = { 3,2};
		final IntegerArray array = IntegerArray.integerArrayFrom(initialValues);
		
		array.getTripletWithMinimalSum();
	}
		
	@Test
	public void testMergeTwoSortedArrays()
	{
		final int[] baseArray = new int[10];
		baseArray[0] = 1;
		baseArray[1] = 7;
		baseArray[2] = 30;
		baseArray[3] = 50;
		
		final int[] arrayToMerge = new int[] { 2,3};
		
		IntegerArray.sortedMerge(baseArray, arrayToMerge, 4, 2);
		
		assertArrayEquals(new int[]{1,2,3,7,30,50,0,0,0,0}, baseArray);
	}
	
	@Test
	public void testMergeTwoSortedArraysToMergeGreaterThanBaseArray()
	{
		final int[] baseArray = new int[11];
		baseArray[0] = 1;
		baseArray[1] = 7;
		baseArray[2] = 30;
		baseArray[3] = 50;
		
		final int[] arrayToMerge = new int[] { 2, 3, 100, 690, 800, 900, 1000};
		
		IntegerArray.sortedMerge(baseArray, arrayToMerge, 4, 7);
		
		assertArrayEquals(new int[]{1,2,3,7,30,50,100,690,800,900, 1000}, baseArray);
	}
	
	@Test
	public void testMergeTwoSortedArraysWithRepetitions()
	{
		final int[] baseArray = new int[10];
		baseArray[0] = 1;
		baseArray[1] = 7;
		baseArray[2] = 30;
		baseArray[3] = 50;
		
		final int[] arrayToMerge = new int[] { 7,30};
		
		IntegerArray.sortedMerge(baseArray, arrayToMerge, 4, 2);
		
		assertArrayEquals(new int[]{1,7,7,30,30,50,0,0,0,0}, baseArray);
	}
	
	@Test
	public void testMaxAscendingSequence() {
		final Integer[] initialValues = { 1, 54, 1, 5, 41,42, 5, 7, 5, 16, 7, 9 };
		final IntegerArray array = IntegerArray.integerArrayFrom(initialValues);
		
		assertEquals(2, array.maxAscendingSequence());
	}
	
	@Test
	public void testMaxAscendingSequenceAtTheEnd() {
		final Integer[] initialValues = { 1, 54, 1, 5, 41,42, 5, 7, 5, 16, 7, 8, 9, 10,12 };
		final IntegerArray array = IntegerArray.integerArrayFrom(initialValues);
		
		assertEquals(10, array.maxAscendingSequence());
	}
	
	@Test
	public void testMaxAscendingSequenceAtTheBeggining() {
		final Integer[] initialValues = { 1, 2,3,4, 41,42, 5, 7, 5, 16, 7, 8, 9 };
		final IntegerArray_old array = IntegerArray_old.integerArrayFrom(initialValues);
		
		assertEquals(4, array.maxAscendingSequence());
	}

    @Test
    public void testFindTheNumberThatRepeatTheMost(){
        final Integer[] initialValues = { 1, 2, 1, 1};
        final IntegerArray_old array = IntegerArray_old.integerArrayFrom(initialValues);

        assertEquals(1, array.findTheMostOccurrences());
    }

    @Test
    public void testFindTheNumberThatRepeatTheMostWithMoreNumbers(){
        final Integer[] initialValues = { 1, 2, 1, 1,6,7,32,4,2,2,2,2,4};
        final IntegerArray_old array = IntegerArray_old.integerArrayFrom(initialValues);

        assertEquals(2, array.findTheMostOccurrences());
    }

    @Test
    public void testFindTheNumberThatRepeatTheMostWithOneOccurrence(){
        final Integer[] initialValues = { 2};
        final IntegerArray_old array = IntegerArray_old.integerArrayFrom(initialValues);

        assertEquals(2, array.findTheMostOccurrences());
    }

    @Test
    public void testFindTheNumberThatRepeatTheMostWithTwoDifferentNumbersWithOneOccurrenceEach(){
        final Integer[] initialValues = {1,2};
        final IntegerArray_old array = IntegerArray_old.integerArrayFrom(initialValues);

        assertEquals(1, array.findTheMostOccurrences());
    }
}
