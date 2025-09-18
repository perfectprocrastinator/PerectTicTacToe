package perfecttictactoe.perfecttictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import perfecttictactoe.perfecttictactoe.models.Board;
import perfecttictactoe.perfecttictactoe.models.BoardCell;
import perfecttictactoe.perfecttictactoe.models.BotPlayer;
import perfecttictactoe.perfecttictactoe.models.Game;
import perfecttictactoe.perfecttictactoe.models.GameLevel;
import perfecttictactoe.perfecttictactoe.models.GameStatus;
import perfecttictactoe.perfecttictactoe.models.GameSymbol;
import perfecttictactoe.perfecttictactoe.models.HumanPlayer;
import perfecttictactoe.perfecttictactoe.models.User;
import perfecttictactoe.perfecttictactoe.strategies.playing.RandomPlayingStrategy;

import java.util.List;

public class TicTacToeTest {

    private static final int DEFAULT_BOARD_SIZE=3;
    @Test
    public void testCreateGame(){
        Game game=Game.GameBuilder
                .builder()
                .withSize(DEFAULT_BOARD_SIZE)
                .witPlayer(HumanPlayer.builder()
                        .user(User.builder().email("b@c").name("Bilal").build())
                        .gameSymbol(GameSymbol.X)
                        .build())
                .witPlayer(BotPlayer.builder()
                        .gameSymbol(GameSymbol.O)
                        .playingStrategy(new RandomPlayingStrategy())
                        .build())
                .build();

        Assertions.assertNotNull(game, "Game should be created");
        Assertions.assertEquals(GameStatus.IN_PROGRESS, game.getStatus(), "New game should be in progress");
        Assertions.assertEquals(2,game.getPlayers().size(), "Game should have 2 players");

    }



    @Test
    public void testCreateBoard(){

        Board board = new Board(3);
        List<List<BoardCell>> boardCells= board.getCells();
        int rowSize=boardCells.size();
        int colSize=boardCells.get(0).size();
        Assertions.assertEquals(3, rowSize, "Board should be created with 3 rows");
        Assertions.assertEquals(3,boardCells.size(), "Board rows should have 3 columns");
    }
}
