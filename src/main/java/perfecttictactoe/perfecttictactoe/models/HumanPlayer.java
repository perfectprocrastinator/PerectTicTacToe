package perfecttictactoe.perfecttictactoe.models;

import lombok.Builder;
import lombok.experimental.SuperBuilder;
import perfecttictactoe.perfecttictactoe.strategies.playing.PlayingStrategy;

@SuperBuilder
public class HumanPlayer extends  Player{
    private User user;
    public HumanPlayer(GameSymbol gameSymbol,User user) {
        super(gameSymbol);
        this.user= user;
    }

    @Override
    public BoardCell makeMove(Board board) {
        // Implementation for human player move
        return null;
    }
}
