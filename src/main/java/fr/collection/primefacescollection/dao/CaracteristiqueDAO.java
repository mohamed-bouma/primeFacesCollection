package fr.collection.primefacescollection.dao;

import fr.collection.primefacescollection.metier.Caracteristique;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CaracteristiqueDAO extends DAO<Caracteristique,Caracteristique> {

    private static final Connection connexion = CollectionConnect.getInstance();

    public CaracteristiqueDAO(Connection connexion) {
        super(connexion);
    }

    @Override
    public Caracteristique getByID(int id) {
        return null;
    }

    @Override
    public ArrayList<Caracteristique> getAll() {
     return null;
    }


    @Override
    public ArrayList<Caracteristique> getLike(Caracteristique objet) {
        return null;
    }

    @Override
    public boolean insert(Caracteristique objet) {
            return false;
    }

    @Override
    public boolean update(Caracteristique object) {
        return false;
    }

    @Override
    public boolean delete(Caracteristique object) {
        return false;
    }

    public static List<Caracteristique> getListCaracteristique(){

        ResultSet rs;
        String Statement = "SELECT * FROM caracteristique";
        List<Caracteristique> listeCaracteristique= new ArrayList<Caracteristique>();
        int i=0;

        try (Statement cStmt = connexion.createStatement()) {

            rs = cStmt.executeQuery(Statement);
            //  rs = cStmt.getResultSet();

            while (rs.next()) {
                listeCaracteristique.add(new Caracteristique());
                listeCaracteristique.get(i).setId_caracteristique(rs.getInt(1));
                listeCaracteristique.get(i++).setLibelle_caracteristique(rs.getString(2));

            }

            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return listeCaracteristique;
    }


}