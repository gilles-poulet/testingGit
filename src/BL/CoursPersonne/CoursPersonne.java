package BL.CoursPersonne;

public class CoursPersonne {
    private Personne personne;
    private Cours cours;
    private int annee;

    public CoursPersonne(Personne personne, Cours cours, int annee) {
        this.personne = personne;
        this.cours = cours;
        this.annee = annee;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }  

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }
    
    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    @Override
    public String toString() {
        return this.getCours().getNom() + " " + this.getPersonne().getNom() + " " + this.getPersonne().getPrenom();
    }
}
