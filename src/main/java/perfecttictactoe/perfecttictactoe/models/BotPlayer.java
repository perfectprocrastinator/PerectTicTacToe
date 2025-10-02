package perfecttictactoe.perfecttictactoe.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import perfecttictactoe.perfecttictactoe.strategies.playing.PlayingStrategy;
@Getter
@Setter
@SuperBuilder
public class BotPlayer extends Player{

    private GameLevel level;
    private PlayingStrategy playingStrategy;

    @Override
    public BoardCell makeMove(Board board) {
       BoardCell cell= playingStrategy.makeMove(board);
       return new BoardCell(cell.getRow(), cell.getCol(),this.getGameSymbol());
    }
}
