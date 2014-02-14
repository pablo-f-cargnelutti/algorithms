package katas.src;

import java.util.HashSet;
import java.util.Set;

public class MyString {

	private final String content;

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
}
