package main.java.BL.Section;

public class Section {

    String nom;

    //get set de notre props NOM ↓↓↓
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if (nom != null) {
            this.nom = nom;
        } else {
            System.out.println("nom");
        }
    };

}
