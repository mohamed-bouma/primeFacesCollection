package fr.collection.primefacescollection.metier;

public class LigneProduit {

    private int idObjet;
    private String libelleCaracteristique;
    private double valeur;
    private String texte;
    private String libelleReferenciel;

    public int getIdObjet() {
        return idObjet;
    }

    public void setIdObjet(int idObjet) {
        this.idObjet = idObjet;
    }

    public String getLibelleCaracteristique() {
        return libelleCaracteristique;
    }

    public void setLibelleCaracteristique(String libelleCaracteristique) {
        this.libelleCaracteristique = libelleCaracteristique;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public String getLibelleReferenciel() {
        return libelleReferenciel;
    }

    public void setLibelleReferenciel(String libelleReferenciel) {
        this.libelleReferenciel = libelleReferenciel;
    }
}
