package View;

import Controller.Game;
import javax.swing.*;

public class ToolBar extends JPanel {

    public ToolBar() {
        init();
    }

    private void init() {
        JButton btn_solve = new JButton("答案");
        btn_solve.setFont(Window.ToolFont);
        btn_solve.addActionListener(e -> Game.solve());
        add(btn_solve);
        JButton btn_next1 = new JButton("新游戏");
        btn_next1.setFont(Window.ToolFont);
        btn_next1.addActionListener(e -> {
            String[] params = {};
            RestartMain.main(params);
        });
        add(btn_next1);
    }

}

