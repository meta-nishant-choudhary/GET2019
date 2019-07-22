package Nqueen;

public class Nqueen {
	
	/**
	 * checks if the queen can be placed or not
	 * @param board
	 * @param row
	 * @param col
	 * @return true if queen can be placed else false.
	 */
	public static boolean isValid(int[][] board,int row,int col)
	{
		int size = board[0].length;
		//checks upper left diagonal
		for(int i=row,j=col;i>=0 && j>=0;i--,j--){
			if(board[i][j] == 1) {
				return false;
			}
		}
		//checks lower left diagonal
		for(int i=row,j=col;i<size-1 && j>=0;i++,j--){
			if(board[i][j] == 1) {
				return false;
			}
		}
		//check upper column
		for(int i=row;i>=0;i--){
			if(board[i][col]==1){
				return false;
			}
		}
		//check lower column
		for(int i=0;i<size;i++){
			if(board[i][col]==1){
				return false;
			}
		}
		//check upper right diagonal
		for(int i=row,j=col;i>=0 && j<size;i--,j++){
			if(board[i][j]==1){
				return false;
			}
		}
		//check lower right diagonal
		for(int i=row,j=col;i<size && j<size;i++,j++){
			if(board[i][j]==1){
				return false;
			}
		}
		return true;
	}
	
	
	public static boolean nQueen(int[][] board, int startRow,int queen)
	{
		//return if all queen is placed
		if(queen==0) {
			return true;
		}
		int size = board[0].length;
		/*loop for selecting one row and increasing the column size
		* for check place for queen
		*/
		for(int col = 0;col<size;col++)
		{
			/*
			* checks given place is right or not
			*/
			if(isValid(board,startRow,col))
			{
				board[startRow][col] = 1;
				queen --;
				//making the board kind of circular
				if(startRow==size-1) {
					startRow = -1;
				}
				/*
				* recursive function that call itself with next row value
				*/	
				if(nQueen(board,startRow+1,queen)) {
					return true;
				}
				//making the board kind of circular
				if(startRow<=-1) {
					startRow = size-1;
				}
				//remove the queen
				board[startRow][col] = 0;
				queen += 1;
			}
		}
		return false;
	}
}
