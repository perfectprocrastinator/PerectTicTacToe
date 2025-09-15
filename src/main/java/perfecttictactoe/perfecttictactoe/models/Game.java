package perfecttictactoe.perfecttictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import perfecttictactoe.perfecttictactoe.exceptions.InvalidGameConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class Game  {
    private final Board board;
    private final GameStatus status;
    private final List<Player> players ;
    private static final GameStatus DEFAULT_STATUS=GameStatus.IN_PROGRESS;

    public void start(){

    }

    public void makeMove(){}

    public Player checkWinner(){
        return null;
    }
    public Boolean checkDraw(){
        return false;
    }

    public static class GameBuilder{
        private int boardSize;
        private final List<Player> players = new ArrayList<>();
        private  GameStatus status;

        public static GameBuilder builder(){
            return new GameBuilder();
        }


        public GameBuilder withSize(int boardSize){
            this.boardSize=boardSize;
            return this;
        }

        public GameBuilder witPlayer(Player player){
            this.players.add(player);
            return this;
        }


        public Game build(){
            boolean isValid= validateGame();
            if(!isValid){
                throw new InvalidGameConfiguration("Game is not valid");
            }
            return new Game(new Board(boardSize),  DEFAULT_STATUS, players);

        }

        private boolean validateGame() {
            if (boardSize <= 0 || players.size() != 2) {
                return false;
            }

            Set<GameSymbol> symbolSet = players.stream()
                    .map(Player::getGameSymbol)
                    .collect(Collectors.toSet());
            return symbolSet.size() == players.size();
        }


    }



}
