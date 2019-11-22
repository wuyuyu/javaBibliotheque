package IHM;

import XSD.Bibliotheque;
import com.sun.codemodel.JForLoop;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableColumnModelListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.TableView;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Main extends JFrame {
    private File myFile = null;
    private final Object[][] tableauDonnees;
    private final String [] tableauEntete = {"Titre" , "Auteur" , "Présentation" , "Colonne" , "Rangée" , "Parution"};

    public Main(){
        this.setTitle("Bibliothèque");
        //this.setPreferredSize(new Dimension(600 , 600));
        this.setMinimumSize(new Dimension(800 , 800));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel myPanel = new JPanel();
        this.setContentPane(myPanel);
        JMenuBar myMenuBar = new JMenuBar();
        this.setJMenuBar(myMenuBar);
        JButton myBtnAdd = new JButton("Add");
        JButton myBtnEdit = new JButton();

        JTextField myTitle = new JTextField();
        JLabel title = new JLabel("Titre :");

        JTextField myAuteur = new JTextField();
        JLabel auteur = new JLabel("Auteur :");

        JTextField myParution = new JTextField();
        JLabel parution = new JLabel("Parution :");

        JTextField myColumn = new JTextField();
        JLabel column = new JLabel("Colonne :");

        JTextField myRow = new JTextField();
        JLabel row = new JLabel("Rangée :");

        JTextArea myPresentation = new JTextArea();
        JLabel presentation = new JLabel("Présentation :");

        JButton myBtnValider= new JButton();

        try {
            Image img = ImageIO.read(getClass().getResource("../resources/check.png"));
            myBtnValider.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }



        /*try {
            Image img = ImageIO.read(getClass().getResource("../resources/pencil.png"));
            myBtnEdit.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }*/

        JButton myBtnDelete = new JButton("Supprimer");
        JTextField myTexField = new JTextField();
        JMenu myFileMenu = new JMenu("File");
        JMenu myEditMenu = new JMenu("Edit");
        JMenu myAboutMenu = new JMenu("About");
        JMenuItem myOpenItem = new JMenuItem("Open");
        JMenuItem myQuitItem = new JMenuItem("Quit");

        GridBagLayout myLayout = new GridBagLayout();
        myPanel.setLayout(myLayout);
        GridBagConstraints myGBC = new GridBagConstraints();


        tableauDonnees  = new Object[][]{
                {"Harry Potter" , "J.K. Rowling" ,"***" , "1" , "1" ,  "1997"},
                {"Le Crime de l'Orient-Express" , "Agatha Christie" , "***" , "5" , "2" , "1934"},
                {"L'art de la guerre" , "Tzu Sun" , "***" , "6" , "8" , "2008"},
                {"Sapiens" , "Yuval Noah Harari" , "***" , "9" , "1" , "2011"},
                {"Astérix" , "Albert Uderzo" , "***" , "2" , "22" , "2019"},
                {"Harry Potter" , "J.K. Rowling" ,"***" , "1" , "1" ,  "1997"},
                {"Le Crime de l'Orient-Express" , "Agatha Christie" , "***" , "5" , "2" , "1934"},
                {"L'art de la guerre" , "Tzu Sun" , "***" , "6" , "8" , "2008"},
                {"Sapiens" , "Yuval Noah Harari" , "***" , "9" , "1" , "2011"},
                {"Astérix" , "Albert Uderzo" , "***" , "2" , "22" , "2019"},
                {"Harry Potter" , "J.K. Rowling" ,"***" , "1" , "1" ,  "1997"},
                {"Le Crime de l'Orient-Express" , "Agatha Christie" , "***" , "5" , "2" , "1934"},
                {"L'art de la guerre" , "Tzu Sun" , "***" , "6" , "8" , "2008"},
                {"Sapiens" , "Yuval Noah Harari" , "***" , "9" , "1" , "2011"},
                {"Astérix" , "Albert Uderzo" , "***" , "2" , "22" , "2019"},
                {"Harry Potter" , "J.K. Rowling" ,"***" , "1" , "1" ,  "1997"},
                {"Le Crime de l'Orient-Express" , "Agatha Christie" , "***" , "5" , "2" , "1934"},
                {"L'art de la guerre" , "Tzu Sun" , "***" , "6" , "8" , "2008"},
                {"Sapiens" , "Yuval Noah Harari" , "***" , "9" , "1" , "2011"},
                {"Astérix" , "Albert Uderzo" , "***" , "2" , "22" , "2019"}
        };

        //JTable myTable = new JTable(tableauDonnees,tableauEntete);

        DefaultTableModel model = new DefaultTableModel(tableauDonnees,tableauEntete);

        JTable myTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(myTable);

        myTable.setPreferredScrollableViewportSize(new Dimension(450,200));
        myTable.setFillsViewportHeight(true);



        myTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int lingeSelectionne = myTable.getSelectedRow();

                myTitle.setText(myTable.getValueAt(lingeSelectionne, 0).toString());
                myAuteur.setText(myTable.getValueAt(lingeSelectionne, 1).toString());
                myParution.setText(myTable.getValueAt(lingeSelectionne, 5).toString());
                myColumn.setText(myTable.getValueAt(lingeSelectionne, 3).toString());
                myRow.setText(myTable.getValueAt(lingeSelectionne, 4).toString());
                myPresentation.setText(myTable.getValueAt(lingeSelectionne, 2).toString());




            }
        });

        myTable.setGridColor(Color.black);
        //myTable.setBackground(Color.gray);

        myMenuBar.add(myFileMenu);
        myMenuBar.add(myEditMenu);
        myMenuBar.add(myAboutMenu);
        myTexField.setText("tapez vos texts ici");
        myFileMenu.add(myOpenItem);
        myFileMenu.add(myQuitItem);


        Dimension btnDim = new Dimension(90,45);
        myBtnAdd.setPreferredSize(btnDim);
        myBtnDelete.setPreferredSize(btnDim);
        myBtnValider.setPreferredSize(btnDim);
        myBtnEdit.setPreferredSize(btnDim);
        Dimension txtDim = new Dimension(90 , 30);
        myTitle.setPreferredSize(txtDim);
        myAuteur.setPreferredSize(txtDim);
        myParution.setPreferredSize(txtDim);
        myColumn.setPreferredSize(txtDim);
        myRow.setPreferredSize(txtDim);
        myPresentation.setPreferredSize(new Dimension(90 , 150));

        myTable.setPreferredSize(new Dimension(200 ,500));

        myTable.setDefaultRenderer(Object.class, new MyCellRenderer(myTable.getDefaultRenderer(Object.class)));

        myGBC.gridx = 0;
        myGBC.gridy = 0;
        myGBC.gridheight = 11;
        myGBC.gridwidth = 6;
        myPanel.add(scrollPane,myGBC);

        myGBC.gridy = 12;
        myGBC.gridheight = 2;
        myGBC.gridwidth = 1;
        myPanel.add(myBtnAdd,myGBC);

        myGBC.gridx = 1;
        myGBC.gridwidth = GridBagConstraints.REMAINDER;
        myPanel.add(myBtnDelete,myGBC);

        myGBC.gridx = 6;
        myGBC.gridy = 0;
        myGBC.gridheight = 1;
        myGBC.gridwidth = 1;
        myPanel.add(title , myGBC);

        myGBC.gridy = 1;
        myPanel.add(auteur , myGBC);

        myGBC.gridy = 2;
        myPanel.add(parution , myGBC);

        myGBC.gridy = 3;
        myPanel.add(column , myGBC);

        myGBC.gridy = 4;
        myPanel.add(row , myGBC);

        myGBC.gridy = 5;
        myPanel.add(presentation , myGBC);

        myGBC.gridx = 7;
        myGBC.gridy = 0;
        myGBC.gridwidth = GridBagConstraints.REMAINDER;
        myPanel.add(myTitle , myGBC);

        myGBC.gridy = 1;
        myGBC.gridwidth = GridBagConstraints.REMAINDER;
        myPanel.add(myAuteur , myGBC);

        myGBC.gridy = 2;
        myGBC.gridwidth = GridBagConstraints.REMAINDER;
        myPanel.add(myParution , myGBC);

        myGBC.gridy = 3;
        myGBC.gridwidth = GridBagConstraints.REMAINDER;
        myPanel.add(myColumn , myGBC);

        myGBC.gridy = 4;
        myGBC.gridwidth = GridBagConstraints.REMAINDER;
        myPanel.add(myRow , myGBC);

        myGBC.gridy = 5;
        myGBC.gridheight = 5;
        myGBC.gridwidth = GridBagConstraints.REMAINDER;
        myPanel.add(myPresentation , myGBC);

        myGBC.gridy = 10;
        myGBC.gridheight = 1;
        myGBC.gridwidth = GridBagConstraints.REMAINDER;
        myPanel.add (myBtnValider , myGBC);






        myBtnValider.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                try {
                    int ligneSelectionnee = myTable.getSelectedRow();
                    int year = Calendar.getInstance().get(Calendar.YEAR);

                    myTable.setValueAt(myTitle.getText(), ligneSelectionnee, 0);
                    myTable.setValueAt(myAuteur.getText(), ligneSelectionnee, 1);
                    myTable.setValueAt(myPresentation.getText(), ligneSelectionnee, 2);


                    Calendar c = Calendar.getInstance();
                    int annee = c.get(Calendar.YEAR);

                    if (Integer.parseInt(myColumn.getText()) > 0 && Integer.parseInt(myColumn.getText()) < 8) {
                        myTable.setValueAt(myColumn.getText(), ligneSelectionnee, 3);
                    } else {
                        JOptionPane myPoPop = new JOptionPane();
                        myPoPop.showMessageDialog(null, "Selectionner un chiffre de colonne entre 1 et 7");
                    }

                    if (Integer.parseInt(myRow.getText()) > 0 && Integer.parseInt(myRow.getText()) < 6) {
                        myTable.setValueAt(myRow.getText(), ligneSelectionnee, 4);
                    } else {
                        JOptionPane myPoPop = new JOptionPane();
                        myPoPop.showMessageDialog(null, "Selectionner un chiffre de rangée entre 1 et 5");
                    }

                    if (Integer.parseInt(myParution.getText()) <= annee) {
                        myTable.setValueAt(myParution.getText(), ligneSelectionnee, 5);
                    } else {
                        JOptionPane myPoPop = new JOptionPane();
                        myPoPop.showMessageDialog(null, "La date de parution ne pourra pas être supérieure à l’année du système");
                    }
                } catch (Exception ext) {
                    JOptionPane myPoPop = new JOptionPane();
                    ImageIcon img2 = new ImageIcon("resources/file.png");
                    myPoPop.showMessageDialog(null, "❌系统错误，请重新输入❌");
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
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
                JFileChooser myChooser = new JFileChooser();
                FileNameExtensionFilter myfilter = new FileNameExtensionFilter("only .xml files" , "xml");
                myChooser.setFileFilter(myfilter);
                myChooser.showOpenDialog(null);
                File myFile = myChooser.getSelectedFile();
                processXml(myFile);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        myBtnDelete.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

                int selectedRow = myTable.getSelectedRow();
                if(selectedRow<0||selectedRow>myTable.getRowCount()){
                    JOptionPane myPoPop1 = new JOptionPane();
                    myPoPop1.showMessageDialog(null, "Aucune ligne selectionnée");
                }else {
                    model.removeRow(selectedRow);
                }

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
        myBtnAdd.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                model.addRow(new TableView.TableRow[]{});


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

        myAboutMenu.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane myPoPop2 = new JOptionPane();
                myPoPop2.showMessageDialog(null, "Dernière version par Yuyuan , Tania et Teddy");
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
    }





    public int getRowCount() {
        return tableauDonnees.length;
    }
    public int getColumnCount() {
        return tableauEntete.length;
    }
    public String getColumnName(int columnIndex) {
        return tableauEntete[columnIndex];
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
        return tableauDonnees[rowIndex][columnIndex];
    }



    private void processXml(File myFile){

        try {
            //Obtenir la configuration du sax parser
            SAXParserFactory spfactory = SAXParserFactory.newInstance();
            //Obtenir une instance de l'objet parser
            SAXParser saxParser = spfactory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                boolean titre = false;
                boolean auteur = false;
                boolean presentation = false;
                boolean parution = false;
                boolean colonne = false;
                boolean rangee = false;

                //cette méthode est invoquée à chaque fois que parser rencontre
                 // une balise fermante '>'
                public void endElement(String uri, String localName,
                                       String qName) throws SAXException {
                    if (qName.equalsIgnoreCase("Titre")) {
                        titre = false;
                    }
                    if (qName.equalsIgnoreCase("auteur")) {
                        auteur = false;
                    }
                    if (qName.equalsIgnoreCase("presentation")) {
                        presentation = false;
                    }
                    if (qName.equalsIgnoreCase("parution")) {
                        parution = false;
                    }
                    if (qName.equalsIgnoreCase("colonne")) {
                        colonne = false;
                    }
                    if (qName.equalsIgnoreCase("rangee")) {
                        rangee = false;
                    }
                }

            };
            saxParser.parse(myFile, handler);


        } catch (Exception e) {
            e.printStackTrace();
        }





    }




    public static void main(String[] args){
        Main myWindow = new Main();
        myWindow.pack();
        myWindow.setVisible(true);
        System.out.println();
    }

}
