package de.fellowork.mayumi.practice.sudokobacktracking;

public class SudokuBoard {

    private final int GRID_SIZE = 9;
    private final int[][] board;

    public SudokuBoard(int[][] board) {
        this.board = board;
    }

    public boolean isValidPlacement(int numberToFillIn, int row, int column) {

        return !isAlreadyNumberInRow(numberToFillIn, row) &&
                !isAlreadyNumberInColumn(numberToFillIn, column) &&
                !isAlreadyNumberInSquare(numberToFillIn, row, column);
    }

    boolean isAlreadyNumberInRow(int numberToFillIn, int row) {

        for(int i = 0; i< GRID_SIZE; i++) {
            if(getBoard()[row] [i] == numberToFillIn) {
                return true;
            }
        }
        return false;
    }

    boolean isAlreadyNumberInColumn(int numberToFillIn, int column) {

        for(int i = 0; i< GRID_SIZE; i++) {
            if(getBoard()[i] [column] == numberToFillIn) {
                return true;
            }
        }
        return false;
    }

    boolean isAlreadyNumberInSquare(int numberToFillIn, int row, int column) {

        int localSquareRow = row - (row % 3);
        int localSquareColumn = column - (column % 3);

        for (int i=localSquareRow; i< localSquareRow + 3; i++) {
            for (int j = localSquareColumn; j < localSquareColumn + 3; j++) {

                if (getBoard()[i][j] == numberToFillIn) {
                    return true;
                }
            }
        }
        return false;
    }

    public int[][] getBoard() {
        return board;
    }

    public int getGRID_SIZE() {
        return GRID_SIZE;
    }


}
