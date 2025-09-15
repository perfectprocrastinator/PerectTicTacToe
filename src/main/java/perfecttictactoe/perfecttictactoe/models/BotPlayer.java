package perfecttictactoe.perfecttictactoe.models;

import lombok.Getter;
import lombok.Setter;
import perfecttictactoe.perfecttictactoe.strategies.playing.PlayingStrategy;
@Getter
@Setter
public class BotPlayer extends Player{

    private GameLevel level;
    private PlayingStrategy playingStrategy;

    public BotPlayer(GameSymbol gameSymbol,GameLevel level, PlayingStrategy playingStrategy) {
        super(gameSymbol);
        this.level=level;
        this.playingStrategy = playingStrategy;
    }

    @Override
    public BoardCell makeMove(Board board) {
       return playingStrategy.makeMove(board);
    }
}
