package perfecttictactoe.perfecttictactoe.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
public class Board {
    private int size;
    private List<List<BoardCell>> cells=new ArrayList<>();
    public Board (int size){
        this.size=size;
        this.cells=initializeBoardCells(size);
    }

    private List<List<BoardCell>> initializeBoardCells(int size){
        List<List<BoardCell>> cells=new ArrayList<>();
        IntStream.range(0,size).forEach(row->{
            List<BoardCell> rowCells=new ArrayList<>();
            IntStream.range(0,size).forEach(col->{
                rowCells.add(new BoardCell(row,col,GameSymbol.EMPTY));
            });
            cells.add(rowCells);
        });
        return cells;

    }

    public void update(BoardCell move){

        cells.get(move.getRow()).get(move.getCol()).setGameSymbol(move.getGameSymbol());
    }

    public List<BoardCell>  getAvailableCells(){
        return cells.stream()
                .flatMap(List::stream)
                .filter(cell -> cell.getGameSymbol() == GameSymbol.EMPTY)
                .collect(Collectors.toList());
    }
}
