import BL.CoursPersonne.Cours;
import BL.CoursPersonne.CoursPersonne;
import BL.CoursPersonne.Personne;
import BL.Section.Section;
import BL.Status.Status;
import DAL.DAO.DAOFactory;
import DAL.Singleton.Singleton;

public class App {
    public static void main(String[] args) throws Exception {
        Singleton.getInstance();
        
        // Création des sections
        Section sectionInfo = new Section("Informatique de gestion");
        Section sectionDroit = new Section("Droit");
        DAOFactory.getSectionDAO().create(sectionInfo);
        DAOFactory.getSectionDAO().create(sectionDroit);

        // Recupération des sections
        sectionInfo = DAOFactory.getSectionDAO().get(sectionInfo);
        sectionDroit = DAOFactory.getSectionDAO().get(sectionDroit);

        // Création des cours
        Cours coursReseaux = new Cours("Base de Réseaux", sectionInfo);
        Cours coursOS = new Cours("Systèmes d'exploitation", sectionInfo);
        Cours coursPOO = new Cours("Programmation orientée objet", sectionInfo);
        Cours coursDCivil = new Cours("Droit civil", sectionDroit);
        Cours coursDCommercial = new Cours("Droit commercial", sectionDroit);
        DAOFactory.getCoursDAO().create(coursReseaux);
        DAOFactory.getCoursDAO().create(coursOS);
        DAOFactory.getCoursDAO().create(coursPOO);
        DAOFactory.getCoursDAO().create(coursDCivil);
        DAOFactory.getCoursDAO().create(coursDCommercial);

        // Recupération des cours
        coursReseaux = DAOFactory.getCoursDAO().get(coursReseaux);
        coursOS = DAOFactory.getCoursDAO().get(coursOS);
        coursPOO = DAOFactory.getCoursDAO().get(coursPOO);
        coursDCivil = DAOFactory.getCoursDAO().get(coursDCivil);
        coursDCommercial = DAOFactory.getCoursDAO().get(coursDCommercial);

        // Création des Status
        Status statusEtudiant = new Status("Étudiant");
        Status statusEnseignant = new Status("Charge de cours");
        Status statusEmpAdmin = new Status("Employé administratif");
        DAOFactory.getStatusDAO().create(statusEtudiant);
        DAOFactory.getStatusDAO().create(statusEnseignant);
        DAOFactory.getStatusDAO().create(statusEmpAdmin);

        // Recupération des Status
        statusEtudiant = DAOFactory.getStatusDAO().get(statusEtudiant);
        statusEnseignant = DAOFactory.getStatusDAO().get(statusEnseignant);
        statusEmpAdmin = DAOFactory.getStatusDAO().get(statusEmpAdmin);

        // Création des personnes
        Personne p1 = new Personne("Poulet", "Gilles", statusEnseignant);
        Personne p2 = new Personne("Godissart", "Emmanuel", statusEnseignant);
        Personne p3 = new Personne("Lai", "Valeria", statusEmpAdmin);
        Personne p4 = new Personne("Mairesse", "David", statusEmpAdmin);
        Personne p5 = new Personne("Durant", "Richard", statusEtudiant);
        Personne p6 = new Personne("Ortiz", "Valerie", statusEtudiant);
        DAOFactory.getPersonneDAO().create(p1);
        DAOFactory.getPersonneDAO().create(p2);
        DAOFactory.getPersonneDAO().create(p3);
        DAOFactory.getPersonneDAO().create(p4);
        DAOFactory.getPersonneDAO().create(p5);
        DAOFactory.getPersonneDAO().create(p6);


        // Recupération des personnes
        p1 = DAOFactory.getPersonneDAO().get(p1);
        p2 = DAOFactory.getPersonneDAO().get(p2);
        p5 = DAOFactory.getPersonneDAO().get(p5);

        // Création des CoursPersonne
        CoursPersonne cp1 = new CoursPersonne(p1, coursOS, 2024);
        CoursPersonne cp2 = new CoursPersonne(p2, coursReseaux, 2024);
        CoursPersonne cp3 = new CoursPersonne(p5, coursOS, 2024);
        CoursPersonne cp4 = new CoursPersonne(p5, coursReseaux, 2024);
        DAOFactory.getCoursPersonneDAO().create(cp1);
        DAOFactory.getCoursPersonneDAO().create(cp2);
        DAOFactory.getCoursPersonneDAO().create(cp3);
        DAOFactory.getCoursPersonneDAO().create(cp4);
        

        // Affichage
        System.out.println("\nTable 2.3 - Status");
        for (Status status : DAOFactory.getStatusDAO().getAll()) {
            System.err.println(status.getStatus());
        }
        System.out.println("\nTable 2.4 - Personne");
        for (Personne personne : DAOFactory.getPersonneDAO().getAll()) {
            System.err.println(personne.toString());
        }
        System.out.println("\nTable 2.5 - Cours_Personne");
        for (CoursPersonne coursPersonne : DAOFactory.getCoursPersonneDAO().getAll()) {
            System.err.println(coursPersonne.toString());
        }

        Singleton.getInstance().close();
    }
}
