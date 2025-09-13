package perfecttictactoe.perfecttictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import perfecttictactoe.perfecttictactoe.models.Board;
import perfecttictactoe.perfecttictactoe.models.BoardCell;
import perfecttictactoe.perfecttictactoe.models.Game;

import java.util.List;

public class TicTacToeTest {
    @Test
    public void testCreateGame(){

    }

    @Test
    public void testCreateBoard(){

        Board board = new Board(3);
        List<List<BoardCell>> boardCells= board.getCells();
        int rowSize=boardCells.size();
        int colSize=boardCells.get(0).size();
        Assertions.assertEquals(3, rowSize, "Board should be created with 3 rows");
        Assertions.assertEquals(3,boardCells.size(), "Board rows should have 3 columns");
    }
}
