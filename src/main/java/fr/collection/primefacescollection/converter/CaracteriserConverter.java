package fr.collection.primefacescollection.converter;

import fr.collection.primefacescollection.bean.Bean;
import fr.collection.primefacescollection.metier.Caracteriser;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.faces.convert.FacesConverter;

@Named
@FacesConverter(value="CaracteriserConverter", managed = true)


public class CaracteriserConverter implements Converter {

    @Inject
    private Bean bean;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0){
            for (Caracteriser caracteriser : bean.getAllCaracteriser()){
                if (caracteriser.getId_caracteristique()== Integer.parseInt(value)){
                    return caracteriser;
                }
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        Caracteriser caracteriser=(Caracteriser) object;
        return String.valueOf(caracteriser.getId_caracteristique());
    }
}
