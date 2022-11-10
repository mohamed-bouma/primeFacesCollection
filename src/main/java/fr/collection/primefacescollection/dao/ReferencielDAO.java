package fr.collection.primefacescollection.dao;

import fr.collection.primefacescollection.metier.Referenciel;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ReferencielDAO extends DAO<Referenciel, Referenciel> {

    private static final Connection connexion = CollectionConnect.getInstance();

    public ReferencielDAO(Connection connexion) {
        super(connexion);
    }

    @Override
    public Referenciel getByID(int id) {
        return null;
    }

    @Override
    public ArrayList<Referenciel> getAll() {
        return null;
    }

    @Override
    public ArrayList<Referenciel> getLike(Referenciel objet) {
        return null;
    }

    @Override
    public boolean insert(Referenciel objet) {
        return false;
    }

    @Override
    public boolean update(Referenciel object) {
        return false;

    }

    @Override
    public boolean delete(Referenciel object) {
        return false;
    }

    public void supprimerReferenciel(String ref){

        ResultSet rs;

        String procedureStockee = "{call dbo.delete_referenciel (?)}";


        try (CallableStatement cStmt = this.connexion.prepareCall(procedureStockee)) {

            cStmt.setString(1, ref);

            cStmt.execute();
            rs = cStmt.getResultSet();

            //while (rs.next()) {   newLigne.setIdObjet(rs.getInt(1));}
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void creerReferenciel(String carac, String ref){

        ResultSet rs;

        String procedureStockee = "{call dbo.insert_referenciel (?, ?)}";


        try (CallableStatement cStmt = this.connexion.prepareCall(procedureStockee)) {

            cStmt.setString(1, ref);
            cStmt.setString(2, carac);

            cStmt.execute();
            rs = cStmt.getResultSet();

            //while (rs.next()) {   newLigne.setIdObjet(rs.getInt(1));}
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
