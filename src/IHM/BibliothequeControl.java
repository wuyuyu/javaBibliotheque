package IHM;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BibliothequeControl {
    private JButton Fichier;
    private JPanel toto;
    private JButton button1;
    private JButton button2;
    private JTable table1;

    public BibliothequeControl() {
        Fichier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Hello World");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bibliotheque");
        frame.setContentPane(new BibliothequeControl().toto);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
