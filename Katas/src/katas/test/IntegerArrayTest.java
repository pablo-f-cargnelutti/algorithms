package katas.test;

import static org.junit.Assert.*;
import katas.src.IntegerArray;
import katas.src.Pair;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IntegerArrayTest {

	@Test
	public void testGetTwoNumbersThanSum10() {
		final Integer[] initialValues = { 1, 54, 1, 5, 41, 5, 7, 5, 16, 7, 9 };
		final IntegerArray array = new IntegerArray(initialValues);
		assertTrue(array.hasTwoNumbersThatSum(10));
	}

	@Test
	public void testWhichIsThePairThatRepresentTheMinimalSum()
			throws IllegalStateException {
		final Integer[] initialValues = { 8, 10, 12, 1, 2 };
		final IntegerArray array = new IntegerArray(initialValues);
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
		final IntegerArray array = new IntegerArray(initialValues);
		array.getPairWithMinimalSum();
	}

	@Test
	public void testWhichIsThePairThatRepresentTheMinimalSumWithComplexData()
			throws IllegalStateException {
		final Integer[] initialValues = { 1, 54, 1, 5, 41, 5, 7, 5, 16, 7, 9 };
		final IntegerArray array = new IntegerArray(initialValues);
		final Pair<Integer, Integer> pair = array.getPairWithMinimalSum();

		assertEquals(pair.left(), Integer.valueOf(1));
		assertEquals(pair.right(), Integer.valueOf(1));
	}

}
