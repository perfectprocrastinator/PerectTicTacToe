package perfecttictactoe.perfecttictactoe.models;

import perfecttictactoe.perfecttictactoe.strategies.playing.PlayingStrategy;

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
