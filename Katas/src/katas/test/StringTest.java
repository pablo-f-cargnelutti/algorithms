package katas.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import katas.src.MyString;

import org.junit.Test;

public class StringTest {

/*
 * Implement an algorithm to determine if a string has all unique characters. 
 * What if you can not use additional data structures?
 */
	@Test
	public void testHasUniqueCharsTrue() {
		final MyString aString = new MyString("abcd");
		assertTrue(aString.hasUniqueChars());
	}
	
	@Test
	public void testHasUniqueCharsTrueWithOneLetter() {
		final MyString aString = new MyString("a");
		assertTrue(aString.hasUniqueChars());
	}
	
	@Test
	public void testHasUniqueCharsFalse() {
		final MyString aString = new MyString("aabcd");
		assertFalse(aString.hasUniqueChars());
	}
	
	@Test
	public void testHasUniqueCharsTrueNotUsingExtraSpace() {
		final MyString aString = new MyString("abcd");
		assertTrue(aString.hasUniqueChars());
	}
	
	@Test
	public void testHasUniqueCharsTrueWithOneLetterNotUsingExtraSpace() {
		final MyString aString = new MyString("a");
		assertTrue(aString.hasUniqueChars());
	}
	
	@Test
	public void testHasUniqueCharsFalseNotUsingExtraSpace() {
		final MyString aString = new MyString("abcdefghijklmnopqrstuvwxyza");
		assertFalse(aString.hasUniqueChars());
	}


	/**
	 * Design an algorithm and write code 
	 * to remove the duplicate characters in a string without using any additional buffer.
	 */
	@Test
	public void testRemoveDuplicatesSameCharacter() {
		MyString aString = new MyString("aaaaaaaaaa");
		aString.removeDuplicates();
		assertEquals("a", aString.toString());
	}
	
	@Test
	public void testRemoveDuplicatesMultipleCharacters() {
		MyString aString = new MyString("abjsjkekdsaaa");
		aString.removeDuplicates();
		assertEquals("abjsked", aString.toString());
	}
	
	@Test
	public void testRemoveDuplicatesNoDuplicates() {
		MyString aString = new MyString("acbdefg");
		aString.removeDuplicates();
		assertEquals("acbdefg", aString.toString());
	}
	
	@Test
	public void testIsAnagram() {
		MyString aString = new MyString("anita");
		assertTrue(aString.isAnagramOf("atina"));
	}
	
	@Test
	public void testIsAnagramFalse() {
		MyString aString = new MyString("anita");
		assertFalse(aString.isAnagramOf("tanit"));
	}
	
	@Test
	public void testIsAnagramWithDifferentLength() {
		MyString aString = new MyString("anita");
		assertFalse(aString.isAnagramOf("tanita"));
	}
	
	
}
