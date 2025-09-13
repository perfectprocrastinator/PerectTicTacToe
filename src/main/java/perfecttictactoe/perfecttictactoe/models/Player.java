package perfecttictactoe.perfecttictactoe.models;

public abstract class Player {

    private GameSymbol gameSymbol;

    public Player(GameSymbol gameSymbol) {
        this.gameSymbol = gameSymbol;
    }
    public abstract void play();

}
