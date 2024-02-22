import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
class Checkbox
{
    public static void main(String[] args)
    {
        JFrame f=new JFrame("");
        JRadioButton rb1 = new JRadioButton("Married");
        rb1.setBounds(30,40,100,30);
        rb1.setForeground(Color.blue);
        JRadioButton rb2= new JRadioButton("unmarried");
        rb2.setBounds(30,80,100,30);
        rb2.setForeground(Color.green);
        ButtonGroup bg =new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        JLabel lb=new JLabel();
        lb.setBounds(30,150,400,50);
        JButton b=new JButton("Marital Status");
        b.setBounds(30,200,100,40);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(rb1.isSelected())
                {
                    lb.setText("married....");
                }
                if (rb2.isSelected()) {
                    lb.setText(" un married....");
                }
            }
        });
        f.add(lb);
        f.add(b);
        f.add(rb1);
        f.add(rb2);

        f.setSize(400, 400);
        f.setResizable(false);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        // f.getContentPane().setBackground(new Color(130, 160, 150));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }
}