package fr.collection.primefacescollection.metier;

import java.util.ArrayList;
import java.util.List;

public class Type {

    private int id_type;
    private String libelle_type;


    private List<Caracteristique> caracteristiquesType = new ArrayList();

    public Integer getId()
    {
        return id_type;
    }

    public void setId(int id_type) {
        this.id_type = id_type;
    }



    public String getLibelle()
    {
        return libelle_type;
    }

    public void setLibelle_type(String libelle_type) {
        this.libelle_type = libelle_type;
    }


    public List<Caracteristique> getCaracteristiquesType() {
        return caracteristiquesType;
    }

    public void setCaracteristiquesType(List<Caracteristique> caracteristiquesType) {
        this.caracteristiquesType = caracteristiquesType;
    }

    @Override
    public String toString() {
        return libelle_type ;
    }




}