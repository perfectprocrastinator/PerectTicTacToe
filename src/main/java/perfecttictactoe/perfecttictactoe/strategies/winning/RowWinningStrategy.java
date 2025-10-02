package perfecttictactoe.perfecttictactoe.strategies.winning;

import perfecttictactoe.perfecttictactoe.models.Board;
import perfecttictactoe.perfecttictactoe.models.BoardCell;

import java.util.List;

public class RowWinningStrategy implements WinningStrategy{
    @Override
    public boolean isWinner(Board board, BoardCell lastMove){
        List<List<BoardCell>> rows=board.getCells();
        boolean isWinner=true;
        for(List<BoardCell> row:rows){
            isWinner=true;
            for(BoardCell col: row){
                if(col.getGameSymbol() != lastMove.getGameSymbol()){
                    isWinner=false;
                    break;
                }
            }
            if(isWinner){
                return true;
            }
        }
        return isWinner;

    }
}
