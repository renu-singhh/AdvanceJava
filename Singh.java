import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
class Singh{
    public static void main(String[] args){
        JFrame jframe=new JFrame("this is the frame");
        JLabel jlabel=new JLabel("enter the first number");
         jlabel.setBounds(40,40,40,40);
         jlabel.setForeground(Color.red);
         jlabel.setBackground(Color.black);
         JLabel jlabe2 = new JLabel("enter the second number");
         jlabe2.setBounds(80, 80, 40, 40);
         jlabe2.setForeground(Color.red);
         jlabe2.setBackground(Color.black);
         JTextArea j= new JTextArea();
         j.setBounds(40,30,40,60);
         j.setBackground(Color.red);
         j.setForeground(Color.black);
         JButton b =new JButton("count");
              b.setBounds(60,40,50,50);
              b.setBackground(Color.red);
              b.setForeground(Color.blue);
              b.addActionListener( new ActionListener()){
                public void actionPerform(ActionEvent e){
               String text=j.getText();
               String word[]=text.split("\\s");
               jlabel.setText("Words"+word.length);
               jlabe2.setText("character"+text.length());
                            }
            };

          jframe.add(jlabe1);



                
         
    }
}