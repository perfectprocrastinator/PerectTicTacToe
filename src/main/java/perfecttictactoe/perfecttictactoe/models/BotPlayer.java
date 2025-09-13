package perfecttictactoe.perfecttictactoe.models;

public class BotPlayer extends Player{
    public BotPlayer(GameSymbol gameSymbol,GameSymbol symbol) {
        super(gameSymbol);
        this.level=level;
    }

    private GameLevel level;

    @Override
    public void play() {

    }
}
