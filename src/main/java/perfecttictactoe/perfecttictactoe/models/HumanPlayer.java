package perfecttictactoe.perfecttictactoe.models;

import lombok.Builder;
import lombok.experimental.SuperBuilder;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import perfecttictactoe.perfecttictactoe.strategies.playing.PlayingStrategy;

import java.util.Scanner;

@SuperBuilder
public class HumanPlayer extends  Player{
    private User user;
    @Builder.Default
    private Scanner scanner = new Scanner(System.in);
    public HumanPlayer(GameSymbol gameSymbol,User user) {
        super(gameSymbol);
        this.user= user;
    }

    @Override
    public BoardCell makeMove(Board board) {
        // Implementation for human player move
        System.out.println("Enter your move (row and column): ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new BoardCell(row, col, this.getGameSymbol());

    }
}
