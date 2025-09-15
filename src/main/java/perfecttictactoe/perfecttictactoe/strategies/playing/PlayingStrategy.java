package perfecttictactoe.perfecttictactoe.strategies.playing;

import perfecttictactoe.perfecttictactoe.models.Board;
import perfecttictactoe.perfecttictactoe.models.BoardCell;

public interface PlayingStrategy {
    BoardCell makeMove(Board board);
}
