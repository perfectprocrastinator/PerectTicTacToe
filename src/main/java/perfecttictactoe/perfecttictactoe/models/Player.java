package perfecttictactoe.perfecttictactoe.models;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Player {

    private GameSymbol gameSymbol;

    public Player(GameSymbol gameSymbol) {
        this.gameSymbol = gameSymbol;
    }
    public abstract BoardCell makeMove(Board board);

}
