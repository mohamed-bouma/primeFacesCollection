package fr.collection.primefacescollection.metier;

public class Referenciel {

    private Integer id_referenciel;

    private String libelle_referenciel;

    private Caracteristique id_caracteristique;


    public Integer getId_referenciel() {
        return id_referenciel;
    }

    public void setId_referenciel(Integer id_referenciel) {
        this.id_referenciel = id_referenciel;
    }

    public String getLibelle_referenciel() {
        return libelle_referenciel;
    }

    public void setLibelle_referenciel(String libelle_referenciel) {
        this.libelle_referenciel = libelle_referenciel;
    }

    public Caracteristique getId_caracteristique() {
        return id_caracteristique;
    }

    public void setId_caracteristique(Caracteristique id_caracteristique) {
        this.id_caracteristique = id_caracteristique;
    }


    @Override
    public String toString() {
        return "Referenciel{" +
                "id_referenciel=" + id_referenciel +
                ", libelle_referenciel='" + libelle_referenciel + '\'' +
                ", id_caracteristique=" + id_caracteristique +
                '}';
    }
}
