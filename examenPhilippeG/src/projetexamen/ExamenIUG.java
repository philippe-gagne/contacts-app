package projetexamen;

import projetexamen.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import javax.swing.JFileChooser;
import static projetexamen.ExamenMain.listContacts;

public  class ExamenIUG extends JFrame implements ActionListener {

    //Deboguer
    static boolean debogue = true;
    
    public static void Debogue (String s) {
        if (debogue) 
            System.out.println(s);
    }

        //DEFINITION DES BUTTONS/LABEL/FLOW/PANEL/GRID
    JButton buttonAjoute = new JButton ("Add");
    JButton buttonAffiche = new JButton ("Display");
    JButton buttonSupprime = new JButton ("Delete");
    JButton buttonImprime = new JButton ("List");

    JLabel labelName = new JLabel ("nameholder");
    JLabel labelPhone = new JLabel ("phoneholder");
    JLabel labelVille = new JLabel ("cityholder");
    
    
    JPanel panelName = new JPanel();
    JPanel panelPhone = new JPanel();
    JPanel panelVille = new JPanel();
    JPanel panelImage = new JPanel();
    JPanel panelButtons = new JPanel();
    
    FlowLayout flow1 = new FlowLayout ();
    FlowLayout flow2 = new FlowLayout ();
    FlowLayout flow3 = new FlowLayout ();
    FlowLayout flow4 = new FlowLayout ();
    FlowLayout flow5 = new FlowLayout ();
    
    GridLayout mainGrid = new GridLayout (5, 1);
    ExamenMain chose=null;
    
    //CONSTRUCTEUR
    public ExamenIUG() throws IOException {
    
        //Désigne la grandeur du IUG
        super ("Contacts");
        setSize (400, 250);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        
        //Début du constructeur
        setLayout (mainGrid);
        
        add (panelName, mainGrid);
        panelName.setLayout (flow1);
        panelName.add (labelName);
        
        add (panelPhone, mainGrid);
        panelPhone.setLayout (flow2);
        panelPhone.add (labelPhone);
        
        add (panelVille, mainGrid);
        panelVille.setLayout (flow3);
        panelVille.add (labelVille);
        
        add (panelImage, mainGrid);
        panelImage.setLayout (flow4);
        
        add (panelButtons, mainGrid);
        panelButtons.setLayout (flow5);
        panelButtons.add (buttonAjoute);
        panelButtons.add (buttonAffiche);
        panelButtons.add (buttonSupprime);
        panelButtons.add (buttonImprime);
        
        //Rend les boutons fonctionnels
        buttonAjoute.addActionListener (this);
        buttonAffiche.addActionListener (this);
        buttonSupprime.addActionListener (this);
        buttonImprime.addActionListener (this);
        
        setVisible (true);
        chose = new ExamenMain();
        chose.scanMethode();
    }
     
    @Override
    public void actionPerformed( ActionEvent actionEvent ) {
         
        String commande = actionEvent.getActionCommand();
         
         //Ajoute un élément à la liste de contacts
        if (commande == "Add") {
            System.out.print("command: add");
             
            ExamenMain.AjouterElt();
           
    }
         
        //Affiche un contact dans le IUG
        if (commande == "Display") {
            System.out.print("command: display");
            //Prend le nombre identifiant du contact à partir d'un autre méthode
            int elt; 
            elt = ExamenMain.AfficherElt();
            
            //Change tout les labels pour afficher la bonne info
            labelName.setText (ExamenMain.listContacts.get(elt).GetNom());
            labelPhone.setText (ExamenMain.listContacts.get(elt).GetPhone());
            labelVille.setText (ExamenMain.listContacts.get(elt).GetVille());
         }
         
        //Supprime un contact
        if (commande == "Delete") {
            System.out.print("command: delete");
            ExamenMain.SupprimeElt();
         }
        
        //Imprime la liste complète des contacts
        if (commande == "List") {
            System.out.print("command: list");
            ExamenMain.ImprimeList();
         }
     }
}

