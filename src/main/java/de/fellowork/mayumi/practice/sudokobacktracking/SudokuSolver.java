package de.fellowork.mayumi.practice.sudokobacktracking;

public class SudokuSolver {

    SudokuBoard boardHandler = new SudokuBoard();
    SudokuNumberChecker placement = new SudokuNumberChecker();

    public boolean hasSolvedBoard() {
        for (int row = 0; row < boardHandler.getGRID_SIZE(); row++){
            for (int column = 0; column < boardHandler.getGRID_SIZE(); column++) {
                if (boardHandler.getBoardToFill()[row][column] == 0) {
                    for (int numberToTry = 1; numberToTry <= boardHandler.getGRID_SIZE(); numberToTry++) {
                        if (placement.isValidPlacement(numberToTry, row, column)) {
                            boardHandler.getBoardToFill()[row][column] = numberToTry;

                            if (hasSolvedBoard()){
                                return true;
                            }
                            else {
                                boardHandler.getBoardToFill()[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

}
