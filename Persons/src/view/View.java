package view;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;

public class View {

    private JFrame frame = new JFrame("Personas");
    private TextArea text = new TextArea();
    public String readString(String message){
        String a = JOptionPane.showInputDialog(message);
        return a;
    }

    public  int readInt(String message){
        int a = Integer.parseInt(JOptionPane.showInputDialog(message));
        return a;
    }
    public void showMessage(String message){
        JOptionPane.showMessageDialog(null,message);
    }

    public void show(String message){
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        text.setText(message);
        text.setEditable(false);
        frame.add(text);
        frame.setVisible(true);
    }
}
