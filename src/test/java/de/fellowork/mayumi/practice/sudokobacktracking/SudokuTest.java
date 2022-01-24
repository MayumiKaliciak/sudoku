package de.fellowork.mayumi.practice.sudokobacktracking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class SudokuTest {

    private final SudokuSolver solver = new SudokuSolver();
    private final SudokuBoard board = new SudokuBoard();
    private final SudukoResultChecker checkerRes = new SudukoResultChecker();
    private final SudokuNumberChecker checkerNum = new SudokuNumberChecker();


    @ParameterizedTest
    @ValueSource (ints = {8, 7, 9, 2, 4, 0, 0, 0, 0})
    void compareRowOne(Integer numberToFillIn) {
        boolean isPartOfRowOne = checkerNum.isAlreadyNumberInRow(numberToFillIn, 1);

        assertThat(isPartOfRowOne).isTrue();
    }

    @ParameterizedTest
    @ValueSource (ints = {5, 0, 0, 7, 0, 0, 0, 9, 6})
    void compareRowThree(Integer numberToFillIn) {
        boolean isPartOfRowThree = checkerNum.isAlreadyNumberInRow(numberToFillIn, 3);

        assertThat(isPartOfRowThree).isTrue();
    }

    @ParameterizedTest
    @ValueSource (ints = {8, 0, 5, 1, 0, 9, 0, 3, 2})
    void compareColumnOne(Integer numberToFillIn) {
        boolean isPartOfColumnOne = checkerNum.isAlreadyNumberInColumn(numberToFillIn, 1);

        assertThat(isPartOfColumnOne).isTrue();
    }

    @ParameterizedTest
    @ValueSource (ints = {9, 0, 0, 8, 4, 2, 0, 0, 0})
    void compareColumnThree(Integer numberToFillIn) {
        boolean isPartOfColumnThree = checkerNum.isAlreadyNumberInColumn(numberToFillIn, 3);

        assertThat(isPartOfColumnThree).isTrue();
    }

        @Test
    void compareBoards() {

        solver.hasSolvedBoard();

        int[][] boardToTest = board.getBoardToFill();
        int[][] resultBoard = {
                {8, 7, 9, 2, 4, 6, 5, 3, 1},
                {4, 1, 6, 9, 5, 3, 2, 8, 7},
                {5, 2, 3, 7, 1, 8, 4, 9, 6},
                {1, 3, 8, 5, 7, 2, 6, 4, 9},
                {7, 6, 4, 1, 3, 9, 8, 2, 5},
                {9, 5, 2, 8, 6, 4, 1, 7, 3},
                {6, 9, 7, 4, 8, 5, 3, 1, 2},
                {3, 8, 1, 6, 2, 7, 9, 5, 4},
                {2, 4, 5, 3, 9, 1, 7, 6, 8},
        };
        assertThat(boardToTest).isEqualTo(resultBoard);
    }

    @Test
    void checkIfTrue() {

       boolean isCorrectlySolved = checkerRes.checkResult();
       assertThat(isCorrectlySolved).isTrue();
    }
}
