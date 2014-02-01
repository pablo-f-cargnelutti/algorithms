package katas.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import katas.src.IntegerArray;
import katas.src.Pair;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IntegerArrayTest {

	@Test
	public void testGetTwoNumbersThanSum10() {
		final Integer[] initialValues = { 1, 54, 1, 5, 41, 5, 7, 5, 16, 7, 9 };
		final IntegerArray array = IntegerArray.integerArrayFrom(initialValues);
		assertTrue(array.hasTwoNumbersThatSum(10));
	}

	@Test
	public void testWhichIsThePairThatRepresentTheMinimalSum()
			throws IllegalStateException {
		final Integer[] initialValues = { 8, 10, 12, 1, 2 };
		final IntegerArray array = IntegerArray.integerArrayFrom(initialValues);
		final Pair<Integer, Integer> pair = array.getPairWithMinimalSum();

		assertEquals(pair.left(), Integer.valueOf(1));
		assertEquals(pair.right(), Integer.valueOf(2));
	}

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void testWhichIsThePairThatRepresentTheMinimalSumWithNotEnoughData()
			throws IllegalStateException {
		expectedException.expect(IllegalStateException.class);

		final Integer[] initialValues = { 8 };
		final IntegerArray array = IntegerArray.integerArrayFrom(initialValues);
		array.getPairWithMinimalSum();
	}

	@Test
	public void testWhichIsThePairThatRepresentTheMinimalSumWithComplexData()
			throws IllegalStateException {
		final Integer[] initialValues = { 1, 54, 1, 5, 41, 5, 7, 5, 16, 7, 9 };
		final IntegerArray array = IntegerArray.integerArrayFrom(initialValues);
		final Pair<Integer, Integer> pair = array.getPairWithMinimalSum();

		assertEquals(pair.left(), Integer.valueOf(1));
		assertEquals(pair.right(), Integer.valueOf(1));
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
	public void testMergeTwoSortedArraysToMergeGreatherThanBaseArray()
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
	public void testMergeTwoSortedArraysWhithrRepetitions()
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
		final Integer[] initialValues = { 1, 54, 1, 5, 41,42, 5, 7, 5, 16, 7, 8, 9 };
		final IntegerArray array = IntegerArray.integerArrayFrom(initialValues);
		
		assertEquals(3, array.maxAscendingSequence());
	}
	
	@Test
	public void testMaxAscendingSequenceAtTheBeggining() {
		final Integer[] initialValues = { 1, 2,3,4, 41,42, 5, 7, 5, 16, 7, 8, 9 };
		final IntegerArray array = IntegerArray.integerArrayFrom(initialValues);
		
		assertEquals(4, array.maxAscendingSequence());
	}
}
