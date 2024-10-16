package DAL.DAO.Implement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.postgresql.util.PSQLException;
import BL.CoursPersonne.*;
import DAL.DAO.DAOFactory;
import DAL.Singleton.Singleton;

public class CoursPersonneDAO {
    private Singleton single;
    private PreparedStatement ps;
    private ResultSet rs;

        
    public CoursPersonneDAO(Singleton single) {
        this.single = single;
    }

    public int get(CoursPersonne obj) {
        int annee = 0;
        try {
            ps = single.getConnection().prepareStatement("SELECT annee FROM Cours_Personne WHERE id_personne = ? AND id_cours = ?;");
            ps.setInt(1, obj.getPersonne().getId());
            ps.setInt(2, obj.getCours().getId());
            rs = ps.executeQuery();
            if (rs.next()) {
                annee = rs.getInt("annee");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return annee;
        }

    public ArrayList<CoursPersonne> getCoursList(CoursPersonne obj) {
        ArrayList<CoursPersonne> cpList = null;
        try {
            ps = single.getConnection().prepareStatement("SELECT id_cours, annee FROM Cours_Personne WHERE id_personne = ?;");
            ps.setInt(1, obj.getPersonne().getId());
            rs = ps.executeQuery();
            cpList = new ArrayList<CoursPersonne>();
            while (rs.next()) {
                CoursPersonne cp = new CoursPersonne(obj.getPersonne(), DAOFactory.getCoursDAO().get(rs.getInt("id_cours")), rs.getInt("annee"));
                cpList.add(cp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return cpList;
    }
    
    public ArrayList<CoursPersonne> getPersonnesList(CoursPersonne obj) {
        ArrayList<CoursPersonne> cpList = null;
        try {
            ps = single.getConnection().prepareStatement("SELECT id_personne, annee FROM Cours_Personne WHERE id_cours = ?;");
            ps.setInt(1, obj.getCours().getId());
            rs = ps.executeQuery();
            cpList = new ArrayList<CoursPersonne>();
            while (rs.next()) {
                CoursPersonne cp = new CoursPersonne(DAOFactory.getPersonneDAO().get(rs.getInt("id_personne")), obj.getCours(), rs.getInt("annee"));
                cpList.add(cp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return cpList;
    }

    public ArrayList<CoursPersonne> getAll() {
        ArrayList<CoursPersonne> cpList = null;
        try {
            ps = single.getConnection().prepareStatement("SELECT id_personne, id_cours, annee FROM Cours_Personne;");
            rs = ps.executeQuery();
            cpList = new ArrayList<CoursPersonne>();
            while (rs.next()) {
                CoursPersonne cp = new CoursPersonne(DAOFactory.getPersonneDAO().get(rs.getInt("id_personne")), DAOFactory.getCoursDAO().get(rs.getInt("id_cours")), rs.getInt("annee"));
                cpList.add(cp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return cpList;
    }

    public ArrayList<CoursPersonne> getAllByYear(int annee) {
        ArrayList<CoursPersonne> cpList = null;
        try {
            ps = single.getConnection().prepareStatement("SELECT id_personne, id_cours FROM Cours_Personne WHERE annee = ?;");
            ps.setInt(1, annee);
            rs = ps.executeQuery();
            cpList = new ArrayList<CoursPersonne>();
            while (rs.next()) {
                CoursPersonne cp = new CoursPersonne(DAOFactory.getPersonneDAO().get(rs.getInt("id_personne")), DAOFactory.getCoursDAO().get(rs.getInt("id_cours")), annee);
                cpList.add(cp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return cpList;
    }

    public boolean update(CoursPersonne obj) {
        boolean flag = false;
        try {
            ps = single.getConnection().prepareStatement("UPDATE Cours_Personne SET id_personne = ?, id_cours = ?, annee = ? WHERE id_personne = ? AND id_cours = ? AND annee = ?;");
            ps.setInt(1, obj.getPersonne().getId());
            ps.setInt(2, obj.getCours().getId());
            ps.setInt(3, obj.getAnnee());
            ps.setInt(4, obj.getPersonne().getId());
            ps.setInt(5, obj.getCours().getId());
            ps.setInt(6, obj.getAnnee());
            ps.executeUpdate();
            flag = true;
        } catch (PSQLException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return flag;
    }

    public boolean create(CoursPersonne obj) {
        boolean flag = false;
        try {
            ps = single.getConnection().prepareStatement("INSERT INTO Cours_Personne (id_personne, id_cours, annee) VALUES (?, ?, ?) ON CONFLICT (id_personne, id_cours, annee) DO NOTHING;");
            ps.setInt(1, obj.getPersonne().getId());
            ps.setInt(2, obj.getCours().getId());
            ps.setInt(3, obj.getAnnee());
            ps.executeUpdate();
            flag = true;
        } catch (PSQLException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return flag;
    }

    public boolean delete(CoursPersonne obj) {
        boolean flag = false;
        try {
            ps = single.getConnection().prepareStatement("DELETE FROM Cours_Personne WHERE id_personne = ? AND id_cours = ? AND annee = ?;");
            ps.setInt(1, obj.getPersonne().getId());
            ps.setInt(2, obj.getCours().getId());
            ps.setInt(3, obj.getAnnee());
            ps.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return flag;
    }


    private void close() {
        try {
            if (this.rs != null) rs.close();
            if (this.ps != null) ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }   
    }
}
