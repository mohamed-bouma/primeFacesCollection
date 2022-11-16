package fr.collection.primefacescollection.metier;

public class Caracteristique {

    private Integer id_caracteristique;

    private String libelle_caracteristique;

    private Boolean liste;

    private Boolean num;

    private Boolean texte;

    public Integer getId_caracteristique() {
        return id_caracteristique;
    }

    public void setId_caracteristique(Integer id_caracteristique) {
        this.id_caracteristique = id_caracteristique;
    }

    public String getLibelle_caracteristique() {
        return libelle_caracteristique;
    }

    public void setLibelle_caracteristique(String libelle_caracteristique) {
        this.libelle_caracteristique = libelle_caracteristique;
    }

    public Boolean getListe() {
        return liste;
    }

    public void setListe(Boolean liste) {
        this.liste = liste;
    }

    public Boolean getNum() {
        return num;
    }

    public void setNum(Boolean num) {
        this.num = num;
    }

    public Boolean getTexte() {
        return texte;
    }

    public void setTexte(Boolean texte) {
        this.texte = texte;
    }


    @Override
    public String toString() {
        return "Caracteristique{" +
                "id_caracteristique=" + id_caracteristique +
                ", libelle_caracteristique='" + libelle_caracteristique + '\'' +
                ", liste=" + liste +
                ", num=" + num +
                ", texte=" + texte +
                '}';
    }
}
