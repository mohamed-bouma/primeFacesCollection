package fr.collection.primefacescollection.metier;

import java.util.Objects;

public class Caracteristique {

    private Integer id_caracteristique;
    private String libelle_caracteristique;
    private Boolean liste;
    private Boolean num;
    private Boolean texte;


    public Caracteristique(Integer id_caracteristique, String libelle_caracteristique, Boolean liste, Boolean num, Boolean texte) {
        this.id_caracteristique = id_caracteristique;
        this.libelle_caracteristique = libelle_caracteristique;
        this.liste = liste;
        this.num = num;
        this.texte = texte;
    }

    public Caracteristique() {

    }

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
        return libelle_caracteristique ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Caracteristique that = (Caracteristique) o;
        return  Objects.equals(libelle_caracteristique, that.libelle_caracteristique);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_caracteristique, libelle_caracteristique, liste, num, texte);
    }
}
