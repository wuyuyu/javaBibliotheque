package IHM;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class Main extends JFrame {
    public Main(){
        this.setTitle("Bibliothèque");
        this.setPreferredSize(new Dimension(600 , 600));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel myPanel = new JPanel();
        this.setContentPane(myPanel);
        JMenuBar myMenuBar = new JMenuBar();
        this.setJMenuBar(myMenuBar);
        JButton myBtnAdd = new JButton("Add");


        //ImageIcon myIcon = new ImageIcon("../resources/pencil.png");
        //File f = new File("../resources/pencil.png");
        JButton myBtnEdit = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("../resources/pencil.png"));
            myBtnEdit.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        JButton myBtnDelete = new JButton("Valider");
        JTextField myTexField = new JTextField();
        JMenu myFileMenu = new JMenu("File");
        JMenu myEditMenu = new JMenu("Edit");
        JMenu myAboutMenu = new JMenu("About");
        JMenuItem myOpenItem = new JMenuItem("Open");
        JMenuItem myQuitItem = new JMenuItem("Quit");
        String tableauEnTete [] = {"Titre" , "Auteur"};
        String tableauDonnees [][] = {{"Harry Potter" , "J.K. Rowling"} , {"Le Crime de l'Orient-Express" , "Agatha Christie"}};
        JTable myTable = new JTable(tableauDonnees,tableauEnTete);
        myMenuBar.add(myFileMenu);
        myMenuBar.add(myEditMenu);
        myMenuBar.add(myAboutMenu);
        myTexField.setText("tapez vos texts ici");
        myFileMenu.add(myOpenItem);
        myFileMenu.add(myQuitItem);

        GridBagLayout myLayout = new GridBagLayout();
        myPanel.setLayout(myLayout);
        GridBagConstraints myGBC = new GridBagConstraints();

        Dimension dim = new Dimension(50,25);
        myBtnAdd.setSize(dim);
        myBtnDelete.setSize(dim);
        myBtnEdit.setSize(dim);
        myTable.setPreferredSize(new Dimension(300 ,200));

        myGBC.gridx = 0;
        myGBC.gridy = 0;
        myGBC.gridheight = 3;
        myGBC.gridwidth = 1;
        //myGBC.fill = GridBagConstraints.HORIZONTAL;
        //myGBC.fill = GridBagConstraints.VERTICAL;
        myPanel.add(myTable,myGBC);

        myGBC.gridx = 1;
        //myGBC.gridy = 0;
        myGBC.gridheight = 1;
        //myGBC.gridwidth = 1;
        myGBC.gridwidth = GridBagConstraints.REMAINDER;
        myPanel.add(myBtnAdd,myGBC);

        myGBC.gridy = 1;
        myGBC.gridwidth = GridBagConstraints.REMAINDER;
        myPanel.add(myBtnDelete,myGBC);

        myGBC.gridy = 2;
        myGBC.gridwidth = GridBagConstraints.REMAINDER;
        myPanel.add(myBtnEdit,myGBC);

        myQuitItem.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            System.exit(0);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        myOpenItem.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
            JFileChooser mychooser = new JFileChooser();
            FileNameExtensionFilter myfilter = new FileNameExtensionFilter("only .xml files" , ".xml");
            mychooser.setFileFilter(myfilter);
            mychooser.showOpenDialog(null);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public static void main(String[] args){
        Main myWindow = new Main();
        myWindow.pack();
        myWindow.setVisible(true);
    }

}
