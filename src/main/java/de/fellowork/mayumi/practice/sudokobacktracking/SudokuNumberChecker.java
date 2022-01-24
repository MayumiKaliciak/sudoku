package de.fellowork.mayumi.practice.sudokobacktracking;

public class SudokuNumberChecker {
    SudokuBoard boardHandler = new SudokuBoard();

    public boolean isValidPlacement(int numberToFillIn, int row, int column) {

        return !isAlreadyNumberInRow(numberToFillIn, row) &&
                !isAlreadyNumberInColumn(numberToFillIn, column) &&
                !isAlreadyNumberInSquare(numberToFillIn, row, column);
    }

    public boolean isAlreadyNumberInRow(int numberToFillIn, int row) {

        for(int i = 0; i< boardHandler.getGRID_SIZE(); i++) {
            if(boardHandler.getUnsolvedBoard()[row] [i] == numberToFillIn) {
                return true;
            }
        }
        return false;
    }

    public boolean isAlreadyNumberInColumn(int numberToFillIn, int column) {

        for(int i = 0; i< boardHandler.getGRID_SIZE(); i++) {
            if(boardHandler.getUnsolvedBoard()[i] [column] == numberToFillIn) {
                return true;
            }
        }
        return false;
    }

    public boolean isAlreadyNumberInSquare(int numberToFillIn, int row, int column) {

        int localSquareRow = row - (row % 3);
        int localSquareColumn = column - (column % 3);

        for (int i=localSquareRow; i< localSquareRow + 3; i++) {
            for (int j = localSquareColumn; j < localSquareColumn + 3; j++) {

                if (boardHandler.getUnsolvedBoard()[i][j] == numberToFillIn) {
                    return true;
                }
            }
        }
        return false;
    }
}
