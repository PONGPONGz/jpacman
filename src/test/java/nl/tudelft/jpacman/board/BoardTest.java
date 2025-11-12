package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test suite to confirm that {@link Board} works correctly.
 *
 * @author Jeroen Roosen 
 */
class BoardTest {

    /**
     * The board under test.
     */
    private Board board;

    /**
     * The grid used to create the board.
     */
    private Square[][] grid;

    /**
     * Sets up a 1x1 board with a BasicSquare.
     */
    @BeforeEach
    void setUp() {
        grid = new Square[1][1];
        grid[0][0] = new BasicSquare();
        board = new Board(grid);
    }

    /**
     * Verifies that the board is created with the correct dimensions.
     */
    @Test
    void testBoardCreation() {
        assertThat(board).isNotNull();
        assertThat(board.getWidth()).isEqualTo(1);
        assertThat(board.getHeight()).isEqualTo(1);
    }

    /**
     * Verifies that the square at position (0,0) is the one we placed there.
     */
    @Test
    void testSquareAt() {
        Square square = board.squareAt(0, 0);
        assertThat(square).isNotNull();
        assertThat(square).isEqualTo(grid[0][0]);
    }

    /**
     * Verifies that positions within the board are recognized as within borders.
     */
    @Test
    void testWithinBorders() {
        assertThat(board.withinBorders(0, 0)).isTrue();
    }

    /**
     * Verifies that positions outside the board are recognized as outside borders.
     */
    @Test
    void testOutsideBorders() {
        assertThat(board.withinBorders(1, 0)).isFalse();
        assertThat(board.withinBorders(0, 1)).isFalse();
        assertThat(board.withinBorders(-1, 0)).isFalse();
        assertThat(board.withinBorders(0, -1)).isFalse();
    }

    /**
     * Verifies that attempting to create a board with a null square fails.
     * This test constructs a board with a null square and attempts to access it.
     */
    @Test
    void testBoardWithNullSquare() {
        Square[][] gridWithNull = new Square[1][1];
        gridWithNull[0][0] = null;
        Board boardWithNull = new Board(gridWithNull);
        
        // Attempting to access the square at (0,0)
        Square square = boardWithNull.squareAt(0, 0);
        assertThat(square).isNull();
    }
}
