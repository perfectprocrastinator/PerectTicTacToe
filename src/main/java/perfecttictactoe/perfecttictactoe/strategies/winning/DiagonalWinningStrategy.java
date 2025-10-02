package perfecttictactoe.perfecttictactoe.strategies.winning;

import perfecttictactoe.perfecttictactoe.models.Board;
import perfecttictactoe.perfecttictactoe.models.BoardCell;

public class DiagonalWinningStrategy implements WinningStrategy{
    @Override
    public boolean isWinner(Board board, BoardCell lastMove) {
        for(int i=0;i<board.getSize();i++){
            if(board.getCells().get(i).get(i).getGameSymbol() != lastMove.getGameSymbol()){
                return false;
            }
        }
        for(int i=0;i<board.getSize();i++){
            if(board.getCells().get(i).get(board.getSize()-i-1).getGameSymbol() != lastMove.getGameSymbol()){
                return false;
            }
        }
        return true;
    }

}
