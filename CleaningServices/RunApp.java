package CleaningServices;

import javax.swing.*;

public class RunApp {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        //set image icon
        ImageIcon imageIcon = new ImageIcon("res/logo (1).png");
        JFrame jFrame = new JFrame("Form Jasa Service");
        jFrame.setIconImage(imageIcon.getImage());
        jFrame.setContentPane(new CleanAndServ().getRootPanel());
        jFrame.setSize(900, 500);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}

