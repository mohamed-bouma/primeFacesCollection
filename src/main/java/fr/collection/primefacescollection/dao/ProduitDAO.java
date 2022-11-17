package fr.collection.primefacescollection.dao;

import fr.collection.primefacescollection.metier.*;
import fr.collection.primefacescollection.service.ProduitSearch;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProduitDAO extends DAO<Produit, ProduitSearch> {

    private static final Connection connexion = CollectionConnect.getInstance();

    public ProduitDAO(Connection connexion) {
        super(connexion);
    }

    @Override
    public Produit getByID(int id) {
        return null;
    }

    @Override
    public ArrayList<Produit> getAll() {
        ResultSet rs;
        ArrayList<Produit> listeProduits = new ArrayList<>();

        try (PreparedStatement cStmt = connexion.prepareStatement("select Objet.id_objet, description,\n" +
                "type.id_type, libelle_type, caracteristique.id_caracteristique, libelle_caracteristique,\n" +
                "caracteristique_objet.valeur, caracteristique_objet.texte,\n" +
                "referenciel.id_referenciel, libelle_referenciel from caracteristique_objet\n" +
                "left join Objet on Objet.id_objet = caracteristique_objet.id_objet\n" +
                "left join type on type.id_type = Objet.id_type\n" +
                "left join caracteristique on caracteristique_objet.id_caracteristique = caracteristique.id_caracteristique\n" +
                "left join referenciel on caracteristique_objet.id_referenciel = referenciel.id_referenciel\n" +
                "order by id_objet")) {

            cStmt.execute();
            rs = cStmt.getResultSet();
            int lastId = -1;
            List<Caracteristique> listeCaracteristiques = new ArrayList<Caracteristique>();
            List<Referenciel> listeReferentiel = new ArrayList<Referenciel>();
            Boolean CaracteristiqueExiste = false;
            Boolean ReferentielExiste = false;
            int indexCaracteristique = -1;
            int indexReferentiel = -1;
            Double valeurNum;
            String valeurTexte;
            while (rs.next()) {

                valeurNum = 0.0;
                valeurTexte = null;

                if (lastId == -1 || lastId != rs.getInt(1)) {
                    lastId = rs.getInt(1);
                    Produit newProduit = new Produit();
                    newProduit.setId_produit(rs.getInt(1));
                    newProduit.setDescription(rs.getString(2));
                    newProduit.setType(new Type());
                    newProduit.getType().setId(rs.getInt(3));
                    newProduit.getType().setLibelle_type(rs.getString(4));
                    newProduit.setListproduitCaracteristiques(new ArrayList<ProduitCaracteristique>());
                    listeProduits.add(newProduit);
                }

                if (rs.getObject(9) != null) { //Il y a un referenciel
                    ReferentielExiste = false;
                    for (int j = 0; j < listeReferentiel.size(); j++) {
                        if (listeReferentiel.get(j).getId_referenciel() == rs.getInt(9)) {
                            ReferentielExiste = true;
                            indexReferentiel = j;
                        }
                    }

                    if (!ReferentielExiste) {
                        Referenciel newReferentiel = new Referenciel();
                        newReferentiel.setId_referenciel(rs.getInt(9));
                        newReferentiel.setLibelle_referenciel(rs.getString(10));

                        listeReferentiel.add(newReferentiel);
                        indexReferentiel = listeReferentiel.size() - 1;
                    }
                } else {
                    indexReferentiel = -1;
                }

                CaracteristiqueExiste = false;
                for (int j = 0; j < listeCaracteristiques.size(); j++) {
                    if (listeCaracteristiques.get(j).getId_caracteristique() == rs.getInt(5)) {
                        CaracteristiqueExiste = true;
                        indexCaracteristique = j;
                    }
                }

                if (!CaracteristiqueExiste) {
                    Caracteristique newCaracteristique = new Caracteristique();
                    newCaracteristique.setId_caracteristique(rs.getInt(5));
                    newCaracteristique.setLibelle_caracteristique(rs.getString(6));
                    if (indexReferentiel != -1) { //il y a un referenciel
                        newCaracteristique.setNum(false);
                        newCaracteristique.setTexte(false);
                        newCaracteristique.setListe(true);
                    } else if (rs.getObject(7) != null) { //c'est un num
                        newCaracteristique.setNum(true);
                        newCaracteristique.setTexte(false);
                        newCaracteristique.setListe(false);
                        valeurNum = rs.getDouble(7);
                    } else { //c'est un simple texte
                        newCaracteristique.setNum(false);
                        newCaracteristique.setTexte(true);
                        newCaracteristique.setListe(false);
                        valeurTexte = rs.getString(8);
                    }
                    listeCaracteristiques.add(newCaracteristique);
                    indexCaracteristique = listeCaracteristiques.size() - 1;
                }


                ProduitCaracteristique newProduitCaracteristique = new ProduitCaracteristique();
                newProduitCaracteristique.setId_produit(rs.getInt(1));
                newProduitCaracteristique.setCaracteristique(listeCaracteristiques.get(indexCaracteristique));
                if (indexReferentiel != -1) {
                    newProduitCaracteristique.setReferentiel(listeReferentiel.get(indexReferentiel));
                }
                newProduitCaracteristique.setValeur(valeurNum);
                newProduitCaracteristique.setTexte(valeurTexte);


                listeProduits.get(lastId - 1).getListproduitCaracteristiques().add(newProduitCaracteristique);


            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(listeProduits);
        System.out.println(listeProduits.get(1).getListproduitCaracteristiques());
        return listeProduits;


    }

    public ArrayList<Produit> getTableProduit(){
        ArrayList<Produit> liste = new ArrayList<>();
        try (Statement stmt = connexion.createStatement()){

            // Determine the column set column

            String strCmd = "select  O.id_objet, O.description,T.id_type,T.libelle_type,caracteristique_objet.valeur from Objet as O\n" +
                    "                    left join type as T on O.id_type = T.id_type \n" +
                    "                    left join caracteristique_objet on O.id_objet = caracteristique_objet.id_objet\n" +
                    "                    left join caracteristique on caracteristique_objet.id_caracteristique = caracteristique.id_caracteristique\n" +
                    "                    where caracteristique.id_caracteristique = 1";
            ResultSet rs = stmt.executeQuery(strCmd);
            while (rs.next()) {
               Produit produit = new Produit(rs.getInt(1), rs.getString(2));
               produit.setType(new Type(rs.getInt(3),rs.getString(4)));
               produit.setListproduitCaracteristiques(new ArrayList<>());
               produit.getListproduitCaracteristiques().add(new ProduitCaracteristique(rs.getDouble(5)));
                liste.add(produit);
            }
            rs.close();
        }

        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return liste;
    }

    @Override
    public ArrayList<Produit> getLike(ProduitSearch produitSearch) {
        ResultSet rs;
        String request;
        ArrayList<Produit> listeProduits = new ArrayList<Produit>();


        request = "select distinct Objet.id_objet, description, libelle_type, libelle_caracteristique, caracteristique_objet.valeur\n" +
                "from caracteristique_objet\n" +
                "left join Objet on Objet.id_objet = caracteristique_objet.id_objet\n" +
                "left join type on type.id_type = Objet.id_type\n" +
                "left join caracteristique on caracteristique_objet.id_caracteristique = caracteristique.id_caracteristique\n" +
                "left join referenciel on referenciel.id_referenciel = caracteristique_objet.id_referenciel\n" +
                "where type.libelle_type like '" + produitSearch.getType().getLibelle() + "'\n" +
                "and caracteristique.id_caracteristique=1\n";
        int i;
        for (i = 0; i < produitSearch.getListproduitCaracteristiques().size(); i++) {
            ProduitCaracteristique pc = produitSearch.getListproduitCaracteristiques().get(i);
            request += "and Objet.id_objet in(\n" +
                    "select distinct Objet.id_objet\n" +
                    "from caracteristique_objet\n" +
                    "left join Objet on Objet.id_objet = caracteristique_objet.id_objet\n" +
                    "left join type on type.id_type = Objet.id_type\n" +
                    "left join caracteristique on caracteristique_objet.id_caracteristique = caracteristique.id_caracteristique\n" +
                    "left join referenciel on referenciel.id_referenciel = caracteristique_objet.id_referenciel\n" +
                    "where libelle_caracteristique= ''" + pc.getCaracteristique().getLibelle_caracteristique() + "'\n";
            if (pc.getCaracteristique().getNum() == true) {
                request += "and valeur = " + pc.getCaracteristique().getNum() + "\n";
            } else if (pc.getCaracteristique().getTexte() == true) {
                request += "and caracteristique_objet.texte like '% " + pc.getCaracteristique().getTexte() + "%'\n";
            } else { //C'est un referentiel
                request += "and libelle_referenciel = '" + pc.getReferentiel().getLibelle_referenciel() + "'\n";
            }
        }
        for (int j = 0; j < i; j++) {
            request += ")";
        }
        request += "order by id_objet";
        System.out.println("requete sql : \n" + request + "\n");
        try (PreparedStatement cStmt = connexion.prepareStatement(request)) {
            cStmt.execute();
            rs = cStmt.getResultSet();
            while (rs.next()) {
                Produit newProduit = new Produit();
                newProduit.setId_produit(rs.getInt(1));
                newProduit.setDescription(rs.getString(2));
                newProduit.setType(produitSearch.getType());
                newProduit.setListproduitCaracteristiques(new ArrayList<ProduitCaracteristique>());
                ProduitCaracteristique prix = new ProduitCaracteristique();
                prix.setId_produit(rs.getInt(1));
                Caracteristique prixC = new Caracteristique();
                prixC.setId_caracteristique(rs.getInt(4));
                prixC.setLibelle_caracteristique(rs.getString(5));
                prixC.setNum(true);
                prixC.setTexte(false);
                prixC.setListe(false);
                prix.setCaracteristique(prixC);
                prix.setValeur(rs.getDouble(6));
                newProduit.getListproduitCaracteristiques().add(prix);
                listeProduits.add(newProduit);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("resultat : \n" + listeProduits);
        return listeProduits;
    }

    @Override
    public boolean insert(Produit objet) { return false; }

    @Override
    public boolean update(Produit object) {
        return false;
    }

    @Override
    public boolean delete(Produit object) {
        return false;
    }
}



