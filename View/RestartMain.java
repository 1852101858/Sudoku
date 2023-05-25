package View;

import java.awt.Window;
import java.lang.reflect.Method;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RestartMain {
    public static void main(String[] args) {
        // 创建 JFrame 对象
        JFrame frame = new JFrame();
        // 显示一个对话框，询问是否要关闭所有窗口
        int option = JOptionPane.showConfirmDialog(frame, "是否进行新游戏", "提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {
            // 获取所有窗口，并关闭它们
            Window[] windows = Window.getWindows();
            Arrays.stream(windows).forEach(Window::dispose);
            // 获取 Game 类的 main 方法
            try {
                Class<?> gameClass = Class.forName("Controller.Game");
                Method mainMethod = gameClass.getMethod("main", String[].class);
                // 调用 main 方法
                mainMethod.invoke(null, (Object) args);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
