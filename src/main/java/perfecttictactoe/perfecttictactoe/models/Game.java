package perfecttictactoe.perfecttictactoe.models;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
public class Game  {
    private Board board;
    private List<Player> players = new ArrayList<>();
    private GameStatus status;

    public void start(){

    }

    public void makeMove(){}

    public Player checkWinner(){
        return null;
    }
    public Boolean checkDraw(){
        return false;
    }



}
