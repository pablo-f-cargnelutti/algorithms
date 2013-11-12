/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codinginterviewproblems.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author pcargnel
 */
class MyString {
    private String content;

    public MyString(String content) {
        this.content = content;
    }
    
    boolean hasUniqueChars() {
        Map<Character, Boolean> charMap = new HashMap<>();
        for(int i=0; i< content.length() ; i++)
        {
            if(charMap.containsKey(content.charAt(i)))
            {
                return false;
            }
            else charMap.put(content.charAt(i), Boolean.TRUE);
        }
        return true;
    }
    
    boolean hasUniqueChars2() {
       if(content.isEmpty())
           return true;
        
        Arrays.sort(content.toCharArray());
        //content = String.valueOf(tempArray);
        
        char previous = content.charAt(0);        
        for(int i=1; i< content.length() ; i++)
        {
            if( content.charAt(i) == previous)
                return false;
            previous = content.charAt(i);                
        }
        return true;
    }
    
    
    
}
