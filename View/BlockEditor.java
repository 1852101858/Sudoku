package View;

import Controller.Game;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

class BlockEditor extends JTextField {
    BlockEditor(int row, int col) {
        if (Game.sudoku.getNum(row, col) != 0) {
            setText(String.valueOf(Game.sudoku.getNum(row, col)));
        }
        setFont(Window.GameFont);
        setBorder(BorderFactory.createLineBorder(Color.white, 1));
        setRightColor();
        setHorizontalAlignment(JTextField.CENTER);
        getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (getDocument().getLength() > 1) {
                    Game.sudoku.setNum(row, col, 0);
                    setWrongColor();
                } else {
                    changedUpdate(e);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (getDocument().getLength() == 0) {
                    Game.sudoku.setNum(row, col, 0);
                    setRightColor();
                } else {
                    changedUpdate(e);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                try {
                    int value = Integer.parseInt(getDocument().getText(0, 1));
                    Game.sudoku.setNum(row, col, value);
                    if (Game.sudoku.check(row, col)&&value!=0) {
                        setRightColor();
                    } else {
                        throw new Exception();
                    }
                } catch (Exception err) {
                    Game.sudoku.setNum(row, col, 0);
                    setWrongColor();
                    return;
                }
                if (Game.sudoku.isWin()) {
                    Game.solve();
                        String[] params = {};
                        RestartMain.main(params);
                }
            }
        });
    }

    private void setRightColor() {
        setForeground(Color.white);
        setBackground(Color.black);
    }

    private void setWrongColor() {
        setForeground(Color.red);
        setBackground(Color.black);
    }
}


