package View;

import javax.swing.*;
import java.awt.*;

class GameBody extends JPanel {
    private final GridLayout grid = new GridLayout(3, 3);

    GameBody() {
        init();
    }

    private void init() {
        setLayout(grid);
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                AreaBlocks areaBlocks = new AreaBlocks(row, col);
                areaBlocks.setBackground(Color.gray);
                areaBlocks.setBorder(BorderFactory.createLineBorder(Color.darkGray, 2));
                add(areaBlocks);
            }
        }
    }

    void next() {
        removeAll();
        init();
        updateUI();
    }
}
