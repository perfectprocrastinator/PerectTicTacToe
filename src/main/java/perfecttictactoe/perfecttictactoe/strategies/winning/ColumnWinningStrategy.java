package perfecttictactoe.perfecttictactoe.strategies.winning;

import perfecttictactoe.perfecttictactoe.models.Board;
import perfecttictactoe.perfecttictactoe.models.BoardCell;

import java.util.List;

public class ColumnWinningStrategy implements WinningStrategy{
    @Override
    public boolean isWinner(Board board, BoardCell latestMove) {
        List<List<BoardCell>> rows = board.getCells();
        boolean isWinner = true;
        for (int col = 0; col < board.getSize(); col++) {
            isWinner = true;
            for (int row = 0; row < board.getSize(); row++) {
                if (rows.get(row).get(col).getGameSymbol() != latestMove.getGameSymbol()) {
                    isWinner = false;
                    break;
                }
            }
            if (isWinner) {
                return true;
            }
        }
        return isWinner;
    }
}
