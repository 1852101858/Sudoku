package View;

import Controller.Game;
import javax.swing.*;
import java.awt.*;

class AreaBlocks extends JPanel {
    private final GridLayout grid = new GridLayout(3, 3);
    private final int Row;
    private final int Col;

    AreaBlocks(int Row, int Col) {
        this.Row = Row;
        this.Col = Col;
        init();
    }

    private void init() {
        setLayout(grid);
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                int row = Row * 3 + r + 1;
                int col = Col * 3 + c + 1;
                if (Game.sudoku.canEdit(row, col)) {
                    add(new BlockEditor(row, col));
                } else {
                    add(new BlockViewer(row, col));
                }
            }
        }
    }
}
