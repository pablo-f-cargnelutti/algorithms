package katas.src;

import java.util.*;
import java.util.LinkedList;

public class StringArray {

	public static StringArray newFrom(final String[] strings) {
		return new StringArray(strings);
	} 
	
	private final List<String> elements;

	private StringArray(final String[] strings) {
		this.elements = Arrays.asList(strings);
	}

	public void sortBasedOnAnagrams() {
		Map<String, List<String>> multiValueMap = new HashMap<>();
        for(String element : elements) {
            char[] charArray = element.toCharArray();
            Arrays.sort(charArray);
            if (multiValueMap.containsKey(element) || multiValueMap.containsKey(charArray.toString()) ){
                multiValueMap.get(element).add(element);
            }
            else{
                multiValueMap.put(element, new LinkedList<>());
            }
        }
        System.out.print(multiValueMap);
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

		private boolean areAnagrams(final String arg0, final String arg1) {
			boolean result = false;
			if(arg0.length() == arg1.length()) {
				result = true;
				for(final Character character : arg0.toCharArray()) {
					if( ! arg1.contains(character.toString()) ) {
						result = false;
						break;
					}
				}				
			}
			return result;
		}
	}
}
