package Aulas.LambdaAula1;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaLambdaActionListener {
    
    public static void main(String[] args) {
        JButton button = new JButton();
    button.addActionListener(new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Olá mundo");
        }
    });

    JButton button2 = new JButton();
    button2.addActionListener(e -> System.out.println("Olá mundo"));
    }
}
