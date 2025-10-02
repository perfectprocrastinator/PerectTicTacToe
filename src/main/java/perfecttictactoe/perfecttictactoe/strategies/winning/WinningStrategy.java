package perfecttictactoe.perfecttictactoe.strategies.winning;

import lombok.AllArgsConstructor;
import perfecttictactoe.perfecttictactoe.models.Board;
import perfecttictactoe.perfecttictactoe.models.BoardCell;

public interface WinningStrategy {
    boolean isWinner(Board board, BoardCell lastMove);
}
