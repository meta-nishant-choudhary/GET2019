package quest3.com.metacube;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;



public class BeatViratTest {
	/**
	 * to test the addBowler() with null inputs
	 */
	@Test
	public void addBowlerTestWithNull() {
		String[] bowler = {"Malinga", "Zaheer", "Lee"};
		Integer[] balls = null;
		String expected = "The input cannot be null";
		try {
			BeatVirat.addBowler(bowler, balls);
			//fails();
		}
		catch(Throwable ex) {
			assertEquals(expected, ex.getMessage());
		}
	}
	
	/**
	 * to test the addBowler() with empty input
	 */
	@Test
	public void addBowlerTestWithEmpty() {
		String[] bowler = {"Malinga", "Zaheer", "Lee"};
		Integer[] balls = {};
		String expected = "empty inputs";
		try {
			BeatVirat.addBowler(bowler, balls);
			//fails();
		}
		catch(Throwable ex) {
			assertEquals(expected, ex.getMessage());
		}
	}
	
	/**
	 * to test the addBowler with UnEqual input
	 */
	@Test
	public void addBowlerTestWithUnEqualInput() {
		String expected = "bowlers and bowls are not equal";
		try {
			String[] bowler = {"Malinga", "Zaheer", "Lee"};
			Integer[] balls = {1, 2};
			BeatVirat.addBowler(bowler, balls);
			//fails();
		}
		catch(Throwable ex) {
			assertEquals(expected, ex.getMessage());
		}
	}
	
	/**
	 * to test the ballsPlayed() with error: "the balls left cannot be greater then the total quota of bowlers have"
	 */
	@Test
	public void ballsPlayedTestWithError() {
		String[] bowler = {"Malinga", "Zaheer", "Lee"};
		Integer[] balls = {1, 2, 3};
		BeatVirat.addBowler(bowler, balls);
		Integer ballsLeft = 7;
		String expected = "bowlers quota for balls are less then the virat played";
		try {
			BeatVirat.ballsPlayed(ballsLeft);
			//fails();
		}
		catch(Throwable ex) {
			assertEquals(expected, ex.getMessage());
		}
	}
	
	/**
	 * to test the ballsLeft() with correct input
	 */
	@Test
	public void ballsLeftTestForCorrectInput() {
		String[] bowler = {"Malinga", "Zaheer", "Lee"};
		Integer[] balls = {1, 2, 3};
		Integer ballsLeft = 5;
		BeatVirat.addBowler(bowler, balls);
		String[] expected = {"Lee", "Lee", "Zaheer", "Malinga", "Lee"};
		assertArrayEquals(expected, BeatVirat.ballsPlayed(ballsLeft));
	}
}
