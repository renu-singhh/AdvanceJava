import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

class fistcode {
    public static void main(String... shruti) {
        JFrame f = new JFrame("Calculator application");
        JLabel l = new JLabel("First Number");
        l.setBounds(20, 20, 200, 30);
        l.setForeground(Color.yellow);
        JTextField tf = new JTextField();
        tf.setBounds(90, 20, 100, 30);

        JLabel l1 = new JLabel("Second Number");
        l1.setBounds(20, 60, 200, 30);
        l1.setForeground(Color.yellow);

        JTextField tf1 = new JTextField();
        tf1.setBounds(90, 60, 100, 30);

        JTextField tf2 = new JTextField();
        tf2.setBounds(20, 140, 130, 30);
        tf2.setForeground(Color.blue);
        tf2.setEditable(false);
        JButton b1 = new JButton("+");
        b1.setBounds(20, 90, 70, 30);
        b1.setForeground(Color.blue);
        b1.setBackground(Color.yellow);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s1 = tf.getText();
                String s2 = tf1.getText();
                int a = Integer.parseInt(s1);
                int b = Integer.parseInt(s2);
                int c = 0;
                if (e.getSource() == b1) {
                    c = a + b;
                }
                String result = String.valueOf(c);
                tf2.setText(result);
            }
        });
        f.add(b1);
        f.add(tf);
        f.add(tf1);
        f.add(l1);
        f.add(l);
        f.add(tf2);
        f.setSize(400, 400);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.blue);
        f.setLayout(null);
        f.setVisible(true);
    }
}