import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
class Menulist
{
    // public static void main(String[] args)
    {
        JFrame f=new JFrame("JComboBox");
        String color[]={"Red","Blue","Pink","Purple","Green"};
        JComboBox cb=new JComboBox<>(color);
        cb.setBounds(30,40,100,30);
        f.add(cb);
        f.setSize(400,400);
        f.setResizable(false);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        // f.getContentPane().setBackground(new Color(130, 160, 150));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }
    public static void main(String[] args){
        new Menulist();
    }
}