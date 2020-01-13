package projetexamen;

import java.io.File;

public class InfoExamen {

private String nom, telephone, ville;

    public InfoExamen() {
        nom="nameHolder";
        telephone = "phoneHolder";
        ville = "villeHolder";
    }
    
    public void SetNom (String nm){
        this.nom = nm;
    }
    
    public void SetPhone (String phoneNum){
        this.telephone = phoneNum;
    }
    
    public void SetVille (String villeName){
        this.ville = villeName;
    }
    
    public InfoExamen GetInfo () {
        return this;
    }
    
    public String GetNom() {
      return this.nom;
   }

   public String GetPhone() {
      return this.telephone;
   }

   public String GetVille() {
      return this.ville;
   }
   
    public String ToString(){
      return "nom = "+this.nom+", phone="+this.telephone+", ville="+this.ville;
   }
}