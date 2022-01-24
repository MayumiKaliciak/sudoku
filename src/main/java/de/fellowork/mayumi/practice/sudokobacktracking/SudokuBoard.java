package de.fellowork.mayumi.practice.sudokobacktracking;

public class SudokuBoard {



    private final int GRID_SIZE = 9;

    private int[][] unsolvedBoard = {
            {8,7,9,2,4,0,0,0,0},
            {0,0,0,9,0,3,0,0,0},
            {5,0,0,7,0,0,0,9,6},
            {1,0,8,0,0,0,6,4,9},
            {0,0,4,0,0,0,0,2,5},
            {9,0,2,8,0,0,0,7,0},
            {0,0,0,4,0,0,0,1,0},
            {3,0,0,0,2,0,0,0,0},
            {2,4,0,0,0,1,0,0,0},
    };



    private int[][] boardToFill = unsolvedBoard;

    public int[][] getUnsolvedBoard() {
        return unsolvedBoard;
    }

    public int[][] getBoardToFill() {
        return boardToFill;
    }

    public int getGRID_SIZE() {
        return GRID_SIZE;
    }

}
