package perfecttictactoe.perfecttictactoe.strategies.playing;

import perfecttictactoe.perfecttictactoe.models.Board;
import perfecttictactoe.perfecttictactoe.models.BoardCell;
import perfecttictactoe.perfecttictactoe.models.GameStatus;
import perfecttictactoe.perfecttictactoe.models.GameSymbol;

import java.util.List;
import java.util.stream.Collectors;

public class RandomPlayingStrategy implements PlayingStrategy{
    @Override
    public BoardCell makeMove(Board board) {
        // Get a list of available cells

        List<BoardCell> availableCells = board.getAvailableCells();

        int availableIndex = (int) (Math.random() * availableCells.size());

        return availableCells.get(availableIndex);

    }
}
