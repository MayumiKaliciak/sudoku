package de.fellowork.mayumi.practice.sudokobacktracking;

public class SudokuSolver {

    private final SudokuPrinter printer;

    public SudokuSolver(SudokuPrinter printer) {
        this.printer = printer;
    }

    public void solveBoard(SudokuBoard sudokuBoard) {
        if(solveBoardWithBacktracking(sudokuBoard)) {
            printer.printOutSuccess();
            printer.printSolvedBoard(sudokuBoard);
        } else {
        printer.printOutFailed();
        }
    }


    boolean solveBoardWithBacktracking(SudokuBoard sudokuBoard) {

        for (int row = 0; row < sudokuBoard.getGRID_SIZE(); row++){
            for (int column = 0; column < sudokuBoard.getGRID_SIZE(); column++) {
                if (isFreeField(sudokuBoard, row, column)) {
                    for (int numberToTry = 1; numberToTry <= sudokuBoard.getGRID_SIZE(); numberToTry++) {
                        if (isPossiblyCorrectNumber(sudokuBoard, row, column, numberToTry)) {
                            putNumberIntoBoard(sudokuBoard, row, column, numberToTry);

                            if (solveBoardWithBacktracking(sudokuBoard)){
                                return true;

                            }
                            else {
                                sudokuBoard.getBoard()[row][column] = 0;
                            }
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }


    private boolean isFreeField(SudokuBoard sudokuBoard, int row, int column) {
        return sudokuBoard.getBoard()[row][column] == 0;
    }

    private boolean isPossiblyCorrectNumber(SudokuBoard sudokuBoard, int row, int column, int numberToTry) {
        return sudokuBoard.isValidPlacement(numberToTry, row, column);
    }

    private void putNumberIntoBoard(SudokuBoard sudokuBoard, int row, int column, int numberToTry) {
        sudokuBoard.getBoard()[row][column] = numberToTry;
    }




}
