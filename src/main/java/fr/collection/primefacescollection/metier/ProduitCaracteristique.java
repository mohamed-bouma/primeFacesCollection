package fr.collection.primefacescollection.metier;

public class ProduitCaracteristique {

    private int id_produit;

    private Caracteristique caracteristique;

    private Referenciel referentiel;

    private String texte;

    private Double valeur;

    public ProduitCaracteristique() {

    }

    public ProduitCaracteristique(Double valeur) {
        this.valeur = valeur;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public Caracteristique getCaracteristique() {
        return caracteristique;
    }

    public void setCaracteristique(Caracteristique caracteristique) {
        this.caracteristique = caracteristique;
    }

    public Referenciel getReferentiel() {
        return referentiel;
    }

    public void setReferentiel(Referenciel referentiel) {
        this.referentiel = referentiel;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public Double getValeur() {
        return valeur;
    }

    public void setValeur(Double valeur) {
        this.valeur = valeur;
    }


    @Override
    public String toString() {
        return "ProduitCaracteristique{" +
                "id_produit=" + id_produit +
                ", caracteristique=" + caracteristique +
                ", referentiel=" + referentiel +
                ", texte='" + texte + '\'' +
                ", valeur=" + valeur +
                '}';
    }
}
