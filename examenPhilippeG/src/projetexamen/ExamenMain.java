package projetexamen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import projetexamen.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ExamenMain {
    
    //debug
    private static boolean debug = true;
    public static List<InfoExamen> listContacts;
    
    public ExamenMain (){
        //Definit list
        listContacts = new ArrayList<InfoExamen>();   
        System.out.println("Make new listContacts");
    }
    
    //methode debug
    private static void Debug (String str) {
        if (debug) System.out.println(str);
    }
    
    //methode pour ajouter un contact
    public static void  AjouterElt (){
        
        String nom, phone, ville;
        //Add file
        
        InfoExamen ex = new InfoExamen ();
        
        //Utilise JOptionPane pour prendre l'info du nouveau contact
        nom = JOptionPane.showInputDialog ("Enter the name of the new contact");
        phone = JOptionPane.showInputDialog ("Enter the phone number of the new "
                + "contact");
        ville = JOptionPane.showInputDialog ("Enter the city of residence of the new "
                + "contact");
        
        //Associe l'info à l'objet dans la liste (le contact)
        ex.SetNom(nom);
        ex.SetPhone(phone);
        ex.SetVille(ville);
        
        Debug("New: "+ex.ToString());
        listContacts.add(ex);
        
        //Place la liste n ordre alphabétique
        if (!listContacts.isEmpty()) {
            Collections.sort(listContacts, new Comparator<InfoExamen>() {
                @Override
                public int compare(InfoExamen nom1, InfoExamen nom2) {
                    return (nom1.GetNom().toUpperCase()).compareTo(nom2.GetNom()
                            .toUpperCase());
                }
            });
        }
        
    }
    
    public static int AfficherElt() {
      //Fait une recherche pour un contact, puis trouve son numéro identifiant
      String element;
      int eltNum = 0;
      element = JOptionPane.showInputDialog (null, "Enter the name of the contact you are searching for:");
      
     for (int i=0; i< listContacts.size();i++){
         if (listContacts.get(i).GetNom().equals(element)){
             eltNum = i;
            
         }
     }
      return (eltNum);
   }
    
    public static void SupprimeElt() {
      //trouve et supprime un objet
        String element;
        element = JOptionPane.showInputDialog (null, "Enter the name of the contact you would like to delete:");
      
        for (int i=0; i<listContacts .size();i++){
            if (listContacts.get(i).GetNom().equals(element)){
                Debug(listContacts.remove(i).ToString());
            }
        }
    }

    public static void ImprimeList() {
      //trouve et supprime un objet
        String element = "";
        System.out.println("Full list of contacts:");
      
        for (int i=0; i<listContacts .size();i++){
            element = listContacts.get(i).GetNom();
            System.out.println(element);
        }
    }
    
    public static void scanMethode ()throws IOException {
        
        String nomholder, phoneholder, villeholder;
        int compteur;
        
        //Message à l'usager pour quoi faire
        JOptionPane.showMessageDialog(null, "Choose the file containing the contacts");
        
        //Definit fichier
        File prendreFichier = null;
        
         //Scanner scan = new Scanner (prendreFichier);
        //Definit FileChooser
        JFileChooser choisirPrendreFichier = new JFileChooser (System.getProperty 
        ("user.dir"));
         
        int valRetourne = choisirPrendreFichier.showOpenDialog (null);
             
            //Verifie la validité du fichier
            if (valRetourne == 0) {   
                prendreFichier = choisirPrendreFichier.getSelectedFile(); 
                if (!prendreFichier.isFile())
                    throw new FileNotFoundException ("That is not a file");
            } else {  
                throw new FileNotFoundException ("That file does not work");
            }
            
            Scanner scan = new Scanner (prendreFichier);
            
                //Definit et retourne scanne
                for ( compteur = 0; compteur < 6; compteur++){  
                    
                    //Prend les string dans le fichier et les transfert à un 
                    //élément
                    InfoExamen ex = new InfoExamen ();    
                    nomholder = scan.next();
                    phoneholder = scan.next();
                    villeholder = scan.next();
                    ex.SetNom(nomholder);
                    ex.SetPhone (phoneholder);
                    ex.SetVille (villeholder);
                    listContacts.add(ex);
                }
                
                //Place la liste en ordre alphabétique
        if (!listContacts.isEmpty()) {
            Collections.sort(listContacts, new Comparator<InfoExamen>() {
                @Override
                public int compare(InfoExamen nom1, InfoExamen nom2) {
                    return (nom1.GetNom().toUpperCase()).compareTo(nom2.GetNom()
                            .toUpperCase());
                }
            });
        }
        
        //Imprime la nouvelle liste, dans le bon ordre
        for (int i=0; i<listContacts.size();i++) {
            System.out.println(listContacts.get(i).GetNom());
        }           
    }
    
    public static void main( String[] argsv) throws IOException {  
         ExamenIUG iug = new ExamenIUG();
    }
}