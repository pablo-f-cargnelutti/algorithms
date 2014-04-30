package katas.src;

import java.util.*;

public class MyString {

	public class AnagramComparator implements Comparator<String> {

		@Override
		public int compare(final String aString, final String otherString) {
			return areAnagrams(aString, otherString) ? 0 : -1;
		}

		private boolean areAnagrams(final String aString, final String otherString) {
			if( aString.length() != otherString.length() ) {
				return false;
			}
			char[] internal = aString.toCharArray();
			char[] otherInternal = otherString.toCharArray();
			Arrays.sort(internal);
			Arrays.sort(otherInternal);
			
			return Arrays.equals(internal, otherInternal);
		}

	}

    public boolean areAnagramas(String aString, String anotherString) {
        if(aString.length() != anotherString.length())
            return false;

        Map<Character, Integer> map = new HashMap<>();
        for(Character aChar : aString.toCharArray())
        {
            int occurrences = map.containsKey(aChar) ? map.get(aChar) + 1 : 1;
            map.put(aChar, occurrences);
        }

        // map: A (2), B(1)

        for(Character aChar : anotherString.toCharArray()) {
            if(map.containsKey(aChar)) {
                int value = map.get(aChar);
                if(value == 0)
                    return false;
                else {
                    value--;
                    map.put(aChar, value);
                }
            }
            else
                return false;
        }

        return true;
    } // end of method

	private String content;

	public MyString(final String content) {
		this.content = content;
	}

	public boolean hasUniqueChars() {
		boolean result = true;
		final Set<Character> characters = new HashSet<>();
		for(final Character character : content.toCharArray()) {
			if ( !characters.add(character) ) {
				result = false;
				break;
			}
		}
		return result;
	}

	public boolean hasUniqueCharsNotUsingExtraSpace(){
		boolean result = true;		
		for (int i = 0; i < content.length(); i++) {
			final Character character = content.charAt(i);
			for (int j = i+1; j < content.length(); j++) {
				final Character otherChar = content.charAt(j);
				if ( character.equals(otherChar) ) {
					result = false;
					break;
				}
			}		
		}		
		return result;
	}

	public void removeDuplicates() {
		StringBuilder temp = new StringBuilder(content);
		for (int i = 0; i < temp.length(); i++) {
			for (int j = i+1; j < temp.length(); j++) {
				if(temp.charAt(i)== temp.charAt(j)) {
					temp.deleteCharAt(j);
					j--;
				}
			}			
		}
		this.content = temp.toString();
	}
	
	@Override
	public String toString() {
		return this.content;
	}

	public boolean isAnagramOf(final String aString) {
		Comparator<String> comparator = new AnagramComparator();
		return comparator.compare(this.content, aString) == 0;
	}
}
