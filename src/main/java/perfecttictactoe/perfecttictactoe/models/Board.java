package perfecttictactoe.perfecttictactoe.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Getter
public class Board {
    private int size;
    private List<List<BoardCell>> cells=new ArrayList<>();
    public Board (int size){
        this.size=size;
        this.cells=initializeBoardCells(size);
    }

    private List<List<BoardCell>> initializeBoardCells(int size){
        List<BoardCell> firstRow = Collections.nCopies(size,new BoardCell());
        List<List<BoardCell>> boardCells= Collections.nCopies(size, firstRow);
        return boardCells;

    }
}
