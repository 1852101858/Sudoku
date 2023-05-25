package View;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private final GameBody gameBody;
    private final ToolBar toolBar;
    static Font GameFont = new Font("Microsoft YaHei", Font.BOLD, 32);
    static Font ToolFont = new Font("Microsoft YaHei", Font.PLAIN, 20);

    public Window() {
        gameBody = new GameBody();
        toolBar = new ToolBar();
        init();
    }

    private void init() {
        add(gameBody, BorderLayout.CENTER);
        add(toolBar, BorderLayout.PAGE_END);
        setTitle("Sudoku");
        setSize(550, 650);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void stop() {
        gameBody.next();
    }
}
