
package notepad;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class About extends JFrame implements ActionListener{
 JButton b1;
    public About(){
       setBounds(600, 200, 700, 600);
       setLayout(null);
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("notepad/icons/windows.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 80,Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 =new JLabel(i3);
        l1.setBounds(150, 40, 400, 80);
        add(l1);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("notepad/icons/notepad.png"));
        Image i5 = i4.getImage().getScaledInstance(70, 70,Image.SCALE_DEFAULT );
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l2 =new JLabel(i6);
        l2.setBounds(50, 180, 70, 70);
        add(l2);
        
        JLabel l3 = new JLabel("<html>Created by Suraj Chaudhari<br>Version 1.0.0");
        l3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        l3.setBounds(170, 65, 500, 300);
        add(l3);
        
        b1 = new JButton("Ok");
        b1.setBounds(580, 500, 80, 25);
        b1.addActionListener(this);
        add(b1);
     setVisible(true);   
    }
    
    
    public void actionPerformed(ActionEvent e){
        this.setVisible(false);
    }
    
    public static void main(String args[]){
        
        new About();
}
}

