package fr.collection.primefacescollection.converter;

import fr.collection.primefacescollection.bean.ProduitBean;
import fr.collection.primefacescollection.metier.Type;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@FacesConverter (value = "typeConverter", managed = true)
public class TypeConverter  implements Converter {

    @Inject
    private ProduitBean produitBean;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0) {
            for (Type type : produitBean.getAllTypes()) {
                if (type.getId() == Integer.parseInt(value)) {
                    return type;
                }
            }
        }
        return null;
    }



    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        Type type = (Type) object;
        return String.valueOf(type.getId());
    }
}
