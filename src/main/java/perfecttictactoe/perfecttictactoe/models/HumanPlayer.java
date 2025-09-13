package perfecttictactoe.perfecttictactoe.models;

public class HumanPlayer extends  Player{
    private User user;
    public HumanPlayer(GameSymbol gameSymbol,User user) {
        super(gameSymbol);
        this.user= user;
    }

    @Override
    public void play() {
        // Implementation for human player move
        return;
    }
}
