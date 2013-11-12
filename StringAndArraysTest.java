/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codinginterviewproblems.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author pcargnel
 */
public class StringAndArraysTest {

    public StringAndArraysTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void testUniqueCharsTrue() {
        MyString myString = new MyString("abcde");
        boolean hasUniqueChars = myString.hasUniqueChars2();
        assertTrue(hasUniqueChars);
    }

    @Test
    public void testUniqueCharsFalse() {
        MyString myString = new MyString("abcdde");
        boolean hasUniqueChars = myString.hasUniqueChars2();
        assertFalse(hasUniqueChars);
    }

    @Test
    public void testUniqueCharsTrueWithEmptyString() {
        MyString myString = new MyString("");
        boolean hasUniqueChars = myString.hasUniqueChars2();
        assertTrue(hasUniqueChars);
    }

    @Test
    public void testUniqueCharsTrueWithOneCharString() {
        MyString myString = new MyString("a");
        boolean hasUniqueChars = myString.hasUniqueChars2();
        assertTrue(hasUniqueChars);
    }

    @Test
    public void testOnlyRepeateds()
    {
        Integer[] array1 = {3,1,2,4};
        Integer[] array2 = {1,4,8};
        Integer[] result = getOnlyCommon(array1, array2);
        assertEquals(result[0], Integer.valueOf(1));
        assertEquals(result[1], Integer.valueOf(4));
        assertEquals(result.length, 2);
    }
    
    @Test
    public void testAnagramsCount() {
        MyPrase myPrase = new MyPrase(new String[]{"cat", "cat", "rat", "tar", "art", "trap", "rapt", "univision", "act", "part", "trap", "part", "tarp", "rat", "face", "cafe"});
        Map<MyPrase.Anagram, MyPrase.Counter> anagrams = myPrase.anagramsCount();
        assertEquals(3, anagrams.get(new MyPrase.Anagram("cat")).get());
        assertEquals(4, anagrams.get(new MyPrase.Anagram("rat")).get());
        assertEquals(1, anagrams.get(new MyPrase.Anagram("univision")).get());
    }

    @Test
    public void testIsThereTwoNumsThatGetsSum() {
        MyArray myArray = new MyArray(new int[]{4, -6, 53, 4, 66, 8, 47});
        boolean isThereTwoIntsToGetSum = myArray.isThereTwoIntsToGetSum(-2);
        assertTrue(isThereTwoIntsToGetSum);
    }

    @Test
    public void testSubArray() {
        MyArray myArray = new MyArray(null);
        int[] array = {1, 56, 45, 4, 7, 45};
        int[] subArray = {4};
        int actual = myArray.findArray(array, subArray);
        assertEquals(2, actual);
    }

    private Integer[] getOnlyCommon(Integer[] array1, Integer[] array2) {
        Map<Integer, Integer> map;
        Integer[] longestArray = array1.length >= array2.length ? array1 : array2;
        Integer[] shorterArray = array1.length >= array2.length ? array2 : array1;
        map = getMapFrom(shorterArray);
        List<Integer> commonValues = new ArrayList(shorterArray.length);        
        for (int value : longestArray) {
            if(map.containsKey(value))
               commonValues.add(value); 
        }
        Integer[] temp = new Integer[commonValues.size()];
        return commonValues.toArray(temp);
    }

    private Map<Integer, Integer> getMapFrom(Integer[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            map.put(i, i);
        }
        return map;
    }
}
class MyPrase {

    private List<String> words;

    public MyPrase(final String[] words) {
        this.words = Arrays.asList(words);
    }

    public Map<Anagram, Counter> anagramsCount() {
        Map<Anagram, Counter> anagrams = new HashMap<>();
        
        for (final String word : words) {
            Anagram anagram = new Anagram(word);            
            Counter auxCounter = new Counter(1);
            Counter oldCounter = anagrams.put(anagram, auxCounter);
            if(oldCounter != null)                
                auxCounter.incrementBy(oldCounter.get());                        
        }
        return anagrams;
    }

    static class Counter {
        int counter;
        public Counter(int from) {
            this.counter = from;
        }

        void incrementOne() {
            ++counter;
        }

        int get() {
            return counter;
        }

        private void incrementBy(int aNumber) {
            counter += aNumber; 
        }
    }

    static class Anagram {

        private final String word;
        private int hashCode;

        public Anagram(final String word) {
            this.word = word;
            calculateHashCode();
        }

        public String get() {
            return this.word;
        }

        public boolean isAnagramOf(final String otherWord) {
            if (otherWord.length() != word.length()) {
                return false;
            }
            char[] wordCharArray = word.toCharArray();
            char[] otherWordCharArray = otherWord.toCharArray();
            Arrays.sort(wordCharArray);
            Arrays.sort(otherWordCharArray);
            return Arrays.equals(otherWordCharArray, wordCharArray);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Anagram other = (Anagram) obj;
            if (!Objects.equals(this.hashCode, other.hashCode)) {
                return false;
            }
            return true;
        }
        
        
        public int hashCode()
        {
            return this.hashCode;
        }

        private void calculateHashCode() {
            hashCode = 0;
            for (Character character : word.toCharArray()) {
                hashCode += character.hashCode();
            } 
        }
    }
}

class MyArray {

    private int[] array;

    public MyArray(int[] elements) {
        array = elements;
    }

    public boolean isThereTwoIntsToGetSum(int sum) {
        Map<Integer, Integer> nums = new HashMap<>();
        for (int num : array) {
            nums.put(num, num);
        }

        for (int num : array) {
            int difference = sum - num;
            if (nums.containsKey(difference)) {
                return true;
            }
        }
        return false;
    }

    int findArray(int[] array, int[] subArray) {
        if (array.length == 0 || subArray.length == 0) {
            return -1;
        }
        if (subArray.length > array.length) {
            return -1;
        }
        int diff = array.length - subArray.length;
        int[] auxArray = new int[subArray.length];
        for (int i = 0; i <= diff; i++) {
            System.arraycopy(array, i, auxArray, 0, subArray.length);
            if (Arrays.equals(auxArray, subArray)) {
                return i;
            }
        }
        return -1;
    }

    private void fillMap(int[] array, Map<Integer, Integer> arrayValueIndexMap) {
        for (int i = 0; i < array.length; i++) {
            arrayValueIndexMap.put(array[i], i);
        }
    }
}