package fr.collection.primefacescollection.bean;

import fr.collection.primefacescollection.dao.DAOfactory;
import fr.collection.primefacescollection.metier.Produit;
import fr.collection.primefacescollection.metier.Type;
import fr.collection.primefacescollection.service.ProduitSearch;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;


@Named("produitBean")
@ViewScoped
public class ProduitBean implements Serializable {



    private List<Produit> produitsFiltred;

    private List<Type> allTypes;
    private Type typeSelected;


    private ProduitSearch articleSearch;


    public ProduitBean() {
        articleSearch = new ProduitSearch();
    }

    @PostConstruct
    public void init(){
        produitsFiltred = DAOfactory.getProduitDAO().getTableProduit();

        allTypes = DAOfactory.getTypeDAO().getAll();
        allTypes.add(0,new Type(0,"Choisir Type"));


    }




    public ProduitSearch getArticleSearch() {
        return articleSearch;
    }

    public void setArticleSearch(ProduitSearch articleSearch) {
        this.articleSearch = articleSearch;
    }

    public List<Produit> getProduitsFiltred() {
        return produitsFiltred;
    }

    public void setProduitsFiltred(List<Produit> produitsFiltred) {
        this.produitsFiltred = produitsFiltred;
    }


    public List<Type> getAllTypes() {
        return allTypes;
    }

    public void setAllTypes(List<Type> allTypes) {
        this.allTypes = allTypes;
    }

    public Type getTypeSelected() {
        return typeSelected;
    }

    public void setTypeSelected(Type typeSelected) {
        this.typeSelected = typeSelected;
    }
}
