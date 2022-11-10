package fr.collection.primefacescollection.outils;

import fr.collection.primefacescollection.metier.Caracteristique;
import fr.collection.primefacescollection.metier.LigneProduit;
import fr.collection.primefacescollection.metier.Produit;
import fr.collection.primefacescollection.metier.Type;

import java.util.List;

public class Affichage {

    public static void afficherLignesProduits(List<LigneProduit> listeLignesProduits) {
        for (LigneProduit ligne : listeLignesProduits) {
            System.out.print(ligne.getIdObjet());
            System.out.print("," + ligne.getLibelleCaracteristique());
            System.out.print("," + ligne.getValeur());
            System.out.print("," + ligne.getTexte());
            System.out.print("," + ligne.getLibelleReferenciel() + "\n");
        }
    }

    public static void afficherProduits(List<Produit> listeProduits){

        System.out.println("Affichage produits");

        for (Produit produit : listeProduits) {
            System.out.print("ID produit : " + produit.getId() + " ");
            System.out.print("Type produit : " + produit.getType() + " ");
            System.out.print("Description produit : " + produit.getDescription() + " ");
            for (Object caracteristique : produit.getCaracteristiques()) {
                System.out.print(caracteristique + " , ");
            }
            System.out.println(" ");
        }


    }

    public static void afficherType(List<Type> typeList){
        System.out.println("Affichage type");
        for (Type type : typeList) {
            System.out.print("ID type : " + type.getId() + " ");
            System.out.print("Libelle type : " + type.getLibelle() + " ");
            System.out.println(" ");
        }

    }

    public static void afficherCaracteristique(List<Caracteristique> caracteristiqueList) {
        System.out.println("Affichage caracteristique");
        for (Caracteristique caracteristique : caracteristiqueList) {
            System.out.print("ID caracteristique : " + caracteristique.getId_caracteristique() + " ");
            System.out.print("Libelle caracteristique : " + caracteristique.getLibelle_caracteristique() + " ");
            System.out.print("stocker dans une liste : "+ caracteristique.getListe()+" ");
            System.out.print("valeur numerique : "+ caracteristique.getNum()+" ");
            System.out.print("valeur texte : "+caracteristique.getTexte()+" ");
            System.out.println(" ");

        }
    }
}