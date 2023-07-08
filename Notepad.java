
package notepad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Notepad extends JFrame implements ActionListener {
    
    JTextArea area;
    String text;
    
    public Notepad(){
        
        setTitle("Notepad");
        
        
        ImageIcon notepadIcon = new ImageIcon(ClassLoader.getSystemResource("notepad/icons/notepad.png"));
        Image icon=notepadIcon.getImage();
        setIconImage(icon);
        
        JMenuBar menubar = new JMenuBar();
        menubar.setBackground(Color.white);
        
        
        JMenu file= new JMenu("File");
        file.setFont(new Font("Aerial", Font.PLAIN, 14));
        
        JMenuItem menuItem1 = new JMenuItem("New");
        menuItem1.addActionListener(this);
        menuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        
        JMenuItem menuItem2 = new JMenuItem("Open");
        menuItem2.addActionListener(this);
        menuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        
        JMenuItem menuItem3 = new JMenuItem("Save");
        menuItem3.addActionListener(this);
        menuItem3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        
        JMenuItem menuItem4 = new JMenuItem("Print");
        menuItem4.addActionListener(this);
        menuItem4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        
        JMenuItem menuItem5 = new JMenuItem("Exit");
        menuItem5.addActionListener(this);
        menuItem5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        
        file.add(menuItem1);
        file.add(menuItem2);
        file.add(menuItem3);
        file.add(menuItem4);
        file.add(menuItem5);
        
        menubar.add(file);
        
        JMenu edit= new JMenu("Edit");
        edit.setFont(new Font("Aerial", Font.PLAIN, 14));
        
        JMenuItem editItem1 = new JMenuItem("Copy");
        editItem1.addActionListener(this);
        editItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        
        JMenuItem editItem2 = new JMenuItem("Paste");
        editItem2.addActionListener(this);
        editItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        
        JMenuItem editItem3 = new JMenuItem("Cut");
        editItem3.addActionListener(this);
        editItem3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        
        JMenuItem editItem4 = new JMenuItem("Select All");
        editItem4.addActionListener(this);
        editItem4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        
        edit.add(editItem1);
        edit.add(editItem2);
        edit.add(editItem3);
        edit.add(editItem4);
        
        menubar.add(edit);
        
        JMenu menuAbout= new JMenu("About");
        menuAbout.setFont(new Font("Aerial", Font.PLAIN, 14));
        
        JMenuItem about= new JMenuItem("About");
        about.addActionListener(this);
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
        
        menubar.add(menuAbout);
        menuAbout.add(about);
        
        area= new JTextArea();
        area.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        //add(area);
        
        JScrollPane pane = new JScrollPane(area);
        pane.setBorder(BorderFactory.createEmptyBorder());
        add(pane);
        
        
        
        setJMenuBar(menubar);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("New")){
            
        area.setText("");
       
        }else if(ae.getActionCommand().equals("Open")){
        JFileChooser chooser= new JFileChooser();
        chooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .txt files", "txt");
        chooser.addChoosableFileFilter(restrict);
        
        int action = chooser.showOpenDialog(this);
        
        if (action != JFileChooser.APPROVE_OPTION){
            return;
        }
        File file = chooser.getSelectedFile();
        try{
        BufferedReader reader = new BufferedReader(new FileReader(file));
        area.read(reader, null);
        }
        catch (Exception e){
            e.printStackTrace();
    }
        
        }else if(ae.getActionCommand().equals("Save")){  
         JFileChooser saveas = new JFileChooser();
         saveas.setApproveButtonText("Save");
         
        int action = saveas.showOpenDialog(this);
        
        if (action != JFileChooser.APPROVE_OPTION){
            return;
        }
        
        File filename =new File(saveas.getSelectedFile()+ ".txt");
        BufferedWriter outFile=null;
        try{
          outFile = new BufferedWriter(new FileWriter(filename));
          area.write(outFile);
        }catch(Exception e){
            e.printStackTrace();
                     
    }
    }else if(ae.getActionCommand().equals("Print")){
        try{
            area.print();
        }catch(Exception e){
            e.printStackTrace();
        
    }
    }else if(ae.getActionCommand().equals("Exit")){
        System.exit(0);
    }
    else if(ae.getActionCommand().equals("Copy")){
        text=area.getSelectedText();
    }else if(ae.getActionCommand().equals("Paste")){
        area.insert(text, area.getCaretPosition());
    }else if(ae.getActionCommand().equals("Cut")){
        text=area.getSelectedText();
        area.replaceRange("", area.getSelectionStart(),area.getSelectionEnd());
    }else if(ae.getActionCommand().equals("Select All")){
        area.selectAll();
    }else if(ae.getActionCommand().equals("About")){
        new About().setVisible(true);
    }
    }
    public static void main(String[] args) {
      
        new Notepad();
    }   
}
