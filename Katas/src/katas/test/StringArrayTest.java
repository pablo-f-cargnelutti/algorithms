package katas.test;

import static org.junit.Assert.*;
import katas.src.StringArray;

import org.junit.Test;

public class StringArrayTest {

	@Test
	public void testSortArrayBasedOnAnagrams() {
		StringArray stringArray = StringArray.newFrom(new String[]{"Pepe", "cacho", "Julio", "choca"});
		stringArray.sortBasedOnAnagrams();
		assertArrayEquals(new String[]{"Julio", "Pepe", "cacho",  "choca"}, stringArray.asArray());
	}
	
	@Test
	public void testSortArrayBasedOnAnagramsWithDifferentStartingChar() {
		StringArray stringArray = StringArray.newFrom(new String[]{"Pepe", "cacho", "Julio", "ochac"});
		stringArray.sortBasedOnAnagrams();
		assertArrayEquals(new String[]{"Julio", "Pepe", "cacho",  "ochac"}, stringArray.asArray());
	}
	
	@Test
	public void testSortArrayBasedOnAnagramsTwoGroupsOfAnagrams() {
		StringArray stringArray = StringArray.newFrom(new String[]{"Lujoi", "cacho", "Julio", "ochac"});
		stringArray.sortBasedOnAnagrams();
		assertArrayEquals(new String[]{"Julio", "Lujoi", "cacho",  "ochac"}, stringArray.asArray());
	}

}
