package perfecttictactoe.perfecttictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardCell {
    private int row;
    private int col;
    private GameSymbol gameSymbol;


}
