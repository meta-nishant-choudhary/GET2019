package SparseMatrix;

import java.util.Arrays;

public class SparseMatrixOperations {

	int[][] sparseMatrix;
	int numberOfRow, numberOfColumn;

	/**
	 * Constructor to assign values to sparse matrix, row, column
	 * 
	 * @param inputMatrix
	 * complexity = O(1)
	 */
	public SparseMatrixOperations(int[][] inputMatrix) {
		if(inputMatrix.length == 0 || inputMatrix == null){
			throw new AssertionError();
		}
		try{
			sparseMatrix = inputMatrix;
			numberOfRow = inputMatrix.length;
			numberOfColumn = inputMatrix[0].length;
		}
		catch (Exception e) {
			System.out.println("wrong input");
		}
	}

	/**
	 * This method converts the sparse matrix to Triplet which only
	 * have non-zero element
	 * 
	 * @param inputMatrix
	 *            is the sparse matrix which is to be converted
	 * @return {int[][]} triplet matrix
	 * complexity: O(n^2)
	 */
	public int[][] sparseToTripletMatrix(int[][] inputMatrix) {
		int i, j;
		int numberOfNonZeros = 0;
		/*
		 * First count number of non zeros
		 */
		for (i = 0; i < numberOfRow; i++) {
			for (j = 0; j < numberOfColumn; j++) {
				if (inputMatrix[i][j] != 0)
					numberOfNonZeros++;
			}
		}
		/*
		 * Forming Triplet Matrix
		 */
		int[][] tripletMatrix = new int[numberOfNonZeros][3];
		int index = 0;
		for (i = 0; i < numberOfRow; i++) {
			for (j = 0; j < numberOfColumn; j++) {
				if (inputMatrix[i][j] != 0) {
					tripletMatrix[index][0] = i;
					tripletMatrix[index][1] = j;
					tripletMatrix[index][2] = inputMatrix[i][j];
					index++;
				}
			}
		}
		return tripletMatrix;
	}

	/**
	 * Method to convert triplet matrix to sparse matrix
	 * 
	 * @param inputMatrix
	 *            , matrix without zeroes
	 * @param row
	 *            , no of rows in the input matrix
	 * @param col
	 *            , no of columns in the input matrix
	 * @return {int[][]} Sparse Matrix
	 * complexity: O(n)
	 */
	public int[][] tripletToSparseMatrix(int[][] inputMatrix, int row, int col) {
		int sparseMatrix[][] = new int[row][col];
		for (int i = 0; i < inputMatrix.length; i++) {
			if (inputMatrix[i][2] == 0)
				break;
			int rowIndex = inputMatrix[i][0];
			int colIndex = inputMatrix[i][1];
			sparseMatrix[rowIndex][colIndex] = inputMatrix[i][2];
		}
		return sparseMatrix;
	}

	/**
	 * This method calculates the transpose of the sparse matrix
	 * 
	 * @return {int[][]} Transpose of the Sparse Matrix
	 * complexity: O(n)
	 */
	public int[][] transposeOfSparseMatrix() {
		assert getSparseMatrix().length == 0 : "Matrix size is zero";

		int[][] matrix = sparseToTripletMatrix(this.getSparseMatrix());
		int[][] transposeMatrix = new int[matrix.length][3];

		for (int i = 0; i < matrix.length; i++) {
			transposeMatrix[i][0] = matrix[i][1];
			transposeMatrix[i][1] = matrix[i][0];
			transposeMatrix[i][2] = matrix[i][2];
		}
		return tripletToSparseMatrix(transposeMatrix, numberOfColumn, numberOfRow);
	}

	/**
	 * This method checks whether the sparse matrix is symmetric or not
	 * 
	 * @return {boolean}
	 */
	public boolean isSparseMatrixSymmetric() {
		assert numberOfRow != numberOfColumn : "Only square matrix can be symmetric";

		int[][] sparseTransposeMatrix = transposeOfSparseMatrix();

		if (Arrays.deepEquals(this.getSparseMatrix(), sparseTransposeMatrix))
			return true;
		else
			return false;
	}

	/**
	 * This method adds two sparse matrices
	 * 
	 * @param inputMatrix
	 *            is the matrix whose addition is to be carried out with the
	 *            current matrix
	 * @return {int[][]} addition of the given two matrices
	 * complexity: O(n^2)
	 */
	public int[][] addTwoSparseMatrices(int[][] inputMatrix) {
		int[][] tripletMatrix1 = sparseToTripletMatrix(getSparseMatrix());
		int[][] tripletMatrix2 = sparseToTripletMatrix(inputMatrix);
		int[][] resultantMatrix = new int[tripletMatrix1.length + tripletMatrix2.length][3];

		assert tripletMatrix1.length == 0 || tripletMatrix2.length == 0 : "Matrices cannot be added";

		if (numberOfRow == inputMatrix.length && numberOfColumn == inputMatrix[0].length) {
			int rowOfMatrix1;
			int columnOfMatrix1;
			int resultantMatrixRow = 0;

			for (int i = 0; i < tripletMatrix1.length; i++) {
				rowOfMatrix1 = tripletMatrix1[i][0];
				columnOfMatrix1 = tripletMatrix1[i][1];

				int index = indexAlreadyPresent(tripletMatrix2, rowOfMatrix1, columnOfMatrix1);
				
				resultantMatrix[resultantMatrixRow][0] = rowOfMatrix1;
				resultantMatrix[resultantMatrixRow][1] = columnOfMatrix1;
				if (index >= 0) {
					resultantMatrix[resultantMatrixRow][2] = tripletMatrix1[i][2] + tripletMatrix2[index][2];
				} else {
					resultantMatrix[resultantMatrixRow][2] = tripletMatrix1[i][2];
				}
				resultantMatrixRow++;
			}

			for (int i = 0; i < tripletMatrix2.length; i++) {
				int index = indexAlreadyPresent(resultantMatrix, tripletMatrix2[i][0], tripletMatrix2[i][1]);
				if (index < 0) {
					resultantMatrix[resultantMatrixRow][0] = tripletMatrix2[i][0];
					resultantMatrix[resultantMatrixRow][1] = tripletMatrix2[i][1];
					resultantMatrix[resultantMatrixRow][2] = tripletMatrix2[i][2];
					resultantMatrixRow++;
				}
			}

		} else
			throw new AssertionError("Matrices size are unequal");

		return tripletToSparseMatrix(resultantMatrix, numberOfRow,
				numberOfColumn);
	}

	/**
	 * This method multiplies two sparse matrices
	 * 
	 * @param inputMatrix
	 *            is the matrix whose multiplication is to be carried out with
	 *            the current matrix
	 * @return {int[][]} product of the given two matrices
	 * complexity: O(n^3)
	 */
	public int[][] multiplySparseMatrix(int[][] inputMatrix) {
		int[][] matrix1 = getSparseMatrix();
		int[][] productMatrix = new int[numberOfRow][inputMatrix[0].length];

		assert numberOfColumn != inputMatrix.length : "Matrices cannot be multiplied";

		for (int i = 0; i < numberOfRow; i++) {
			for (int j = 0; j < inputMatrix[0].length; j++) {
				for (int k = 0; k < inputMatrix.length; k++) {
					productMatrix[i][j] += matrix1[i][k] * inputMatrix[k][j];
				}
			}
		}

		return productMatrix;
	}

	/**
	 * This method checks whether the given row and column index are present in
	 * the matrix
	 * 
	 * @param matrixToBeChecked
	 *            is the matrix in which the checking is to be done
	 * @param rowToBeChecked
	 *            is the row index which is to be checked
	 * @param ColumnTobeChecked
	 *            is the column index which is to be checked
	 * @return {int} index where the indices are found
	 * complexity: O(n)
	 */
	public int indexAlreadyPresent(int[][] matrixToBeChecked, int rowToBeChecked, int ColumnTobeChecked) {
		int i;
		int answer = -1;
		for (i = 0; i < matrixToBeChecked.length; i++) {
			if ((matrixToBeChecked[i][0] == rowToBeChecked)
					&& (matrixToBeChecked[i][1] == ColumnTobeChecked)) {
				answer = i;
				break;
			}
		}
		return answer;
	}

	/**
	 * This method returns the sparse matrix
	 * 
	 * @return {int[][]} Sparse matrix
	 */
	public int[][] getSparseMatrix() {
		return sparseMatrix;
	}

	/**
	 * This method returns the number of rows in the Sparse Matrix
	 * 
	 * @return {int} Number of Rows in the Sparse Matrix
	 */
	public int getRow() {
		return numberOfRow;
	}

	/**
	 * This method returns the number of columns in the Sparse Matrix
	 * 
	 * @return {int} Number of Columns in the Sparse Matrix
	 */
	public int getColumn() {
		return numberOfColumn;
	}

}
