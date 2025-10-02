package perfecttictactoe.perfecttictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import perfecttictactoe.perfecttictactoe.exceptions.InvalidGameConfiguration;
import perfecttictactoe.perfecttictactoe.exceptions.InvalidMoveException;
import perfecttictactoe.perfecttictactoe.strategies.winning.WinningStrategy;

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
    private int nextPlayerIndex;
    private List<WinningStrategy> strategies;

    private static final GameStatus DEFAULT_STATUS=GameStatus.IN_PROGRESS;

    public void start(){
        // Assign next player index
        nextPlayerIndex = (int) (Math.random() * players.size());

        status=GameStatus.IN_PROGRESS;



    }

    public void makeMove(){
        //Get next player Move
        BoardCell move=getNextPlayerMove();



        // Make move
        // Bot- PlayingStrategy
        // Human - User Input

        // Validate move from Human
        try{
            validateMove(move);
        }
        catch (InvalidMoveException e){
            System.out.println(e.getMessage());
            nextPlayerIndex--;
            makeMove();
            return;
        }

        // Update board

        board.update(move);


        // Check for win/draw

        if(checkWinner(board,move)){
            status=GameStatus.FINISHED;
            System.out.println("Player with symbol "+move.getGameSymbol()+" has won the game!" );
        }
        if(checkDraw()){
            status=GameStatus.DRAW;
        }

    }
    private void validateMove(BoardCell move){
        if(move.getRow() <0 || move.getRow() >= board.getSize() || move.getCol() <0 || move.getCol() >= board.getSize()){
            throw new InvalidMoveException("Invalid Move at"+move.getRow()+move.getCol());
        }
        if(board.getCells().get(move.getRow()).get(move.getCol()).getGameSymbol() != GameSymbol.EMPTY){
            throw new InvalidMoveException("Cell is already occupied at"+move.getRow()+move.getCol());
        }
    }

    private BoardCell getNextPlayerMove() {
        // Get the next player
        Player currentPlayer= players.get(nextPlayerIndex % players.size());
        nextPlayerIndex=(nextPlayerIndex+1)% players.size();
        // Get the move from the player
        BoardCell move=currentPlayer.makeMove(board);
        return move;
    }

    public boolean checkWinner(Board board,BoardCell latestMove){
        for(WinningStrategy strategy: strategies){
            if(strategy.isWinner(board,latestMove)){
                return true;
            }
        }
        return false;
    }
    public Boolean checkDraw(){
        List<BoardCell> availableCells=board.getAvailableCells();
        if(availableCells.isEmpty() && status != GameStatus.FINISHED){
            System.out.println("Game is a draw");
            return true;
        }
        return false;
    }

    public void printBoard(){
        for(int i=0;i<board.getSize();i++){
            System.out.print("|");
            for(int j=0;j<board.getSize();j++){
                BoardCell cell=board.getCells().get(i).get(j);
                if(cell.getGameSymbol() != GameSymbol.EMPTY){
                    System.out.print(cell.getGameSymbol()+"|");
                }else{
                    System.out.print("_|");
                }
            }
            System.out.println();
        }

    }

    public static class GameBuilder{
        private int boardSize;
        private final List<Player> players = new ArrayList<>();
        private  GameStatus status;
        private List<WinningStrategy> winningStrategyList=new ArrayList<>();;

        public static GameBuilder builder(){
            return new GameBuilder();
        }


        public GameBuilder withSize(int boardSize){
            this.boardSize=boardSize;
            return this;
        }
        public GameBuilder withWinningStrategies(List<WinningStrategy> winningStrategyList){
            this.winningStrategyList=winningStrategyList;
            return this;
        }

        public GameBuilder withPlayer(Player player){
            this.players.add(player);
            return this;
        }


        public Game build(){
            boolean isValid= validateGame();
            if(!isValid){
                throw new InvalidGameConfiguration("Game is not valid");
            }
            return new Game(new Board(boardSize),  DEFAULT_STATUS, players,0,winningStrategyList);

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
