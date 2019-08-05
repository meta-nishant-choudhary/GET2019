package quest2.com.metacube;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Unique {
	
	public static HashMap<String, Integer> cache = new HashMap<String, Integer>();
	/**
	 * methos to check the uniqueness of the string
	 * @param str type: String
	 * @return unique type: Integer
	 */
	public static Integer checkUnique(String str){
		//check for string to empty or null
		if(str == null) {
			throw new AssertionError("string can't be null");
		}
		
		if(str.length() == 0) {
			throw new AssertionError("string can't be empty");
		}
		
		int result = 0;
		
		if(!cache.containsKey(str))
		{
			HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
	        char[] strArray = str.toCharArray();
	        
	        for (char c : strArray)
	        {
	        	if(!(c == ' ')) {
		            if(charCountMap.containsKey(c))
		            {
		            	charCountMap.put(c, charCountMap.get(c)+1);
		            }
		            else
		            {
		                charCountMap.put(c, 1);
		            }
	        	}
	        }
	        
	        Integer unique = 0;
			//count unique characters in the string through map
	        for(char c : strArray) {
	        	if(!(c == ' ')) {
					if(charCountMap.get(c) == 1) {
						unique++;
					}
	        	}
			}
	        //create cache of the strings with there uniqueness
			cache.put(str, unique);
		}
		return cache.get(str);
	}
}
