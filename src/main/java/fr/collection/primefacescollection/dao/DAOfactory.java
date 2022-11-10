package fr.collection.primefacescollection.dao;
import java.sql.Connection;

public class DAOfactory {

    private static final Connection connexion = CollectionConnect.getInstance();

    public static ProduitDAO getObjetDAO(){return new ProduitDAO(connexion);}

    public static TypeDAO getTypeDAO(){return new TypeDAO(connexion);}

    public static CaracteristiqueDAO getCaracteristiqueDAO(){return  new CaracteristiqueDAO(connexion);}

    public static ReferencielDAO getReferencielDAO(){return new ReferencielDAO(connexion);}






}
