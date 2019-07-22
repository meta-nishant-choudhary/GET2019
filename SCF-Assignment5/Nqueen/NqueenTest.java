package Nqueen;

import static org.junit.Assert.*;    

import org.junit.Test;

public class NqueenTest {
	//positive test case
	@Test
    public void QueenTest() {
    	boolean expected = true;
    	int startingRow = 0;
        int sizeOfBoard = 8;
        int[][] array = new int[sizeOfBoard][sizeOfBoard];
    	assertEquals(expected, Nqueen.nQueen(array,startingRow, sizeOfBoard));
    }
	//negative test case
    @Test
    public void QueenNegativeTest() {
    	boolean expected = false;
    	int startingRow = 0;
        int sizeOfBoard = 2;
        int[][] array = new int[sizeOfBoard][sizeOfBoard];
    	assertEquals(expected, Nqueen.nQueen(array,startingRow,sizeOfBoard));
    }
}
