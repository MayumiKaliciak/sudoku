package de.fellowork.mayumi.practice.sudokobacktracking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class SudokuTest {

    private final SudokuSolver solver = new SudokuSolver(new SudokuPrinter());

    @ParameterizedTest
    @ValueSource(ints = {8, 7, 9, 2, 4, 0, 0, 0, 0})
    void compareRowOne(Integer numberToFillIn) {
        SudokuBoard board = getDefaultTestBoard();
        boolean isPartOfRowOne = board.isAlreadyNumberInRow(numberToFillIn, 0);

        assertThat(isPartOfRowOne).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 0, 0, 7, 0, 0, 0, 9, 6})
    void compareRowThree(Integer numberToFillIn) {
        SudokuBoard board = getDefaultTestBoard();
        boolean isPartOfRowThree = board.isAlreadyNumberInRow(numberToFillIn, 2);

        assertThat(isPartOfRowThree).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {8, 0, 5, 1, 0, 9, 0, 3, 2})
    void compareColumnOne(Integer numberToFillIn) {
        SudokuBoard board = getDefaultTestBoard();
        boolean isPartOfColumnOne = board.isAlreadyNumberInColumn(numberToFillIn, 0);

        assertThat(isPartOfColumnOne).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {9, 0, 0, 8, 4, 2, 0, 0, 0})
    void compareColumnThree(Integer numberToFillIn) {
        SudokuBoard board = getDefaultTestBoard();
        boolean isPartOfColumnThree = board.isAlreadyNumberInColumn(numberToFillIn, 2);

        assertThat(isPartOfColumnThree).isTrue();
    }

    @Test
    void compareBoards() {
        SudokuBoard board = getDefaultTestBoard();
        solver.solveBoard(board);





        int[][] boardToTest = board.getBoard();
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


    private SudokuBoard getDefaultTestBoard() {
        int[][] testBoard = {
                {8, 7, 9, 2, 4, 0, 0, 0, 0},
                {0, 0, 0, 9, 0, 3, 0, 0, 0},
                {5, 0, 0, 7, 0, 0, 0, 9, 6},
                {1, 0, 8, 0, 0, 0, 6, 4, 9},
                {0, 0, 4, 0, 0, 0, 0, 2, 5},
                {9, 0, 2, 8, 0, 0, 0, 7, 0},
                {0, 0, 0, 4, 0, 0, 0, 1, 0},
                {3, 0, 0, 0, 2, 0, 0, 0, 0},
                {2, 4, 0, 0, 0, 1, 0, 0, 0},
        };
        return new SudokuBoard(testBoard);
    }

}
