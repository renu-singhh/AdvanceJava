import javax.swing.*;
import java.awt.Color;
class test{
    public static void main(String[] args){
        JFrame f=new JFrame("this is my first application");
        f.setSize(400,400);
        f.setResizable(false);
        f.setLayout(null);
        f.setLocationRelativeTo(f);
        f.getContentPane().setBackground(Color.BLACK);
        f.setVisible(true);

    }
}