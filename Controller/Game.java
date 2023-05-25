package Controller;

import Model.Sudoku;
import View.Window;
import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Method;
public class Game {
    private static Window window;
    public static Sudoku sudoku;

    // 游戏难度，设定一个 0 ~ 1 之间的小数，表示初始数独的完成度
    // 程序保证所有数独一定有至少一个正确答案
    // 完成度越高游戏越简单，对计算机性能要求越高，建议设置最高 0.45
    public  double percent;
    public  double level;
    // 创建游戏
    public Game() {
        JFrame frame = new JFrame("游戏难度（1-5）");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout()); //设置布局为边界布局
        JTextField textField = new JTextField(20);
        Font font = new Font("Microsoft YaHei", Font.PLAIN, 20);
        textField.setFont(font);
        panel.add(textField, BorderLayout.CENTER);
        JButton button = new JButton("确定");
        button.setFont(font);
        panel.add(button, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setSize(200, 200);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);

        button.addActionListener(e -> {
            level = Double.parseDouble(textField.getText());
            if(level==5){
                percent=0.12;
            }
            else if(level==4){
                percent=0.19;
            }
            else if(level==3){
                percent=0.26;
            }
            else if(level==2){
                percent=0.33;
            }
            else if(level==1){
                percent=0.40;
            }
            sudoku = new Sudoku(percent);
            window = new Window();
            frame.dispose(); // 关闭窗口
        });


    }

    public static void solve() {
        sudoku.solve(0);
        window.stop();
    }

    public static void main(String[] args) {
       new Game();
        }
}

