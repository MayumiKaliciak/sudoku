package de.fellowork.mayumi.practice.sudokobacktracking;

public class SudokuPrinter {

    SudokuBoard boardHandler = new SudokuBoard();

    void printOutSuccess() {
        System.out.println("Successfully solved Sudoku!");
    }

    void printOutFailed() {
        System.out.println("Failed to solve Sudoku, not possible to solve!");
    }

    void printSolvedBoard() {
        for (int row = 0; row < boardHandler.getGRID_SIZE(); row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("-----------");
            }
            for (int column = 0; column < boardHandler.getGRID_SIZE(); column++) {
                if (column % 3 == 0 && column != 0) {
                    System.out.print("|");
                }
                System.out.print(boardHandler.getBoardToFill()[row][column]);
            }
            System.out.println();
        }

    }
}
