package fr.collection.primefacescollection.metier;

public class Referenciel {
    private Integer id_referenciel;
    private String libelle_referenciel;
    private Integer id_caracteristique;

    public Referenciel(Integer id_referenciel, String libelle_referenciel, Integer id_caracteristique) {
        this.id_referenciel = id_referenciel;
        this.libelle_referenciel = libelle_referenciel;
        this.id_caracteristique = id_caracteristique;
    }

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

    public Integer getId_caracteristique() {
        return id_caracteristique;
    }

    public void setId_caracteristique(Integer id_caracteristique) {
        this.id_caracteristique = id_caracteristique;
    }
}
