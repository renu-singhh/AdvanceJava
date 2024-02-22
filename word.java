import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
class word{
    public static void main(String[] args){
JFrame f =new JFrame("JtextArea application");
JLable l1=new JLable();
l1.setBounds(20,40,150,30);
l1.setForeground(Color.blue);
JLable l2= new JLbale();
l1.setBounds(20, 40, 150, 30);
l2.setForeground(Color.green);
JTextArea ta=new JTextArea();
ta.setBounds(40,80,60,89);
ta.setForeground(Color.blue);
JButton b=new JButton("count");
b.setBounds(120,120,123,134);
b.setForeground(Color.red);
b.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e)
}
String text=ta.getText();

String word[]=text.split("\\s");
l1.setText("Words:-"+word.length);
l2.setText("characters:-" text.length());
    }
    });
f.add(l1);
f.add(l2);
