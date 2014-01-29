package katas.src;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringArray {

	public static StringArray newFrom(final String[] strings) {
		return new StringArray(strings);
	} 
	
	private List<String> elements;

	private StringArray(final String[] strings) {
		this.elements = Arrays.asList(strings);
	}

	public void sortBasedOnAnagrams() {
		final Comparator<String> anagramComparator = new AnagramComparator();
		Collections.sort(this.elements, anagramComparator);		
	}

	public String[] asArray() {		
		final String[] tempArray = new String[2];
		return this.elements.toArray(tempArray);
	}
	
	public class AnagramComparator implements Comparator<String> {

		@Override
		public int compare(final String arg0, final String arg1) {
			return areAnagrams(arg0, arg1) ? 0 : arg0.compareTo(arg1);
		}

		private boolean areAnagrams(String arg0, String arg1) {
			for(Character character : arg0.toCharArray()) {
				if( ! arg1.contains(character.toString()) )
					return false;
			}
			return true;
		}
	}
}
