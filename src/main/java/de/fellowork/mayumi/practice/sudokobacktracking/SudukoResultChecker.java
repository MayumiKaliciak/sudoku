package de.fellowork.mayumi.practice.sudokobacktracking;

public class SudukoResultChecker {
    SudokuSolver solve = new SudokuSolver();
    SudokuPrinter print = new SudokuPrinter();

    public boolean checkResult() {
        if (solve.hasSolvedBoard()) {
            print.printOutSuccess();
            print.printSolvedBoard();
            return true;
        }
        print.printOutFailed();
        return false;
    }

}
