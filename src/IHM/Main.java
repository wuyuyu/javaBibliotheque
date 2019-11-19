package IHM;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public Main(){
        this.setTitle("Bibliothèque");
        this.setPreferredSize(new Dimension(600 , 600));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel myPanel = new JPanel();
        this.setContentPane(myPanel);
        JButton myBtnOK = new JButton("Valider");
        JButton myBtnNOK = new JButton("NOK");
        JButton myBtnExit = new JButton("Exit");
        JTextField myTexField = new JTextField();
        JCheckBox myCheckBox = new JCheckBox();
        JMenuBar myMenuBar = new JMenuBar();
        JMenu myMenu = new JMenu();

        myTexField.setText("tapez vos texts ici");
        //myMenu.addMenuListener
        GridBagLayout myLayout = new GridBagLayout();
        myPanel.setLayout(myLayout);
        GridBagConstraints myGBC = new GridBagConstraints();

        Dimension dim = new Dimension(70,25);
        myBtnNOK.setSize(dim);
        myBtnOK.setSize(dim);
        myTexField.setPreferredSize(dim);
        myBtnNOK.setSize(dim);
        myBtnOK.setSize(dim);

        myBtnExit.setSize(70 , 50);

        myGBC.gridx = 0;
        myGBC.gridy = 0;
        myGBC.gridheight = 1;
        myGBC.gridwidth = 3;
        myGBC.fill = GridBagConstraints.HORIZONTAL;
        myGBC.gridwidth = GridBagConstraints.REMAINDER;
        myPanel.add(myMenuBar, myGBC);

        myGBC.gridx = 1;
        myGBC.gridwidth = GridBagConstraints.REMAINDER;
        myPanel.add(myBtnNOK,myGBC);

        myGBC.gridx = 0;
        myGBC.gridy = 1;
        myGBC.gridheight = 2;
        myGBC.gridwidth = 1;
        myGBC.fill = GridBagConstraints.VERTICAL;
        myPanel.add(myBtnExit,myGBC);

        myGBC.gridx = 1;
        myGBC.gridheight = 1;
        myGBC.gridwidth = GridBagConstraints.REMAINDER;
        myPanel.add(myTexField,myGBC);

        myGBC.gridy = 2;
        myGBC.gridwidth = GridBagConstraints.REMAINDER;
        myPanel.add(myCheckBox,myGBC);

        //myPanel.

    }



    public static void main(String[] args){
        Main myWindow = new Main();
        myWindow.pack();
        myWindow.setVisible(true);
    }

}
