package perfecttictactoe.perfecttictactoe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import perfecttictactoe.perfecttictactoe.models.BotPlayer;
import perfecttictactoe.perfecttictactoe.models.Game;
import perfecttictactoe.perfecttictactoe.models.GameStatus;
import perfecttictactoe.perfecttictactoe.models.GameSymbol;
import perfecttictactoe.perfecttictactoe.models.HumanPlayer;
import perfecttictactoe.perfecttictactoe.models.Player;
import perfecttictactoe.perfecttictactoe.models.User;
import perfecttictactoe.perfecttictactoe.strategies.playing.RandomPlayingStrategy;
import perfecttictactoe.perfecttictactoe.strategies.winning.ColumnWinningStrategy;
import perfecttictactoe.perfecttictactoe.strategies.winning.DiagonalWinningStrategy;
import perfecttictactoe.perfecttictactoe.strategies.winning.RowWinningStrategy;

import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class PerfectTicTacToeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PerfectTicTacToeApplication.class, args);
    }

}
@Component
class TicTacToeRunner implements CommandLineRunner {
    private static final int DEFAULT_BOARD_SIZE = 3;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Tic Tac Toe Game Started!");
        // You can initialize and start your game logic here

        //Get User input and create a user
        HumanPlayer humanPlayer=getUserInput();

        // Create a game
        Game game = createGame(humanPlayer);

        //Start the game
        game.start();

        // Start playing, Loop until the Game finishes or Draws
        while(game.getStatus().equals(GameStatus.IN_PROGRESS)){
            Player nextPlayer = getNextPlayer(game);
            System.out.println("Next Player: " + nextPlayer.getGameSymbol());
            game.makeMove();
            game.printBoard();
        }







    }
    private Player getNextPlayer(Game game){
        return game.getPlayers().get(game.getNextPlayerIndex());
    }

    private Game createGame(HumanPlayer humanPlayer){
        // Create a game with the human player and a bot player
        return Game.GameBuilder.builder()
                .withPlayer(humanPlayer)
                .withPlayer(BotPlayer.builder()
                        .gameSymbol(getBotPlayerSymbol(humanPlayer.getGameSymbol()))
                        .playingStrategy(new RandomPlayingStrategy())
                        .build())
                .withSize(DEFAULT_BOARD_SIZE)
                .withWinningStrategies(List.of(new RowWinningStrategy(),new ColumnWinningStrategy(),new DiagonalWinningStrategy()))
                .build();
    }
    // TODO: GET THE LIST OF SYMBOLS AND FILTER OUT THE SYMBOLS USED AND THEN SELECT RANDOMLY THE UNUSED SYMBOL
    private GameSymbol getBotPlayerSymbol(GameSymbol humanPlayerSymbol){
        return humanPlayerSymbol==GameSymbol.X ? GameSymbol.O : GameSymbol.X;
    }

    private HumanPlayer getUserInput(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your name:");
        String name=sc.nextLine();
        System.out.println("Enter your email:");
        String email=sc.nextLine();
        User user = User.builder().name(name).email(email).build();
        System.out.println("Enter your symbol (X/O):");
        try{
            GameSymbol symbol=GameSymbol.valueOf(sc.nextLine().toUpperCase());
            return HumanPlayer.builder().gameSymbol(symbol).user(user).build();
        }catch (Exception e){
            System.out.println("Invalid symbol. Please enter X or O.");
            return getUserInput();
        }


    }
}
