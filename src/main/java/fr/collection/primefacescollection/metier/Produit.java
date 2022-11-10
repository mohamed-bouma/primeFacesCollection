package fr.collection.primefacescollection.metier;

import java.util.ArrayList;
import java.util.List;

public class Produit {
    private String type;
    private Integer id;
    private String description;
    private List<Object> caracteristiques = new ArrayList();



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public List<Object> getCaracteristiques() {
        return caracteristiques;
    }
    public void addCaracteristiques(Object obj) {
        this.caracteristiques.add(obj);
    }

}

