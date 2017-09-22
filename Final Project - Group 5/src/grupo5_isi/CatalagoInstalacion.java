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
public class CatalagoInstalacion {
    //se encarga de buscar las instalaciones
    private Set<DescripcionInstalacion> catalagoInstalacion;

    public CatalagoInstalacion() {
        catalagoInstalacion = new HashSet<DescripcionInstalacion>();
    }

    public void add(DescripcionInstalacion descripcion){
        //añade la descripcion de la pista a la lista catalagoInstalacion para luego buscarlas en el metodo buscarInstalaciones
        this.catalagoInstalacion.add(descripcion);
    }

    public boolean buscarInstalacion(String itemId) {
        //Busca la pista en la lista catalagoInstalacion
        Iterator<DescripcionInstalacion> it = catalagoInstalacion.iterator();
        boolean enc = false;
        while (it.hasNext() && !enc) {
            DescripcionInstalacion aux = it.next();
            if (aux.getItemId().equals(itemId)) {
                enc = true;
            }
        }
        return enc;//si lo encuentra true en caso contrario false
    }
}
