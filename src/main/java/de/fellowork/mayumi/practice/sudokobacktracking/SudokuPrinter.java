package de.fellowork.mayumi.practice.sudokobacktracking;

public class SudokuPrinter {

    void printOutSuccess() {
        System.out.println("Successfully solved Sudoku!");
    }

    void printOutFailed() {
        System.out.println("Failed to solve Sudoku, not possible to solve!");
    }

    void printSolvedBoard(SudokuBoard sudokuBoard) {
        for (int row = 0; row < sudokuBoard.getGRID_SIZE(); row++) {
            if (isMultipleOfThree(row)) {
                System.out.println("-----------");
            }
            for (int column = 0; column < sudokuBoard.getGRID_SIZE(); column++) {
                if (isMultipleOfThree(column)) {
                    System.out.print("|");
                }
                System.out.print(sudokuBoard.getBoard()[row][column]);
            }
            System.out.println();
        }

    }

    private boolean isMultipleOfThree(int row) {
        return row % 3 == 0 && row != 0;
    }
}
