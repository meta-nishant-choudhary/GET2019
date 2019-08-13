package quest3.com.metacube;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BeatVirat {
	private static Map<String, Integer> bowlersData = new HashMap<String, Integer>();
	
	/**
	 * to addBowler in the 
	 * @param bowler
	 * @param balls
	 * @return
	 */
	public static boolean addBowler(String[]bowler, Integer[] balls) {
		if(bowler == null || balls == null) {
			throw new AssertionError("The input cannot be null");
		}
		
		if(bowler.length == 0 || balls.length == 0) {
			throw new AssertionError("empty inputs");
		}
		
		if(bowler.length != balls.length) {
			throw new AssertionError("bowlers and bowls are not equal");
		}
		
		for(int i = 0; i < bowler.length; i++) {
			bowlersData.put(bowler[i], balls[i]);
		}
		return true;
	}
	
	/**
	 * to evaluae the balls who gonna ball to virat to gave minimum runs
	 * @param ballsLeft type: integer
	 * @return List of bowlers in there bowling sequence
	 */
	public static String[] ballsPlayed(Integer ballsLeft) {
		Integer totalBallsOfBowers = 0;
		for (Entry<String, Integer> entry : bowlersData.entrySet()) {
		    totalBallsOfBowers += entry.getValue();
		}
		if(totalBallsOfBowers < ballsLeft) {
			throw new AssertionError("bowlers quota for balls are less then the virat played");
		}
			
		List<String> bowlers = new ArrayList<String>();
		String key = "";
		
        while(ballsLeft > 0) {
        	Integer maxValueInMap = (Collections.max(bowlersData.values())); // This will return max value in the Hashmap
        	for (Entry<String, Integer> entry : bowlersData.entrySet()) {  // Itrate through hashmap
                if (entry.getValue() == maxValueInMap) {
                    key = entry.getKey();
                }
            }
        	bowlers.add(key);
            bowlersData.put(key, bowlersData.get(key) - 1);
        	ballsLeft--;
        }
        String[] arr = new String[bowlers.size()];
        for(int i = 0; i < bowlers.size(); i++) {
        	arr[i] = bowlers.get(i);
        }
        
		return arr;
	}
 }
