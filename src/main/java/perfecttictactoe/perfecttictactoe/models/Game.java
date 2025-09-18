package perfecttictactoe.perfecttictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import perfecttictactoe.perfecttictactoe.exceptions.InvalidGameConfiguration;
import perfecttictactoe.perfecttictactoe.exceptions.InvalidMoveException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class Game  {
    private final Board board;
    private GameStatus status;
    private final List<Player> players ;
    private static final GameStatus DEFAULT_STATUS=GameStatus.IN_PROGRESS;
    private int currentPlayerIndex;

    public void start(){

    }

    public void makeMove(){
        //Get next player Move
        BoardCell move=getNextPlayerMove();



        // Make move
        // Bot- PlayingStrategy
        // Human - User Input

        // Validate move from Human
        validateMove(move);

        // Update board

        board.update(move);


        // Check for win/draw

        if(checkWinner()){
            status=GameStatus.FINISHED;
        }
        if(checkDraw()){
            status=GameStatus.DRAW;
        }

    }
    private void validateMove(BoardCell move){
        if(move.getRow() <0 || move.getRow() >= board.getSize() || move.getCol() <0 || move.getCol() >= board.getSize()){
            throw new InvalidMoveException("Invalid Move at"+move.getRow()+move.getCol());
        }
        if(board.getCells().get(move.getRow()).get(move.getCol()) != null){
            throw new InvalidMoveException("Cell is already occupied at"+move.getRow()+move.getCol());
        }
    }

    private BoardCell getNextPlayerMove() {
        // Get the next player
        Player currentPlayer= players.get(currentPlayerIndex % players.size());
        currentPlayerIndex=(currentPlayerIndex+1)% players.size();
        // Get the move from the player
        BoardCell move=currentPlayer.makeMove(board);
        return move;
    }

    public boolean checkWinner(){
        return false;
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
            return new Game(new Board(boardSize),  DEFAULT_STATUS, players,0);

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
