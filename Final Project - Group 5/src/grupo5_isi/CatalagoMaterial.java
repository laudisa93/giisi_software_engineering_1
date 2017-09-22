/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5_isi;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Ricardo
 */
public class CatalagoMaterial {
    private Set<DescripcionMaterial> catalagoMaterial;

    public CatalagoMaterial() {
        catalagoMaterial = new HashSet<DescripcionMaterial>();
    }

    public void add(DescripcionMaterial descripcion){
        //añade descripcion del material a la lista de catalagoMaterial
        this.catalagoMaterial.add(descripcion);
    }
    
    public boolean buscarMaterial(String itemId) {
        //busca el material en la lista catalagoMaterial
        Iterator<DescripcionMaterial> it = catalagoMaterial.iterator();
        boolean enc = false;
        while (it.hasNext() && !enc) {
            DescripcionMaterial aux = it.next();
            if (aux.getItemId().equals(itemId)) {
                enc = true;
            }
        }
        return enc;//devolvera true o false si lo encuentra o no
    }
}
