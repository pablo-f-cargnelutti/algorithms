package katas.test;

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


}
